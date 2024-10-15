/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poep1;

/**
 *
 * @author RC_Student_lab
 */
public class accountLogin {

    private String storedUsername;
    private String storedFirstname;
    private String storedLastname;
    private String storedPassword;

    // Constructor for the class
    public accountLogin() {
    }

    // Method 1: Boolean checkUserName
    public boolean checkUserName(String username) {
        // Ensure username contains an underscore and is no more than 5 characters
        if(username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }
    // Method 2: Boolean checkPasswordComplexity
    public boolean checkPasswordComplexity(String password) {
        // Ensure password is at least 8 characters, contains uppercase, number, and special character
        boolean hasNum = false;
        boolean hasCap = false;
        boolean hasLow = false;
        boolean hasSpecial = false;
        char c;

        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                c = password.charAt(i);
                if (Character.isDigit(c)) {
                    hasNum = true;
                } else if (Character.isUpperCase(c)) {
                    hasCap = true;
                } else if (Character.isLowerCase(c)) {
                   hasLow = true;
                } else if ("!@#$%^&*()_+[]{}|;:,.<>?".indexOf(c) >= 0) {
                    hasSpecial = true;
                }
            }
        }

        return hasNum && hasCap && hasLow && hasSpecial;
    }

    // Method 3: String registerUser 
    public String registerUser (String username, String firstname, String lastname, String password) {
        // Register user 
        if (!checkUserName(username)) {
            return "Username is incorrectly formatted. It must contain an underscore and be no more than 5 characters.";
        } else if (!checkPasswordComplexity(password)) {
            return "Password does not meet complexity requirements. It must be at least 8 characters long, contain a capital letter, a number, and a special character.";
        } else {  
            this.storedUsername = username;
            this.storedFirstname = firstname;
            this.storedLastname = lastname;
            this.storedPassword = password;
            return "User  has been registered successfully!";
        }
    }

    // Method 4: Boolean loginUser
    public boolean loginUser(String username, String password) {
        // Verify that login details
        return username.equals(this.storedUsername) && password.equals(this.storedPassword);
    }
}