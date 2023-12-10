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
import static my.Classes.FileLocationInterface.userFilePath;

/**  
 *
 * @author himagi
 */
public class Runner extends User{
    int revenue;
    ArrayList<runOrder> arrHistoryOrder = new ArrayList<runOrder>();
    
    public Runner(String id, String fullName, String password, String contactNum){
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.contactNum = contactNum;
        this.revenue = 0;
    }
    public Runner(String id, String fullName, String password, String contactNum, int revenue){
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.contactNum = contactNum;
        this.revenue = revenue;
    }
    
    public Runner(String fullName, String password, String contactNum){
        this.fullName = fullName;
        this.password = password;
        this.contactNum = contactNum;
    }
    
    public Runner(String id){
        this.id = id;
    }
    
    @Override
    public void createAccount(){
        String accName = this.fullName;
        String accPassword = this.password;
        String contactNum = this.contactNum;
        
        String accId = String.valueOf(availableId());
        
        String accountData = accId + "," + accName + "," + accPassword + "," + contactNum + ",Runner,0";//continue
        
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
       String newText = this.id + "," + this.fullName + "," + this.password + "," + this.contactNum + ",Runner," + String.valueOf(this.revenue);
       


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
    
    public void setFullName(String FullName){
        this.fullName = FullName;
    }
    
    public void setPassword(String Password){
        this.password= Password;
    }
    
    public void setContact(String Contact){
        this.contactNum = Contact;
    }
    
    public int getRunnerDataFromID(){
        String userId = this.id;
        
        String userFullName= "";
        String userPassword= "";
        String userContact = "";
        String userRole = "";
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
                
                if (dataArr[0].equals(userId) && dataArr[4].equals("Runner")){
                    userFullName = dataArr[1];
                    userPassword = dataArr[2];
                    userContact = dataArr[3];
                    userRole = dataArr[4];
                    userRevenue = dataArr[5];
                    
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
                this.revenue = Integer.parseInt(userRevenue);
                return 0;
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return -1;
    } 

    public int getRevenue() {
        return this.revenue;
    }
    public void addRevenue()
    {
        revenue += 5;
    }
    public String getId() {
        return id;
    }
    

    public ArrayList<runOrder> getArrHistoryOrder() {
        return arrHistoryOrder;
    }

    public void setArrHistoryOrder(ArrayList<runOrder> arrHistoryOrder) {
        this.arrHistoryOrder = arrHistoryOrder;
    }


    
    
}
