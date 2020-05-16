package com.example.helpapi.Domain.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id_addres;

	@Column
	String name_street;

	@Column
	int cep;

	public Address() {
	}

	public Address(int id_addres, String name_street, int cep) {
		this.id_addres = id_addres;
		this.name_street = name_street;
		this.cep = cep;
	}

	public int getId_addres() {
		return id_addres;
	}

	public void setId_addres(int id_addres) {
		this.id_addres = id_addres;
	}

	public String getName_street() {
		return name_street;
	}

	public void setName_street(String name_street) {
		this.name_street = name_street;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

}
