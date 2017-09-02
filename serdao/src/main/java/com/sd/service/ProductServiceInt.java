package com.sd.service;

import java.util.List;

import com.sd.model.Product;

public interface ProductServiceInt {
	void addProduct(Product prd);
	void deleteProduct(String pid);
	void updateProduct(Product prd);
	List<Product> getAllProducts();
	Product getProductById(String pid);
}
