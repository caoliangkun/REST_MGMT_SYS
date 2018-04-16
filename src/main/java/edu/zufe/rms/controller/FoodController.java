package edu.zufe.rms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zufe.rms.service.FoodService;

@Controller
@RequestMapping(path = "/food")
public class FoodController {
	@Autowired
	private FoodService foodService;

	@GetMapping(path = "/foodlist")
	public String getFoodList(Model model) {
		model.addAttribute("foods", foodService.findAll());
		return "foodlist";
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

}
