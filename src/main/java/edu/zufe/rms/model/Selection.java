package edu.zufe.rms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.zufe.rms.enums.Spicey;

@Entity
@javax.persistence.Table(name = "selections")
public class Selection {
	@Id
	@GeneratedValue
	@Column(name = "selection_id")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Spicey spicey;
	
	private Boolean favorite;
	
	@ManyToOne
	@JoinColumn(name = "food_id")
	private Food food;
	
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "cart_item_id")
	private CartItem cartItem;
	
}
