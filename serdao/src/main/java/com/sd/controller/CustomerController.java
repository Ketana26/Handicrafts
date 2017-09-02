package com.sd.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sd.model.BillingAddress;
import com.sd.model.Cart;
import com.sd.model.Customer;
import com.sd.model.ShippingAddress;
import com.sd.model.UserDetails;
import com.sd.model.Vw_Prod_Supp_Xps;
import com.sd.service.CustomerServiceInt;
import com.sd.service.UserDetailsServiceInt;
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerServiceInt customerService;
	
	@RequestMapping("/reqLoginPage1")
	public String loginPage1(@RequestParam(value="error", required=false)String error,Model m){
		if(error!=null){
			String message = "Login failed..,\nTry again...";
			m.addAttribute("errormsg", message);
		}
		return "springSecuityLoginPage";
	}

	@RequestMapping("/reqLogoutSpring")  // spring security logout
	public String logoutSpring(HttpSession hsession,Model m){
		hsession.invalidate();
		String logoutMessage = "Logged out succcessfully.\nThanks for visiting our site...";
		m.addAttribute("message", logoutMessage);
		return "homepage";
	}

	
	
	/*@RequestMapping("/reqLogout")
	public String logout(HttpSession hsession,Model m){
       hsession.invalidate();
	   String logoutMessage="logged out successfully.\nThanks for visiting our site";
       m.addAttribute("message",logoutMessage);
	   return "homepage";
	}*/
	 
	 
	@RequestMapping("/reqSignupPages")
	public String displaySignupForm(Model m) {
		UserDetails ud = new UserDetails();
		ShippingAddress sad = new ShippingAddress();
		Customer cust = new Customer();
		cust.setUserDetails(ud);
		cust.setShippingAddress(sad);
		m.addAttribute("customer", cust);
		return "signuppages";
	}
	
	@RequestMapping("/reqSendSignupData")
	public String sendSignUpData(@ModelAttribute("customer") Customer cust, Model m) {

		cust.setEnabled(true);
		cust.getUserDetails().setUserrole("ROLE_USER");
		cust.getUserDetails().setEnabled(true);

		BillingAddress bad = new BillingAddress();
		bad.setHouseno(cust.getShippingAddress().getHouseno());
		bad.setStreet(cust.getShippingAddress().getStreet());
		bad.setArea(cust.getShippingAddress().getArea());
		bad.setCity(cust.getShippingAddress().getCity());
		bad.setState(cust.getShippingAddress().getState());
		bad.setCountry(cust.getShippingAddress().getCountry());
		bad.setPincode(cust.getShippingAddress().getPincode());

		Cart crt = new Cart();

		cust.setBillingAddress(bad);
		cust.setCart(crt);

		String userid = customerService.addCustomer(cust);
		String message = "Signup is successfull.\nNew User id : " + userid;
		m.addAttribute("signupmsg", message);
		m.addAttribute("userObject", new UserDetails());
		return "loginpage1";

	}
	@RequestMapping("/reqSendSignupData1")
	public String sendSignUpData(@Valid @ModelAttribute("customer") Customer cust, BindingResult result, Model m) {
		if(result.hasErrors())
		{
			System.out.println("\n errors");
			m.addAttribute("customer",cust);
			return "signuppages";
		}

		cust.setEnabled(true);
		cust.getUserDetails().setUserrole("ROLE_USER");
		cust.getUserDetails().setEnabled(true);

		BillingAddress bad = new BillingAddress();
		bad.setHouseno(cust.getShippingAddress().getHouseno());
		bad.setStreet(cust.getShippingAddress().getStreet());
		bad.setArea(cust.getShippingAddress().getArea());
		bad.setCity(cust.getShippingAddress().getCity());
		bad.setState(cust.getShippingAddress().getState());
		bad.setCountry(cust.getShippingAddress().getCountry());
		bad.setPincode(cust.getShippingAddress().getPincode());

		Cart crt = new Cart();

		cust.setBillingAddress(bad);
		cust.setCart(crt);

		String userid = customerService.addCustomer(cust);
		String message = "Signup is successfull.\nNew User id : " + userid;
		m.addAttribute("signupmsg", message);
		m.addAttribute("userObject", new UserDetails());
		return "loginpage1";

	}
	
	/*@RequestMapping("/reqLoginPage")
	public String loginPage(UserDetails ud,Model m){
		m.addAttribute("userObject", new UserDetails());
		return "loginpage1";
	}*/
	
	@RequestMapping("/springLoginCheck") // comes here after spring security authenticates user
	public String loginCheck(Principal principal,HttpSession hsession,Model m){
		System.out.print("\nCustomerController - springLoginCheck()");
		System.out.println("\nName : " + principal.getName());
		Customer customer = customerService.getCustomerByUserId(principal.getName());
		UserDetails userDetials = customer.getUserDetails();
		System.out.println("\nRole : " + userDetials.getUserrole());

		if(userDetials.getUserrole().equals("ROLE_USER")){
			hsession.setAttribute("customerprofile", customer);
			return "redirect:/reqDisplayProductsUser";
		}

		if(userDetials.getUserrole().equals("ROLE_ADMIN")){
			hsession.setAttribute("adminprofile", customer);
			return "adminhomepage";
		}
		return "";
	}
	
	/*@RequestMapping("/reqLoginCheck")
	public String loginCheck(HttpSession hsession,@ModelAttribute("userObject") UserDetails ud, Model m) {
		UserDetails temp = customerService.loginCheck(ud);
		System.out.println(temp);
		if (temp == null) {// if authentication failed
			String message = "Login failed..,\nTry again...";
			m.addAttribute("userObject", new UserDetails());
			m.addAttribute("errormsg", message);
			return "loginpage1";
		} else if (temp.getUserrole().equals("ROLE_USER")) {			
			List <Vw_Prod_Supp_Xps> productsuser = customerService.getProductsForUser();
			Customer cust = customerService.getCustomerByUserId(temp.getUserid());
			System.out.println(cust.getCart().getCartItems());
			hsession.setAttribute("customerprofile",customerService.getCustomerByUserId(temp.getUserid()) );
			m.addAttribute("productsuser",productsuser);
			return "userhomepage";
		} else {			
			hsession.setAttribute("adminprofile", customerService.getCustomerByUserId(temp.getUserid()));
			m.addAttribute("userid", temp.getUserid());
			return "adminhomepage";
		}
	}*/
	
	@RequestMapping("/reqDisplayProductsUser")
	public String displayProductsUser(HttpSession hsession, Model m) {
		Customer oldcust = (Customer) hsession.getAttribute("customerprofile");
		Customer newcust = customerService.getCustomerById(oldcust.getCustomerid());
		hsession.setAttribute("customerprofile", newcust);
		List <Vw_Prod_Supp_Xps> productsuser = customerService.getProductsForUser();
		m.addAttribute("productsuser", productsuser);
		return "userhomepage";
	}
	
	@RequestMapping("/reqProductAllSuppliers")
	public String getProductsAllSuppliers(@RequestParam("pid")String pid,Model m){
		List<Vw_Prod_Supp_Xps> allSupProd = customerService.getAllSuppProd(pid);
		m.addAttribute("allSupProd", allSupProd);
		return "productsAllSuppliers";
	}
}



