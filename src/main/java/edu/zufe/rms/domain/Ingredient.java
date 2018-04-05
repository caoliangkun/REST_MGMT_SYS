package edu.zufe.rms.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ingredient {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Unit unit;
	private Double remain;
	private Double approRemain;
	private User lastModifiedBy;
	private Date lastModifiedTime;

	protected Ingredient() {
		super();
	}

	public Ingredient(String name, Unit unit, Double remain, Double approRemain, User lastModifiedBy,
			Date lastModifiedTime) {
		super();
		this.name = name;
		this.unit = unit;
		this.remain = remain;
		this.approRemain = approRemain;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedTime = lastModifiedTime;
	}

}
