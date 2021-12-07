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

import com.hcl.walmart.entity.MyOrders;
import com.hcl.walmart.responsemodel.BuyResponse;
import com.hcl.walmart.responsemodel.MyOrdersResponse;
import com.hcl.walmart.service.BuyService;
import com.hcl.walmart.service.MyOrdersService;
@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class MyOrdersController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyOrdersController.class);

	@Autowired
	MyOrdersService myOrdersService;

	@PostMapping(value = "/myorders")
	public MyOrdersResponse buyCheck(@RequestBody MyOrders order) {
		
		logger.debug("Entering into MyOrdersController ==========>> ");
		
		List<MyOrders> myOrders = myOrdersService.myOrdersCheck(order);
		
		if (myOrders.isEmpty()) {
			MyOrdersResponse myOrdersResponse = new MyOrdersResponse();
			myOrdersResponse.setMessage("You have no Orders");
			myOrdersResponse.setStatusCode("200");
			myOrdersResponse.setStatusMessage("OK");
			return myOrdersResponse;

		} else {
			MyOrdersResponse myOrdersResponse = new MyOrdersResponse();
			myOrdersResponse.setMyOrders(myOrders);
			myOrdersResponse.setMessage("Here are your orders");
			myOrdersResponse.setStatusCode("200");
			myOrdersResponse.setStatusMessage("OK");
			return myOrdersResponse;
		}

	}

}
