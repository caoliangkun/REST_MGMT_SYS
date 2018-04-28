package edu.zufe.rms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zufe.rms.model.CartItem;
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
	public String updateCart(@RequestParam(name = "id") Long id) {
		Food food = foodService.findById(id);
		if (cartService.isFoodExist(food) == true) {
			// alter quantity
			cartService.quantityPlusOne(food);
		} else {
			// save a new cart item
			cartService.saveCartItem(food);
		}
		return "redirect:menu.html";
	}
	
	@GetMapping(path = "/deleteCartItem")
	public String deleteCartItem(@RequestParam(name = "id") Long id) {
		cartService.deleteById(id);
		return "redirect:cart.html";
	}
	
}
