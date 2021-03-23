package com.cjaqo.batchmenuapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjaqo.batchmenuapp.domain.Product;
import com.cjaqo.batchmenuapp.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private Product saveOrUpdateProduct(Product product) {
		
		// Logic here for when adding users, backlog, update, etc...
		return productRepository.save(product);
	}
}
