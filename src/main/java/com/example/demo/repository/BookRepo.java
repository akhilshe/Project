package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Books;

public interface BookRepo extends JpaRepository<Books, Integer>{
		
}
