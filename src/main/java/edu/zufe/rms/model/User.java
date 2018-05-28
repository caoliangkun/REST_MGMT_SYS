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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.zufe.rms.enums.Position;

@Entity
@Table(name = "users")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long id;
	@Column(length = 11, unique = true, nullable = true)
	private String phone;
	@Column(nullable = false)
	private String name;
	
	private String sex;
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Position position;
	
	private boolean login;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private StaffProfile profile;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Food> foods;
	
	
	
	@OneToMany(mappedBy = "waiter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<OrderItem> orderItems;
	
	@OneToMany(mappedBy = "cashier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Payment> payments;
	
	@OneToOne(mappedBy = "waiter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private edu.zufe.rms.model.Table table;

	protected User() {
	}

	public User(String name, String password, String phone, Position position) {
		super();
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.position = position;
	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public StaffProfile getProfile() {
		return profile;
	}

	public void setProfile(StaffProfile profile) {
		this.profile = profile;
	}

	public Set<Food> getFoods() {
		return foods;
	}

	public void setFoods(Set<Food> foods) {
		this.foods = foods;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public edu.zufe.rms.model.Table getTable() {
		return table;
	}

	public void setTable(edu.zufe.rms.model.Table table) {
		this.table = table;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public String toString() {
		return getName() + ", " + getPassword();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	

}
