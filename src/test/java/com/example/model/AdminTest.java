package com.example.model;



import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AdminTest {

    @Test
    public void testAdminGettersAndSetters() {
        // Arrange
        String username = "adminUser";
        String password = "securePass123";
        Admin admin = new Admin();

        // Act
        admin.setUsername(username);
        admin.setPassword(password);

        // Assert
        assertEquals(username, admin.getUsername(), "Username should match the one set.");
        assertEquals(password, admin.getPassword(), "Password should match the one set.");
    }

    @Test
    public void testAdminConstructor() {
        // Arrange
        String username = "newAdmin";
        String password = "newPass123";

        // Act
        Admin admin = new Admin(username, password);

        // Assert
        assertEquals(username, admin.getUsername(), "Username should match the one provided in constructor.");
        assertEquals(password, admin.getPassword(), "Password should match the one provided in constructor.");
    }
}

