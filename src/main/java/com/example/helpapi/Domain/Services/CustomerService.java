package com.example.helpapi.Domain.Services;

import com.example.helpapi.Domain.Commands.CustomerCommands.Inputs.SaveCustomerCommand;
import com.example.helpapi.Domain.Commands.CustomerCommands.Outputs.CustomerTO;
import com.example.helpapi.Domain.Config.Notifications;
import com.example.helpapi.Domain.Models.Customer;
import com.example.helpapi.Infra.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService extends Notifications {
	
	public String user;
	public String pass;
	
    private final CustomerRepository _repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this._repository = repository;
    }

    public List<CustomerTO> GetAll(){
        return CustomerTO.Converter(_repository.findAll());
    }

    public ResponseEntity<?> SaveCustomer(SaveCustomerCommand command, UriComponentsBuilder builder) {
        if (!command.IsValid()){
            return ResponseEntity.badRequest().body(command.GetNotifications());
        }

        Customer customer = new Customer(command.Name,command.Email,command.Password,command.Birthday);
        _repository.save(customer);

        URI uri = builder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(new CustomerTO(customer));
    }

    public ResponseEntity<?> GetCustomer(int id) {
        Optional<Customer> customer = _repository.findById(id);
        if(!customer.isPresent()){
            return ResponseEntity.badRequest().body(CreateNotification("Cliente","Não encontrado."));
        }
        return ResponseEntity.ok(customer.get());
    }

	public Customer login(String name,String password) {
		this.user = name;
		this.pass = password;
		Customer customer = _repository.findByNameAndPassword(name,password);
		if( customer != null )
			return customer;
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	public Customer getThisUser() {
		Customer customer = _repository.findByNameAndPassword(user,pass);
		if( customer != null )
			return customer;
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
}
