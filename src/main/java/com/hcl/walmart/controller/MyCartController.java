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

import com.hcl.walmart.entity.Cart;
import com.hcl.walmart.responsemodel.CartResponse;
import com.hcl.walmart.responsemodel.MyCartResponse;
import com.hcl.walmart.service.MyCartService;
@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class MyCartController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyCartController.class);

	@Autowired
	MyCartService myCartService;

	@PostMapping(value = "/mycart")
	public MyCartResponse cartCheck(@RequestBody Cart cart) {
		
		logger.debug("Entering into MyCartController ==========>> ");
		
		List<Cart> myCart = myCartService.myCartCheck(cart);
		
		if (myCart.isEmpty()) {
			MyCartResponse myCartResponse = new MyCartResponse();
			myCartResponse.setMessage("Your cart is empty");
			myCartResponse.setStatusCode("200");
			myCartResponse.setStatusMessage("OK");
			return myCartResponse;

		} else {
			MyCartResponse myCartResponse = new MyCartResponse();
			myCartResponse.setMycart(myCart);
			myCartResponse.setMessage("Here is our cart");
			myCartResponse.setStatusCode("200");
			myCartResponse.setStatusMessage("OK");
			return myCartResponse;
		}

	}

}
