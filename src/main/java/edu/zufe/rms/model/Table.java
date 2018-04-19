package edu.zufe.rms.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@javax.persistence.Table(name = "tables")
public class Table implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "table_id")
	private Long id;
	
	@Column(name = "capacity")
	private Integer capacity;
	

	
	@OneToMany(mappedBy = "table")
	private Set<OrderItem> orderItems;
	
	@OneToOne
	@JoinColumn(name = "waiter_id")
	private User waiter;
}
