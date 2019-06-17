package com.cgapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgapp.dto.LoginRepository;
import com.cgapp.entity.Login;

@RestController
public class LoginController {

	@Autowired
	private LoginRepository repo;

	@RequestMapping("/test")
	public String hello() {
		return "test";
	}

	@PostMapping("/create")
	public String createlogin(@RequestBody Login login) {
		repo.save(login);
		return "Data Added";
	}
}
