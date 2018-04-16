package edu.zufe.rms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zufe.rms.model.User;
import edu.zufe.rms.service.UserService;

@Controller
@RequestMapping(path = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(
			@RequestParam(required = false, name = "name") String name,
			@RequestParam(name = "password", required = false) String password,
			@RequestParam(required = false, name = "phone") String phone) {
		User user = userService.CreateUser(name, password, phone);
		return "Have saved a user: " + user.getName();
	}
	
	@GetMapping(path = "/findall")
	public String findAll(Model model) {
		model.addAttribute("users", userService.findAll());
		return "allusers";
	}
	
	@GetMapping(path = "/delete")
	public String deleteByPhone(@RequestParam(name = "phone"	) String phone) {
		userService.deleteByPhone(phone);
		return "redirect:/user/findall";
	}
}
