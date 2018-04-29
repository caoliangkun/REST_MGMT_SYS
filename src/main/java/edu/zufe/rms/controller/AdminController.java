package edu.zufe.rms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping(path = "/admin")
	public String index() {
		return "admin/admin-index";
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
