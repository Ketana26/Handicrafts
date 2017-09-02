package com.sd.dao;

import java.util.List;

import com.sd.model.Product;

public interface ProductDaoInt {
	void addProduct(Product prd);
	List<Product> getAllProducts();
	
	void deleteProduct(String pid);
	void updateProduct(Product prd);	
	Product getProductById(String pid);

}

