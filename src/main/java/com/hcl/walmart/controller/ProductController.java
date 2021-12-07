package com.hcl.walmart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.walmart.entity.Product;
import com.hcl.walmart.responsemodel.ProductResponse;
import com.hcl.walmart.service.ProductService;
@CrossOrigin
@RestController
@RequestMapping(value="admin/")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@PostMapping(value = "/product/add")
	public ProductResponse addCheck(@RequestBody Product product) {
		
		logger.debug("Entering into ProductController ==========>> ");
		
		Product addedProduct = productService.addCheck(product);
		
		ProductResponse addProdResponse = new ProductResponse();
		addProdResponse.setProduct(addedProduct);
		addProdResponse.setMessage("Product added");
		addProdResponse.setStatusCode("200");
		addProdResponse.setStatusMessage("OK");
		return addProdResponse;

	}

}
