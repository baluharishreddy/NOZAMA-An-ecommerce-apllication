package com.hcl.walmart.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hcl.walmart.entity.Product;
import com.hcl.walmart.controller.BuyController;
import com.hcl.walmart.entity.Cart;
import com.hcl.walmart.repository.ProductRepository;
import com.hcl.walmart.repository.CartRepository;
import com.hcl.walmart.repository.RegisterRepository;

@Service
public class CartService {
	
	private static final Logger logger = LoggerFactory.getLogger(CartService.class);

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CartRepository cartRepository;

	public Cart cartCheck(Cart cart) {
		
		logger.debug("Entering into CartService ==========>> ");
		
		Product addProduct = productRepository.findByProdId(cart.getProdId());
		
		Cart addToCart = new Cart();
		addToCart.setProdId(addProduct.getProdId());
		addToCart.setProdName(addProduct.getProdName());
		addToCart.setPrice(addProduct.getPrice());
		addToCart.setDescription(addProduct.getDescription());
		addToCart.setImage(addProduct.getImage());
		addToCart.setDeliveryTime(addProduct.getDeliveryTime());
		addToCart.setCatId(addProduct.getCatId());
		addToCart.setUserId(cart.getUserId());
		return cartRepository.save(addToCart);

	}

}
