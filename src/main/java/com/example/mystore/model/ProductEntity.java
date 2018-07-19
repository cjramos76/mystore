package com.example.mystore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "PRODUCTS")
@Entity
public class ProductEntity {
	
	@Id
	@Column(name = "P_BASEPRODUCT")
	private Long id;

	@Column(name = "P_VENUE")
	private String name;

	@Column(name = "P_DATE")
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
