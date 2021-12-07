package com.hcl.walmart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.walmart.controller.BuyController;
import com.hcl.walmart.entity.Register;
import com.hcl.walmart.repository.CategoryRepository;
import com.hcl.walmart.repository.RegisterRepository;

@Service
public class RegisterService {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterService.class);

	@Autowired
	RegisterRepository registerRepository;

	public Register registerCheck(Register register) {
		
		logger.debug("Entering into RegisterService ==========>> ");
		
		return registerRepository.save(register);
	}

}
