package com.hcl.walmart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.walmart.controller.BuyController;
import com.hcl.walmart.entity.Product;
import com.hcl.walmart.repository.ProductRepository;

@Service
public class ProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	ProductRepository productRepository;

	public Product addCheck(Product product) {
		
		logger.debug("Entering into ProductService ==========>> ");
		
		return productRepository.save(product);
	}

}
