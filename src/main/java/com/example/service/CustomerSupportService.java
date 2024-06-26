package com.example.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.CustomerSupport;
import com.example.repository.CustomerSupportRepository;

@Service
public class CustomerSupportService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerSupportService.class);

    private final CustomerSupportRepository customerSupportRepository;
    
    public CustomerSupportService(CustomerSupportRepository customerSupportRepository) {
        this.customerSupportRepository = customerSupportRepository;
    }

    public ResponseEntity<String> loginCustomerService(CustomerSupport loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        logger.info("Customer support login attempt for username: {}", username);
        Optional<CustomerSupport> customerSupport = customerSupportRepository.findByUsernameAndPassword(username, password);
        if (customerSupport.isPresent()) {
            logger.info("Customer support logged in successfully for username: {}", username);
            return ResponseEntity.ok("CustomerService logged in successfully!");
        } else {
            logger.warn("Invalid username or password for username: {}", username);
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }
}
