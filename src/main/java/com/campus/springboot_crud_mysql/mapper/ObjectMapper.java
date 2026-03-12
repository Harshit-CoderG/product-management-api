package com.campus.springboot_crud_mysql.mapper;

import com.campus.springboot_crud_mysql.dto.ProductDto;
import com.campus.springboot_crud_mysql.entity.Product;

public class ObjectMapper {

	public static Product toMapProduct(ProductDto productDto) {
		Product product=new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setColor(productDto.getColor());
		product.setMfd(productDto.getMfd());
		product.setExpd(productDto.getExpd());
		product.setPrice(productDto.getPrice());
		
		return product;
	}
	public static ProductDto toMapProductDto(Product product) {
		ProductDto productDto=new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setColor(product.getColor());
		productDto.setMfd(product.getMfd());
		productDto.setExpd(product.getExpd());
		productDto.setPrice(product.getPrice());
		
		return productDto;
	}
}
