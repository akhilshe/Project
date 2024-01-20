package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.User;
import com.example.demo.servicefirst.Servicefirst;

import jakarta.servlet.http.HttpSession;



@Service
public  class Services implements Servicefirst{

	@Autowired
	UserDao userDao;
	
	@Override
	public String signup(User user, BindingResult result) {
		if (userDao.checkEmailDuplicate(user.getEmail()))
			result.rejectValue("email", "error.email", "Account Already Exists - Check Email");
		if (userDao.checkMobileDuplicate(user.getMobile()))
			result.rejectValue("mobile", "error.mobile", "Account Already Exists - Check Mobile");

		
		if (result.hasErrors()) {
			return "Signup";
		}
		else
		{
			user.setUser("user");
//			user.setPassword(AES.encrypt(user.getPassword(), "123"));

			userDao.createUser(user);
			return "redirect:/signin";
			
		}
	}

	public  String login(String email, String password, HttpSession session) {
		
		return null;
	}

	
	
}
