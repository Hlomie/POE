/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poep1;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class POEp1 {

    public static void main(String[] args) {
        // Create a Scanner to read the outputs
        Scanner input = new Scanner(System.in);
        accountLogin login = new accountLogin();

        // Prompt the user to enter their username
        System.out.print("Enter your Username: ");
        String username = input.nextLine();

        System.out.print("Enter your Firstname: ");
        String firstname = input.nextLine();

        System.out.print("Enter your Lastname: ");
        String lastname = input.nextLine();

        // Prompt the user to enter their password
        System.out.print("Enter your Password: ");
        String password = input.nextLine();

        // Register user
        String registrationMessage = login.registerUser (username, firstname, lastname, password);
        System.out.println(registrationMessage);

        // After registration, check login status (for demonstration)
        if (registrationMessage.equals("User  has been registered successfully!")) {
            // Prompt for login
            System.out.print("Please log in with your Username: ");
            String loginUsername = input.nextLine();
            System.out.print("Please log in with your Password: ");
            String loginPassword = input.nextLine();

            // Check login status
            if (login.loginUser (loginUsername, loginPassword)) {
                System.out.println("Welcome " + firstname + " " + lastname + ", it is great to see you!");
            } else {
                System.out.println("Username or password is incorrect, please try again.");
            }
        }

        
    }
}