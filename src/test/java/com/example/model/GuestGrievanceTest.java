package com.example.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

class GuestGrievanceTest {

    @Test
    void testNoArgsConstructor() {
        GuestGrievance guestGrievance = new GuestGrievance();
        assertNotNull(guestGrievance);
    }

    @Test
    void testAllArgsConstructor() {
        Date timestamp = new Date();
        GuestProfile guestProfile = new GuestProfile();
        GuestGrievance guestGrievance = new GuestGrievance(1L, guestProfile, "subject", "description", timestamp, ResolutionStatus.PENDING);

        assertEquals(1L, guestGrievance.getGrievanceId());
        assertEquals(guestProfile, guestGrievance.getGuestProfile());
        assertEquals("subject", guestGrievance.getSubject());
        assertEquals("description", guestGrievance.getDescription());
        assertEquals(timestamp, guestGrievance.getTimestamp());
        assertEquals(ResolutionStatus.PENDING, guestGrievance.getStatus());
    }

    @Test
    void testGetAndSetGrievanceId() {
        GuestGrievance guestGrievance = new GuestGrievance();
        guestGrievance.setGrievanceId(1L);
        assertEquals(1L, guestGrievance.getGrievanceId());
    }

    @Test
    void testGetAndSetGuestProfile() {
        GuestGrievance guestGrievance = new GuestGrievance();
        GuestProfile guestProfile = new GuestProfile();
        guestGrievance.setGuestProfile(guestProfile);
        assertEquals(guestProfile, guestGrievance.getGuestProfile());
    }

    @Test
    void testGetAndSetSubject() {
        GuestGrievance guestGrievance = new GuestGrievance();
        guestGrievance.setSubject("subject");
        assertEquals("subject", guestGrievance.getSubject());
    }

    @Test
    void testGetAndSetDescription() {
        GuestGrievance guestGrievance = new GuestGrievance();
        guestGrievance.setDescription("description");
        assertEquals("description", guestGrievance.getDescription());
    }

    @Test
    void testGetAndSetTimestamp() {
        GuestGrievance guestGrievance = new GuestGrievance();
        Date timestamp = new Date();
        guestGrievance.setTimestamp(timestamp);
        assertEquals(timestamp, guestGrievance.getTimestamp());
    }

    @Test
    void testGetAndSetStatus() {
        GuestGrievance guestGrievance = new GuestGrievance();
        guestGrievance.setStatus(ResolutionStatus.PENDING);
        assertEquals(ResolutionStatus.PENDING, guestGrievance.getStatus());
    }


}
