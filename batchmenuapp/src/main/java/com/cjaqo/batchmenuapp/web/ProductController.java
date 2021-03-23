package com.cjaqo.batchmenuapp.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjaqo.batchmenuapp.domain.Product;
import com.cjaqo.batchmenuapp.services.MapValidationErrorService;
import com.cjaqo.batchmenuapp.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
//	@PostMapping("")
//	public ResponseEntity<?> createNewProduct(@RequestBody Product product) {
//		Product product1 = productService.saveOrUpdateProduct(product);
//		return new ResponseEntity<Product>(product1, HttpStatus.CREATED);
//	}
	
	@PostMapping("")
	public ResponseEntity<?> createNewProduct(@Valid @RequestBody Product product, BindingResult result) {
		
		ResponseEntity<?> errMap = mapValidationErrorService.MapValidationService(result);
		
		if (errMap != null) return errMap;
		
		Product product1 = productService.saveOrUpdateProduct(product);
		return new ResponseEntity<Product>(product1, HttpStatus.CREATED);
	}
	
	@GetMapping("/{productBatchNumber}")
	public ResponseEntity<?> getProductByBatchNumber(@PathVariable String productBatchNumber) {
		Product product = productService.findProductByBatchNumber(productBatchNumber);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Iterable<Product> getAllProducts() {
		return productService.findAllProducts();
	}
	
	@DeleteMapping("/{productBatchNumber}")
	public ResponseEntity<?> deleteProduct(@PathVariable String productBatchNumber) {
		productService.deleteProductByBatchNumber(productBatchNumber);
		
		return new ResponseEntity<String>("Product with batch number: '" + productBatchNumber + "' was deleted", HttpStatus.OK);
	}
}
