/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poep1;
import java.util.Scanner;
import javax.swing.JOptionPane;



/**
 *
 * @author RC_Student_lab
 */
public class POEp1 {

    public static void main(String[] args) {
        //create scanner to read outputs
      Scanner input = new Scanner(System.in);
        accountLogin login = new accountLogin();
         System.out.print("Enter your Username: ");
        String username = input.nextLine();

        System.out.print("Enter your Firstname: ");
        String firstname = input.nextLine();

        System.out.print("Enter your Lastname: ");
        String lastname = input.nextLine();

        System.out.print("Enter your Password: ");
        String password = input.nextLine();
        
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
            if (login.loginUser(loginUsername, loginPassword)) {
            System.out.println("Welcome to EasyKanban, " + firstname + " " + lastname + "!");

           //Manage Task
           manageTasks(input);
            }else{
                System.out.println("Login failed. Exiting application.");
            }
            input.close();
    }
    
        private static void manageTasks(Scanner input){
            //Ask user how many tasks they would like to enter
            System.out.print("How many tasks would you like to enter? ");
            int numOfTasks = input.nextInt();
            input.nextLine();
            Task[] tasks = new Task[numOfTasks];
            int totalHours = 0;
            int taskCount = 0;
            
            while (true) {
            System.out.println("Menu:");
            System.out.println("1) Add Task");
            System.out.println("2) Show Report (Coming soon)");
            System.out.println("3) Quit");
            System.out.print("Choose an option: ");
            int option = input.nextInt();
            input.nextLine(); 

            if (option == 1) {
                if (taskCount < numOfTasks) {
                    System.out.print("Enter task name: ");
                    String taskName = input.nextLine();
                    System.out.print("Enter task description: ");
                    String taskDescription = input.nextLine();
                    
                    // Check task description length
                    if (taskDescription.length() > 50) {
                        System.out.println("Please enter a task description of less than 50 characters.");
                        continue; 
                    }
                    
                    System.out.print("Enter developer details: ");
                    String developerDetails = input.nextLine();
                    System.out.print("Enter task duration (in hours): ");
                    double taskDuration = input.nextDouble();
                    input.nextLine(); 
                    
                    // Select task status
                System.out.println("Select Task Status:");
                System.out.println("1) To Do");
                System.out.println("2) Doing");
                System.out.println("3) Done");
                String taskStatus = "";
                int statusOption = input.nextInt();
                input.nextLine(); // Consume newline
                switch (statusOption) {
                    case 1: taskStatus = "To Do"; break;
                    case 2: taskStatus = "Doing"; break;
                    case 3: taskStatus = "Done"; break;
                    default: System.out.println("Invalid status. Defaulting to 'To Do'."); taskStatus = "To Do"; break;
                }
                

                     // Create a new Task object
                    Task newTask = new Task(taskName, taskDescription, developerDetails, taskDuration, taskCount);
                    tasks[taskCount] = newTask; // Store the task in the array
                    totalHours += newTask.returnTotalHours(); // Accumulate total hours
                    taskCount++; // Increment task count

                    // Display task details
                    JOptionPane.showMessageDialog(null, newTask.printTaskDetails());
                    System.out.println("Task successfully captured.");
                } else {
                    System.out.println("Maximum number of tasks reached.");
                }
            } else if (option == 2) {
                System.out.println("Coming soon");
            } else if (option == 3) {
                System.out.println("Exiting application. Goodbye!");
                break; // Exit the loop
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        
        // Display total hours
        System.out.println("Total hours across all tasks: " + totalHours);
            
            //Loop to gather task details
             for (int i = 0; i < numOfTasks; i++) {
            System.out.print("Enter task name for task " + (i + 1) + ": ");
            String taskName = input.nextLine();
            System.out.print("Enter task description for task " + (i + 1) + ": ");
            String taskDescription = input.nextLine();
            System.out.print("Enter developer details for task " + (i + 1) + ": ");
            String developerDetails = input.nextLine();
            System.out.print("Enter task duration (in hours) for task " + (i + 1) + ": ");
            double taskDuration = input.nextDouble();
            input.nextLine(); 
            int taskNumber = i + 1; 

            // Create a new Task object
            Task newTask = new Task(taskName, taskDescription, developerDetails, taskDuration, taskNumber);

            // Check if the task description is valid before adding
            if (newTask.checkTaskDescription()) {
                tasks[i] = newTask; // Store the task in the array
            } else {
                System.out.println("Task description must be 50 characters or less. Task not added.");
                i--; 
            }
        }
             // Display all tasks
        StringBuilder taskDetails = new StringBuilder("Tasks Entered:\n");
        for (Task task : tasks) {
            if (task != null) { // Check for null to avoid NullPointerException
                taskDetails.append(task.printTaskDetails()).append("\n\n");
            }
        }

        JOptionPane.showMessageDialog(null, taskDetails.toString());
    }}
            
            
           
          