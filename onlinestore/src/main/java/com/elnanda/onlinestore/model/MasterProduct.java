package com.elnanda.onlinestore.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "master_product")
public class MasterProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "image")
	private String image;

	@Column(name = "description")
	private String description;

	@Override
	public String toString() {
		return String.format("" + "master_product[id=%d,name=%s,price=%s,image=%s,description=%tD", id, name, price, image, description);
	}

}
