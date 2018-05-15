package edu.zufe.rms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@javax.persistence.Table(name = "favorites")
public class Favorite {
	@Id
	@GeneratedValue
	@Column(name = "favorite_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "food_id")
	private Food food;
	
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;

	public Favorite() {
	}

	public Favorite(Food food, Customer cust) {
		this.food = food;
		this.customer =  cust;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
