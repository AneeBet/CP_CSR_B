package com.example.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerScheduleCallTest {

    @Test
    void testNoArgsConstructor() {
        CustomerScheduleCall call = new CustomerScheduleCall();
        assertNotNull(call);
    }

    @Test
    void testAllArgsConstructor() {
        CustomerCardAccount account = new CustomerCardAccount();
        CustomerScheduleCall call = new CustomerScheduleCall(
            1L, account, "Subject", "Description", "10:00 AM - 11:00 AM", ResolutionStatus.PENDING
        );

        assertEquals(1L, call.getScheduleCallId());
        assertEquals(account, call.getCustomerCardAccount());
        assertEquals("Subject", call.getSubject());
        assertEquals("Description", call.getDescription());
        assertEquals("10:00 AM - 11:00 AM", call.getTimeSlot());
        assertEquals(ResolutionStatus.PENDING, call.getStatus());
    }

    @Test
    void testGetAndSetScheduleCallId() {
        CustomerScheduleCall call = new CustomerScheduleCall();
        call.setScheduleCallId(1L);
        assertEquals(1L, call.getScheduleCallId());
    }

    @Test
    void testGetAndSetCustomerCardAccount() {
        CustomerScheduleCall call = new CustomerScheduleCall();
        CustomerCardAccount account = new CustomerCardAccount();
        call.setCustomerCardAccount(account);
        assertEquals(account, call.getCustomerCardAccount());
    }

    @Test
    void testGetAndSetSubject() {
        CustomerScheduleCall call = new CustomerScheduleCall();
        call.setSubject("Subject");
        assertEquals("Subject", call.getSubject());
    }

    @Test
    void testGetAndSetDescription() {
        CustomerScheduleCall call = new CustomerScheduleCall();
        call.setDescription("Description");
        assertEquals("Description", call.getDescription());
    }

    @Test
    void testGetAndSetTimeSlot() {
        CustomerScheduleCall call = new CustomerScheduleCall();
        call.setTimeSlot("10:00 AM - 11:00 AM");
        assertEquals("10:00 AM - 11:00 AM", call.getTimeSlot());
    }

    @Test
    void testGetAndSetStatus() {
        CustomerScheduleCall call = new CustomerScheduleCall();
        call.setStatus(ResolutionStatus.PENDING);
        assertEquals(ResolutionStatus.PENDING, call.getStatus());
    }


}
