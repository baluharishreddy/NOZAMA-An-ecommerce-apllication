package com.hcl.walmart.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.walmart.entity.Product;
import com.hcl.walmart.controller.BuyController;
import com.hcl.walmart.entity.MyOrders;
import com.hcl.walmart.repository.ProductRepository;
import com.hcl.walmart.repository.BuyRepository;

@Service
public class BuyService {
	
	private static final Logger logger = LoggerFactory.getLogger(BuyService.class);

	@Autowired
	ProductRepository productRepository;

	@Autowired
	BuyRepository buyRepository;

	public MyOrders buyCheck(MyOrders buy) {
		
		logger.debug("Entering into BuyService ==========>> ");
		
		Product myProduct = productRepository.findByProdId(buy.getProdId());
		
		MyOrders boughtProduct = new MyOrders();
		boughtProduct.setProdId(myProduct.getProdId());
		boughtProduct.setProdName(myProduct.getProdName());
		boughtProduct.setPrice(myProduct.getPrice());
		boughtProduct.setDescription(myProduct.getDescription());
		boughtProduct.setImage(myProduct.getImage());
		boughtProduct.setCatId(myProduct.getCatId());
		boughtProduct.setDeliveryTime(myProduct.getDeliveryTime());
		boughtProduct.setUserId(buy.getUserId());
		boughtProduct.setDeliveryAddress(buy.getDeliveryAddress());
		return buyRepository.save(boughtProduct);

	}

}
