/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.poep1;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author RC_Student_lab
 */

public class accountLoginTest {

  @Test
    public void testCheckUserNameCorrect() {
        accountLogin login = new accountLogin("John", "Doe", "kyl_1", "Ch&&sec@ke99!");
        String result = login.registerUser ("kyl_1", "John", "Doe", "Ch&&sec@ke99!");
        assertEquals("User   has been registered successfully!", result);
        
        // Simulate login and check return message
        assertEquals("welcomeJohn,Doe it is great to see you.", login.loginUser ("kyl_1", "Ch&&sec@ke99!"));
        assertTrue(login.loginUser  ("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckUserNameIncorrect() {
        accountLogin login = new accountLogin("John", "Doe", "kyl_1", "Ch&&sec@ke99!");
        String result = login.registerUser ("kyle!!!!!", "John", "Doe", "Ch&&sec@ke99!");
        assertEquals("Username is incorrectly formatted. It must contain an underscore and be no more than 5 characters.", result);
        
        // Simulate login and check return message
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", login.loginUser ("kyle!!!!!", "Ch&&sec@ke99!"));
        assertFalse(login.loginUser  ("kyle!!!!!", "Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexityCorrect() {
        accountLogin login = new accountLogin("John", "Doe", "kyl_1", "Ch&&sec@ke99!");
        String result = login.registerUser ("kyl_1", "John", "Doe", "Ch&&sec@ke99!");
        assertEquals("User   has been registered successfully!", result);
        
        // Simulate login and check return message
        assertEquals("Password successfully captured.", login.loginUser  ("kyl_1", "Ch&&sec@ke99!"));
        assertTrue(login.loginUser ("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexityIncorrect() {
        accountLogin login = new accountLogin("John", "Doe", "kyl_1", "Ch&&sec@ke99!");
        String result = login.registerUser ("kyl_1", "John", "Doe", "password");
        assertEquals("Password does not meet complexity requirements. It must be at least 8 characters long, contain a capital letter, a number, and a special character.", result);
        
        // Simulate login and check return message
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", login.loginUser  ("kyl_1", "password"));
        assertFalse(login.loginUser ("kyl_1", "password"));
    }
}