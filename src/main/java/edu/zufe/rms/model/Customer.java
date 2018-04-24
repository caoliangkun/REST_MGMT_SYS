package edu.zufe.rms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@javax.persistence.Table(name = "customers")
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private Long id;
	private String name;
	@Column(nullable = false)
	private String phone;
	@Column(name = "create_date")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Order> orders = new HashSet<>();
	
	@OneToMany(mappedBy = "customer")
	private Set<Payment> payments;
	
	@OneToMany(mappedBy = "customer")
	private Set<Selection> selections;
	
	
}
