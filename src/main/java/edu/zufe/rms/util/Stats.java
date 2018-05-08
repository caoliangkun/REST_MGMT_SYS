package edu.zufe.rms.util;

import java.util.Calendar;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import edu.zufe.rms.model.Order;
import edu.zufe.rms.model.OrderStats;
import edu.zufe.rms.service.OrderService;

@Component
public class Stats {
	@Autowired
	private OrderService orderService;
	
	@Bean
	public String order() {
		// OrderStats orderStats = new OrderStats(100, 150, 130, 120,
		// 160, 150, 420, 320,
		// 130, 320, 240, 430);
		OrderStats orderStats = new OrderStats();
		Calendar calendar = Calendar.getInstance();
		List<Order> orders = orderService.findAll();
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
	

}
