package edu.zufe.rms.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.zufe.rms.enums.Applyed;
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
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false)
	private Double price;

	@Column()
	@Enumerated(EnumType.STRING)
	private Applyed applyed;

	@Temporal(TemporalType.DATE)
	@Column(name = "last_update_at")
	private Date lastUpdatedAt;

	private String image;

	@Enumerated(value = EnumType.STRING)
	private Rating rating;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "last_update_by")
	private User user;

	@Enumerated(value = EnumType.STRING)
	private FoodType dishType;

	public Food() {
		super();
	}



	public Food(String name, Double price, Applyed applyed, Date lastUpdatedAt, String image, Rating rating, User user,
			FoodType dishType) {
		super();
		this.name = name;
		this.price = price;
		this.applyed = applyed;
		this.lastUpdatedAt = lastUpdatedAt;
		this.image = image;
		this.rating = rating;
		this.user = user;
		this.dishType = dishType;
	}



	public Food(String name, double price) {
		this.name = name;
		this.price = price;
	}



	public Applyed getApplyed() {
		return applyed;
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

	public Applyed isApplyed() {
		return applyed;
	}

	public void setApplyed(Applyed applyed) {
		this.applyed = applyed;
	}

	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public FoodType getDishType() {
		return dishType;
	}

	public void setDishType(FoodType dishType) {
		this.dishType = dishType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
