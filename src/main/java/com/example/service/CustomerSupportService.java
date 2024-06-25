package com.example.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.CustomerSupport;
import com.example.repository.CustomerSupportRepository;

@Service
public class CustomerSupportService {

	private final CustomerSupportRepository customerSupportRepository;
	
	public CustomerSupportService(CustomerSupportRepository customerSupportRepository) {
		this.customerSupportRepository = customerSupportRepository;
	}

    public ResponseEntity<String> loginCustomerService(CustomerSupport loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        Optional<CustomerSupport> customerSupport = customerSupportRepository.findByUsernameAndPassword(username, password);
        if (customerSupport.isPresent()) {
            return ResponseEntity.ok("CustomerService logged in successfully!");
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }
}
