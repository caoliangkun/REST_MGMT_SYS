package edu.zufe.rms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zufe.rms.model.Food;
import edu.zufe.rms.service.FoodService;

@Controller
public class FoodController {
	@Autowired
	private FoodService foodService;

	@GetMapping(path = "/foods.html")
	public String getFoodList(Model model) {
		model.addAttribute("foods", foodService.findAll());
		return "admin/foods";
	}
	
	@GetMapping(path = "/deleteFood")
	public String deleteFoodById(@RequestParam(name = "id") Long id) {
		foodService.deleteFoodById(id);
		return "redirect:foods.html";
	}
	
	@GetMapping(path = "/to-save-food")
	public String toSave() {
		return "save-food";
	}
	@GetMapping(path = "/save")
	public String saveFood(@RequestParam(name = "name")String name, @RequestParam(name = "price") Double price) {
		if (name != null && price != null) {
			foodService.save(name, price);
		}
		return "redirect:/food/foodlist";
	}
	
	
	
	@GetMapping(path = "/addFood")
	public String addFood(@RequestParam(name = "name")String name, 
			@RequestParam(name = "price") Double price,
			@RequestParam(name = "applied") String applied,
			@RequestParam(name = "foodType") String foodType) {
		Food food = null;
		if (name != null && price != null ) {
			food = foodService.save(name, price, applied, foodType);
//			food = foodService.save(name, price);
		}
		return "redirect:add-food.html";
	}

}
