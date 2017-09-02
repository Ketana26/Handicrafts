package com.sd.dao;

import java.util.List;

import com.sd.model.Customer;
import com.sd.model.UserDetails;
import com.sd.model.Vw_Prod_Supp_Xps;

public interface CustomerDaoInt {

	public String addCustomer(Customer cust);
	public Customer getCustomerByUserId(String uid);
	public Customer getCustomerById(String custid);
	UserDetails loginCheck(UserDetails ud);
	public List<Vw_Prod_Supp_Xps> getProductsForUser();
	public List<Vw_Prod_Supp_Xps> getAllSuppProd(String pid);
	}
