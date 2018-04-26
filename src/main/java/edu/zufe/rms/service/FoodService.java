package edu.zufe.rms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.enums.FoodType;
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
	
	public void deleteFoodById(Long id) {
		foodRepo.deleteById(id);
	}
	
	public Food save(String name, Double price, String applied, String foodType) {
		Food food = new Food(name, price, applied, FoodType.valueOf(foodType));
		return foodRepo.save(food);
	}
	
	public Food findById(Long id) {
		Optional<Food> food =  foodRepo.findById(id);
		if (food.isPresent()) {
			Food f = food.get();
			return f;
		}
		return null;
	}

	
}
