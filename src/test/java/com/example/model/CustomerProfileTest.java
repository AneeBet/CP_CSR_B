package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerProfileTest {

    private CustomerProfile customerProfile;

    @BeforeEach
    public void setUp() {
        customerProfile = new CustomerProfile();
    }

    @Test
    public void testDefaultConstructor() {
        assertNull(customerProfile.getCustomerId());
        assertNull(customerProfile.getName());
        assertNull(customerProfile.getAadhaarNumber());
        assertNull(customerProfile.getEmail());
        assertNull(customerProfile.getPassword());
        assertNull(customerProfile.getAddress());
        assertNull(customerProfile.getPanId());
        assertNull(customerProfile.getMobileNumber());
        assertNull(customerProfile.getDob());
        assertTrue(customerProfile.getFirstLogin());
        assertNull(customerProfile.getEmploymentYears());
        assertNull(customerProfile.getCompanyName());
        assertNull(customerProfile.getAnnualIncome());
        assertNull(customerProfile.getIncomeProofFilePath());
        assertNull(customerProfile.getCustomerCardAccounts());
    }

    @Test
    public void testParameterizedConstructor() {
        Date dob = new Date();
        List<CustomerCardAccount> cardAccounts = List.of(new CustomerCardAccount());

        CustomerProfile profile = new CustomerProfile(
                1L, "John Doe", 123456789012L, "john.doe@example.com", "password123", 
                "123 Main St", "ABCDE1234F", "1234567890", dob, true, 
                5, "Tech Corp", new BigDecimal("50000"), "path/to/incomeProof", cardAccounts);

        assertEquals(1L, profile.getCustomerId());
        assertEquals("John Doe", profile.getName());
        assertEquals(123456789012L, profile.getAadhaarNumber());
        assertEquals("john.doe@example.com", profile.getEmail());
        assertEquals("password123", profile.getPassword());
        assertEquals("123 Main St", profile.getAddress());
        assertEquals("ABCDE1234F", profile.getPanId());
        assertEquals("1234567890", profile.getMobileNumber());
        assertEquals(dob, profile.getDob());
        assertTrue(profile.getFirstLogin());
        assertEquals(5, profile.getEmploymentYears());
        assertEquals("Tech Corp", profile.getCompanyName());
        assertEquals(new BigDecimal("50000"), profile.getAnnualIncome());
        assertEquals("path/to/incomeProof", profile.getIncomeProofFilePath());
        assertEquals(cardAccounts, profile.getCustomerCardAccounts());
    }

    @Test
    public void testSetAndGetCustomerId() {
        customerProfile.setCustomerId(1L);
        assertEquals(1L, customerProfile.getCustomerId());
    }

    @Test
    public void testSetAndGetName() {
        customerProfile.setName("John Doe");
        assertEquals("John Doe", customerProfile.getName());
    }

    @Test
    public void testSetAndGetAadhaarNumber() {
        customerProfile.setAadhaarNumber(123456789012L);
        assertEquals(123456789012L, customerProfile.getAadhaarNumber());
    }

    @Test
    public void testSetAndGetEmail() {
        customerProfile.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", customerProfile.getEmail());
    }

    @Test
    public void testSetAndGetPassword() {
        customerProfile.setPassword("password123");
        assertEquals("password123", customerProfile.getPassword());
    }

    @Test
    public void testSetAndGetAddress() {
        customerProfile.setAddress("123 Main St");
        assertEquals("123 Main St", customerProfile.getAddress());
    }

    @Test
    public void testSetAndGetPanId() {
        customerProfile.setPanId("ABCDE1234F");
        assertEquals("ABCDE1234F", customerProfile.getPanId());
    }

    @Test
    public void testSetAndGetMobileNumber() {
        customerProfile.setMobileNumber("1234567890");
        assertEquals("1234567890", customerProfile.getMobileNumber());
    }

    @Test
    public void testSetAndGetDob() {
        Date dob = new Date();
        customerProfile.setDob(dob);
        assertEquals(dob, customerProfile.getDob());
    }

    @Test
    public void testSetAndGetFirstLogin() {
        customerProfile.setFirstLogin(false);
        assertEquals(false, customerProfile.getFirstLogin());
    }

    @Test
    public void testSetAndGetEmploymentYears() {
        customerProfile.setEmploymentYears(5);
        assertEquals(5, customerProfile.getEmploymentYears());
    }

    @Test
    public void testSetAndGetCompanyName() {
        customerProfile.setCompanyName("Tech Corp");
        assertEquals("Tech Corp", customerProfile.getCompanyName());
    }

    @Test
    public void testSetAndGetAnnualIncome() {
        customerProfile.setAnnualIncome(new BigDecimal("50000"));
        assertEquals(new BigDecimal("50000"), customerProfile.getAnnualIncome());
    }

    @Test
    public void testSetAndGetIncomeProofFilePath() {
        customerProfile.setIncomeProofFilePath("path/to/incomeProof");
        assertEquals("path/to/incomeProof", customerProfile.getIncomeProofFilePath());
    }

    @Test
    public void testSetAndGetCustomerCardAccounts() {
        List<CustomerCardAccount> cardAccounts = List.of(new CustomerCardAccount());
        customerProfile.setCustomerCardAccounts(cardAccounts);
        assertEquals(cardAccounts, customerProfile.getCustomerCardAccounts());
    }
}
