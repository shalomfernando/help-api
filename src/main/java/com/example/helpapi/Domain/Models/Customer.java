package com.example.helpapi.Domain.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Calendar;

@Data
@Entity
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    private int Id;

    private String Name;

    private String Email;

    private String Password;

    private Calendar Birthday;

    public Customer(String name,String email, String password,Calendar birthday){
        this.Name = name;
        this.Email = email;
        this.Password = password;
        this.Birthday = birthday;
    }
}
