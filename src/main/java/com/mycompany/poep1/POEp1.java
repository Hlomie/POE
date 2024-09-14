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
        
        //Declarations of variables
        String username;
        String password;
        
        //Create a Scanner to read the outputs
        Scanner input = new Scanner(System.in);
        
        //Prompt the user to enter their username
        System.out.print("Enter your Username:");
        username = input.nextLine();
        
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
