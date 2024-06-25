package com.example.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class GuestScheduleCallTest {

    @Test
    void testNoArgsConstructor() {
        GuestScheduleCall guestScheduleCall = new GuestScheduleCall();
        assertNotNull(guestScheduleCall);
    }

    @Test
    void testAllArgsConstructor() {
        GuestProfile guestProfile = new GuestProfile();
        GuestScheduleCall guestScheduleCall = new GuestScheduleCall(1L, guestProfile, "Subject", "Description", "10:00 AM - 11:00 AM", ResolutionStatus.PENDING);

        assertEquals(1L, guestScheduleCall.getScheduleCallId());
        assertEquals(guestProfile, guestScheduleCall.getGuestProfile());
        assertEquals("Subject", guestScheduleCall.getSubject());
        assertEquals("Description", guestScheduleCall.getDescription());
        assertEquals("10:00 AM - 11:00 AM", guestScheduleCall.getTimeSlot());
        assertEquals(ResolutionStatus.PENDING, guestScheduleCall.getStatus());
    }

    @Test
    void testGetAndSetScheduleCallId() {
        GuestScheduleCall guestScheduleCall = new GuestScheduleCall();
        guestScheduleCall.setScheduleCallId(1L);
        assertEquals(1L, guestScheduleCall.getScheduleCallId());
    }

    @Test
    void testGetAndSetGuestProfile() {
        GuestScheduleCall guestScheduleCall = new GuestScheduleCall();
        GuestProfile guestProfile = new GuestProfile();
        guestScheduleCall.setGuestProfile(guestProfile);
        assertEquals(guestProfile, guestScheduleCall.getGuestProfile());
    }

    @Test
    void testGetAndSetSubject() {
        GuestScheduleCall guestScheduleCall = new GuestScheduleCall();
        guestScheduleCall.setSubject("Subject");
        assertEquals("Subject", guestScheduleCall.getSubject());
    }

    @Test
    void testGetAndSetDescription() {
        GuestScheduleCall guestScheduleCall = new GuestScheduleCall();
        guestScheduleCall.setDescription("Description");
        assertEquals("Description", guestScheduleCall.getDescription());
    }

    @Test
    void testGetAndSetTimeSlot() {
        GuestScheduleCall guestScheduleCall = new GuestScheduleCall();
        guestScheduleCall.setTimeSlot("10:00 AM - 11:00 AM");
        assertEquals("10:00 AM - 11:00 AM", guestScheduleCall.getTimeSlot());
    }

    @Test
    void testGetAndSetStatus() {
        GuestScheduleCall guestScheduleCall = new GuestScheduleCall();
        guestScheduleCall.setStatus(ResolutionStatus.PENDING);
        assertEquals(ResolutionStatus.PENDING, guestScheduleCall.getStatus());
    }

}

