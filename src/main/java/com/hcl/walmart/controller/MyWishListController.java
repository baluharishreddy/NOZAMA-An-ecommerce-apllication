package com.hcl.walmart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.walmart.entity.Cart;
import com.hcl.walmart.entity.WishList;
import com.hcl.walmart.repository.WishListRepository;
import com.hcl.walmart.responsemodel.MyCartResponse;
import com.hcl.walmart.responsemodel.MyWishListResponse;
import com.hcl.walmart.service.MyWishListService;
@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class MyWishListController {

	private static final Logger logger = LoggerFactory.getLogger(MyWishListController.class);

	@Autowired
	MyWishListService myWishListService;

	@PostMapping(value = "/mywishlist")
	public MyWishListResponse cartCheck(@RequestBody WishList wishList) {
		
		logger.debug("Entering into MyWishListController ==========>> ");
		
		List<WishList> myWishList = myWishListService.wishListCheck(wishList);
		
		if (myWishList.isEmpty()) {
			MyWishListResponse myWishListResponse = new MyWishListResponse();
			myWishListResponse.setMessage("Your Wishlist is empty");
			myWishListResponse.setStatusCode("200");
			myWishListResponse.setStatusMessage("OK");
			return myWishListResponse;

		} else {
			MyWishListResponse myWishListResponse = new MyWishListResponse();
			myWishListResponse.setWishList(myWishList);
			myWishListResponse.setMessage("Here is your Wishlist");
			myWishListResponse.setStatusCode("200");
			myWishListResponse.setStatusMessage("OK");
			return myWishListResponse;
		}

	}

}
