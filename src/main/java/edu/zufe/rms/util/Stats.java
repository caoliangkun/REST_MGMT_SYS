package edu.zufe.rms.util;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import edu.zufe.rms.model.Order;
import edu.zufe.rms.model.OrderStats;
import edu.zufe.rms.model.Payment;
import edu.zufe.rms.model.PaymentStats;
import edu.zufe.rms.service.OrderService;
import edu.zufe.rms.service.PaymentService;


public class Stats {
	@Autowired
	private OrderService orderService;

	@Autowired
	private static PaymentService paymentService;

	public String order(String year) {
		// paymentStats paymentStats = new paymentStats(100, 150, 130, 120,
		// 160, 150, 420, 320,
		// 130, 320, 240, 430);
		OrderStats orderStats = new OrderStats();
		Calendar calendar = Calendar.getInstance();
		List<Order> orders = orderService.findAll(year);
		for (Order order : orders) {
			if (order.getCreatedAt() != null) {
				calendar.setTime(order.getCreatedAt());
				if (calendar.get(Calendar.MONTH) == 0) {
					orderStats.setJan(orderStats.getJan() + 1);
				} else if (calendar.get(Calendar.MONTH) == 1) {
					orderStats.setFeb(orderStats.getFeb() + 1);
				} else if (calendar.get(Calendar.MONTH) == 2) {
					orderStats.setMar(orderStats.getMar() + 1);
				} else if (calendar.get(Calendar.MONTH) == 3) {
					orderStats.setApr(orderStats.getApr() + 1);
				} else if (calendar.get(Calendar.MONTH) == 4) {
					orderStats.setMay(orderStats.getMay() + 1);
				} else if (calendar.get(Calendar.MONTH) == 5) {
					orderStats.setJun(orderStats.getJun() + 1);
				} else if (calendar.get(Calendar.MONTH) == 6) {
					orderStats.setJul(orderStats.getJul() + 1);
				} else if (calendar.get(Calendar.MONTH) == 7) {
					orderStats.setAug(orderStats.getAug() + 1);
				} else if (calendar.get(Calendar.MONTH) == 8) {
					orderStats.setSep(orderStats.getSep() + 1);
				} else if (calendar.get(Calendar.MONTH) == 9) {
					orderStats.setOct(orderStats.getOct() + 1);
				} else if (calendar.get(Calendar.MONTH) == 10) {
					orderStats.setNov(orderStats.getNov() + 1);
				} else if (calendar.get(Calendar.MONTH) == 11) {
					orderStats.setDec(orderStats.getDec() + 1);
				}
			}
		}
		String orderStatsJson = JSON.toJSONString(orderStats);
		return orderStatsJson;
	}

	public static String incomeStats(String year) {
		
		PaymentStats paymentStats = new PaymentStats();
		if (paymentService == null)
			System.out.println("break point");
		List<Payment> payments = paymentService.findAll();
		Calendar calendar = Calendar.getInstance();
		for (Payment payment : payments) {
			if (payment.getPayAt() != null) {
				calendar.setTime(payment.getPayAt());
				if (calendar.get(Calendar.MONTH) == 0) {
					paymentStats.setJan(paymentStats.getJan() + 1);
				} else if (calendar.get(Calendar.MONTH) == 1) {
					paymentStats.setFeb(paymentStats.getFeb() + 1);
				} else if (calendar.get(Calendar.MONTH) == 2) {
					paymentStats.setMar(paymentStats.getMar() + 1);
				} else if (calendar.get(Calendar.MONTH) == 3) {
					paymentStats.setApr(paymentStats.getApr() + 1);
				} else if (calendar.get(Calendar.MONTH) == 4) {
					paymentStats.setMay(paymentStats.getMay() + 1);
				} else if (calendar.get(Calendar.MONTH) == 5) {
					paymentStats.setJun(paymentStats.getJun() + 1);
				} else if (calendar.get(Calendar.MONTH) == 6) {
					paymentStats.setJul(paymentStats.getJul() + 1);
				} else if (calendar.get(Calendar.MONTH) == 7) {
					paymentStats.setAug(paymentStats.getAug() + 1);
				} else if (calendar.get(Calendar.MONTH) == 8) {
					paymentStats.setSep(paymentStats.getSep() + 1);
				} else if (calendar.get(Calendar.MONTH) == 9) {
					paymentStats.setOct(paymentStats.getOct() + 1);
				} else if (calendar.get(Calendar.MONTH) == 10) {
					paymentStats.setNov(paymentStats.getNov() + 1);
				} else if (calendar.get(Calendar.MONTH) == 11) {
					paymentStats.setDec(paymentStats.getDec() + 1);
				}
			}
		}
		String paymentStatsJson = JSON.toJSONString(paymentStats);
		return paymentStatsJson;
	}

}
