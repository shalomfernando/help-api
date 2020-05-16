package com.example.helpapi.Infra.Repository;

import com.example.helpapi.Domain.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByNameAndPassword(String name, String password);
}
