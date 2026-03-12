package com.campus.springboot_crud_mysql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Repository;

import com.campus.springboot_crud_mysql.entity.Product;
import com.campus.springboot_crud_mysql.repository.ProductRepository;


@Repository
public class ProductDao {
	
	@Autowired
	private ProductRepository productRepository;
	

	public Product saveProductDao(Product product) {
		return productRepository.saveAndFlush(product);
	}
	
	public  Product getProductByIdDao(int id) {
		
		Optional<Product> optional = productRepository.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
		
	}
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	public List<Product> saveMultipleProductDao(List<Product> prods){
		return productRepository.saveAllAndFlush(prods);
		
	}
	
	
	public boolean deleteProductByIdDao(int prodId) {
		Product prod=getProductByIdDao(prodId);
		if(prod!=null) {
			productRepository.delete(prod);
			return true;
		}
		return false;
	}
	
	public Product updateProductDao(Product prod) {
		Product product=getProductByIdDao(prod.getId());
		if(product==null) {
			return null;
		}
		product.setName(prod.getName());
		product.setColor(prod.getColor());
		product.setPrice(prod.getPrice());
		product.setMfd(prod.getMfd());
		product.setExpd(prod.getExpd());
		
		return productRepository.saveAndFlush(product);
	}
	
	public List<Product> prodFindByPrice(double price){
		return productRepository.findByPrice(price);
	}
	
	public List<Product> sortProductByPriceAscDao(String attributeName){
	 return productRepository.findAll(Sort.by(Order.asc(attributeName)));
	}
	
	
	public Page<Product> paginationProductDao(int pageNumber){
		return productRepository.findAll(PageRequest.of(pageNumber, 3));
	}
}
