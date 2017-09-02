package com.sd.dao;

import java.util.List;

import com.sd.model.Supplier;

public interface SupplierDaoInt {

	public void addSupplier(Supplier sup);
	public List<Supplier> getAllSuppliers();
	public Supplier getSupplierById(String supid);
	public void editSupplier(Supplier sup);
	public void deleteSupplier(String supid);
}

