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
	
	@PostMapping("")
	public ResponseEntity<Product> createNewProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}
}
