package com.hcl.walmart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.walmart.controller.BuyController;
import com.hcl.walmart.entity.Category;
import com.hcl.walmart.repository.CategoryRepository;
import com.hcl.walmart.repository.ProductRepository;

@Service
public class CategoryService {

	private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

	@Autowired
	CategoryRepository categoryRepository;

	public Category addCheck(Category category) {

		logger.debug("Entering into CategoryService ==========>> ");

		Category find = categoryRepository.findByCatId(category.getCatId());		
		if (find != null)
			return null;
		else {
			return categoryRepository.save(category);
		}
	}
}
