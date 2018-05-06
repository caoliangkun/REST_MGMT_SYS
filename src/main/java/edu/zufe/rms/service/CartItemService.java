package edu.zufe.rms.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Test;
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
		for (CartItem c : findAll()) {
			if (c.getCustomer().getId().equals(cust.getId()))
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

	public void quantityPlusOne(Food food, Customer cust) {
		for (CartItem c : findAll(cust)) {
			if (c.getFood().getId().equals(food.getId())) {
				c.setQuantity(c.getQuantity() + 1);
				cartItemRepo.save(c);
			}
		}

	}

	public boolean isFoodExist(Food food, HttpSession session) {
		List<CartItem> cart = findAll();
		Customer cust = (Customer) session.getAttribute("cust");
		for (CartItem c : cart) {
			if (food.getId().equals(c.getFood().getId())) {
				if (c.getCustomer().getId().equals(cust.getId()))
					return true;
			}
		}
		return false;
	}

	public void deleteAll(Customer cust) {
		List<CartItem> cartItems = findAll(cust);
		for (CartItem c : cartItems) {
			cartItemRepo.deleteById(c.getId());
		}
	}

	public void deleteById(String id) {
		cartItemRepo.deleteById(Long.valueOf(id));
	}

	public CartItem saveCartItem(Food food, Customer cust) {

		CartItem cartItem = new CartItem();
		cartItem.setFood(food);
		cartItem.setQuantity(1);
		cartItem.setCustomer(cust);
		return cartItemRepo.save(cartItem);
	}


	public List<CartItem> findAllByCust(Customer cust) {
//		Customer cust = (Customer) session.getAttribute("cust");
		List<CartItem> cart = new ArrayList<>();
		for (CartItem c : findAll()) {
			if (c.getCustomer().getId() == cust.getId())
				cart.add(c);
		}
		return cart;
	}

	
	@Test
	public void test() {
		Food food = new Food();
		food.setId(1L);
		Customer cust = new Customer();
		cust.setId(62L);
		CartItem cartItem = new CartItem();
		cartItem.setCustomer(cust);
		cartItem.setFood(food);
		Assert.assertEquals(cartItem.getFood().getId(), food.getId());
	}
}
