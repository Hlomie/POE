/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.poep1;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class TaskManagementTest{

    private Task[] tasks;

    @Before
    public void setUp() {
        // Simulating the addition of tasks
        tasks = new Task[4];
        tasks[0] = new Task("Create Login", "Login feature", "Mike Smith", 5, 0, "To Do");
        tasks[1] = new Task("Create Add Features", "Add features to the app", "Edward Harrison", 8, 1, "Doing");
        tasks[2] = new Task("Create Reports", "Generate reports", "Samantha Paulson", 2, 2, "Done");
        tasks[3] = new Task("Add Array", "Implement array handling", "Glenda Oberholzer", 11, 3, "To Do");
    }

    @Test
    public void testDevelopersArray() {
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        for (int i = 0; i < expectedDevelopers.length; i++) {
            assertEquals(expectedDevelopers[i], tasks[i].getDeveloperDetails());
        }
    }

    @Test
    public void testLongestTaskDuration() {
        double maxDuration = 0;
        String longestTaskDeveloper = "";
        String longestTaskName = "";

        for (Task task : tasks) {
            if (task.getTaskDuration() > maxDuration) {
                maxDuration = task.getTaskDuration();
                longestTaskDeveloper = task.getDeveloperDetails();
                longestTaskName = task.getTaskName();
            }
        }

        assertEquals("Glenda Oberholzer", longestTaskDeveloper);
        assertEquals(11, maxDuration, 0.01); // Allow a small delta for double comparison
    }

    @Test
    public void testSearchTaskByName() {
        String searchTaskName = "Create Login";
        Task foundTask = null;

        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(searchTaskName)) {
                foundTask = task;
                break;
            }
        }

        assertNotNull(foundTask);
        assertEquals("Mike Smith", foundTask.getDeveloperDetails());
        assertEquals("Create Login", foundTask.getTaskName());
    }

    @Test
    public void testSearchTasksByDeveloper() {
        String searchDeveloper = "Samantha Paulson";
        StringBuilder developerTasks = new StringBuilder("Tasks for Developer: " + searchDeveloper + "\n");

        for (Task task : tasks) {
            if (task.getDeveloperDetails().equalsIgnoreCase(searchDeveloper)) {
                developerTasks.append("Task Name: ").append(task.getTaskName()).append("\n");
            }
        }

        assertEquals("Tasks for Developer: Samantha Paulson\nTask Name: Create Reports\n", developerTasks.toString());
    }

    @Test
    public void testDeleteTask() {
        String deleteTaskName = "Create Reports";
        boolean taskDeleted = false;

        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].getTaskName().equalsIgnoreCase(deleteTaskName)) {
                // Shift tasks down in the array
                for (int j = i; j < tasks.length - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
                tasks[tasks.length - 1] = null; // Remove last element
                taskDeleted = true;
                break;
            }
        }

        assertTrue(taskDeleted);
        assertNull(tasks[2]); // Assuming task "Create Reports" was at index 2
    }

    @Test
    public void testDisplayReport() {
        StringBuilder taskSummary = new StringBuilder("Task Summary: \n\n");
        for (Task task : tasks) {
            if (task != null) {
                taskSummary.append(task.printTaskDetails()).append("\n\n");
            }
        }

        assertNotNull(taskSummary.toString());
        assertEquals(3, taskSummary.toString().split("\n\n").length - 1); // Check that there are 3 tasks remaining
    }
}

    
    
   
