package edu.zufe.rms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.zufe.rms.model.CartItem;
import edu.zufe.rms.model.Customer;
import edu.zufe.rms.model.Food;
import edu.zufe.rms.model.Order;
import edu.zufe.rms.model.OrderItem;
import edu.zufe.rms.service.CartItemService;
import edu.zufe.rms.service.CustomerService;
import edu.zufe.rms.service.OrderItemService;
import edu.zufe.rms.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private CartItemService cartService;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired 
	private CustomerService custService;
	
	@GetMapping("/saveOrder")
	public String saveOrder(HttpSession session) {
		Customer c = (Customer) session.getAttribute("cust");
		Customer cust = custService.findByPhone(c.getPhone());
		// Save a order record in table orders
		Order order = orderService.save(cust);
		
		// Save all order items record with order id
		List<CartItem> cart = cartService.findAll(cust);
		double addition = 0.0;
		for (CartItem i : cart) {
			Food food = i.getFood();
			int quantity = i.getQuantity();
			OrderItem orderItem = orderItemService.save(food, order, quantity);
			orderItem.setCreatedAt(new Date());
			addition += orderItem.getFood().getPrice() * orderItem.getQuantity() ;
		}
		orderService.changeTotalPrice(addition, order);
		// Delete the cart items 
		cartService.deleteAll();
		return "order_success";
	}
	
	@GetMapping(path = "/allOrders")
	public String toOrdersAll(Model model, HttpSession session) {
		Customer cust = (Customer) session.getAttribute("cust");
		if (cust == null) {
			return "redirect:login";
		}
		List<Order> orders = orderService.findAll();
		model.addAttribute("orders", orders);
		return "orders_all";
	}
	
}
