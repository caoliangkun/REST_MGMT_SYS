package edu.zufe.rms.util.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zufe.rms.model.Customer;
import edu.zufe.rms.service.CustomerService;

public class SyncSession implements edu.zufe.rms.util.SyncSession {
	@Autowired
	private CustomerService custService;

	@Override
	public void syncCust(HttpSession custSession) {
//		Customer custP = (Customer) custSession.getAttribute("cust");
//		System.out.println(custP.getId());
//		Customer cust = custService.findById(custP.getId());
//		custSession.setAttribute("cust", cust);
	}

}
