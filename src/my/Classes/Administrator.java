/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import static my.Classes.UserInterface.userFilePath;

/**
 *
 * @author himagi
 */
public class Administrator extends User implements UserInterface {
    
    public Administrator(String id, String username, String password, String contactNum){
        this.id = id;
        this.fullName= username;
        this.password = password;
        this.contactNum = contactNum;
    }
    
    public Administrator(String username, String password, String contactNum){
        this.fullName= username;
        this.password = password;
        this.contactNum = contactNum;
    }
    
    public String getId(){
        return this.id;
    }
    public String getUsername(){
        return this.fullName;
    }
    
    
    
    public void displayUser(DefaultTableModel table, String role){
        ArrayList<ArrayList<String>> fullData = new ArrayList<ArrayList<String>>();
        fullData = getUser(role);
        
        for (int counter = 0; counter < fullData.size(); counter++) { 		      
            ArrayList<String> eachData = new ArrayList<String>();
            eachData = fullData.get(counter);
            String[] finalData = {eachData.get(0),eachData.get(1),eachData.get(2),eachData.get(3)};
            table.addRow(finalData);
      }   	
    }
    
    
    protected ArrayList<ArrayList<String>> getUser(String role){
        ArrayList<ArrayList<String>> finalInfo = new ArrayList<ArrayList<String>>();
        try {
        File myObj = new File(userFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            
            String data = myReader.nextLine();
            
            if (data.equals("")){
                continue;
            }
            
            String[] dataArr = data.split(",");
            if(dataArr[4].equals(role)){
                ArrayList<String> dataList = new ArrayList<String>();
                dataList.add(dataArr[0]);
                dataList.add(dataArr[1]);
                dataList.add(dataArr[2]);
                dataList.add(dataArr[3]);
            
                finalInfo.add(dataList);
            }
            
        }
        myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
        
        return finalInfo;
    }
    
    public void createAccount(){
        String accName = this.fullName;
        String accPassword = this.password;
        String contactNum = this.contactNum;
        
        String accId = String.valueOf(availableId());
        
        String accountData = accId + "," + accName + "," + accPassword + "," + contactNum + ",Admin";//continue
        
        try {
            // Create a BufferedWriter in append mode to write to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(userFilePath, true));

            writer.write(accountData + "\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    };
    
    @Override
    public void editAccount(){
        int lineNum = getUserTextLine(this.id);
       String newText = this.id + "," + this.fullName + "," + this.password + "," + this.contactNum + ",Admin";
       


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
    @Override
    public void deleteAccount(){
        int lineNum = getUserTextLine(this.id);
       String newText = "";
     
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