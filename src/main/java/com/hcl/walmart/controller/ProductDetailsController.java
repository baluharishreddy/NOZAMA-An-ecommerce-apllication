package com.hcl.walmart.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.hcl.walmart.model.Products;
import com.hcl.walmart.responsemodel.ProductResponse;
import com.hcl.walmart.responsemodel.ProductListResponse;
import com.hcl.walmart.service.ProductDetailsService;
@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class ProductDetailsController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDetailsController.class);

	@Autowired
	ProductDetailsService productDetailsService;

	@PostMapping(value = "/productdetails")
	public ProductResponse productCheck(@RequestBody Product product) {
		
		logger.debug("Entering into ProductDetailsController ==========>> ");
		
		Product productDetails = productDetailsService.productCheck(product);
		
		if (productDetails == null) {
			ProductResponse addProdResponse = new ProductResponse();
			addProdResponse.setMessage("Product does not exist");
			addProdResponse.setStatusCode("200");
			addProdResponse.setStatusMessage("OK");
			return addProdResponse;

		} else {
			ProductResponse addProdResponse = new ProductResponse();
			addProdResponse.setProduct(productDetails);
			addProdResponse.setMessage("Product details");
			addProdResponse.setStatusCode("200");
			addProdResponse.setStatusMessage("OK");
			return addProdResponse;

		}

	}

}
