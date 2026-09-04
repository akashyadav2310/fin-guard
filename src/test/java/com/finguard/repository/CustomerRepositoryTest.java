package com.finguard.repository;

import com.finguard.entity.Customer;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    private final CustomerRepository customerRepository =
            new CustomerRepository();

    @Test
    void save_shouldStoreCustomer() {

        Customer customer = createCustomer("CUST-001");

        Customer saved = customerRepository.save(customer);

        assertNotNull(saved);
        assertEquals("CUST-001", saved.getCustomerId());
    }

    @Test
    void findById_shouldReturnCustomer() {

        Customer customer = createCustomer("CUST-001");

        customerRepository.save(customer);

        Optional<Customer> result =
                customerRepository.findById("CUST-001");

        assertTrue(result.isPresent());
        assertEquals("CUST-001",
                result.get().getCustomerId());
    }

    @Test
    void findById_shouldReturnEmptyWhenCustomerDoesNotExist() {

        Optional<Customer> result =
                customerRepository.findById("CUST-999");

        assertTrue(result.isEmpty());
    }

    @Test
    void save_shouldReplaceExistingCustomer() {

        Customer firstCustomer = createCustomer("CUST-001");
        firstCustomer.setName("First Name");

        Customer secondCustomer = createCustomer("CUST-001");
        secondCustomer.setName("Updated Name");

        customerRepository.save(firstCustomer);
        customerRepository.save(secondCustomer);

        Customer result =
                customerRepository.findById("CUST-001").orElseThrow();

        assertEquals("Updated Name", result.getName());
    }

    private Customer createCustomer(String customerId) {

        return new Customer(
                customerId,
                "Akash Yadav",
                "akash@example.com",
                "9876543210",
                "ACTIVE",
                LocalDateTime.now()
        );
    }
}