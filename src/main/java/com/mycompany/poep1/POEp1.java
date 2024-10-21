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
            JOptionPane.showMessageDialog(null,"Welcome to EasyKanban, " + firstname + " " + lastname + "!");

           //Manage Task
           manageTasks(input);
            }else{
               JOptionPane.showMessageDialog(null,"Login failed. Exiting application.");
            }
            input.close();
    }
    
        private static void manageTasks(Scanner input){
            //Ask user how many tasks they would like to enter
            int numOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to enter? "));
            Task[] tasks = new Task[numOfTasks];
            int totalHours = 0;
            int taskCount = 0;
            
            while (true) {
            String menu = "Menu:\n1) Add Task\n2) Show Report (Coming soon)\n3) Quit";
            String optionStr = JOptionPane.showInputDialog(menu + "\nChoose an option:");
            int option = Integer.parseInt(optionStr);

            if (option == 1) {
                if (taskCount < numOfTasks) {
                     String taskName = JOptionPane.showInputDialog("Enter task name:");
                    String taskDescription = JOptionPane.showInputDialog("Enter task description:");
                    
                    // Check task description length
                    if (taskDescription.length() > 50) {
                        JOptionPane.showMessageDialog(null,"Please enter a task description of less than 50 characters.");
                        continue; 
                    }
                    
                   String developerDetails = JOptionPane.showInputDialog("Enter developer details:");
                    double taskDuration = Double.parseDouble(JOptionPane.showInputDialog("Enter task duration (in hours):"));
                    
                    // Select task status
                 String statusMenu = "Select Task Status:\n1) To Do\n2) Doing\n3) Done";
                    String statusOptionStr = JOptionPane.showInputDialog(statusMenu);
                 int statusOption = Integer.parseInt(statusOptionStr);
                    String taskStatus = "";
                switch (statusOption) {
                    case 1:
        taskStatus = "To Do";
        JOptionPane.showMessageDialog(null, "Task status set to: " + taskStatus);
        break;
    case 2:
        taskStatus = "Doing";
        JOptionPane.showMessageDialog(null, "Task status set to: " + taskStatus);
        break;
    case 3:
        taskStatus = "Done";
        JOptionPane.showMessageDialog(null, "Task status set to: " + taskStatus);
        break;
    default:
        System.out.println("Invalid status. Defaulting to 'To Do'.");
        taskStatus = "To Do";
        JOptionPane.showMessageDialog(null, "Invalid option selected. Defaulting to: " + taskStatus);
        break;
                }
                

                     // Create a new Task object
                    Task newTask = new Task(taskName, taskDescription, developerDetails, taskDuration, taskCount);
                    tasks[taskCount] = newTask; 
                    totalHours += newTask.returnTotalHours(); 
                    taskCount++; 

                    // Display task details
                    JOptionPane.showMessageDialog(null, newTask.printTaskDetails());
                    JOptionPane.showMessageDialog(null, "Task successfully captured.");
                } else {
                    JOptionPane.showMessageDialog(null, "Maximum number of tasks reached.");
                }
            } else if (option == 2) {
                JOptionPane.showMessageDialog(null, "Coming soon");
            } else if (option == 3) {
                JOptionPane.showMessageDialog(null, "Exiting application. Goodbye!");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }

        
        
        // Display total hours
       StringBuilder taskDetails = new StringBuilder("Tasks Entered:\n");
    for (Task task : tasks) {
        if (task != null) { // Check for null to avoid NullPointerException
            taskDetails.append(task.printTaskDetails()).append("\n\n");
        }
    }
     
     JOptionPane.showMessageDialog(null, taskDetails.toString());
 }

        }
//hill lilll