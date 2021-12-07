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
import com.hcl.walmart.entity.Register;
import com.hcl.walmart.model.Products;
import com.hcl.walmart.responsemodel.CategoryListResponse;
import com.hcl.walmart.responsemodel.ProductListResponse;
import com.hcl.walmart.service.LoginService;
import com.hcl.walmart.service.ProductListService;
@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class ProductListController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductListController.class);

	@Autowired
	ProductListService productsService;

	@PostMapping(value = "/productslist")
	public ProductListResponse loginCheck(@RequestBody Category category) {
		
		logger.debug("Entering into ProductListController ==========>> ");
		
		List<Product> products = productsService.productCheck(category);
		
		if (products.isEmpty()) {
			ProductListResponse productListResponse = new ProductListResponse();
			productListResponse.setMessage("Category does not exist");
			productListResponse.setStatusCode("200");
			productListResponse.setStatusMessage("Failed");
			return productListResponse;
		} else {
			List<Products> prodNames = new ArrayList<Products>();
			for (Product product : products) {
				Products prod = new Products();
				prod.setCatId(product.getCatId());
				prod.setProdId(product.getProdId());
				prod.setProdName(product.getProdName());
				prod.setImage(product.getImage());
				prodNames.add(prod);
			}

			ProductListResponse productListResponse = new ProductListResponse();
			productListResponse.setProducts(prodNames);
			productListResponse.setMessage("Here are the products");
			productListResponse.setStatusCode("200");
			productListResponse.setStatusMessage("OK");
			return productListResponse;

		}

	}

}
