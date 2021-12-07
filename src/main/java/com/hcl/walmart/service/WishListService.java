package com.hcl.walmart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.walmart.entity.Product;
import com.hcl.walmart.controller.BuyController;
import com.hcl.walmart.entity.Cart;
import com.hcl.walmart.entity.WishList;
import com.hcl.walmart.repository.ProductRepository;
import com.hcl.walmart.repository.WishListRepository;

@Service
public class WishListService {

	private static final Logger logger = LoggerFactory.getLogger(WishListService.class);

	@Autowired
	ProductRepository productRepository;

	@Autowired
	WishListRepository wishListRepository;

	public WishList addCheck(WishList wishList) {

		logger.debug("Entering into WishListService ==========>> ");

		WishList find = wishListRepository.findByUserIdAndProdId(wishList.getUserId(), wishList.getProdId());
		if (find != null) {
			return null;
		} else {
			Product added = productRepository.findByProdId(wishList.getProdId());
			WishList add = new WishList();
			add.setProdId(added.getProdId());
			add.setProdName(added.getProdName());
			add.setPrice(added.getPrice());
			add.setDescription(added.getDescription());
			add.setImage(added.getImage());
			add.setDeliveryTime(added.getDeliveryTime());
			add.setCatId(added.getCatId());
			add.setUserId(wishList.getUserId());
			return wishListRepository.save(add);
		}
	}

}
