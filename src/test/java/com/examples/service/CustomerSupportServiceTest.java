package com.examples.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.example.model.CustomerSupport;
import com.example.repository.CustomerSupportRepository;
import com.example.service.CustomerSupportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

class CustomerSupportServiceTest {

    @Mock
    private CustomerSupportRepository customerSupportRepository;

    @InjectMocks
    private CustomerSupportService customerSupportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoginCustomerService_Success() {
        CustomerSupport customerSupport = new CustomerSupport();
        customerSupport.setUsername("validUser");
        customerSupport.setPassword("validPass");

        when(customerSupportRepository.findByUsernameAndPassword("validUser", "validPass"))
                .thenReturn(Optional.of(customerSupport));

        ResponseEntity<String> response = customerSupportService.loginCustomerService(customerSupport);

        assertEquals(ResponseEntity.ok("CustomerService logged in successfully!"), response);
        verify(customerSupportRepository, times(1)).findByUsernameAndPassword("validUser", "validPass");
    }

    @Test
    void testLoginCustomerService_Failure() {
        CustomerSupport customerSupport = new CustomerSupport();
        customerSupport.setUsername("invalidUser");
        customerSupport.setPassword("invalidPass");

        when(customerSupportRepository.findByUsernameAndPassword("invalidUser", "invalidPass"))
                .thenReturn(Optional.empty());

        ResponseEntity<String> response = customerSupportService.loginCustomerService(customerSupport);

        assertEquals(ResponseEntity.badRequest().body("Invalid username or password"), response);
        verify(customerSupportRepository, times(1)).findByUsernameAndPassword("invalidUser", "invalidPass");
    }
}
