package edu.zufe.rms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.model.Food;
import edu.zufe.rms.model.Selection;
import edu.zufe.rms.repository.SelectionRepository;

@Service
public class SelectionService {
	
	@Autowired
	private SelectionRepository selectionRepo;
	private FoodService foodService;
	private CartItemService cartItemService;
	
	public Selection saveSelection(Long id) {
		Food food = foodService.findById(id);
		
//		Selection s = new Selection(food, cartItem);a
//		return selectionRepo.save(s);
		return null;
	}
}
