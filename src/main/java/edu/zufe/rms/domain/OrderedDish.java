package edu.zufe.rms.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderedDish {
	@Id
	@GeneratedValue
	private Long id;
	private Dish dish;
	private DishStatus status;
	private Order order;
	private Date orderTime;
	private String comment = null;
}
