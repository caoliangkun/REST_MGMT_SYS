package edu.zufe.rms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.model.CartItem;
import edu.zufe.rms.model.Customer;
import edu.zufe.rms.model.Food;
import edu.zufe.rms.repository.CartItemRepository;

@Service
public class CartItemService {
	@Autowired
	CartItemRepository cartItemRepo;

	public CartItem saveCartItem(Food food) {
		CartItem cartItem = new CartItem();
		cartItem.setFood(food);
		cartItem.setQuantity(1);
		return cartItemRepo.save(cartItem);
	}

	public List<CartItem> findAll(Customer cust) {
		List<CartItem> cart = new ArrayList<>();
		for (CartItem c : cartItemRepo.findAll()) {
			if (c.getCustomer().getId() == cust.getId())
				cart.add(c);

		}
		return cart;
	}

	public List<CartItem> findAll() {
		List<CartItem> cart = new ArrayList<>();
		for (CartItem c : cartItemRepo.findAll()) {
			cart.add(c);

		}
		return cart;
	}

	public void quantityPlusOne(Food food) {
		for (CartItem c : findAll()) {
			if (c.getFood().getId() == food.getId()) {
				c.setQuantity(c.getQuantity() + 1);
				cartItemRepo.save(c);
			}
		}

	}

	public boolean isFoodExist(Food food) {
		List<CartItem> cart = findAll();
		for (CartItem c : cart) {
			if (food.getId() == c.getFood().getId()) {
				return true;
			}
		}
		return false;
	}

	public void deleteAll() {
		cartItemRepo.deleteAll();
	}

	public void deleteById(Long id) {
		cartItemRepo.deleteById(id);
	}

	public CartItem saveCartItem(Food food, Customer cust) {

		CartItem cartItem = new CartItem();
		cartItem.setFood(food);
		cartItem.setQuantity(1);
		cartItem.setCustomer(cust);
		return cartItemRepo.save(cartItem);
	}
}
