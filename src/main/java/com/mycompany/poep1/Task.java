/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poep1;

/**
 *
 * @author RC_Student_lab
 */
    public class Task {
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private double taskDuration;
    private int taskNumber;
    private String taskStatus;
    private String taskID;

    public Task(String taskName, String taskDescription, String developerDetails, double taskDuration, int taskNumber, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskNumber = taskNumber;
        this.taskID = createTaskID();
        this.taskStatus = taskStatus; 
        
    }
   
    public boolean checkTaskDescription(){
        return taskDescription.length() <=50;
    }
    
     public void setTaskStatus(String status) {
        this.taskStatus = status;
    }

    public double getTaskDuration() {
        return taskDuration;
    }
    
    public String createTaskID  (){
        String firstTwoLetters = taskName.substring(0, 2).toUpperCase();
        String lastThreeLetters = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return firstTwoLetters + ":" + taskNumber + ":" + lastThreeLetters;
    }
    
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
                "Task ID" +taskID + "\n" +
               "Duration: " + taskDuration + " hours";
    }

 
       
   }
     