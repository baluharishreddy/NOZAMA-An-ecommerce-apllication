package com.hcl.walmart.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.walmart.controller.BuyController;
import com.hcl.walmart.entity.Category;
import com.hcl.walmart.entity.Product;
import com.hcl.walmart.repository.ProductRepository;

@Service
public class ProductListService {
	private static final Logger logger = LoggerFactory.getLogger(ProductListService.class);

	@Autowired
	ProductRepository productRepository;

	public List<Product> productCheck(Category category) {
		
		logger.debug("Entering into ProductListService ==========>> ");
		
		return productRepository.findByCatId(category.getCatId());
	}

}
