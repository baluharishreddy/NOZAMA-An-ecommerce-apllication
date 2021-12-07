package com.hcl.walmart.responsemodel;

import java.util.List;

import com.hcl.walmart.entity.MyOrders;

public class BuyResponse {
	
	private MyOrders boughtProduct;
	private String message;
	private String StatusMessage;
	private String StatusCode;

	public MyOrders getBoughtProduct() {
		return boughtProduct;
	}

	public void setBoughtProduct(MyOrders boughtProduct) {
		this.boughtProduct = boughtProduct;
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
