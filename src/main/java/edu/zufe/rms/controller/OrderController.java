package edu.zufe.rms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.zufe.rms.model.CartItem;
import edu.zufe.rms.model.Food;
import edu.zufe.rms.model.Order;
import edu.zufe.rms.model.OrderItem;
import edu.zufe.rms.service.CartItemService;
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
	
	@GetMapping(path = "/saveOrder")
	public String saveOrder() {
		// Save a order record in table orders
		Order order = orderService.save();
		
		// Save all order items record with order id
		List<CartItem> cart = cartService.findAll();
		double addition = 0.0;
		for (CartItem i : cart) {
			Food food = i.getFood();
			int quantity = i.getQuantity();
			OrderItem orderItem = orderItemService.save(food, order, quantity);
			addition += orderItem.getFood().getPrice() * orderItem.getQuantity() ;
		}
		orderService.changeTotalPrice(addition, order);
		// Delete the cart items 
		cartService.deleteAll();
		return "order_success";
	}
	
	
	
}
