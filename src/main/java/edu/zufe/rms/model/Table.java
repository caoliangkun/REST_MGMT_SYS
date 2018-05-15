package edu.zufe.rms.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import edu.zufe.rms.enums.TableStatus;

@Entity
@javax.persistence.Table(name = "tables")
public class Table implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "table_id")
	private Long id;
	
	@Column(name = "capacity")
	private Integer capacity;
	
	@Enumerated(EnumType.STRING)
	private TableStatus tableStatus;
	
	@OneToMany(mappedBy = "table", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<OrderItem> orderItems;
	
	@OneToOne
	@JoinColumn(name = "waiter_id")
	private User waiter;

	public Table() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Table(Long id, Integer capacity, TableStatus tableStatus) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.tableStatus = tableStatus;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public TableStatus getTableStatus() {
		return tableStatus;
	}

	public void setTableStatus(TableStatus tableStatus) {
		this.tableStatus = tableStatus;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public User getWaiter() {
		return waiter;
	}

	public void setWaiter(User waiter) {
		this.waiter = waiter;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
