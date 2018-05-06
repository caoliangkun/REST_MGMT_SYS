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

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name = "orders")
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JSONField(name = "ID", ordinal = 1)
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private Long id;
	
	@JSONField(name = "TOTAL PRICE", ordinal = 2)
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

	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderItem> orderItems;
	
	public Order() {
		this.totalPrice = 0.0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Boolean getFinished() {
		return finished;
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
