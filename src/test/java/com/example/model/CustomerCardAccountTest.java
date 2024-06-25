package com.example.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerCardAccountTest {

    private CustomerCardAccount account;
    private CustomerProfile customerProfile;

    @BeforeEach
    public void setUp() {
        customerProfile = new CustomerProfile();
        customerProfile.setCustomerId(1L);

        account = new CustomerCardAccount(
                1234567890L, customerProfile, "INR", new Date(), 
                CustomerCardAccount.ActivationStatus.ACTIVE, 1234567890123456L, 
                CustomerCardAccount.ActivationStatus.ACTIVE, 
                CustomerCardAccount.PaymentStatus.ENABLE, 
                CustomerCardAccount.PaymentStatus.ENABLE, 1234, 
                CustomerCardAccount.PaymentStatus.ENABLE, 
                new BigDecimal("50000.0000"), new BigDecimal("20000.0000"), 
                new BigDecimal("10000.0000"), new BigDecimal("0.0000"), 
                new BigDecimal("0.0000"), new BigDecimal("100000.0000"), 
                new Date(), new Date(), "123", "Platinum"
        );
    }

    @Test
    public void testGetters() {
        assertEquals(1234567890L, account.getAccountNumber());
        assertEquals(customerProfile, account.getCustomerProfile());
        assertEquals("INR", account.getBaseCurrency());
        assertEquals(CustomerCardAccount.ActivationStatus.ACTIVE, account.getActivationStatus());
        assertEquals(1234567890123456L, account.getCardNumber());
        assertEquals(CustomerCardAccount.ActivationStatus.ACTIVE, account.getCardStatus());
        assertEquals(CustomerCardAccount.PaymentStatus.ENABLE, account.getInternationalPayment());
        assertEquals(CustomerCardAccount.PaymentStatus.ENABLE, account.getOnlinePayment());
        assertEquals(1234, account.getPin());
        assertEquals(CustomerCardAccount.PaymentStatus.ENABLE, account.getCardSwipe());
        assertEquals(new BigDecimal("50000.0000"), account.getOnlinePaymentLimit());
        assertEquals(new BigDecimal("20000.0000"), account.getCardSwipeLimit());
        assertEquals(new BigDecimal("10000.0000"), account.getInternationalPaymentLimit());
        assertEquals(new BigDecimal("0.0000"), account.getCardBalance());
        assertEquals(new BigDecimal("0.0000"), account.getDueAmount());
        assertEquals(new BigDecimal("100000.0000"), account.getCreditCardLimit());
        assertEquals("123", account.getCvv());
        assertEquals("Platinum", account.getCreditCard());
    }

    @Test
    public void testSetters() {
        account.setAccountNumber(9876543210L);
        account.setCustomerProfile(customerProfile);
        account.setBaseCurrency("USD");
        account.setOpeningDate(new Date());
        account.setActivationStatus(CustomerCardAccount.ActivationStatus.INACTIVE);
        account.setCardNumber(6543210987654321L);
        account.setCardStatus(CustomerCardAccount.ActivationStatus.INACTIVE);
        account.setInternationalPayment(CustomerCardAccount.PaymentStatus.DISABLE);
        account.setOnlinePayment(CustomerCardAccount.PaymentStatus.DISABLE);
        account.setPin(4321);
        account.setCardSwipe(CustomerCardAccount.PaymentStatus.DISABLE);
        account.setOnlinePaymentLimit(new BigDecimal("60000.0000"));
        account.setCardSwipeLimit(new BigDecimal("30000.0000"));
        account.setInternationalPaymentLimit(new BigDecimal("20000.0000"));
        account.setCardBalance(new BigDecimal("1000.0000"));
        account.setDueAmount(new BigDecimal("2000.0000"));
        account.setCreditCardLimit(new BigDecimal("150000.0000"));
        account.setDueDate(new Date());
        account.setExpiryDate(new Date());
        account.setCvv("456");
        account.setCreditCard("Gold");

        assertEquals(9876543210L, account.getAccountNumber());
        assertEquals(customerProfile, account.getCustomerProfile());
        assertEquals("USD", account.getBaseCurrency());
        assertEquals(CustomerCardAccount.ActivationStatus.INACTIVE, account.getActivationStatus());
        assertEquals(6543210987654321L, account.getCardNumber());
        assertEquals(CustomerCardAccount.ActivationStatus.INACTIVE, account.getCardStatus());
        assertEquals(CustomerCardAccount.PaymentStatus.DISABLE, account.getInternationalPayment());
        assertEquals(CustomerCardAccount.PaymentStatus.DISABLE, account.getOnlinePayment());
        assertEquals(4321, account.getPin());
        assertEquals(CustomerCardAccount.PaymentStatus.DISABLE, account.getCardSwipe());
        assertEquals(new BigDecimal("60000.0000"), account.getOnlinePaymentLimit());
        assertEquals(new BigDecimal("30000.0000"), account.getCardSwipeLimit());
        assertEquals(new BigDecimal("20000.0000"), account.getInternationalPaymentLimit());
        assertEquals(new BigDecimal("1000.0000"), account.getCardBalance());
        assertEquals(new BigDecimal("2000.0000"), account.getDueAmount());
        assertEquals(new BigDecimal("150000.0000"), account.getCreditCardLimit());
        assertEquals("456", account.getCvv());
        assertEquals("Gold", account.getCreditCard());
    }
}
