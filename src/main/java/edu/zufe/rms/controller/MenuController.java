package edu.zufe.rms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.zufe.rms.enums.FoodType;
import edu.zufe.rms.model.Food;
import edu.zufe.rms.service.FoodService;

@Controller
public class MenuController {
	@Autowired
	FoodService foodService;
	
	@GetMapping(path = "/menu")
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
}
