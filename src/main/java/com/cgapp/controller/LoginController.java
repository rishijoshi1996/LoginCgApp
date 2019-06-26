package com.cgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgapp.dto.LoginRepository;
import com.cgapp.entity.Login;
@CrossOrigin(origins = "*", allowedHeaders = "*") 
@RestController
@RequestMapping("/cgapp")
public class LoginController {

	@Autowired
	private LoginRepository repo;

	@RequestMapping("/test")
	public String hello() {
		return "test";
	}

	@PostMapping("/login")
	public String createlogin(@RequestBody Login login) {
		repo.save(login);
		return "Data Added";
	}

	@GetMapping("/getlogin")
	public List<Login> getLogin() {
		return repo.findAll();
	}

	@GetMapping("/login")
	public String checkLogin(Login login) {
		if (login.getUsername().equals("rishi") && login.getPassword().equals("1234")) {
			return "Login success";
		} else {
			return "Login Fail";
		}
	}
}
