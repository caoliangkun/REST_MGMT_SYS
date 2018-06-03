package edu.zufe.rms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.zufe.rms.enums.FoodType;
import edu.zufe.rms.enums.Rating;

@Entity
public class Food implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "food_id")
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false)
	private Double price;

	@Column(length = 5)
	private String applied;

	@Temporal(TemporalType.DATE)
	@Column(name = "last_update_at")
	private Date lastUpdatedAt;
	
	@OneToOne
	@JoinColumn(name = "img_id")
	private Image img;

	@Enumerated(value = EnumType.STRING)
	private Rating rating;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "last_update_by")
	private User user;

	@Enumerated(value = EnumType.STRING)
	private FoodType foodType;
	
	
	@OneToMany(mappedBy = "food", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<CartItem> cart;
	
	@OneToMany(mappedBy = "food", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<OrderItem> orderItems;
	
	@OneToMany(mappedBy = "food", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Favorite> favorites;
	@Column(columnDefinition = "int default 0") 
	private Long num;

	public Food() {
		super();
	}


	public Food(String name, Double price, String applied, FoodType foodType) {
		super();
		this.name = name;
		this.price = price;
		this.applied = applied;
		this.foodType = foodType;
	}


	public Food(String name, double price) {
		this.name = name;
		this.price = price;
	}


	
	
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}


	public Set<Favorite> getFavorites() {
		return favorites;
	}


	public void setFavorites(Set<Favorite> favorites) {
		this.favorites = favorites;
	}


	public Long getNum() {
		return num;
	}


	public void setNum(Long num) {
		this.num = num;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getApplied() {
		return applied;
	}


	public void setApplied(String applied) {
		this.applied = applied;
	}


	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}


	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}


	public Image getImg() {
		return img;
	}


	public void setImg(Image img) {
		this.img = img;
	}


	public Rating getRating() {
		return rating;
	}


	public void setRating(Rating rating) {
		this.rating = rating;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public FoodType getFoodType() {
		return foodType;
	}


	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}


	

	public Set<CartItem> getCart() {
		return cart;
	}


	public void setCart(Set<CartItem> cart) {
		this.cart = cart;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String toString() {
//		return "id: " + getId() + ", name: " + getName() + ", price: " + getPrice() + ",food type: " + getFoodType().toString() + ", applied: " + getApplied();
		return "id: " + getId() + ", name: " + getName() + ", price: " + getPrice();
	} 

}
