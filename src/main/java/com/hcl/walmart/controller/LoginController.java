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

import com.hcl.walmart.entity.Category;
import com.hcl.walmart.entity.Register;
import com.hcl.walmart.responsemodel.CategoryListResponse;
import com.hcl.walmart.responsemodel.RegisterResponse;
import com.hcl.walmart.service.LoginService;
import com.hcl.walmart.service.RegisterService;
@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginService loginService;

	@PostMapping(value = "/login")
	public CategoryListResponse loginCheck(@RequestBody Register login) {

		int check = 0;
		logger.debug("Entering into LoginController ==========>> ");

		List<Register> loggedin = loginService.loginCheck(login);

		if (loggedin.isEmpty()) {
			CategoryListResponse catListResponse = new CategoryListResponse();
			catListResponse.setMessage("User does not exist");
			catListResponse.setStatusCode("200");
			catListResponse.setStatusMessage("Login failed");
			return catListResponse;
		}

		else {
			for (Register register : loggedin) {
				if (register.getUserName().equals(login.getUserName())
						&& register.getPassword().equals(login.getPassword())) {

					List<Category> catList = loginService.getAllCat();
					check = 1;
					CategoryListResponse catListResponse = new CategoryListResponse();
					catListResponse.setUserId(register.getUserId());
					catListResponse.setUserName(register.getUserName());
					catListResponse.setMessage("You have successfully logged in");
					catListResponse.setStatusCode("200");
					catListResponse.setStatusMessage("OK");
					catListResponse.setCategory(catList);
					return catListResponse;
				}
			}
			if (check == 0) {
				CategoryListResponse catListResponse = new CategoryListResponse();
				catListResponse.setMessage("Passwords does not match");
				catListResponse.setStatusCode("200");
				catListResponse.setStatusMessage("Login failed");
				return catListResponse;
			}
			return null;
		}

	}

}
