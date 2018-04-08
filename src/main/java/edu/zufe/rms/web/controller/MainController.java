package edu.zufe.rms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zufe.rms.domain.model.User;
import edu.zufe.rms.service.LoginService;
import edu.zufe.rms.service.UserService;

@Controller
public class MainController {
	@Autowired
	LoginService loginService;
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	String toLogin() {
		return "login";
	}
	@GetMapping("/welcome")
	String home(@RequestParam(name = "name", required = false, defaultValue = "Liangkun") String name, Model model) {
		model.addAttribute("name", name);
		return "welcome";
	}
	
	// Now use the user's name and password for logging in
	@GetMapping(path = "/login")
	public String login(@RequestParam(name = "account") String account, @RequestParam(name = "password") String password, Model model) {
		if (loginService.login(account, password)) {
			User user = userService.findByAccount(account);
			if (user.getName() != null) {
				model.addAttribute("name", user.getName());
			}
			return "welcome";
		} else {
			return null;
		}
	}
}
