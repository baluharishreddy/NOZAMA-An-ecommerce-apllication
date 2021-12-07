package com.hcl.walmart.responsemodel;

import java.util.List;

import com.hcl.walmart.entity.MyOrders;
import com.hcl.walmart.entity.WishList;

public class MyWishListResponse {
	
	List<WishList> wishList;

	private String message;
	private String StatusMessage;
	private String StatusCode;

	public List<WishList> getWishList() {
		return wishList;
	}

	public void setWishList(List<WishList> wishList) {
		this.wishList = wishList;
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
