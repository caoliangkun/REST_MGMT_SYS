package edu.zufe.rms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.enums.Applyed;
import edu.zufe.rms.model.Food;
import edu.zufe.rms.repository.FoodRepository;

@Service
public class FoodService {
	@Autowired
	private FoodRepository foodRepo;
	
	public List<Food> findAll() {
		List<Food> foods = new ArrayList<>();
		for (Food food : foodRepo.findAll()) {
			foods.add(food);
		}
		return foods;
	}
	
	public Food save(String name, double price) {
		Food food = new Food(name, price);
		return foodRepo.save(food);
	}
}
