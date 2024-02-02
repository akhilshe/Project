package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.Books;
import com.example.demo.dto.User;
import com.example.demo.service.AdminService;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/admin")
@MultipartConfig
public class AdminController {
	@Autowired
	AdminService adminService;
	@GetMapping
	public String loadAdminDashboard(HttpSession session) {
		return adminService.loadAdminDashBoard(session);
	}
	@GetMapping("/add-book")
	public String addBook(HttpSession session, ModelMap map) {
		return adminService.addbook(session, map);
	}
	
}
