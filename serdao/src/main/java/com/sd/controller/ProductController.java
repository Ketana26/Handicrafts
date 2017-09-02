package com.sd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sd.model.Product;
import com.sd.service.ProductServiceInt;

@Controller
public class ProductController {
	@Autowired
	private ProductServiceInt productService;
	
	@RequestMapping("/reqProductForm")
	public String displayProductForm(Model m){
		m.addAttribute("productObject", new Product());
		return "addproductform";
	}
	
	@RequestMapping("/reqSendProductData")
	public String addProduct(@ModelAttribute("productObject")Product prd,Model m){
		prd.setIsproductavailable(true);
		productService.addProduct(prd);
		String productmessage = "Product added successfully...";
		m.addAttribute("productmessage", productmessage);
		List<Product> allproducts = productService.getAllProducts();	
		m.addAttribute("allproducts", allproducts);
		return "displayproductadmin";	
	}
	
	@RequestMapping("/reqDisplayProdcutsAdmin")
	public String displayProductsAdmin(Model m){
		List<Product> allproducts = productService.getAllProducts();	
		m.addAttribute("allproducts", allproducts);
		return "displayproductadmin";
	}
	
	@RequestMapping("/reqDeleteProductAdmin")
	public String deleteProductAdmin(@RequestParam("pid")String pid,Model m){
		productService.deleteProduct(pid);
		String productmessage="Product deleted successfully....";
		m.addAttribute("productmessage", productmessage);
		List<Product> allproducts = productService.getAllProducts();	
		m.addAttribute("allproducts", allproducts);
		return "displayproductadmin";
	}
	
	@RequestMapping("/reqEditProductPageAdmin")
	public String editProductPageAdmin(@RequestParam("pid")String pid,Model m){		
		Product prd = productService.getProductById(pid);
		m.addAttribute("product",prd);
		return "producteditadmin";
	}
	
	@RequestMapping("/reqSendUpdatedProductToDB")
	public String updateProductToDB(@ModelAttribute("productObject")Product prd,Model m){
		productService.updateProduct(prd);
		String productmessage="Product edited successfully....";
		m.addAttribute("productmessage", productmessage);
		List<Product> allproducts = productService.getAllProducts();	
		m.addAttribute("allproducts", allproducts);
		return "displayproductadmin";
	}
}

	