package com.hcl.walmart.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.walmart.controller.BuyController;
import com.hcl.walmart.entity.Category;
import com.hcl.walmart.entity.Register;
import com.hcl.walmart.repository.CategoryRepository;
import com.hcl.walmart.repository.RegisterRepository;

@Service
public class LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	RegisterRepository registerRepository;

	@Autowired
	CategoryRepository categoryRepository;

	public List<Register> loginCheck(Register login) {

		logger.debug("Entering into LoginService1 ==========>> ");

		return registerRepository.findByUserName(login.getUserName());
	}

	public List<Category> getAllCat() {

		logger.debug("Entering into LoginService2 ==========>> ");

		return categoryRepository.findAll();
	}

}
