package com.hcl.walmart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.walmart.controller.BuyController;
import com.hcl.walmart.entity.Product;
import com.hcl.walmart.repository.ProductRepository;

@Service
public class ProductDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDetailsService.class);

	@Autowired
	ProductRepository productRepository;

	public Product productCheck(Product product) {
		
		logger.debug("Entering into ProductDetailsService ==========>> ");
		
		return productRepository.findByProdId(product.getProdId());
	}

}
