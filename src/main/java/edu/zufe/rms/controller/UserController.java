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
	
	
	@GetMapping(path = "/delete")
	public String deleteByPhone(@RequestParam(name = "phone"	) String phone) {
		userService.deleteByPhone(phone);
		return "redirect:/user/findall";
	}
	
	@GetMapping(path = "/deleteUser")
	public String deleteById(@RequestParam(name = "id"	) Long id) {
		userService.deleteById(id);
		return "redirect:users.html";
	}
	
	@RequestMapping(path = "createUser", method = RequestMethod.GET)
	public String saveUser(
			@RequestParam(name = "name") String name,
			@RequestParam(name = "pwd") String password,
			@RequestParam(name = "phone") String phone,
			@RequestParam(name = "position") String postion) {
		User user = userService.CreateUser(name, password, phone);
		return "admin/add-user";
	}
	
	@RequestMapping(path = "add-user.html", method = RequestMethod.GET)
	public String toAddUser() {
		
		return "admin/add-user";
	}
	
	@GetMapping(path = "/users.html")
	public String findAll(Model model) {
		model.addAttribute("users", userService.findAll());
		return "admin/users";
	}
	
}
