package com.cjaqo.batchmenuapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjaqo.batchmenuapp.domain.Product;
import com.cjaqo.batchmenuapp.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
// 	@PostMapping("")
// 	public ResponseEntity<Product> createNewProduct(@RequestBody Product product) {
// 		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
// 	}
	
	@PostMapping("")
	public ResponseEntity<?> createNewProduct(@Valid @RequestBody Product product, BindingResult result) {
		
		if (result.hasErrors()) {
			Map<String, String> errMap = new HashMap<>();
			
			for (FieldError err: result.getFieldErrors() ) {
				errMap.put(err.getField(), err.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errMap, HttpStatus.BAD_REQUEST);
		}
		Product product1 = productService.saveOrUpdateProduct(product);
		return new ResponseEntity<Product>(product1, HttpStatus.CREATED);
	}
}
