package com.hcl.walmart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.walmart.entity.Category;
import com.hcl.walmart.entity.Product;
import com.hcl.walmart.responsemodel.CategoryResponse;
import com.hcl.walmart.responsemodel.ProductResponse;
import com.hcl.walmart.service.CategoryService;
import com.hcl.walmart.service.ProductService;
@CrossOrigin
@RestController
@RequestMapping(value="admin/")
public class CategoryController {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	CategoryService categoryService;

	@PostMapping(value = "/category/add")
	public CategoryResponse addCheck(@RequestBody Category category) {

		logger.debug("Entering into CategoryController ==========>> ");

		Category addedCat = categoryService.addCheck(category);
		if (addedCat == null) {
			CategoryResponse addcatResponse = new CategoryResponse();
			addcatResponse.setMessage("Category already exists");
			addcatResponse.setStatusCode("200");
			addcatResponse.setStatusMessage("OK");
			return addcatResponse;
		} else {
			CategoryResponse addcatResponse = new CategoryResponse();
			addcatResponse.setCategory(addedCat);
			addcatResponse.setMessage("Category added");
			addcatResponse.setStatusCode("200");
			addcatResponse.setStatusMessage("OK");
			return addcatResponse;

		}

	}

}
