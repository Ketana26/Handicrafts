package com.sd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.dao.XpsDaoInt;
import com.sd.model.XMAP_Product_Supplier;

@Service
public class XpsServiceImpl implements XpsServiceInt {

	@Autowired
	private XpsDaoInt xpsDao;
	
	public void addxps(XMAP_Product_Supplier xps) {
		xpsDao.addxps(xps);
	}

	public List<XMAP_Product_Supplier> getAllXps() {	
		return xpsDao.getAllXps();
	}
	
	public void deleteXps(String psid) {
		xpsDao.deleteXps(psid);
	}

	public void editXps(XMAP_Product_Supplier xps) {
		xpsDao.editXps(xps);
	}

	public XMAP_Product_Supplier getXpsById(String psid) {		
		return xpsDao.getXpsById(psid);
	}
}
