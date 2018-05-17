package edu.zufe.rms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/")
	public String defaultPage() {
		return "redirect:index.html";
	}

	// Uses the user phone account and password for logging in
	@PostMapping(path = "/login")
	public String login(@RequestParam(name = "phone") String phone, @RequestParam(name = "password") String password,
			Model model, HttpSession session) {
		if (loginService.loginUser(phone, password)) {
			User user = userService.findByAccount(phone);
			if (user.getPosition() != null) {
				model.addAttribute("position", user.getPosition());
			}
			user.setLogin(true);
			userService.save(user);
			session.setAttribute("user", user);
			session.setAttribute("person", user);
			return "redirect:admin-index.html";
		} else if (loginService.loginCust(phone, password)) {
			Customer cust = customerService.findByPhone(phone);
			cust.setTableId(Long.valueOf(0L));
			cust.setLogin(true);
			customerService.saveCust(cust);
			session.setAttribute("person", cust);
			session.setAttribute("cust", cust);
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
		return "redirect:login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("cust") != null) {
			Customer cust = (Customer) session.getAttribute("cust");
			cust.setLogin(false);
			customerService.saveCust(cust);
			session.removeAttribute("cust");
		} else if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			user.setLogin(false);
			userService.save(user);
			session.removeAttribute("user");
		}
		
		
		return "login";
	}

	@GetMapping(path = "/updateProfile")
	public String updateProfile(@RequestParam(name = "name") String name, @RequestParam(name = "phone") String phone,
			@RequestParam(name = "password") String password, @RequestParam(name = "confirmPswd") String comfirmPswd,
			@RequestParam(name = "sex") String sex, HttpSession session) {
		Customer cust = (Customer) session.getAttribute("cust");
		if (cust != null && phone.length() == 11) {
			if (name != null)
				cust.setName(name);
			if (phone != null)
				cust.setPhone(phone);
			if (phone != null)
				cust.setPassword(password);
			if (sex != null)
				cust.setSex(sex);
			if (password != null && password.compareTo(comfirmPswd) == 0)
				cust.setPassword(password);
			customerService.saveCust(cust);
		}

		System.out.println("update profile");
		return "redirect:/profile";
	}
	
	@GetMapping(path = "/error")
	public String toError() {
		return "error";
	}
}
