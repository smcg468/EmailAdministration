/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailapp;

import java.util.Scanner;

/**
 *
 * @author shan4
 */
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String department;
    private int mailCapacity = 1000;
    private int defaultPasswordLength = 8;
    private String company = "company.com";
    private String alternateEmail;
    
    //Constructor will recieve full name
    public Email (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        
        
        
        this.department = setDepartment();
        System.out.println("Department Selected: " + this.department);
    
     // Call a method that returns a random password
        this.password = randomPassword(8);
        System.out.println("Your Password is: " + this.password);
        
     // Generate email
        email = firstName.toLowerCase()+ "." + lastName.toLowerCase() + "@" + department + "." + company;
        
    }
    
    
    // Ask for department
    private String setDepartment(){
        System.out.println ("Select your Department \n 1 for Sales \n 2 for Development"
        + " \n 3 for Accounting \n 4 for None \n Enter Your Department Code: ");
        Scanner in = new Scanner (System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {return "Sales";}
        else if (depChoice == 2) {return "Development";}
        else if (depChoice == 3) {return "Accounting";}
        else {return "Unspecified";}
    }
    
    // Generate random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789";
        char[] password = new char[length];
        for (int i=0; i<length; i++){
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String (password);
    }
    
    // Set Mailbox capacity - Encapsulation
    public void setMailboxCapacity (int capacity){
        this.mailCapacity = capacity;
    }
    // set alternate email
    public void setAlternateEmail (String alternateEmail){
        this.alternateEmail = alternateEmail;
    }
    // change password
    public void changePssword (String password){
        this.password = password;
    }
    
    //
    public int getMailCapacity() {return mailCapacity;}
    public String getAlternateEmail() {return alternateEmail;}
    public String getPassword () {return password;}
    
    public String showInfo(){
        return "\n Name: " + firstName + lastName + 
            "\n Company Email: " + email +
            "\n Mail Capacity: " + mailCapacity + "mb";
        
    
    }
    
}
