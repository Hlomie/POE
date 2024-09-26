/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poep1;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author RC_Student_lab
 */
public class POEp1 {

    public static void main(String[] args) {
        
        //Declarations of variables and initializing
        String username;
        String password;
        
 // Create a Scanner to read the outputs
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter their username
        System.out.print("Enter your Username:");
        username = input.nextLine();

        // Regex: define the pattern for validation
        Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z0-9])[a-zA-Z0-9_]+$");
        Matcher matcher = pattern.matcher(username);

        // Check if the user name contains an underscore and is no more than 5 characters in length
        if (username.contains("_") && matcher.matches()) {
            System.out.println("Username is successfully captured");
        } else {
            System.out.println("Username is not correctly formatted, please ensure that the username contains an underscore and is no more than 5 characters in length");
        }

        // Prompt the user to enter their password
        System.out.print("Enter your Password: ");
        password = input.nextLine();

        // Validate password
        if (password.length() > 7) {
            if (checkPass(password)) {
                System.out.println("Password successfully captured");
            } else {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            }
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
        }

        // Boolean for username and password validation
        if (IsUsernameAndPasswordCorrect(username, password)) {
            System.out.println("Welcome <user first name>, <user last name> it is great to see you!");
        } else {
            System.out.println("Username or password is incorrect, please try again.");
        }
    }

    // Check password
    public static boolean checkPass(String password) {
        boolean hasNum = false;
        boolean hasCap = false;
        boolean hasLow = false;
        boolean hasSpecial = false;
        char c;

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

        return hasNum && hasCap && hasLow && hasSpecial;
    }

    // Method to check if both username and password are correct
    public static boolean IsUsernameAndPasswordCorrect(String username, String password) {
  
        boolean isUsernameValid = username.contains("_") && username.length() <= 5;
        boolean isPasswordValid = checkPass(password);

        // Return true if both username and password are valid
        return isUsernameValid && isPasswordValid;
    }
}