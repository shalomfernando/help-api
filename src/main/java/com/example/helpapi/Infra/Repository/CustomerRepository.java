package com.example.helpapi.Infra.Repository;

import com.example.helpapi.Domain.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
