/*package com.hcl.walmart.api;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
@RestController
@RequestMapping("/user")
public class BarCodeController {
	

	

	@RequestMapping(value = "/barcode", method = RequestMethod.GET)
	public void barcode( HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(getBarCodeImage("BaluHarishReddy", 500, 500));
		outputStream.flush();
		outputStream.close();
	}
		public static byte[] getBarCodeImage(String text, int width, int height) throws IOException, WriterException {
		
			
			
				Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
				hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
				Writer writer = new Code128Writer();
				BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.CODE_128, width, height);
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
				return byteArrayOutputStream.toByteArray();
		
			}
		}*/

	

