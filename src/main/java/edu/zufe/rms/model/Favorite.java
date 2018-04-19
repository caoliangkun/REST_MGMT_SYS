package edu.zufe.rms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Favorite {
	@Id
	@GeneratedValue
	@Column(name = "favorite_id")
	private Long id;
	
	
}
