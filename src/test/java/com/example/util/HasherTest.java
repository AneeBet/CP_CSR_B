package com.example.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HasherTest {

    @Test
    public void testHashPassword() {
        String password = "mySecurePassword";
        String hashedPassword = Hasher.hashPassword(password);
        
        // Verify that the hashed password is not null
        assertNotNull(hashedPassword);
        
        // Verify that the hashed password has the expected length for SHA-256 (64 hex characters)
        assertEquals(64, hashedPassword.length());
        
        // Verify that the same password produces the same hash
        String hashedPasswordAgain = Hasher.hashPassword(password);
        assertEquals(hashedPassword, hashedPasswordAgain);
        
        // Verify that different passwords produce different hashes
        String differentPassword = "anotherPassword";
        String hashedDifferentPassword = Hasher.hashPassword(differentPassword);
        assertNotEquals(hashedPassword, hashedDifferentPassword);
    }

   
}
