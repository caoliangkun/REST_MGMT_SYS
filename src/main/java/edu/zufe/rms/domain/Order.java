package edu.zufe.rms.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Order {
	@Id
	@GeneratedValue
	private Long id;
	private Table table;
	private Double totalPrice;
	private Date orderTime;
	private Customer customer;
	private User asistant;
	private String comment;

	protected Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Table table, Double totalPrice, Date orderTime, Customer customer, User asistant, String comment) {
		this.table = table;
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
		this.customer = customer;
		this.asistant = asistant;
		this.comment = comment;
	}

}
