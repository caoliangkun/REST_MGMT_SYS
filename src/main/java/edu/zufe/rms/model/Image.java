package edu.zufe.rms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Image implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue()
	@Column(name = "img_id")
	private Long id;
	
	@Column(name = "img_name")
	private String imgName;
	
	@Column(name = "img_location")
	private String imgLocation;	
	
	@OneToOne(mappedBy = "img")
	private Food food;
	
	@OneToOne(mappedBy = "img")
	private Item item;
}
