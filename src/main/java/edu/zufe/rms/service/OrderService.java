package edu.zufe.rms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.model.Order;
import edu.zufe.rms.model.OrderItem;
import edu.zufe.rms.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepo;

	public Order save() {
		Order order = new Order();
		return orderRepo.save(order);
	}
	
	public List<Order> findAll() {
		List<Order> orders = new ArrayList<>();
		for(Order order: orderRepo.findAll()) {
			orders.add(order);
		}
		return orders;
	}

	public void changeTotalPrice(double addition, Order order) {
		order.setTotalPrice(order.getTotalPrice() + addition);
		orderRepo.save(order);
	}

}
