package com.sd.dao;

import java.util.List;

import com.sd.model.Cart;
import com.sd.model.CustomerOrder;
import com.sd.model.CustomerOrderHistory;

public interface CustomerOrderDaoInt {
	public void addCustomerOrder(Cart cart);//throws MessagingException;
	public List<CustomerOrder> custOrders(String custid);
	//public void addProductReview(ProductReview pr);
	public float getRating(String productid);
	public CustomerOrderHistory getCustomerOrderHistoryByOrderHistoryId(String ordhistid);
	public int getNoOfReviews(String productid);
	public int getNoOfItemsSold(String productid);
	//public List<Vw_Cust_Rating> getCommentsForProduct(String productid);
	public void updateOrderHistory(CustomerOrderHistory coh);
	
}