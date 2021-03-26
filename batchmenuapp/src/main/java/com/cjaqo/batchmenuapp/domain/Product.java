package com.cjaqo.batchmenuapp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="product")
public class Product {
	
	// Product Data
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Batch number is required")
	@Column(updatable = false, unique = true)
	private String productBatchNumber;
	
	@NotBlank(message = "Product name is required")
	private String productName;
	
	@NotBlank(message = "Product category is required")
	private String productCategory;
	
	@NotBlank(message = "Product sub-category is required")
	private String productSubCategory;
	
	@NotBlank(message = "Product total cannabinoids is required")
	private String productTotalCannabinoids;
	
	@NotBlank(message = "Product THC is required")
	private String productTHC;
	
	@NotBlank(message = "Product CBD is required")
	private String productCBD;
	
	@NotBlank(message = "Product quantity is required")
	private String productQuantity;
	
	@NotBlank(message = "Product type (S/H/I) is required")
	private String productType;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date harvest_Date;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date packaged_Date;
	
	// Object Data
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date created_At;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date updated_At;
	
	public Product() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductBatchNumber() {
		return productBatchNumber;
	}

	public void setProductBatchNumber(String productBatchNumber) {
		this.productBatchNumber = productBatchNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductSubCategory() {
		return productSubCategory;
	}

	public void setProductSubCategory(String productSubCategory) {
		this.productSubCategory = productSubCategory;
	}

	public String getProductTotalCannabinoids() {
		return productTotalCannabinoids;
	}

	public void setProductTotalCannabinoids(String productTotalCannabinoids) {
		this.productTotalCannabinoids = productTotalCannabinoids;
	}

	public String getProductTHC() {
		return productTHC;
	}

	public void setProductTHC(String productTHC) {
		this.productTHC = productTHC;
	}

	public String getProductCBD() {
		return productCBD;
	}

	public void setProductCBD(String productCBD) {
		this.productCBD = productCBD;
	}

	public String getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Date getHarvest_Date() {
		return harvest_Date;
	}

	public void setHarvest_Date(Date harvest_Date) {
		this.harvest_Date = harvest_Date;
	}

	public Date getPackaged_Date() {
		return packaged_Date;
	}

	public void setPackaged_Date(Date packaged_Date) {
		this.packaged_Date = packaged_Date;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}
	
	@PrePersist
	protected void onCreate() {
		this.created_At = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated_At = new Date();
	}
}
