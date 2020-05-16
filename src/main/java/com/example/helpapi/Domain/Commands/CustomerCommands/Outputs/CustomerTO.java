package com.example.helpapi.Domain.Commands.CustomerCommands.Outputs;

import com.example.helpapi.Domain.Models.Customer;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import lombok.val;


public class CustomerTO {
    private String Name;
    private String Email;

    public CustomerTO(Customer customer){
        this.Name = customer.getName();
        this.Email = customer.getEmail();
    }

    public static List<CustomerTO> Converter(List<Customer> customer){
        return customer.stream().map(CustomerTO::new).collect(Collectors.toList());
    }

	public String getName() {
		return Name;
	}

	public String getEmail() {
		return Email;
	}

    
    
}

