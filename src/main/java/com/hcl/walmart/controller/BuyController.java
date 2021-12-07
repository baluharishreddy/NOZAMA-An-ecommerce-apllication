package com.hcl.walmart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.walmart.entity.Product;
import com.hcl.walmart.entity.Cart;
import com.hcl.walmart.entity.MyOrders;
import com.hcl.walmart.responsemodel.ProductResponse;
import com.hcl.walmart.responsemodel.BuyResponse;
import com.hcl.walmart.responsemodel.MyCartResponse;
import com.hcl.walmart.responsemodel.MyOrdersResponse;
import com.hcl.walmart.service.BuyService;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class BuyController {
	
	private static final Logger logger = LoggerFactory.getLogger(BuyController.class);

	@Autowired
	BuyService buyService;

	@PostMapping(value = "/buy")
	public BuyResponse buyCheck(@RequestBody MyOrders buy) {
		
		logger.debug("Entering into BuyController ==========>> ");
		
		MyOrders bought = buyService.buyCheck(buy);
		
		BuyResponse buyResponse = new BuyResponse();
		buyResponse.setBoughtProduct(bought);
		buyResponse.setMessage("Product bought successfully");
		buyResponse.setStatusCode("200");
		buyResponse.setStatusMessage("OK");
		return buyResponse;

	}

}
