package com.hcl.walmart.responsemodel;

import java.util.List;

import com.hcl.walmart.entity.Product;
import com.hcl.walmart.entity.Cart;

public class MyCartResponse {
	
	List<Cart> mycart;

	private String message;
	private String StatusMessage;
	private String StatusCode;

	public List<Cart> getMycart() {
		return mycart;
	}

	public void setMycart(List<Cart> mycart) {
		this.mycart = mycart;
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
