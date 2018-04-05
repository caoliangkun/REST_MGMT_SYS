package edu.zufe.rms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Integer countArrival; // The times of this customer have consumered

	protected Customer() { }

	public Customer(String name, Integer countArrival) {
		this.name = name;
		this.countArrival = countArrival;
	}


}
