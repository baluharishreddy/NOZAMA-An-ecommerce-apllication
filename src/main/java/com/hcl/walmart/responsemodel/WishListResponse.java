package com.hcl.walmart.responsemodel;

import com.hcl.walmart.entity.Product;
import com.hcl.walmart.entity.WishList;

public class WishListResponse {
	
	private WishList added;
	private String message;
	private String StatusMessage;
	private String StatusCode;

	public WishList getAdded() {
		return added;
	}

	public void setAdded(WishList added) {
		this.added = added;
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
