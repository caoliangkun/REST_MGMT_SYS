package edu.zufe.rms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	
	@GetMapping("/welcome")
	String index(@RequestParam(name = "title", required = false, defaultValue = "gourmet")String title,
			@RequestParam(name = "name", required = false, defaultValue = "Lyon")String name, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("name", name);
		return "welcome";
	}
}
