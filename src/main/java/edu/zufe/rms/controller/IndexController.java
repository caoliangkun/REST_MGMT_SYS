package edu.zufe.rms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping(path = "/index.html")
	public String toIndex() {
		return "index";
	}
	
	@GetMapping(path = "/cart.html")
	public String toCart() {
		return "cart";
	}
	
	@GetMapping(path = "/menu.html")
	public String toMenu() {
		return "menu";
	}
	
	@GetMapping(path = "/orders.html")
	public String toOrders() {
		return "orders_all";
	}
	
	@GetMapping(path = "/orders_all.html")
	public String toOrdersAll() {
		return "orders_all";
	}
	
	@GetMapping(path = "/orders_nc.html")
	public String toOrdersNC() {
		return "orders_nc";
	}
	
	@GetMapping(path = "/orders_c.html")
	public String toOrdersC() {
		return "orders_c";
	}
	
	@GetMapping(path = "/profile.html")
	public String toProfile() {
		return "profile";
	}
	
	@GetMapping(path = "/login.html")
	public String toLogin() {
		return "login";
	}
	
	@GetMapping(path = "/register.html")
	public String toRegister() {
		return "register";
	}
	
}
