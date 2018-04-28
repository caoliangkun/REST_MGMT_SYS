package edu.zufe.rms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
