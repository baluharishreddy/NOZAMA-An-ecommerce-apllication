package com.hcl.walmart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.walmart.entity.Register;
import com.hcl.walmart.responsemodel.RegisterResponse;
import com.hcl.walmart.service.RegisterService;
@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	RegisterService registerService;

	@PostMapping(value = "/register")
	public RegisterResponse registerCheck(@RequestBody Register register) {
		
		logger.debug("Entering into Register ==========>> ");
		
		Register registered = registerService.registerCheck(register);
		
		RegisterResponse registerResponse = new RegisterResponse();
		registerResponse.setUserId(registered.getUserId());
		registerResponse.setUserName(registered.getUserName());
		registerResponse.setMessage("Registration successful");
		registerResponse.setStatusCode("200");
		registerResponse.setStatusMessage("OK");
		return registerResponse;

	}


}
