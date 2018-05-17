
package edu.zufe.rms.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.zufe.rms.enums.OrderItemStatus;

@Entity
@javax.persistence.Table(name = "order_items")
public class OrderItem {
	@Id
	@GeneratedValue
	@Column(name = "order_item_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "food_id")
	private Food food;
	
	private Integer quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "table_id")
	private Table table;
	@ManyToOne
	@JoinColumn(name = "waiter_id")
	private User waiter;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "order_item_status", columnDefinition = "order_item_status varchar(225) default 'IN ORDER'")
	private OrderItemStatus orderItemStatus;
	
	public OrderItem() {};
	
	public OrderItem(Food food, Order order, Integer quantity) {
		this.food = food;
		this.order = order;
		this.quantity = quantity;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public User getWaiter() {
		return waiter;
	}

	public void setWaiter(User waiter) {
		this.waiter = waiter;
	}

	public OrderItemStatus getOrderItemStatus() {
		return orderItemStatus;
	}

	public void setOrderItemStatus(OrderItemStatus orderItemStatus) {
		this.orderItemStatus = orderItemStatus;
	}



	public Food getFood() {
		return food;
	}



	public void setFood(Food food) {
		this.food = food;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
