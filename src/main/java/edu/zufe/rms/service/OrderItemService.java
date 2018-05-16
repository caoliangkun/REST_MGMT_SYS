package edu.zufe.rms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.enums.OrderItemStatus;
import edu.zufe.rms.model.Food;
import edu.zufe.rms.model.Order;
import edu.zufe.rms.model.OrderItem;
import edu.zufe.rms.repository.OrderItemRepository;

@Service
public class OrderItemService {
	@Autowired
	OrderItemRepository orderItemRepo;

	public OrderItem save(Food food, Order order, int quantity) {
		OrderItem orderItem =  new OrderItem(food, order, quantity);
		return orderItemRepo.save(orderItem);
	}

	public OrderItem save(OrderItem orderItem) {
		return orderItemRepo.save(orderItem);
		
	}

	public List<OrderItem> findAll(OrderItemStatus s) {
		List<OrderItem> orderItems = new ArrayList<>();
		for (OrderItem oi : orderItemRepo.findAll()) {
			if (oi.getOrderItemStatus() != null && oi.getOrderItemStatus().compareTo(s) == 0)
				orderItems.add(oi);
		}
		return orderItems;
	}

}
