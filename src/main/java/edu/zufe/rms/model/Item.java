package edu.zufe.rms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@javax.persistence.Table(name = "inventory")
public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue()
	@Column(name = "item_id")
	private Long id;
	
	@Column(name = "item_name")
	private String itemName;
	
	private Double remain;
	
	private Double appr_remain;
	
	@OneToOne
	@JoinColumn(name = "img_id")
	private Image img;
}
