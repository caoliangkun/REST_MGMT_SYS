package edu.zufe.rms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zufe.rms.enums.OrderItemStatus;
import edu.zufe.rms.model.OrderItem;
import edu.zufe.rms.service.OrderItemService;

@Controller
public class OrderItemController {
	@Autowired
	private OrderItemService orderItemService;
	
	@GetMapping(path = "/updateOrderItem")
	public String updateOrderItem(Model model) {
		List<OrderItem> orderItems = orderItemService.findAll(OrderItemStatus.IN_ORDER);
		model.addAttribute("orderItems", orderItems);
		return "admin/order_items";
	}
	
	@GetMapping(path = "/updateOrderItemStatus")
	public String updateOrderItemStatus(@RequestParam(name = "id") String id) {
		OrderItem oi = orderItemService.findById(id);
		if (oi.getOrderItemStatus().compareTo(OrderItemStatus.IN_ORDER) == 0) {
			oi.setOrderItemStatus(OrderItemStatus.COOKED);
			orderItemService.save(oi);
		}
		return "redirect:/updateOrderItem"; 
	}
}
