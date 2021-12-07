package com.hcl.walmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.walmart.entity.Category;
import com.hcl.walmart.entity.Register;
import com.hcl.walmart.responsemodel.CategoryListResponse;
import com.hcl.walmart.service.LoginService;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class CatListController 
{
	@Autowired
	LoginService loginService;

	@PostMapping(value = "/catlist")
	public CategoryListResponse loginCheck()
	{
		List<Category> catList = loginService.getAllCat();
		CategoryListResponse catListResponse = new CategoryListResponse();
		catListResponse.setMessage("You have successfully logged in");
		catListResponse.setStatusCode("200");
		catListResponse.setStatusMessage("OK");
		catListResponse.setCategory(catList);
		return catListResponse;
	
	}
	

}
