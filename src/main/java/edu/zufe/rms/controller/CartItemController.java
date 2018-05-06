package edu.zufe.rms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zufe.rms.model.Customer;
import edu.zufe.rms.model.Food;
import edu.zufe.rms.service.CartItemService;
import edu.zufe.rms.service.FoodService;

@Controller
public class CartItemController {
	@Autowired
	FoodService foodService;
	
	@Autowired
	CartItemService cartService;
	
	@GetMapping(path = "/updateCart")
	public String updateCart(@RequestParam(name = "id") Long id, HttpSession session) {
		Food food = foodService.findById(id);
		Customer cust = (Customer) session.getAttribute("cust");
		if (cust == null) {
			return "redirect:login";
		}
		
		if (cartService.isFoodExist(food, cust) == true) {
			// alter quantity
			
			cartService.quantityPlusOne(food, cust);
		} else {
			// save a new cart item
			
			
				cartService.saveCartItem(food, cust);
			
			
		}
		return "redirect:menu.html";
	}
	
	@GetMapping(path = "/deleteCartItem")
	public String deleteCartItem(@RequestParam(name = "id") Long id, HttpSession session) {
		Customer cust = (Customer) session.getAttribute("cust");
		cartService.deleteById(id, session);
		return "redirect:cart";
	}
	
}
