package edu.zufe.rms.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.model.Customer;
import edu.zufe.rms.model.Order;
import edu.zufe.rms.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	CustomerService custService;

	public Order save(Customer cust) {
		Order order = new Order();
		order.setCreatedAt(new Date());
		order.setCustomer(cust);
		return orderRepo.save(order);
	}

	public List<Order> findAll() {
		List<Order> orders = new ArrayList<>();
		List<Order> notCompletedOrders = new ArrayList<>();
		List<Order> completedOrders = new ArrayList<>();
		for (Order order : orderRepo.findAll()) {
			if (order.getFinished() == null) {
				notCompletedOrders.add(order);
			} else {
				completedOrders.add(order);
			}
		}
		orders.addAll(notCompletedOrders);
		orders.addAll(completedOrders);
		return orders;
	}

	public void changeTotalPrice(double addition, Order order) {
		order.setTotalPrice(order.getTotalPrice() + addition);
		orderRepo.save(order);
	}

	public Order findById(String id) {
		Optional<Order> order = orderRepo.findById(Long.valueOf(id));
		if (order.isPresent()) {
			return order.get();
		}
		return null;
	}

	public void save(Order order) {
		orderRepo.save(order);

	}

	public List<Order> findAll(String year) {
		List<Order> orders = new ArrayList<>();
		for (Order order : orderRepo.findAll()) {

			if (order.getFinished() != null && order.getCreatedAt() != null) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(order.getCreatedAt());
				if (calendar.get(Calendar.YEAR) == Integer.valueOf(year)) {
					orders.add(order);
				}
			}
		}
		return orders;
	}

	public List<Order> findAll(Customer cust) {
		List<Order> orders = new ArrayList<>();
		List<Order> notCompletedOrders = new ArrayList<>();
		List<Order> completedOrders = new ArrayList<>();
		for (Order order : orderRepo.findAll()) {
			if (order.getCustomer().getId().equals(cust.getId())) {
				if (order.getFinished() == null) {
					notCompletedOrders.add(order);
				} else {
					completedOrders.add(order);
				}
			}
		}
		orders.addAll(notCompletedOrders);
		orders.addAll(completedOrders);
		return orders;
	}

}
