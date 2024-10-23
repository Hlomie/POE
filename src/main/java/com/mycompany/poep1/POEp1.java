/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
    
package com.mycompany.poep1;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.*;


/**
 *
 * @author RC_Student_lab
 */
public class POEp1 {

    public static void main(String[] args) {
        //create scanner to read outputs
      Scanner input = new Scanner(System.in);
       
        
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);

        System.out.print("Enter your Firstname: ");
        String firstname = input.nextLine();

        System.out.print("Enter your Lastname: ");
        String lastname = input.nextLine();
        
          System.out.print("Enter your Username: ");
        String username = input.nextLine();

        System.out.print("Enter your Password: ");
        String password = input.nextLine();
        accountLogin login = new accountLogin(username, firstname, lastname, password);
        //register user
         String registrationMessage = login.registerUser(username, firstname, lastname, password);
        System.out.println(registrationMessage);
        
        // Check login status if registration was successful
            //prompt for login
            System.out.print("Please login with your Username: ");
            String loginUsername = input.nextLine();
            System.out.print("Please login with your Password: ");
            String loginPassword = input.nextLine();
            login.loginUser (loginUsername, loginPassword) ;
            
            
            //Check login status
        if (login.loginUser (loginUsername, loginPassword)) {
        JOptionPane.showMessageDialog(dialog, "Welcome to EasyKanban, " + firstname + " " + lastname + "!");
        manageTasks(); // Call the manageTasks method
        } else {
        JOptionPane.showMessageDialog(dialog, "Login failed. Please check your credentials.");
    }
        
        dialog.dispose();
    }
    
    // Method to manage tasks
    private static void manageTasks() {
        String numTasksStr = JOptionPane.showInputDialog("How many tasks would you like to enter?");
        int numOfTasks = Integer.parseInt(numTasksStr);
        Task[] tasks = new Task[numOfTasks];
        int totalHours = 0;
        int taskCount = 0;

        while (true) {
            String menu = "Menu:\n1) Add Task\n2) Show Report\n3) Quit\nChoose an option:";
            String optionStr = JOptionPane.showInputDialog(menu);
            int option = Integer.parseInt(optionStr);
            
            switch (option) {
                case 1:
                    if (taskCount < numOfTasks) {
                        String taskName = JOptionPane.showInputDialog("Enter task name:");
                        String taskDescription = JOptionPane.showInputDialog("Enter task description:");
                        
                        //check description length
                        if (taskDescription.length() > 50) {
                            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                            continue;
                        }
                        String developerDetails = JOptionPane.showInputDialog("Enter developer details:");
                        String taskDurationStr = JOptionPane.showInputDialog("Enter task duration (in hours):");
                        double taskDuration = Double.parseDouble(taskDurationStr);
                        String statusOptionStr = JOptionPane.showInputDialog("Select Task Status:\n1) To Do\n2) Doing\n3) Done");
                 int statusOption = Integer.parseInt(statusOptionStr);
                    

                        String taskStatus;
                        
                        // Assign task status based on user input
                        switch (Integer.parseInt(statusOptionStr)) {
                            case 1: 
                                taskStatus = "To Do"; 
                                break;
                            case 2: 
                                taskStatus = "Doing"; 
                                break;
                            case 3: 
                                taskStatus = "Done"; 
                                break;
                            default: 
                                taskStatus = "To Do"; 
                                break;
                        }

                        // Create and store the new task
                        Task newTask = new Task(taskName, taskDescription, developerDetails, taskDuration, taskCount, taskStatus);
                        tasks[taskCount] = newTask;
                        totalHours += newTask.returnTotalHours();
                        taskCount++;
                        //display task details
                        JOptionPane.showMessageDialog(null, newTask.printTaskDetails());
                        JOptionPane.showMessageDialog(null, "Task successfully captured.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Maximum number of tasks reached.");
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Coming soon");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Exiting application. Goodbye!");
                    return; // Exit the method and end the application
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                    break;
            }
        }
                
        // Display total hours
      
 }


    }

      


