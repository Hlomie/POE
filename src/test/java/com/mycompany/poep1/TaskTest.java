/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.poep1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
   @Test
    public void testTaskDescriptionLength() {
        // Success case
        Task task1 = new Task("Task1", "This is a valid description.", "Developer1", 10, 1, "Open");
        assertTrue("Task successfully captured", task1.checkTaskDescription());

        // Failure case
        Task task2 = new Task("Task2", "This description is way too long and exceeds the limit of fifty characters.", "Developer2", 5, 2, "Open");
        assertFalse("Please enter a task description of less than 50 characters", task2.checkTaskDescription());
    }

    @Test
    public void testTaskIDGeneration() {
        Task task1 = new Task("AD", "Valid description", "BYN", 10, 1, "Open");
        assertEquals("AD:1:BYN", task1.createTaskID());

        // Additional tests for other Task IDs
        Task task2 = new Task("CR", "Valid description", "IKE", 10, 0, "Open");
        assertEquals("CR:0:IKE", task2.createTaskID());

        Task task3 = new Task("CR", "Valid description", "ARD", 10, 1, "Open");
        assertEquals("CR:1:ARD", task3.createTaskID());

        Task task4 = new Task("CR", "Valid description", "THA", 10, 2, "Open");
        assertEquals("CR:2:THA", task4.createTaskID());

        Task task5 = new Task("CR", "Valid description", "ND", 10, 3, "Open");
        assertEquals("CR:3:ND", task5.createTaskID());
    }

    @Test
    public void testTotalHoursAccumulation() {
        Task task1 = new Task("Task1", "Description", "Dev1", 10, 1, "Open");
        Task task2 = new Task("Task2", "Description", "Dev2", 8, 2, "Open");
        assertEquals(10, task1.returnTotalHours(), 0);
        assertEquals(8, task2.returnTotalHours(), 0);

        // Total hours in a loop
        double totalHours = 0;
        for (Task task : new Task[]{task1, task2}) {
            totalHours += task.returnTotalHours();
        }
        assertEquals(18, totalHours, 0);

        // Additional test data
        Task[] additionalTasks = {
            new Task("Task3", "Description", "Dev3", 55, 3, "Open"),
            new Task("Task4", "Description", "Dev4", 11, 4, "Open"),
            new Task("Task5", "Description", "Dev5", 1, 5, "Open")
        };

        double additionalTotalHours = 0;
        for (Task task : additionalTasks) {
            additionalTotalHours += task.returnTotalHours();
        }
        assertEquals(67, additionalTotalHours, 0);
    }    
    
   
}  