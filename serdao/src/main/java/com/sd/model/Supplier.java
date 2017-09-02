package com.sd.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Supplier implements Serializable {
	
	@Id
	private String supplierid;
	private String suppliername;
	private String supplierdesc;
	private boolean issupplieravailable;
	
	@Transient 	
	private MultipartFile supplierImage;

	public String getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

	public String getSuppliername() {
		return suppliername;
	}

	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}

	public String getSupplierdesc() {
		return supplierdesc;
	}

	public void setSupplierdesc(String supplierdesc) {
		this.supplierdesc = supplierdesc;
	}

	public boolean isIssupplieravailable() {
		return issupplieravailable;
	}

	public void setIssupplieravailable(boolean issupplieravailable) {
		this.issupplieravailable = issupplieravailable;
	}

	public MultipartFile getSupplierImage() {
		return supplierImage;
	}

	public void setSupplierImage(MultipartFile supplierImage) {
		this.supplierImage = supplierImage;
	}

	
	
	

}
