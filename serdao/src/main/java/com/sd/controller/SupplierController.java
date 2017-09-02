package com.sd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sd.model.Supplier;
import com.sd.service.SupplierServiceInt;

@Controller
public class SupplierController {

	@Autowired
	private SupplierServiceInt supplierService;
	
	@RequestMapping("/reqDisplaySuppliers")
	public String displaySuppliers(Model m){
		List<Supplier> suppliers = supplierService.getAllSuppliers();
		m.addAttribute("allsuppliers", suppliers);
		return "displaysupplier";
	}
	@RequestMapping("/reqAddSupplierForm")
	public String addSupplierForm(Model m){		
		m.addAttribute("supplier", new Supplier());
		return "addsupplierform";
	}
	
	
	@RequestMapping("/reqSendSupplierData")
	public String addSupplierToDB(@ModelAttribute("supplier")Supplier sup,Model m){
		sup.setIssupplieravailable(true);
		supplierService.addSupplier(sup);
		String message = "Supplier added successfully....";
		m.addAttribute("suppliermessage", message);
		List<Supplier> suppliers = supplierService.getAllSuppliers();
		m.addAttribute("allsuppliers", suppliers);
		return "displaysupplier";
	}
	
	
	@RequestMapping("/reqDeleteSupplierAdmin")
	public String deleteProductAdmin(@RequestParam("sid")String sid,Model m){
		supplierService.deleteSupplier(sid);
		String message = "Supplier deleted successfully....";
		m.addAttribute("suppliermessage", message);
		List<Supplier> suppliers = supplierService.getAllSuppliers();
		m.addAttribute("allsuppliers", suppliers);
		return "displaysupplier";
	}
	
	@RequestMapping("/reqEditSupplierPageAdmin")
	public String editSupplierPage(@RequestParam("sid")String sid,Model m){
		Supplier sup = supplierService.getSupplierById(sid);
		m.addAttribute("supplier", sup);
		return "suppliereditadmin";
	}
	
	@RequestMapping("/reqSendUpdatedSupplierToDB")
	public String editSupplierToDb(@ModelAttribute("supplier")Supplier sup, Model m){
		supplierService.editSupplier(sup);
		String message = "Supplier edited successfully....";
		m.addAttribute("suppliermessage", message);
		List<Supplier> suppliers = supplierService.getAllSuppliers();
		m.addAttribute("allsuppliers", suppliers);
		return "displaysupplier";
	}
	
			
	
}
