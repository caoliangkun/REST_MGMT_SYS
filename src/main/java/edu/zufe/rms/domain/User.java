package edu.zufe.rms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Position position;
	private String phone;

	protected User() {
		super();
	}

	public User(String name, Position position, String phone) {
		super();
		this.name = name;
		this.position = position;
		this.phone = phone;
	}

}
