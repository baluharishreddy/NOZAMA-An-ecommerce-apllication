package com.hcl.walmart.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.walmart.controller.BuyController;
import com.hcl.walmart.entity.Cart;
import com.hcl.walmart.repository.CartRepository;

@Service
public class MyCartService {
	
	private static final Logger logger = LoggerFactory.getLogger(MyCartService.class);

	@Autowired
	CartRepository cartRepository;

	public List<Cart> myCartCheck(Cart cart) {
		
		logger.debug("Entering into MyCartService ==========>> ");
		
		return cartRepository.findByUserId(cart.getUserId());
	}

}
