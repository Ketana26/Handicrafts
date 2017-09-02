package com.sd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sd.model.Cart;
import com.sd.model.CartItem;
import com.sd.model.Customer;
import com.sd.model.Vw_Prod_Supp_Xps;
import com.sd.model.XMAP_Product_Supplier;
import com.sd.service.CartItemServiceInt;
import com.sd.service.CartServiceInt;
import com.sd.service.CustomerServiceInt;
import com.sd.service.XpsServiceInt;

@Controller
public class CartController {

	@Autowired
	private XpsServiceInt xpsService;
	
	@Autowired
	private CartItemServiceInt cartItemService;
	
	@Autowired
	private CustomerServiceInt customerService;
	
	@Autowired
	private CartServiceInt cartService;
	
	@RequestMapping("/reqAddItemToCart/{psid}")
	public String addItemToCart(@PathVariable("psid")String psid, @RequestParam("qty")int qty,HttpSession hsession,Model m){
		System.out.println("psid : "+psid + "  qty : " + qty);
		Customer cust = (Customer)hsession.getAttribute("customerprofile");
		Cart cart = cust.getCart();
		XMAP_Product_Supplier xps = xpsService.getXpsById(psid);
		CartItem cartitem = new CartItem();
		cartitem.setCart(cart);
		cartitem.setXmap_product_supplier(xps);
		cartitem.setQuantity(qty);
		cartitem.setItemwisetotal(xps.getProductsupplierprice()*qty);
		
		cartItemService.addCartItem(cartitem);
		
		Customer customer1=customerService.getCustomerByUserId(cust.getUserDetails().getUserid());
		Cart cart1=customer1.getCart();		
		
		List<CartItem> cartitems = cart1.getCartItems();
		int sum=0;
		for(CartItem critem :cartitems){
			sum+= critem.getItemwisetotal();
		}
		cart1.setTotalbill(sum);
		cartService.updateCart(cart1);	
		hsession.setAttribute("customerprofile", customerService.getCustomerById(customer1.getCustomerid()));
		List <Vw_Prod_Supp_Xps> productsuser = customerService.getProductsForUser();	
		m.addAttribute("productsuser", productsuser);
		m.addAttribute("cartmessage","Item added to cart successfully..");
		return "userhomepage";
	}
	
	@RequestMapping("/reqDisplayCart")
	public String displayCart(HttpSession hsession,Model m){
		
		Customer cust = (Customer)hsession.getAttribute("customerprofile");
		Customer cust1 = customerService.getCustomerById(cust.getCustomerid());
		Cart cart = cust1.getCart();	
		hsession.setAttribute("customerprofile",cust1);		
		
		List<CartItem> cartitems = cart.getCartItems();	
		int sum=0;
		for(CartItem critem :cartitems){
			sum+= critem.getItemwisetotal();
		}  
		cart.setTotalbill(sum);
		cartService.updateCart(cart);			

		m.addAttribute("cartitems", cartitems);
		return "displaycartitem";
	}
	
	
	@RequestMapping("/reqDeleteCartItem/{cartitemid}")
	public String deleteCartItem(@PathVariable("cartitemid")String cartitemid,HttpSession hsession ){
		cartItemService.removeCartItem(cartitemid);		
		return "redirect:/reqDisplayCart";
	}	

	@RequestMapping("/reqClearCart/{customerid}")
	public String deleteAllCartItems(@PathVariable("customerid")String customerid,HttpSession hsession){
		cartItemService.removeAllCartItems(customerid);	
		
		Customer cust = (Customer)hsession.getAttribute("customerprofile");
		cust.getCart().setTotalbill(0);
		cartService.updateCart(cust.getCart());
		
		hsession.setAttribute("customerprofile", customerService.getCustomerById(cust.getCustomerid()));
		return "redirect:/reqDisplayProductsUser";
	}
}

