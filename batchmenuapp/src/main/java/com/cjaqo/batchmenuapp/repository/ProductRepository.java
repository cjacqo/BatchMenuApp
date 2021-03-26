package com.cjaqo.batchmenuapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjaqo.batchmenuapp.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	Product findByProductBatchNumber(String productBatchNumber);
	
	@Override
	Iterable<Product> findAll();
	
}
