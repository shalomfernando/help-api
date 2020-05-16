package com.example.helpapi.Domain.Commands.CustomerCommands.Outputs;

import com.example.helpapi.Domain.Models.Customer;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
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
}
