package com.finguard.service;

import com.finguard.dto.CustomerRequest;
import com.finguard.dto.CustomerResponse;
import com.finguard.entity.Customer;
import com.finguard.exception.CustomerNotFoundException;
import com.finguard.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse createCustomer(CustomerRequest request) {

        String customerId = "CUST-" + UUID.randomUUID();

        Customer customer = new Customer(
                customerId,
                request.getName(),
                request.getEmail(),
                request.getMobile(),
                "ACTIVE",
                LocalDateTime.now()
        );

        Customer savedCustomer = customerRepository.save(customer);

        return mapToResponse(savedCustomer);
    }

    @Override
    public CustomerResponse getCustomer(String customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new CustomerNotFoundException(
                                "Customer not found: " + customerId));

        return mapToResponse(customer);
    }

    private CustomerResponse mapToResponse(Customer customer) {

        return new CustomerResponse(
                customer.getCustomerId(),
                customer.getName(),
                customer.getEmail(),
                customer.getMobile(),
                customer.getStatus(),
                customer.getCreatedAt()
        );
    }
}