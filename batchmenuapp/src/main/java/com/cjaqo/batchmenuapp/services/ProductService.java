package com.cjaqo.batchmenuapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjaqo.batchmenuapp.domain.Product;
import com.cjaqo.batchmenuapp.exceptions.ProductIdException;
import com.cjaqo.batchmenuapp.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public Product saveOrUpdateProduct(Product product) {
		
		try {
			product.setProductBatchNumber(product.getProductBatchNumber().toUpperCase());
			return productRepository.save(product);
		} catch (Exception e) {
			throw new ProductIdException("Product Batch Number '" + product.getProductBatchNumber().toUpperCase() + "' already exists");
		}
		
		// Logic here for when adding users, backlog, update, etc...
//		return productRepository.save(product);
	}
	
	public Product findProductByBatchNumber(String productBatchNumber) {
		Product product = productRepository.findByProductBatchNumber(productBatchNumber.toUpperCase());
		
		if (product == null) {
			throw new ProductIdException("Product Batch Number '" + productBatchNumber + "' does not exist");
		}
		return product;
	}
	
	public Iterable<Product> findAllProducts() {
		return productRepository.findAll();
	}
	
	public void deleteProductByBatchNumber(String productBatchNumber) {
		Product product = productRepository.findByProductBatchNumber(productBatchNumber.toUpperCase());
		
		if (product == null) {
			throw new ProductIdException("Cannot delete product with batch number '" + productBatchNumber + "'. This product does not exist.");
		}
		
		productRepository.delete(product);
	}
}
