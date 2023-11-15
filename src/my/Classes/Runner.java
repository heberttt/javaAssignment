/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static my.Classes.UserInterface.userFilePath;

/**
 *
 * @author himagi
 */
public class Runner extends User{
    
    public Runner(String id, String fullName, String password, String contactNum){
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.contactNum = contactNum;
    }
    
    public Runner(String fullName, String password, String contactNum){
        this.fullName = fullName;
        this.password = password;
        this.contactNum = contactNum;
    }
    
    @Override
    public void createAccount(){
        String accName = this.fullName;
        String accPassword = this.password;
        String contactNum = this.contactNum;
        
        String accId = String.valueOf(availableId());
        
        String accountData = accId + "," + accName + "," + accPassword + "," + contactNum + ",Runner";//continue
        
        try {
            // Create a BufferedWriter in append mode to write to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(userFilePath, true));

            writer.write(accountData + "\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
    
    
    @Override
    public void editAccount(){
       int lineNum = getUserTextLine(this.id);
       String newText = this.id + "," + this.fullName + "," + this.password + "," + this.contactNum + ",Runner";
       


       try {
           BufferedReader reader = new BufferedReader(new FileReader(userFilePath));
           String line;
           int lineNumber = 1;

           StringBuilder modifiedContent = new StringBuilder();
           while ((line = reader.readLine()) != null) {
               if (lineNumber == lineNum) {
                   modifiedContent.append(newText).append(System.lineSeparator());
               } else {
                   modifiedContent.append(line).append(System.lineSeparator());
               }
               lineNumber++;
           }

           BufferedWriter writer = new BufferedWriter(new FileWriter(userFilePath));

           writer.write(modifiedContent.toString());

           reader.close();
           writer.close();

       } catch (IOException e) {
          e.printStackTrace();
       }
       
       
    }
}
