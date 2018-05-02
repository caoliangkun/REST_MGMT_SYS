package edu.zufe.rms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zufe.rms.model.Customer;
import edu.zufe.rms.model.Order;
import edu.zufe.rms.model.Payment;
import edu.zufe.rms.service.OrderService;
import edu.zufe.rms.service.PaymentService;

@Controller
public class PaymentController {
	
	@Autowired
	private PaymentService payService;
	@Autowired
	private OrderService orderService;

	
	@GetMapping("/pay")
	public String pay(@RequestParam(name = "id") String id, HttpSession session) {
		Order order = orderService.findById(id);
		System.out.println(order.getId());
		order.setFinished(true);
		order.setUpdateAt(new Date());
		orderService.save(order);
		Customer cust = (Customer) session.getAttribute("cust");
		Payment payment = new Payment();
		payment.setAmount(order.getTotalPrice());
		payment.setCustomer(cust);
		payment.setPayAt(new Date());
		payService.save(payment);
		return "redirect:allOrders";
	}
	
	@GetMapping("/showPayments")
	public String showPayments(Model model) {
		List<Payment> payments = payService.findAll();
		model.addAttribute("payments", payments);
		return "admin/payments";
	}
	
	
}
