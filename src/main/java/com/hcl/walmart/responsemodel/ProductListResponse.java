package com.hcl.walmart.responsemodel;

import java.util.List;

import com.hcl.walmart.entity.Product;
import com.hcl.walmart.model.Products;

public class ProductListResponse {

	List<Products> products;

	private String message;
	private String StatusMessage;
	private String StatusCode;

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusMessage() {
		return StatusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		StatusMessage = statusMessage;
	}

	public String getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}

}
