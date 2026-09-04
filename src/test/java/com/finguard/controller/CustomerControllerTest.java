package com.finguard.controller;

public class CustomerControllerTest {
}

//package com.finguard.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.finguard.dto.CustomerRequest;
//import com.finguard.dto.CustomerResponse;
//import com.finguard.exception.CustomerNotFoundException;
//import com.finguard.service.CustomerService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.LocalDateTime;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(CustomerController.class)
//class CustomerControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private CustomerService customerService;
//
//    @Test
//    void createCustomer_shouldReturn201() throws Exception {
//
//        CustomerRequest request = new CustomerRequest();
//        request.setName("Akash Yadav");
//        request.setEmail("akash@example.com");
//        request.setMobile("9876543210");
//
//        CustomerResponse response = new CustomerResponse(
//                "CUST-123",
//                "Akash Yadav",
//                "akash@example.com",
//                "9876543210",
//                "ACTIVE",
//                LocalDateTime.now()
//        );
//
//        when(customerService.createCustomer(any(CustomerRequest.class)))
//                .thenReturn(response);
//
//        mockMvc.perform(
//                        post("/api/v1/customers")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(objectMapper.writeValueAsString(request))
//                )
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.customerId").value("CUST-123"))
//                .andExpect(jsonPath("$.name").value("Akash Yadav"))
//                .andExpect(jsonPath("$.email").value("akash@example.com"))
//                .andExpect(jsonPath("$.status").value("ACTIVE"));
//    }
//
//    @Test
//    void getCustomer_shouldReturn200() throws Exception {
//
//        CustomerResponse response = new CustomerResponse(
//                "CUST-123",
//                "Akash Yadav",
//                "akash@example.com",
//                "9876543210",
//                "ACTIVE",
//                LocalDateTime.now()
//        );
//
//        when(customerService.getCustomer("CUST-123"))
//                .thenReturn(response);
//
//        mockMvc.perform(
//                        get("/api/v1/customers/CUST-123")
//                )
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.customerId").value("CUST-123"))
//                .andExpect(jsonPath("$.name").value("Akash Yadav"))
//                .andExpect(jsonPath("$.email").value("akash@example.com"))
//                .andExpect(jsonPath("$.status").value("ACTIVE"));
//    }
//}