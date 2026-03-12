package com.campus.springboot_crud_mysql.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.springboot_crud_mysql.dto.ProductDto;
import com.campus.springboot_crud_mysql.entity.Product;
import com.campus.springboot_crud_mysql.mapper.ObjectMapper;
import com.campus.springboot_crud_mysql.service.ProductDao;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/product")
@Tag(name = "ProductController", description = "Operations related to Product details")
public class ProductController {
	@Autowired
	private ProductDao dao;

	@PostMapping(value = "/saveProduct")
	public ResponseEntity<?> saveProductController(@RequestBody @Validated ProductDto prod) {
		System.out.println(prod);
		if (prod == null) {
			return ResponseEntity.badRequest().body("Product details are not valid");

		}

		Product product1 = ObjectMapper.toMapProduct(prod);

		Product product2 = dao.saveProductDao(product1);

		Map<String, Object> responseMap = new HashMap<>();
		if (product2 != null) {
			responseMap.put("message =", "product save successfully");
			responseMap.put("data = ", product2);
			return ResponseEntity.accepted().body(responseMap);
		} else {
			responseMap.put("message =", "product not saved");
			responseMap.put("data = ", product2);
			return ResponseEntity.accepted().body(responseMap);
		}

	}

//	@PostMapping(value = "/saveMultipleProduct")
//	public List<ProductDto> saveMultipleProduct(@RequestBody @Validated List<ProductDto> productDtos) {
//		
	
//		System.out.println(productDtos);
//		if (productDtos.isEmpty() || productDtos == null) {
//			return ResponseEntity.badRequest().body("Product details are not valid");
//		}
//		Map<String, Object> responseMap = new HashMap<>();
//
//		List<Product>products=new ArrayList<>();
//		for (ProductDto pdt : productDtos) {
//			Product product = ObjectMapper.toMapProduct(pdt);
//			Product product1 = dao.saveProductDao(product);
//			
//
//			if (product1 != null) {
//				products.add(product1);
//				responseMap.put("message =", "product save successfully");
//				responseMap.put("data = ", products);
//
//			} else {
//				responseMap.put("message =", "product not saved");
//				responseMap.put("data = ", product1);
//			}
//
//		}
//		return ResponseEntity.accepted().body(responseMap);
//	}
	
	
	@GetMapping(value = "/getProductById/{prodId}")
	public ResponseEntity<?> getProductByIdController(@PathVariable(name = "prodId") int prodId) {

		Product product = dao.getProductByIdDao(prodId);
		Map<String, Object> responseMap = new HashMap<>();
		if (product != null) {
			ProductDto dto = ObjectMapper.toMapProductDto(product);
			responseMap.put("Data=", dto);
			return ResponseEntity.status(HttpStatus.FOUND).body(responseMap);

		} else {
			responseMap.put("message=", "given product id is not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);

		}
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable int id) {

	    boolean isDeleted = dao.deleteProductByIdDao(id);

	    Map<String, Object> response = new HashMap<>();

	    if (isDeleted) {
	        response.put("message", "Product deleted successfully");
	        response.put("productId", id);
	        return ResponseEntity.ok(response); // 200
	    } else {
	        response.put("message", "Product not found");
	        response.put("productId", id);
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response); // 404
	    }
	}

	@GetMapping("/getAllProduct")
	public ResponseEntity<?> getAllProduct() {

	    List<Product> productList = dao.getAllProduct();
	    Map<String, Object> responseMap = new HashMap<>();

	    if (productList == null || productList.isEmpty()) {
	        responseMap.put("message", "No products found");
	        responseMap.put("data", Collections.emptyList());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
	    }

	    List<ProductDto> dtoList = new ArrayList<>();

	    for (Product product : productList) {
	        ProductDto dto = ObjectMapper.toMapProductDto(product);
	        dtoList.add(dto);
	    }

	    responseMap.put("message", "Products fetched successfully");
	    responseMap.put("count", dtoList.size());
	    responseMap.put("data", dtoList);

	    return ResponseEntity.ok(responseMap);
	}
	
	@PostMapping("/saveMultiple")
	public List<Product> saveMultipleProduct(@RequestBody List<Product> produs){
		return dao.saveMultipleProductDao(produs);	
	}

	
@PutMapping(value="/update")
public Product updateProduct(@RequestBody Product product) {
	return dao.updateProductDao(product);
}


@GetMapping(value="/findByPrice/{price}")
List<Product> findByPrice(@PathVariable double price){
	return dao.prodFindByPrice(price);
}
@GetMapping(value="/sortProductByAttributeAsc/{attributeName}")
public List<Product> sortProductByAttributeAsc(@PathVariable (name="attributeName") String attributeName){
	return dao.sortProductByPriceAscDao(attributeName);
}

@GetMapping(value="paginationProduct/{pageNumber}")
public Page<Product> paginationProduct(@PathVariable(name="pageNumber")int pageNumber){
	return dao.paginationProductDao(pageNumber);
	
}
}
 
	


