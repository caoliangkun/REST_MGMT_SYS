package edu.zufe.rms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.zufe.rms.enums.FoodType;
import edu.zufe.rms.model.CartItem;
import edu.zufe.rms.model.Food;
import edu.zufe.rms.service.CartItemService;
import edu.zufe.rms.service.FoodService;

@Controller
public class IndexController {
	@Autowired
	FoodService foodService;
	@Autowired
	CartItemService cartService;
	
	@GetMapping(path = "/index.html")
	public String toIndex() {
		return "index";
	}
	
	@GetMapping(path = "/cart.html")
	public String toCart(Model model) {
		List<CartItem> cart = cartService.findAll();
		double total = 0.0;
		for (CartItem c : cart) {
			total += c.getFood().getPrice() * c.getQuantity();
		}
		model.addAttribute("cart", cart);
		model.addAttribute("total", total);
		return "cart";
	}
	
	@GetMapping(path = "/menu.html")
	public String toMenu(Model model) {
		List<Food> foods = foodService.findAll();
		List<Food> chineseDishes = new ArrayList<>();
		List<Food> noodle = new ArrayList<>();
		List<Food> drink = new ArrayList<>();
		for (Food food : foods) {
			if (food.getFoodType().equals(FoodType.ChineseDish)) {
				chineseDishes.add(food);
			} else if (food.getFoodType().equals(FoodType.Noodle)) {
				noodle.add(food);
			} else if (food.getFoodType().equals(FoodType.Drink)) {
				drink.add(food);
			}
		}
		model.addAttribute("chineseDishes", chineseDishes);
		model.addAttribute("noodle", noodle);
		model.addAttribute("drink", drink);
		model.addAttribute("foods", foodService.findAll());
		return "menu";
	}
	
	@GetMapping(path = "/orders.html")
	public String toOrders() {
		return "orders_all";
	}
	
	@GetMapping(path = "/orders_all.html")
	public String toOrdersAll() {
		return "orders_all";
	}
	
	@GetMapping(path = "/orders_nc.html")
	public String toOrdersNC() {
		return "orders_nc";
	}
	
	@GetMapping(path = "/orders_c.html")
	public String toOrdersC() {
		return "orders_c";
	}
	
	@GetMapping(path = "/profile.html")
	public String toProfile() {
		return "profile";
	}
	
	@GetMapping(path = "/login.html")
	public String toLogin() {
		return "login";
	}
	
	@GetMapping(path = "/register.html")
	public String toRegister() {
		return "register";
	}
	
}
