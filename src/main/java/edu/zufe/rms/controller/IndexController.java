package edu.zufe.rms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.zufe.rms.enums.FoodType;
import edu.zufe.rms.model.CartItem;
import edu.zufe.rms.model.Customer;
import edu.zufe.rms.model.Food;
import edu.zufe.rms.model.Order;
import edu.zufe.rms.service.CartItemService;
import edu.zufe.rms.service.FoodService;
import edu.zufe.rms.service.OrderService;
import edu.zufe.rms.service.TableService;

@Controller
public class IndexController {
	@Autowired
	FoodService foodService;
	@Autowired
	CartItemService cartService;
	@Autowired
	OrderService orderService;

	@GetMapping(path = "/index.html")
	public String toIndex(HttpSession session) {
		if (session.getAttribute("person") == null) {
			Customer cust = new Customer();
			cust.setLogin(false);
			cust.setTableId(Long.valueOf(0L));
			session.setAttribute("person", cust);
			session.setAttribute("cust", cust);
		}
		return "index";
	}

	

	

	@GetMapping(path = "/orders.html")
	public String toOrders() {
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

	@GetMapping(path = "/profile")
	public String toProfile(HttpSession session, Model model) {
		Customer cust = (Customer) session.getAttribute("cust");
		model.addAttribute("cust", cust);
		return "profile";
	}

	@GetMapping(path = "/login")
	public String toLogin() {
		return "login";
	}

	@GetMapping(path = "/register.html")
	public String toRegister() {
		return "register";
	}
	
	@GetMapping(path = "/about")
	public String toAbout() {
		return "about";
	}
	
	
	
}
