package com.example.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CustomerSupportTest {

    @Test
    void testNoArgsConstructor() {
        CustomerSupport customerSupport = new CustomerSupport();
        assertNotNull(customerSupport);
    }

    @Test
    void testAllArgsConstructor() {
        CustomerSupport customerSupport = new CustomerSupport("username", "password");

        assertEquals("username", customerSupport.getUsername());
        assertEquals("password", customerSupport.getPassword());
    }

    @Test
    void testGetAndSetUsername() {
        CustomerSupport customerSupport = new CustomerSupport();
        customerSupport.setUsername("username");
        assertEquals("username", customerSupport.getUsername());
    }

    @Test
    void testGetAndSetPassword() {
        CustomerSupport customerSupport = new CustomerSupport();
        customerSupport.setPassword("password");
        assertEquals("password", customerSupport.getPassword());
    }


}
