package com.finguard.repository;

import com.finguard.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CustomerRepository {

    private final Map<String, Customer> customers = new ConcurrentHashMap<>();

    public Customer save(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
        return customer;
    }

    public Optional<Customer> findById(String customerId) {
        return Optional.ofNullable(customers.get(customerId));
    }
}