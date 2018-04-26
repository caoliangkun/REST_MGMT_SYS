package edu.zufe.rms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private Long id;
	@Column(name = "total_price", nullable = false)
	private Double totalPrice;
	private String review;
	private Boolean finished;
	@Column(name = "create_date")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdAt;
	@Column(name = "last_update")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updateAt;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	
	@OneToMany(mappedBy = "order")
	private Set<OrderItem> orderItems;
}
