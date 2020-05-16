package com.example.helpapi.Api.Controller;

import com.example.helpapi.Domain.Commands.CustomerCommands.Inputs.SaveCustomerCommand;
import com.example.helpapi.Domain.Commands.CustomerCommands.Outputs.CustomerTO;
import com.example.helpapi.Domain.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController()
@RequestMapping("api/Customer")
public class CustomerController {
    private CustomerService _service;

    @Autowired
    public CustomerController(CustomerService _service) {
        this._service = _service;
    }

    @GetMapping("/GetAllCustomers")
    public List<CustomerTO> Get(){
        return _service.GetAll();
    }
    @GetMapping("/GetCustomer/{Id}")
    public ResponseEntity<?> Get(@PathVariable int Id){
        return _service.GetCustomer(Id);
    }

    @PostMapping("/SaveCustomer")
    public ResponseEntity<?> Post(@RequestBody SaveCustomerCommand command, UriComponentsBuilder builder){
        return _service.SaveCustomer(command,builder);
    }

}
