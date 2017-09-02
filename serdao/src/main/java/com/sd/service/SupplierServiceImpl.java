package com.sd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.dao.SupplierDaoInt;
import com.sd.model.Supplier;

@Service
public class SupplierServiceImpl implements SupplierServiceInt {

	@Autowired
	private SupplierDaoInt supplierDao;
	
	public void addSupplier(Supplier sup) {
		supplierDao.addSupplier(sup);
	}

	public List<Supplier> getAllSuppliers() {		
		return supplierDao.getAllSuppliers();
	}

	public Supplier getSupplierById(String supid) {		
		return supplierDao.getSupplierById(supid);
	}

	public void editSupplier(Supplier sup) {
		supplierDao.editSupplier(sup);
	}

	public void deleteSupplier(String supid) {
		supplierDao.deleteSupplier(supid);
	}

}
