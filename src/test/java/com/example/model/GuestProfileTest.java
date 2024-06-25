package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class GuestProfileTest {

    @Test
    public void testNoArgsConstructor() {
        GuestProfile guestProfile = new GuestProfile();
        
        assertNull(guestProfile.getGuestEmail());
        assertNull(guestProfile.getPassword());
        assertNull(guestProfile.getApplicationId());
        assertNull(guestProfile.getMobileNumber());
        assertNull(guestProfile.getName());
        assertNull(guestProfile.getPanId());
        assertNull(guestProfile.getAadhaarNumber());
        assertNull(guestProfile.getAddress());
        assertNull(guestProfile.getDob());
        assertNull(guestProfile.getEmploymentYears());
        assertNull(guestProfile.getCompanyName());
        assertNull(guestProfile.getAnnualIncome());
        assertNull(guestProfile.getIncomeProofFilePath());
        assertNull(guestProfile.getCreditCard());
        assertNull(guestProfile.getApplicationStatus());
        assertNull(guestProfile.getAadhaarFilePath());
        assertNull(guestProfile.getPanFilePath());
        assertNull(guestProfile.getSignatureFilePath());
        assertNull(guestProfile.getPhotoFilePath());
        assertNull(guestProfile.getAdmin());
    }

    @Test
    public void testAllArgsConstructor() {
        String guestEmail = "test@example.com";
        String password = "password";
        Long applicationId = 12345L;
        String mobileNumber = "1234567890";
        String name = "John Doe";
        String panId = "ABCDE1234F";
        Long aadhaarNumber = 123456789012L;
        String address = "123 Main St";
        Date dob = new Date();
        Integer employmentYears = 5;
        String companyName = "Company";
        BigDecimal annualIncome = new BigDecimal("100000.00");
        String incomeProofFilePath = "path/to/incomeProof";
        CreditCard creditCard = new CreditCard();
        ApplicationStatus applicationStatus = ApplicationStatus.PENDING;
        String aadhaarFilePath = "path/to/aadhaar";
        String panFilePath = "path/to/pan";
        String signatureFilePath = "path/to/signature";
        String photoFilePath = "path/to/photo";
        Admin admin = new Admin();

        GuestProfile guestProfile = new GuestProfile(guestEmail, password, applicationId, mobileNumber, name, panId, 
            aadhaarNumber, address, dob, employmentYears, companyName, annualIncome, incomeProofFilePath, creditCard, 
            applicationStatus, aadhaarFilePath, panFilePath, signatureFilePath, photoFilePath, admin);

        assertEquals(guestEmail, guestProfile.getGuestEmail());
        assertEquals(password, guestProfile.getPassword());
        assertEquals(applicationId, guestProfile.getApplicationId());
        assertEquals(mobileNumber, guestProfile.getMobileNumber());
        assertEquals(name, guestProfile.getName());
        assertEquals(panId, guestProfile.getPanId());
        assertEquals(aadhaarNumber, guestProfile.getAadhaarNumber());
        assertEquals(address, guestProfile.getAddress());
        assertEquals(dob, guestProfile.getDob());
        assertEquals(employmentYears, guestProfile.getEmploymentYears());
        assertEquals(companyName, guestProfile.getCompanyName());
        assertEquals(annualIncome, guestProfile.getAnnualIncome());
        assertEquals(incomeProofFilePath, guestProfile.getIncomeProofFilePath());
        assertEquals(creditCard, guestProfile.getCreditCard());
        assertEquals(applicationStatus, guestProfile.getApplicationStatus());
        assertEquals(aadhaarFilePath, guestProfile.getAadhaarFilePath());
        assertEquals(panFilePath, guestProfile.getPanFilePath());
        assertEquals(signatureFilePath, guestProfile.getSignatureFilePath());
        assertEquals(photoFilePath, guestProfile.getPhotoFilePath());
        assertEquals(admin, guestProfile.getAdmin());
    }

    @Test
    public void testSettersAndGetters() {
        GuestProfile guestProfile = new GuestProfile();

        String guestEmail = "test@example.com";
        String password = "password";
        Long applicationId = 12345L;
        String mobileNumber = "1234567890";
        String name = "John Doe";
        String panId = "ABCDE1234F";
        Long aadhaarNumber = 123456789012L;
        String address = "123 Main St";
        Date dob = new Date();
        Integer employmentYears = 5;
        String companyName = "Company";
        BigDecimal annualIncome = new BigDecimal("100000.00");
        String incomeProofFilePath = "path/to/incomeProof";
        CreditCard creditCard = new CreditCard();
        ApplicationStatus applicationStatus = ApplicationStatus.PENDING;
        String aadhaarFilePath = "path/to/aadhaar";
        String panFilePath = "path/to/pan";
        String signatureFilePath = "path/to/signature";
        String photoFilePath = "path/to/photo";
        Admin admin = new Admin();

        guestProfile.setGuestEmail(guestEmail);
        guestProfile.setPassword(password);
        guestProfile.setApplicationId(applicationId);
        guestProfile.setMobileNumber(mobileNumber);
        guestProfile.setName(name);
        guestProfile.setPanId(panId);
        guestProfile.setAadhaarNumber(aadhaarNumber);
        guestProfile.setAddress(address);
        guestProfile.setDob(dob);
        guestProfile.setEmploymentYears(employmentYears);
        guestProfile.setCompanyName(companyName);
        guestProfile.setAnnualIncome(annualIncome);
        guestProfile.setIncomeProofFilePath(incomeProofFilePath);
        guestProfile.setCreditCard(creditCard);
        guestProfile.setApplicationStatus(applicationStatus);
        guestProfile.setAadhaarFilePath(aadhaarFilePath);
        guestProfile.setPanFilePath(panFilePath);
        guestProfile.setSignatureFilePath(signatureFilePath);
        guestProfile.setPhotoFilePath(photoFilePath);
        guestProfile.setAdmin(admin);

        assertEquals(guestEmail, guestProfile.getGuestEmail());
        assertEquals(password, guestProfile.getPassword());
        assertEquals(applicationId, guestProfile.getApplicationId());
        assertEquals(mobileNumber, guestProfile.getMobileNumber());
        assertEquals(name, guestProfile.getName());
        assertEquals(panId, guestProfile.getPanId());
        assertEquals(aadhaarNumber, guestProfile.getAadhaarNumber());
        assertEquals(address, guestProfile.getAddress());
        assertEquals(dob, guestProfile.getDob());
        assertEquals(employmentYears, guestProfile.getEmploymentYears());
        assertEquals(companyName, guestProfile.getCompanyName());
        assertEquals(annualIncome, guestProfile.getAnnualIncome());
        assertEquals(incomeProofFilePath, guestProfile.getIncomeProofFilePath());
        assertEquals(creditCard, guestProfile.getCreditCard());
        assertEquals(applicationStatus, guestProfile.getApplicationStatus());
        assertEquals(aadhaarFilePath, guestProfile.getAadhaarFilePath());
        assertEquals(panFilePath, guestProfile.getPanFilePath());
        assertEquals(signatureFilePath, guestProfile.getSignatureFilePath());
        assertEquals(photoFilePath, guestProfile.getPhotoFilePath());
        assertEquals(admin, guestProfile.getAdmin());
    }
}
