package edu.zufe.rms.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@javax.persistence.Table(name = "cart")
public class CartItem {
	@Id
	@GeneratedValue
	@Column(name = "cart_item_id")
	private Long id;
	
	private Integer quantity;
	
//	@OneToMany(mappedBy = "cartItem")
//	private Set<Selection> selections;
	
	
	

	@ManyToOne
	@JoinColumn(name = "food_id")
	private Food food;
	
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
//	private User user;
	
	public CartItem() {
	}
	
	public CartItem(Integer quantity, Food food, Customer customer) {
		this.quantity = quantity;
		this.food = food;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

//	public Set<Selection> getSelections() {
//		return selections;
//	}
//
//	public void setSelections(Set<Selection> selections) {
//		this.selections = selections;
//	}

	

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
