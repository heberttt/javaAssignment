/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;  
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author himagi
 */
public class Customer extends User{
    
    protected int credit;
    
    public Customer(String id, String fullName, String password, String contactNum){
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.contactNum = contactNum;
    }
    
    public Customer(String fullName, String password, String contactNum){
        this.fullName = fullName;
        this.password = password;
        this.contactNum = contactNum;
    }
    
    public void createAccount(){
        String accName = this.fullName;
        String accPassword = this.password;
        String contactNum = this.contactNum;
        
        String accId = String.valueOf(availableId());
        
        String accountData = accId + "," + //continue
        
        try {
            // Create a BufferedWriter in append mode to write to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/himagi/javaAssignment/src/Classes/Users.txt", true));

            writer.write("this is a test\n");

            writer.close();

            System.out.println("Data appended to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
    
    

    
    
    
    
    
}
