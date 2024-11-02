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
        
        //Arrays to store task details
        String [] developers = new String [numOfTasks];
        String[] taskNames = new String[numOfTasks];
        String[] taskIDs = new String[numOfTasks];
        double[] taskDurations = new double[numOfTasks];
        String[] taskStatuses = new String[numOfTasks];
    
        Task[] tasks = new Task[numOfTasks];
        int totalHours = 0;
        int taskCount = 0;
        
        

        while (true) {
            String menu = "Menu:\n1) Add Task\n2) Show Report\n3)Display Done Tasks\n4) Longest Task Duration\n5) Search Task by Name\n6) Search Tasks by Developer\n7) Delete Task\n8) Quit\nChoose an option:";
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
                        
                        //Store task details in arrays
                    developers[taskCount] = developerDetails;
                    taskNames[taskCount] = taskName;
                    taskIDs[taskCount] = newTask.createTaskID();
                    taskDurations[taskCount] = taskDuration;
                    taskStatuses[taskCount] = taskStatus;
                    
                        totalHours += newTask.returnTotalHours();
                        taskCount++;
                        //display task details
                        JOptionPane.showMessageDialog(null, newTask.printTaskDetails());
                        JOptionPane.showMessageDialog(null, "Task successfully captured.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Maximum number of tasks reached.");                       
                    }
                    break;
                case 2: // Display full report of all tasks
                String taskSummary = "Task Summary: \n\n";
                for (int i = 0; i < taskCount; i++) {
                    taskSummary += tasks[i].printTaskDetails() + "\n\n";
                }
                JOptionPane.showMessageDialog(null, taskSummary, "Task Summary", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Total hours worked on tasks: " + totalHours);
                break;

            case 3:// Display done tasks
                 StringBuilder doneTasks = new StringBuilder("Done Tasks:\n");
                for (int i = 0; i < taskCount; i++) {
                    if (taskStatuses[i].equals("Done")) {
                        doneTasks.append("Developer: ").append(developers[i])
                                  .append(", Task Name: ").append(taskNames[i])
                                                         .append(", Duration: ").append(taskDurations[i]).append(" hours\n");
                    }
                }
                JOptionPane.showMessageDialog(null, doneTasks.toString(), "Done Tasks", JOptionPane.INFORMATION_MESSAGE);
                break;


            case 4: // Display longest task duration
                 double maxDuration = 0;
                String longestTaskDeveloper = "";
                String longestTaskName = "";
                for (int i = 0; i < taskCount; i++) {
                    if (taskDurations[i] > maxDuration) {
                        maxDuration = taskDurations[i];
                        longestTaskDeveloper = developers[i];
                        longestTaskName = taskNames[i];
                    }
                }
                JOptionPane.showMessageDialog(null, "Longest Task:\nDeveloper: " + longestTaskDeveloper + "\nTask Name: " + longestTaskName + "\nDuration: " + maxDuration + " hours", "Longest Task", JOptionPane.INFORMATION_MESSAGE);
                break;
                
               
            case 5: // display search task by name
                 String searchTaskName = JOptionPane.showInputDialog("Enter the task name to search:");
                boolean taskFound = false;
                for (int i = 0; i < taskCount; i++) {
                    if (taskNames[i].equalsIgnoreCase(searchTaskName)) {
                        JOptionPane.showMessageDialog(null, "Task Name: " + taskNames[i] + "\nDeveloper: " + developers[i] + "\nStatus: " + taskStatuses[i], "Task Found", JOptionPane.INFORMATION_MESSAGE);
                        taskFound = true;
                        break;
                    }
                }
                if (!taskFound) {
                    JOptionPane.showMessageDialog(null, "Task not found.", "Search Result", JOptionPane.WARNING_MESSAGE);
                }
                break;

               

            case 6: // display search task by developer
                
                 String searchDeveloper = JOptionPane.showInputDialog("Enter the developer name to search:");
                StringBuilder developerTasks = new StringBuilder("Tasks for Developer: " + searchDeveloper + "\n");
                boolean developerFound = false;
                for (int i = 0; i < taskCount; i++) {
                    if (developers[i].equalsIgnoreCase(searchDeveloper)) {
                        developerTasks.append("Task Name: ").append(taskNames[i]).append(", Status: ").append(taskStatuses[i]).append("\n");
                        developerFound = true;
                    }
                }
                if (developerFound) {
                    JOptionPane.showMessageDialog(null, developerTasks.toString(), "Tasks by Developer", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No tasks found for this developer.", "Search Result", JOptionPane.WARNING_MESSAGE);
                }
                break;
                
               
            case 7: // Delete task
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
                        
               

            case 8: // exit application
                JOptionPane.showMessageDialog(null, "Exiting application. Goodbye!");
                return;
                
               
                

            default:
                JOptionPane.showMessageDialog(null, "Invalid option. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }}}}
    
   
                    
       
      

    

      


