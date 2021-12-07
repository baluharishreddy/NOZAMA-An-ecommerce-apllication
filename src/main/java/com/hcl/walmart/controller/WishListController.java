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
import com.hcl.walmart.entity.WishList;
import com.hcl.walmart.responsemodel.CategoryResponse;
import com.hcl.walmart.responsemodel.ProductResponse;
import com.hcl.walmart.responsemodel.WishListResponse;
import com.hcl.walmart.service.CategoryService;
import com.hcl.walmart.service.WishListService;
@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class WishListController {

	private static final Logger logger = LoggerFactory.getLogger(WishListController.class);

	@Autowired
	WishListService addToWishListService;

	@PostMapping(value = "/wishlist/add")
	public WishListResponse addCheck(@RequestBody WishList wishList) {

		logger.debug("Entering into WishListController ==========>> ");

		WishList added = addToWishListService.addCheck(wishList);
		
		if (added == null) {
			WishListResponse addToWishListResponse = new WishListResponse();
			addToWishListResponse.setMessage("You have already added this product to Wishlist");
			addToWishListResponse.setStatusCode("200");
			addToWishListResponse.setStatusMessage("OK");
			return addToWishListResponse;
		} else {
			WishListResponse addToWishListResponse = new WishListResponse();
			addToWishListResponse.setAdded(added);
			addToWishListResponse.setMessage("Added to Wishlist");
			addToWishListResponse.setStatusCode("200");
			addToWishListResponse.setStatusMessage("OK");
			return addToWishListResponse;

		}

	}

}
