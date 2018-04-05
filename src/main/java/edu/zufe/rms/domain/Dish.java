package edu.zufe.rms.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dish {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private DishType dishCategory;
	private Double price;
	private User addedBy;
	private Date addedDate;
	private Boolean supplyed;
	private DishPopularity dishPopularity;

	protected Dish() { }

	public Dish(String name, DishType dishCategory, Double price, User addedBy, Date addedDate,
			Boolean supplyed, DishPopularity dishPopularity) {
		this.name = name;
		this.dishCategory = dishCategory;
		this.price = price;
		this.addedBy = addedBy;
		this.addedDate = addedDate;
		this.supplyed = supplyed;
		this.dishPopularity = dishPopularity;
	}
	


}
