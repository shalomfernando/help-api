package com.example.helpapi.Domain.Models;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Occurrence {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	@Column
	private String occurrence_type;

	@OneToOne(cascade = CascadeType.PERSIST)
	@Autowired
	private Address address;

	@Column
	private double longitude;

	@Column
	private double latitude;

	@Column
	private String description;

	@Column
	private Calendar date;

	@Column
	private String pathFoto;

	@ManyToOne
	@JsonIgnoreProperties
	private Customer customer;

	@Column
	@JsonIgnoreProperties
	private String image;

	
	public Occurrence() {
	}

	public Occurrence(int id, String occurrence_type, Address address, double longitude, double latitude,
			String description, Calendar date, String pathFoto, Customer customer, String image) {
		this.id = id;
		this.occurrence_type = occurrence_type;
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
		this.description = description;
		this.date = date;
		this.pathFoto = pathFoto;
		this.customer = customer;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOccurrence_type() {
		return occurrence_type;
	}

	public void setOccurrence_type(String occurrence_type) {
		this.occurrence_type = occurrence_type;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getPathFoto() {
		return pathFoto;
	}

	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


}
