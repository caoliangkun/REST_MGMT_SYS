package edu.zufe.rms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zufe.rms.domain.model.User;
import edu.zufe.rms.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "/saveuser", method = RequestMethod.GET)
	@ResponseBody
	public String save(@RequestParam(required = false, name = "name", defaultValue = "admin") String name, @RequestParam(name = "password", required = false, defaultValue = "admin") String password,
			@RequestParam(required = false, name = "name", defaultValue = "admin") String phone) {
		User user = userService.CreateUser(name, password, phone);
		return "Have saved a user: " + user.getName();
	}
}
