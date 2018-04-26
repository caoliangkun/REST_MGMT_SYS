package edu.zufe.rms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zufe.rms.model.Customer;
import edu.zufe.rms.model.User;
import edu.zufe.rms.service.CustomerService;
import edu.zufe.rms.service.LoginService;
import edu.zufe.rms.service.UserService;

@Controller
public class MainController {
	@Autowired
	LoginService loginService;
	@Autowired
	UserService userService;
	@Autowired
	CustomerService customerService;

	// Uses the user phone account and password for logging in
	@PostMapping(path = "/login")
	public String login(@RequestParam(name = "phone") String phone, @RequestParam(name = "password") String password,
			Model postion) {
		if (loginService.loginUser(phone, password)) {
			User user = userService.findByAccount(phone);
			if (user.getPosition() != null) {
				postion.addAttribute("position", user.getPosition());
			}
			return "redirect:index.html";
		} else if (loginService.loginCust(phone, password)) {
			return "redirect:index.html";
		} else {
			return null;
		}
	}

	@PostMapping(path = "/register")
	public String register(@RequestParam(name = "name") String name, @RequestParam(name = "phone") String phone,
			@RequestParam(name = "pwd") String pwd, @RequestParam(name = "rpwd") String rpwd) {
		if (!pwd.equals(rpwd)) {
			return "register";
		}
		Customer cust = new Customer();
		cust.setName(name);
		cust.setPhone(phone);
		cust.setPassword(pwd);
		customerService.saveCust(cust);
		return "redirect:login.html";
	}
}
