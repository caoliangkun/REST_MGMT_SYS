package edu.zufe.rms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.zufe.rms.enums.DishStatus;

@Entity
@javax.persistence.Table(name = "dish")
public class Dish {
	@Id
	@GeneratedValue
	@Column(name = "dish_id")
	private Long id;
	
	private Double quantity;
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "food_id")
	private Food food;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "table_id")
	private Table table;
	@ManyToOne
	@JoinColumn(name = "waiter_id")
	private User waiter;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "dish_status")
	private DishStatus dishStatus;
}
