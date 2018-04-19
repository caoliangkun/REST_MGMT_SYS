package edu.zufe.rms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import edu.zufe.rms.enums.OrderItemStatus;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue
	@Column(name = "order_item_id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "cart_item_id")
	private CartItem cartItem;
	
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
	@Column(name = "order_item_status")
	private OrderItemStatus orderItemStatus;
}
