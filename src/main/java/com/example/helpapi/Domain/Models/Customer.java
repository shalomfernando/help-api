package com.example.helpapi.Domain.Models;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Calendar;

@Entity
public class Customer {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    private int Id;

    private String name;

    private String Email;

    private String password;

    private Calendar Birthday;
    

    public Customer(String name,String email, String password,Calendar birthday){
        this.name = name;
        this.Email = email;
        this.password = password;
        this.Birthday = birthday;
    }

	public Customer() {
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Calendar getBirthday() {
		return Birthday;
	}

	public void setBirthday(Calendar birthday) {
		Birthday = birthday;
	}

    
}
