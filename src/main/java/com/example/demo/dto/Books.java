package com.example.demo.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Entity
@Component
@Data
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min =5, max = 50,message = "* Enter Between 5~ 50 letters ")
	private String name;
	@Size(min =5, max = 50,message = "* Enter Between 5~ 50 letters ")
	private String authorName;
	@Size(min =5, max = 50,message = "* Enter Between 5~ 50 letters ")
	private String genre;
	@Size(min =5, max = 50,message = "* Enter Between 5~ 50 letters ")
	private double price;
	@DecimalMin(value = "1", message = "* Enter Stock greater than 1")
	private int stock;
	@NotEmpty(message = "* this is required field")
	private String type;
	private String picturePath;
	private String demoPdfPath;


}
