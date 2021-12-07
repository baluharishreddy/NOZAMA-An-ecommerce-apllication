package com.hcl.walmart.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.walmart.controller.BuyController;
import com.hcl.walmart.entity.WishList;
import com.hcl.walmart.repository.WishListRepository;

@Service
public class MyWishListService {
	
	private static final Logger logger = LoggerFactory.getLogger(MyWishListService.class);

	@Autowired
	WishListRepository wishListRepository;

	public List<WishList> wishListCheck(WishList wishList) {
		
		logger.debug("Entering into MyWishListService ==========>> ");
		
		return wishListRepository.findByUserId(wishList.getUserId());
	}

}
