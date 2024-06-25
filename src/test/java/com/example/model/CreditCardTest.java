package com.example.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class CreditCardTest {

    @Test
    void testNoArgsConstructor() {
        CreditCard creditCard = new CreditCard();
        assertNotNull(creditCard);
    }

    @Test
    void testAllArgsConstructor() {
        CreditCard creditCard = new CreditCard("GOLD", new BigDecimal("10000.0000"), new BigDecimal("15.00"), new BigDecimal("100.0000"));
        assertEquals("GOLD", creditCard.getCardType());
        assertEquals(new BigDecimal("10000.0000"), creditCard.getMaxLimit());
        assertEquals(new BigDecimal("15.00"), creditCard.getInterest());
        assertEquals(new BigDecimal("100.0000"), creditCard.getAnnualFee());
    }

    @Test
    void testGetAndSetCardType() {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardType("PLATINUM");
        assertEquals("PLATINUM", creditCard.getCardType());
    }

    @Test
    void testGetAndSetMaxLimit() {
        CreditCard creditCard = new CreditCard();
        creditCard.setMaxLimit(new BigDecimal("20000.0000"));
        assertEquals(new BigDecimal("20000.0000"), creditCard.getMaxLimit());
    }

    @Test
    void testGetAndSetInterest() {
        CreditCard creditCard = new CreditCard();
        creditCard.setInterest(new BigDecimal("12.50"));
        assertEquals(new BigDecimal("12.50"), creditCard.getInterest());
    }

    @Test
    void testGetAndSetAnnualFee() {
        CreditCard creditCard = new CreditCard();
        creditCard.setAnnualFee(new BigDecimal("150.0000"));
        assertEquals(new BigDecimal("150.0000"), creditCard.getAnnualFee());
    }

   
}
