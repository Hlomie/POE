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
        
        //Create a Scanner to read the outputs
        Scanner input = new Scanner(System.in);
        
        //Prompt the user to enter their username
        System.out.print("Enter your Username:");
        username = input.nextLine();
        
           //Regex: define the pattern for validation
           Pattern pattern = Pattern.compile( "^(?=.*[a-zA-Z0-9])[a-zA-Z0-9_]+$");
           Matcher matcher = pattern.matcher(username);
           
           //Check if the user name contains an underscore and is no more than 5 characters in length
           if(username.contains("_") && matcher.matches()){
               System.out.println("Username is successfully captured");
           }else{
               System.out.println("Username is not correctly formatted, please ensure that the username contains an underscore and is no more than 5 characters in length");
           }
   
                   
           
          
          
          
          
        
        //Prompt the user to enter their pasword
        System.out.print(" Enter your Password:");
        password = input.nextLine();
        
        if(username.equals(" ")&& (password.equals(" "))){
            System.out.println(" ");
        }else{
            System.out.println(" ");
        }
        
        
    }
}
