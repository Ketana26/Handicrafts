package com.sd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.dao.CustomerDaoInt;
import com.sd.model.Customer;
import com.sd.model.UserDetails;
import com.sd.model.Vw_Prod_Supp_Xps;

@Service
public class CustomerServiceImpl implements CustomerServiceInt {

	@Autowired
	private CustomerDaoInt customerDao;

	public String addCustomer(Customer cust) {
		return customerDao.addCustomer(cust);
	}

	public Customer getCustomerByUserId(String uid) {
		return customerDao.getCustomerByUserId(uid);
	}
	
	public Customer getCustomerById(String custid) {
		return customerDao.getCustomerById(custid);
	}
	
	public UserDetails loginCheck(UserDetails ud)
	{
		return customerDao.loginCheck(ud);
	}
	
    public List<Vw_Prod_Supp_Xps> getProductsForUser() {
	return customerDao.getProductsForUser();
    }
    
    public List<Vw_Prod_Supp_Xps> getAllSuppProd(String pid) {		
		return customerDao.getAllSuppProd(pid);
	}
}