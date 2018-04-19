package edu.zufe.rms.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CartItem {
	@Id
	@GeneratedValue
	@Column(name = "cart_item_id")
	private Long id;
	
	private Integer quantity;
	
	@OneToMany(mappedBy = "cartItem")
	private Set<Selection> selections;
	
	@OneToOne(mappedBy = "cartItem")
	private OrderItem orderItem;
}
