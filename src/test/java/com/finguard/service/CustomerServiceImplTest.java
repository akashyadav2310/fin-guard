package com.finguard.service;

import com.finguard.dto.CustomerRequest;
import com.finguard.dto.CustomerResponse;
import com.finguard.entity.Customer;
import com.finguard.exception.CustomerNotFoundException;
import com.finguard.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;


    @Test
    void createCustomer_shouldCreateCustomerSuccessfully() {

        CustomerRequest request = new CustomerRequest();
        request.setName("Akash Yadav");
        request.setEmail("akash@example.com");
        request.setMobile("9876543210");

        when(customerRepository.save(any(Customer.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        CustomerResponse response =
                customerService.createCustomer(request);

        assertNotNull(response);
        assertNotNull(response.getCustomerId());

        assertEquals("Akash Yadav", response.getName());
        assertEquals("akash@example.com", response.getEmail());
        assertEquals("9876543210", response.getMobile());
        assertEquals("ACTIVE", response.getStatus());

        verify(customerRepository, times(1))
                .save(any(Customer.class));
    }


    @Test
    void getCustomer_shouldReturnCustomerSuccessfully() {

        Customer customer = new Customer(
                "CUST-123",
                "Akash Yadav",
                "akash@example.com",
                "9876543210",
                "ACTIVE",
                java.time.LocalDateTime.now()
        );

        when(customerRepository.findById("CUST-123"))
                .thenReturn(Optional.of(customer));

        CustomerResponse response =
                customerService.getCustomer("CUST-123");

        assertNotNull(response);

        assertEquals("CUST-123", response.getCustomerId());
        assertEquals("Akash Yadav", response.getName());
        assertEquals("akash@example.com", response.getEmail());
        assertEquals("9876543210", response.getMobile());
        assertEquals("ACTIVE", response.getStatus());

        verify(customerRepository, times(1))
                .findById("CUST-123");
    }


    @Test
    void getCustomer_shouldThrowExceptionWhenCustomerDoesNotExist() {

        when(customerRepository.findById("CUST-999"))
                .thenReturn(Optional.empty());

        CustomerNotFoundException exception =
                assertThrows(
                        CustomerNotFoundException.class,
                        () -> customerService.getCustomer("CUST-999")
                );

        assertEquals(
                "Customer not found: CUST-999",
                exception.getMessage()
        );

        verify(customerRepository, times(1))
                .findById("CUST-999");
    }
}