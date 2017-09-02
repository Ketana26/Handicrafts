package com.sd.service;

import java.util.List;

import com.sd.model.Supplier;

public interface SupplierServiceInt {
	public void addSupplier(Supplier sup);
	public List<Supplier> getAllSuppliers();
	public Supplier getSupplierById(String supid);
	public void editSupplier(Supplier sup);
	public void deleteSupplier(String supid);
}
