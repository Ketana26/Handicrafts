package com.sd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.dao.ProductDaoInt;
import com.sd.model.Product;

@Service
public class ProductServiceImpl implements ProductServiceInt {

	@Autowired
	private ProductDaoInt productDao;
	
	public void addProduct(Product prd) {
		productDao.addProduct(prd);
	}

	public List<Product> getAllProducts() {		
		return productDao.getAllProducts();
	}
	public void deleteProduct(String pid) {
		productDao.deleteProduct(pid);
	}

	public void updateProduct(Product prd) {
		productDao.updateProduct(prd);
	}

	public Product getProductById(String pid) {		
		return productDao.getProductById(pid);
	}

}
