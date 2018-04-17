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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.zufe.rms.enums.Applied;
import edu.zufe.rms.enums.FoodType;
import edu.zufe.rms.enums.Rating;

@Entity
public class Food implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue()
	@Column(name = "food_id")
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false)
	private Double price;

	@Column()
	@Enumerated(EnumType.STRING)
	private Applied applied;

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
	
	@OneToMany(mappedBy = "food")
	private Set<Dish> dishes;

	public Food() {
		super();
	}



	public Food(String name, Double price, Date lastUpdatedAt, Rating rating, User user,
			FoodType foodType) {
		super();
		this.name = name;
		this.price = price;
		this.lastUpdatedAt = lastUpdatedAt;
		this.rating = rating;
		this.user = user;
		this.foodType = foodType;
	}



	public Food(String name, double price) {
		this.name = name;
		this.price = price;
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



	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}