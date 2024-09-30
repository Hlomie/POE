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

    // Test that the checkUserName method returns true when the username is correct
    @Test
    public void testCheckUserNameCorrect() {
        accountLogin login = new accountLogin();
        assertTrue(login.checkUserName("kyl_1"));
    }

    // Test that the checkUserName method returns false when the username is incorrect
    @Test
    public void testCheckUserNameIncorrect() {
        accountLogin login = new accountLogin();
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    // Test that the checkPasswordComplexity method returns true when the password is correct
    @Test
    public void testCheckPasswordComplexityCorrect() {
        accountLogin login = new accountLogin();
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    // Test that the checkPasswordComplexity method returns false when the password is incorrect
    @Test
    public void testCheckPasswordComplexityIncorrect() {
        accountLogin login = new accountLogin();
        assertFalse(login.checkPasswordComplexity("password"));
    }

    // Test that the registerUser method returns the expected message when the username and password are correct
    @Test
    public void testRegisterUserSuccess() {
        accountLogin login = new accountLogin();
        assertEquals("User has been registered successfully!", login.registerUser("kyl_1", "Ch&&sec@ke99!"));
    }

    // Test that the registerUser method returns the expected message when the username is incorrect
    @Test
    public void testRegisterUserUsernameIncorrect() {
        accountLogin login = new accountLogin();
        assertEquals("Username is incorrectly formatted. It must contain an underscore and be no more than 5 characters.", login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!"));
    }

    // Test that the registerUser method returns the expected message when the password is incorrect
    @Test
    public void testRegisterUserPasswordIncorrect() {
        accountLogin login = new accountLogin();
        assertEquals("Password does not meet complexity requirements. It must be at least 8 characters long, contain a capital letter, a number, and a special character.", login.registerUser("kyl_1", "password"));
    }

    // Test that the loginUser method returns true when the username and password are correct
    @Test
    public void testLoginUserSuccess() {
        accountLogin login = new accountLogin();
        login.registerUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    // Test that the loginUser method returns false when the username or password is incorrect
    @Test
    public void testLoginUserFailure() {
        accountLogin login = new accountLogin();
        login.registerUser("kyl_1", "Ch&&sec@ke99!");
        assertFalse(login.loginUser("kyle", "password"));
    }

    // Test that the returnLoginStatus method returns the expected message when the login is successful
    @Test
    public void testReturnLoginStatusSuccess() {
        accountLogin login = new accountLogin();
        login.registerUser("kyl_1", "Ch&&sec@ke99!");
        assertEquals("Login successful. Welcome!", login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!"));
    }

    // Test that the returnLoginStatus method returns the expected message when the login fails
    @Test
    public void testReturnLoginStatusFailure() {
        accountLogin login = new accountLogin();
        login.registerUser("kyl_1", "Ch&&sec@ke99!");
        assertEquals("Login failed. Incorrect username or password.", login.returnLoginStatus("kyle", "password"));
    }
}

   

    


