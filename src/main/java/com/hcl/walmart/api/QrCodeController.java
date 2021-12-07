package com.hcl.walmart.api;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Hashtable;
import java.util.Map;
 
import javax.imageio.ImageIO;

import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.graphics2d.svg.ViewBox;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
/**
 * @author Crunchify.com
 * Updated: 03/20/2016 - added code to narrow border size 
 */
@RestController
@RequestMapping("/user")
public class QrCodeController  {
 
	// Tutorial: http://zxing.github.io/zxing/apidocs/index.html
	@RequestMapping("/user")
	public void hello() throws IOException
	{
		
	        BufferedImage qrCode = getQrCode("www.facebook.com", 200, 200);
	        File file = new File("qrcode.png");
	        ImageIO.write(qrCode, "png", file);

	        String qrCodeSvg = getQRCodeSvg("www.facebook.com", 200, 200, false);
	        System.out.println(qrCodeSvg);

	}
	public  static BufferedImage getQrCode(String targetUrl,int width,int height) {
		 try {
		
		        Hashtable<EncodeHintType, Object> hintMap = new Hashtable<>();
		        hintMap.put(EncodeHintType.ERROR_CORRECTION, 
		            ErrorCorrectionLevel.L);
		        QRCodeWriter qrCodeWriter = new QRCodeWriter();
		        BitMatrix byteMatrix = qrCodeWriter.encode(targetUrl, 
		            BarcodeFormat.QR_CODE, width, height, hintMap);
		        int CrunchifyWidth = byteMatrix.getWidth();
		        BufferedImage image = new BufferedImage(CrunchifyWidth, 
		            CrunchifyWidth, BufferedImage.TYPE_INT_RGB);
		        image.createGraphics();
		        Graphics2D graphics = (Graphics2D) image.getGraphics();
		        graphics.setColor(Color.WHITE);
		        graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
		        graphics.setColor(Color.BLACK);
		        for (int i = 0; i < CrunchifyWidth; i++) {
		            for (int j = 0; j < CrunchifyWidth; j++) {
		                if (byteMatrix.get(i, j)) {
		                    graphics.fillRect(i, j, 1, 1);
		                }
		            }
		        }
		  
		      return image;
		    } catch (WriterException e) {
		        e.printStackTrace();
		        throw new RuntimeException("Error getting QR Code");
		    }
		//System.out.println("\n\nYou have successfully created QR Code.");
	}
	//@GetMapping("/qr")
	public static String getQRCodeSvg(String targetUrl, int width, 
		    int height, boolean withViewBox){
	
		    SVGGraphics2D g2 = new SVGGraphics2D(width, height);
		    BufferedImage qrCodeImage = getQrCode(targetUrl, width, height);
		    g2.drawImage(qrCodeImage, 0,0, width, height, null);
		    ViewBox viewBox = null;
		    if ( withViewBox ){
		        viewBox = new ViewBox(0,0,width,height);
		    }
		    return g2.getSVGElement(null, true, viewBox, null, null);
		}
}