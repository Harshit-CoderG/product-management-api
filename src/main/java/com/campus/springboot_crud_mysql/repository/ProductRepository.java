package com.campus.springboot_crud_mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.campus.springboot_crud_mysql.entity.Product;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	List<Product>findByPrice(double price);
	List<Product> findByPriceLessThan(double price);

	@Query("Select p from Product p where p.color=?1")
	List<Product> getProductByColor(String color);
	
	
	@Query("Delete from Product p where p.color=?1")
	@Transactional
	@Modifying
	void deleteProductByColor(String color);
}
