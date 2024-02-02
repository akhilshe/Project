package com.example.demo.service;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Books;
import com.example.demo.dto.User;

@Service
public class AdminService {
	@Autowired
	Books book;
	
	@Autowired
	User user;
	
	public String loadAdminDashBoard(HttpSession session) {
		User user = (User)session.getAttribute("user");
		if (user ==null)
		{
			session.setAttribute("failMessage", "Session Expired");
			return "redirect:/signin";
		}
		else 
		{
		if (user.getUser().equals("ADMIN"))
		{
			return "Admindashboard";
		}
		else 
		{
			session.setAttribute("failMessage", "ou are Unauthorized to use this URL");
			return "redirect:/signin";
		}
		}
	}
	
	
//	public String loadAdminDashboard(HttpSession session) 
//	{
//		return adminService.loadAdminDashBoard(session);
//	}
//@PostMapping("path")
	public String addbook(HttpSession session, ModelMap map)
	{
	User user = (User) session.getAttribute("user");
	if (user == null) {
		session.setAttribute("failMessage", "Session Expired");
		return "redirect:/signin";
	} else {
		if (user.getUser().equals("ADMIN")) {
			map.put("book",book);
			return "AddBook";
		} else {
			session.setAttribute("failMessage", "You are Unauthorized to use this URL");
			return "redirect:/";
		}
	}
	}
}
