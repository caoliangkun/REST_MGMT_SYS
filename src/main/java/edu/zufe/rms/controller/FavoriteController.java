package edu.zufe.rms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zufe.rms.model.Customer;
import edu.zufe.rms.model.Favorite;
import edu.zufe.rms.model.Food;
import edu.zufe.rms.service.FavoriteService;
import edu.zufe.rms.service.FoodService;

@Controller
public class FavoriteController {
	@Autowired
	private FoodService foodService;

	@Autowired
	private FavoriteService fvtService;

	@GetMapping(path = "/favorite")
	public String toFavorite(Model model, HttpSession session) {
		Customer cust = (Customer) session.getAttribute("cust");
		List<Favorite> favorites = fvtService.findAll(cust);
		model.addAttribute("favorites", favorites);
		return "favorite";
	}

	@GetMapping(path = "/saveFavorite")
	public String saveFavorite(@RequestParam(name = "id") String id, HttpSession session) {
		Customer cust = (Customer) session.getAttribute("cust");

		Food food = foodService.findById(Long.valueOf(id));
		Favorite fvt = new Favorite(food, cust);
		if (!fvtService.exsit(fvt)) {
			fvtService.save(fvt);
//			foodService.numPlus(Long.valueOf(id));
		}
			
		return "redirect:menu";
	}
	
	@GetMapping(path = "/deleteFavorite")
	public String deleteFavorite(@RequestParam(name = "id") String id) {
		fvtService.deleteById(Long.valueOf(id));
		return "redirect:/favorite";
	}
}
