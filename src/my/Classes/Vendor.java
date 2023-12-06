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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static my.Classes.FileLocationInterface.CustomerNotificationsFilePath;
import static my.Classes.FileLocationInterface.userFilePath;

/**
 *
 * @author himagi
 */
public class Vendor extends User {
    
    String restaurantName;

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public String getContactNum() {
        return contactNum;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public int getRevenue() {
        return revenue;
    }
    int revenue;
    
    public Vendor(String id, String fullName, String password, String contactNum, String restaurantName){
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.contactNum = contactNum;
        this.restaurantName = restaurantName;
    }
    
    public Vendor(String fullName, String password, String contactNum, String restaurantName){
        this.fullName = fullName;
        this.password = password;
        this.contactNum = contactNum;
        this.restaurantName = restaurantName;
    }
    
    public Vendor(String id, String fullName, String password, String contactNum, String restaurantName, String revenue){
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.contactNum = contactNum;
        this.restaurantName = restaurantName;
        this.revenue = Integer.parseInt(revenue);
    }
    
    public Vendor(String id){
        this.id = id;
    }
    
    @Override
    public void createAccount(){
        String accName = this.fullName;
        String accPassword = this.password;
        String contactNum = this.contactNum;
        String restaurantName = this.restaurantName;
        
        String accId = String.valueOf(availableId());
        
        String accountData = accId + "," + accName + "," + accPassword + "," + contactNum + ",Vendor," + restaurantName + ",0";//continue
        
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
       String newText = this.id + "," + this.fullName + "," + this.password + "," + this.contactNum + ",Vendor," + this.restaurantName + "," + String.valueOf(revenue);
       


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
    
    public int getVdrDatafromID(){
        String userId = this.id;
        
        String userFullName= "";
        String userPassword= "";
        String userContact = "";
        String userRole = "";
        String userRestaurantName = "";
        String userRevenue = "";
        
        boolean flag = false;
        try {
            File myObj = new File(userFilePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                
                String data = myReader.nextLine();
                if (data.equals("")){
                    continue;
                }
                String[] dataArr = data.split(",");
                
                if (dataArr[0].equals(userId) && dataArr[4].equals("Vendor")){
                    userFullName = dataArr[1];
                    userPassword = dataArr[2];
                    userContact = dataArr[3];
                    userRole = dataArr[4];
                    userRestaurantName = dataArr[5];
                    userRevenue = dataArr[6];
                    
                    flag = true;
                    myReader.close();
                    break;
                }
                
            }
            if (flag == false){
                JOptionPane.showMessageDialog(null, "User doesn't exist or the user is not a vendor");
                myReader.close();
                return 1;
            }
            else{
                this.fullName = userFullName;
                this.password = userPassword;
                this.contactNum = userContact;
                this.restaurantName = userRestaurantName;
                this.revenue = Integer.parseInt(userRevenue);
                return 0;
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return -1;
    }
    
    public void setFullName(String FullName){
        this.fullName = FullName;
    }
    
    public void setPassword(String Password){
        this.password = Password;
    }
    
    public void setContact(String Contact){
        this.contactNum = Contact;
    }
    
    public void setRestaurantName(String RestaurantName){
        this.restaurantName = RestaurantName;
    }
    
    
    
}
