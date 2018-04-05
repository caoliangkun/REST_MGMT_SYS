package edu.zufe.rms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Table {
	@Id
	@GeneratedValue
	private int id;
	private TableStatus status;
	protected Table() {
		super();
	}
	public Table(TableStatus status) {
		super();
		this.status = status;
	}
	
}
