package com.campus.springboot_crud_mysql.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Product {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_seq")
	@SequenceGenerator(name = "product_seq", schema = "product.product_seq",initialValue = 1001,allocationSize = 1)
	@Schema(description = "mat kar lala")
	private int id;
	private String name;
	private String color;
	private double price;
	private LocalDate mfd;
	private LocalDate expd;
	

}
