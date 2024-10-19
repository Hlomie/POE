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

    public accountLogin() {
        
    }
    //Method 1: Boolean checkUserName 
    public boolean checkUserName(String username) {
        //Ensure that the username contains underscore and is no more than 5 characters
        
        return username.contains("_") && username.length() <= 5;
    }
    //Method 2: Boolean checkPasswordComplexity
    public boolean checkPasswordComplexity(String password) {
        //Ensure that boolean has atleast 8 characters, contains uppercase, lowercase, number and a special character
        boolean hasNum = false, hasCap = false, hasLow = false, hasSpecial = false;

        if (password.length() >= 8) {
            for (char c : password.toCharArray()) {
                if (Character.isDigit(c)) hasNum = true;
                else if (Character.isUpperCase(c)) hasCap = true;
                else if (Character.isLowerCase(c)) hasLow = true;
                else if ("!@#$%^&*()_+[]{}|;:,.<>?".indexOf(c) >= 0) hasSpecial = true;
            }
        }
        return hasNum && hasCap && hasLow && hasSpecial;
    }
    //Method 3: String registerUser
    public String registerUser (String username, String firstname, String lastname, String password) {
        //Register user
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
    //Method 4: Boolean LoginUser
    public boolean loginUser (String username, String password) {
        //verify login details
        return username.equals(this.storedUsername) && password.equals(this.storedPassword);
    }
}