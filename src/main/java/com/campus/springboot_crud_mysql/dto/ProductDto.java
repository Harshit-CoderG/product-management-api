package com.campus.springboot_crud_mysql.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import lombok.Data;


@Data
public class ProductDto {
	private int id;
	@NotEmpty(message="Product name must not be empty")
	private String name;
	private String color;
	@Positive(message="price must be greater than 0")
	private double price;
	@PastOrPresent(message="Manufacturing date must be in past or present")
	private LocalDate mfd;
	@FutureOrPresent(message="expiry date must be in future or present")
	private LocalDate expd;
	
}
