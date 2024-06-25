package com.example.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;


class CustomerGrievanceTest {

    @Test
    void testNoArgsConstructor() {
        CustomerGrievance grievance = new CustomerGrievance();
        assertNotNull(grievance);
    }

    @Test
    void testAllArgsConstructor() {
        CustomerCardAccount account = new CustomerCardAccount();
        Date date = new Date();
        CustomerGrievance grievance = new CustomerGrievance(
            1L, account, "Subject", "Description", date, ResolutionStatus.PENDING
        );

        assertEquals(1L, grievance.getGrievanceId());
        assertEquals(account, grievance.getCustomerCardAccount());
        assertEquals("Subject", grievance.getSubject());
        assertEquals("Description", grievance.getDescription());
        assertEquals(date, grievance.getTimestamp());
        assertEquals(ResolutionStatus.PENDING, grievance.getStatus());
    }

    @Test
    void testGetAndSetGrievanceId() {
        CustomerGrievance grievance = new CustomerGrievance();
        grievance.setGrievanceId(1L);
        assertEquals(1L, grievance.getGrievanceId());
    }

    @Test
    void testGetAndSetCustomerCardAccount() {
        CustomerGrievance grievance = new CustomerGrievance();
        CustomerCardAccount account = new CustomerCardAccount();
        grievance.setCustomerCardAccount(account);
        assertEquals(account, grievance.getCustomerCardAccount());
    }

    @Test
    void testGetAndSetSubject() {
        CustomerGrievance grievance = new CustomerGrievance();
        grievance.setSubject("Subject");
        assertEquals("Subject", grievance.getSubject());
    }

    @Test
    void testGetAndSetDescription() {
        CustomerGrievance grievance = new CustomerGrievance();
        grievance.setDescription("Description");
        assertEquals("Description", grievance.getDescription());
    }

    @Test
    void testGetAndSetTimestamp() {
        CustomerGrievance grievance = new CustomerGrievance();
        Date date = new Date();
        grievance.setTimestamp(date);
        assertEquals(date, grievance.getTimestamp());
    }

    @Test
    void testGetAndSetStatus() {
        CustomerGrievance grievance = new CustomerGrievance();
        grievance.setStatus(ResolutionStatus.PENDING);
        assertEquals(ResolutionStatus.PENDING, grievance.getStatus());
    }

}