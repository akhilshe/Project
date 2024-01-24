package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.User;
import com.example.demo.repository.UserRepository;


@Repository
public class UserDao {
	@Autowired
	UserRepository userRepository;
//	public boolean checkemailduplicate(String email) {
//		userrepo.existsByEmail(email);
//		return false;
//	}
//
//
//	
//
//	public User createUser(User user) {
//		return userrepo.save(user);
//		
//	}




	public boolean checkEmailDuplicate(String email) {
		// TODO Auto-generated method stub
		return userRepository.existsByEmail(email);
	}




	public boolean checkMobileDuplicate(long mobile) {
		return userRepository.existsByMobile(mobile);
		
	}




	public User createUser(User user) {
		return userRepository.save(user);
		
	}




	public User findbyid(int id) {
		
		return userRepository.findById(id).orElseThrow();
	}


}
