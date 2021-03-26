package com.cjaqo.batchmenuapp.exceptions;

public class ProductIdExceptionResponse {
	
	private String productBatchNumber;
	
	public ProductIdExceptionResponse(String productBatchNumber) {
		this.productBatchNumber = productBatchNumber;
	}

	public String getProductBatchNumber() {
		return productBatchNumber;
	}

	public void setProductBatchNumber(String productBatchNumber) {
		this.productBatchNumber = productBatchNumber;
	}
	
	

}
