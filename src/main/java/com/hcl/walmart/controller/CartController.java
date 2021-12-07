package com.hcl.walmart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.walmart.entity.Cart;
import com.hcl.walmart.entity.Register;
import com.hcl.walmart.responsemodel.CartResponse;
import com.hcl.walmart.responsemodel.RegisterResponse;
import com.hcl.walmart.service.CartService;
import com.hcl.walmart.service.MyCartService;
import com.hcl.walmart.service.RegisterService;
@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class CartController {
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	CartService cartService;

	@PostMapping(value = "/cart/add")
	public CartResponse cartCheck(@RequestBody Cart cart) {
		
		logger.debug("Entering into CartController ==========>> ");
		
		Cart addedToCart = cartService.cartCheck(cart);
		
		CartResponse cartResponse = new CartResponse();
		cartResponse.setCart(addedToCart);
		cartResponse.setMessage("Added to cart succesfully");
		cartResponse.setStatusCode("200");
		cartResponse.setStatusMessage("OK");
		return cartResponse;

	}

}
