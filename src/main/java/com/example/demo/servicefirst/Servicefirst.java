package com.example.demo.servicefirst;

import org.springframework.validation.BindingResult;

import com.example.demo.dto.User;

import jakarta.servlet.http.HttpSession;


public interface Servicefirst {
	public String signup(User user,BindingResult result);
	public String login(String email, String password, HttpSession session);
}
