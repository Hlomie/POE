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
    
    // Arrays to store task details
    String[] developers = new String[numOfTasks];
    String[] taskNames = new String[numOfTasks];
    String[] taskIDs = new String[numOfTasks];
    double[] taskDurations = new double[numOfTasks];
    String[] taskStatuses = new String[numOfTasks];
    
    Task[] tasks = new Task[numOfTasks];
    int totalHours = 0;
    int taskCount = 0;

    // Loop to enter tasks
    while (taskCount < numOfTasks) {
        String taskName = JOptionPane.showInputDialog("Enter task name:");
        String taskDescription = JOptionPane.showInputDialog("Enter task description:");
        
        // Check description length
        if (taskDescription.length() > 50) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
            continue; // Skip to the next iteration
        }
        
        String developerDetails = JOptionPane.showInputDialog("Enter developer details:");
        String taskDurationStr = JOptionPane.showInputDialog("Enter task duration (in hours):");
        double taskDuration = Double.parseDouble(taskDurationStr);
        
        String statusOptionStr = JOptionPane.showInputDialog("Select Task Status:\n1) To Do\n2) Doing\n3) Done");
        String taskStatus;
        
        // Assign task status based on user input
        switch (Integer.parseInt(statusOptionStr)) {
            case 1: taskStatus = "To Do"; break;
            case 2: taskStatus = "Doing"; break;
            case 3: taskStatus = "Done"; break;
            default: taskStatus = "To Do"; break;
        }

        // Create and store the new task
        Task newTask = new Task(taskName, taskDescription, developerDetails, taskDuration, taskCount, taskStatus);
        tasks[taskCount] = newTask;

        // Store task details in arrays
        developers[taskCount] = developerDetails;
        taskNames[taskCount] = taskName;
        taskIDs[taskCount] = newTask.createTaskID();
        taskDurations[taskCount] = taskDuration;
        taskStatuses[taskCount] = taskStatus;

        totalHours += newTask.returnTotalHours();
        taskCount++;
        
        // Display task details
        JOptionPane.showMessageDialog(null, newTask.printTaskDetails());
        JOptionPane.showMessageDialog(null, "Task successfully captured.");
    }

    // Menu for managing tasks
    while (true) {
        String menu = "Menu:\n1) Show Report\n2) Display Done Tasks\n3) Longest Task Duration\n4) Search Task by Name\n5) Search Tasks by Developer\n6) Delete Task\n7) Quit\nChoose an option:";
        String optionStr = JOptionPane.showInputDialog(menu);
        int option = Integer.parseInt(optionStr);
        
        switch (option) {
            case 1: // Display full report of all tasks
                StringBuilder taskSummary = new StringBuilder("Task Summary: \n\n");
                for (int i = 0; i < taskCount; i++) {
                    taskSummary.append(tasks[i].printTaskDetails()).append("\n\n");
                }
                JOptionPane.showMessageDialog(null, taskSummary.toString(), "Task Summary", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Total hours worked on tasks: " + totalHours);
                break;

           case 2: // Display tasks that are marked as "Done"
    StringBuilder doneTasks = new StringBuilder("Tasks marked as 'Done':\n\n");
    boolean hasDoneTasks = false; 

    for (int i = 0; i < taskCount; i++) {
        Object taskStatus = tasks[i].getTaskStatus(); 
        if (taskStatus != null && taskStatus.equals("Done")) {
            doneTasks.append(tasks[i].printTaskDetails()).append("\n\n");
            hasDoneTasks = true; 
        }
    }

    if (!hasDoneTasks) {
        doneTasks.append("No tasks are marked as 'Done'.");
    }

    // Display the message to the user
    JOptionPane.showMessageDialog(null, doneTasks.toString(), "Done Tasks", JOptionPane.INFORMATION_MESSAGE);
    
    
    int continueOption = JOptionPane.showConfirmDialog(null, "Would you like to return to the main menu?", "Continue", JOptionPane.YES_NO_OPTION);
    if (continueOption == JOptionPane.NO_OPTION) {
        System.exit(0); 
    }
    break;
    

            case 3: // Find the longest task duration
                double longestDuration = 0;
                                String longestTaskName = "";
                for (int i = 0; i < taskCount; i++) {
                    if (taskDurations[i] > longestDuration) {
                        longestDuration = taskDurations[i];
                        longestTaskName = taskNames[i];
                    }
                }
                JOptionPane.showMessageDialog(null, "The longest task is: " + longestTaskName + " with a duration of " + longestDuration + " hours.");
                break;

            case 4: // Search task by name
                String searchName = JOptionPane.showInputDialog("Enter the task name to search:");
                StringBuilder searchResults = new StringBuilder("Search Results: \n\n");
                boolean found = false;
                for (int i = 0; i < taskCount; i++) {
                    if (taskNames[i].equalsIgnoreCase(searchName)) {
                        searchResults.append(tasks[i].printTaskDetails()).append("\n\n");
                        found = true;
                    }
                }
                if (!found) {
                    searchResults.append("No tasks found with the name: ").append(searchName);
                }
                JOptionPane.showMessageDialog(null, searchResults.toString(), "Search Results", JOptionPane.INFORMATION_MESSAGE);
                break;

            case 5: // Search tasks by developer
                String searchDeveloper = JOptionPane.showInputDialog("Enter the developer's name to search:");
                StringBuilder developerResults = new StringBuilder("Tasks for Developer: \n\n");
                found = false;
                for (int i = 0; i < taskCount; i++) {
                    if (developers[i].equalsIgnoreCase(searchDeveloper)) {
                        developerResults.append(tasks[i].printTaskDetails()).append("\n\n");
                        found = true;
                    }
                }
                if (!found) {
                    developerResults.append("No tasks found for developer: ").append(searchDeveloper);
                }
                JOptionPane.showMessageDialog(null, developerResults.toString(), "Developer Search Results", JOptionPane.INFORMATION_MESSAGE);
                break;

            case 6: // Delete a task
            
          String deleteTaskName = JOptionPane.showInputDialog("Enter the task name to delete:");
         boolean taskDeleted = false;
         for (int i = 0; i < taskCount; i++) {
             if (taskNames[i].equalsIgnoreCase(deleteTaskName)) {
                 // Shift tasks down in the array
                 for (int j = i; j < taskCount - 1; j++) {
                     tasks[j] = tasks[j + 1];
                     developers[j] = developers[j + 1];
                     taskNames[j] = taskNames[j + 1];
                     taskIDs[j] = taskIDs[j + 1];
                     taskDurations[j] = taskDurations[j + 1];
                     taskStatuses[j] = taskStatuses[j + 1];
                 }
                 taskCount--; // Reduce task count
                 taskDeleted = true;
                 JOptionPane.showMessageDialog(null, "Task '" + deleteTaskName + "' has been deleted.", "Task Deleted", JOptionPane.INFORMATION_MESSAGE);
                 
             }
         }
         if (!taskDeleted) {
             JOptionPane.showMessageDialog(null, "Task not found.", "Delete Result", JOptionPane.WARNING_MESSAGE);
         }
                 break;

            case 7: // Exit application
                JOptionPane.showMessageDialog(null, "Exiting application. Goodbye!");
                return; // Exit the method and thus the application

            default:
                JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                break;
        }
    }
   }}
                        