package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.User;
import com.example.demo.service.Services;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class Bookcontroller {
	@Autowired
	Services services;
	@Autowired
	User user;
	
@GetMapping("/")
 public String home() {
	return "Home";
}

@GetMapping("/signin")
public String loadSignin() {
	return "Signin";
}

@GetMapping("/signup")
public String loadSignup(ModelMap map) {
	map.put("user", user);
	return "Signup";
}

@PostMapping("/signup")
public String signup(@Valid User user, BindingResult result,ModelMap map) {
	if (result.hasErrors()) {
		
		return "Signup";
	}
	else
		
			return services.signup(user, result);
		
}
//@PostMapping("/Login")
//public String Login(@RequestParam String email,@RequestParam String password,HttpSession session)
//{
//	return Services.login(email, password, session);
//}
//pathvariable
@PostMapping("/send-otp/{id}")
public String sendotp(@PathVariable int id,ModelMap map)
{
	map.put("id", id);
	map.put("sucess message","otp sucess sent");
	return "OtpEnter";
	
	
	
}
public String verifyotp(@RequestParam int id,@RequestParam int otp,HttpSession httpSession,ModelMap modelMap)
{
	return services.verifyotp(id,otp,modelMap,httpSession);
	
	
}
}
