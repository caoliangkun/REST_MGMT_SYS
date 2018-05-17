package edu.zufe.rms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import edu.zufe.rms.model.User;

@Controller
public class AdminController {
	@GetMapping(path = "/admin")
	public String index(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null && user.isLogin())
			return "admin/admin-index";
		else
			return "login";
	}

	@GetMapping(path = "/admin-index.html")
	public String admin() {
		return "admin/admin-index";
	}

	@GetMapping(path = "/add-food.html")
	public String addFood() {
		return "admin/add-food";
	}

	@GetMapping(path = "/add_table.html")
	public String addTable() {
		return "admin/add_table";
	}

}
