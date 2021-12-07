package com.hcl.walmart.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.walmart.controller.BuyController;
import com.hcl.walmart.entity.MyOrders;
import com.hcl.walmart.repository.BuyRepository;

@Service
public class MyOrdersService {
	
	private static final Logger logger = LoggerFactory.getLogger(MyOrdersService.class);

	@Autowired
	BuyRepository buyRepository;

	public List<MyOrders> myOrdersCheck(MyOrders order) {
		
		logger.debug("Entering into MyOrdersService ==========>> ");
		
		return buyRepository.findByUserId(order.getUserId());
	}

}
