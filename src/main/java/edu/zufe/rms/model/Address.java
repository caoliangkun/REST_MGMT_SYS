package edu.zufe.rms.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@javax.persistence.Table(name = "addresses")
public class Address {
	@Id
	@GeneratedValue
	@Column(name = "address_id")
	private Long id;

	private String country;
	@Column(nullable = false, length = 50)
	private String province;
	@Column(nullable = false, length = 50)
	private String city;
	@Column(nullable = false, length = 50)
	private String street;
	@Column(nullable = false, length = 50)
	private String detail;
	@Column(length = 6)
	private String postalCode;
	@Column(name = "last_update", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateAt;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "address")
	private Set<StaffProfile> staff = new HashSet<>();

	protected Address() {
	}

	public Address(String country, String province, String city, String street, String detail, String postalCode,
			Date lastUpdateAt, Set<StaffProfile> staff) {
		super();
		this.country = country;
		this.province = province;
		this.city = city;
		this.street = street;
		this.detail = detail;
		this.postalCode = postalCode;
		this.lastUpdateAt = lastUpdateAt;
		this.staff = staff;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Date getLastUpdateAt() {
		return lastUpdateAt;
	}

	public void setLastUpdateAt(Date lastUpdateAt) {
		this.lastUpdateAt = lastUpdateAt;
	}

	public Set<StaffProfile> getStaff() {
		return staff;
	}

	public void setStaff(Set<StaffProfile> staff) {
		this.staff = staff;
	}

	public Long getId() {
		return id;
	};
	
}
