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
import static my.Classes.FileLocationInterface.userFilePath;
   
/**
 *
 * @author himagi
 */
public class Administrator extends User implements FileLocationInterface {
    
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
    public Administrator(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }
    public String getUsername(){
        return this.fullName;
    }
    
    
    
    public void displayUser(DefaultTableModel table, String role){    // takes the table model and role and add the role info in the table
        ArrayList<ArrayList<String>> fullData = new ArrayList<ArrayList<String>>();
        fullData = getUser(role);
        
        for (int counter = 0; counter < fullData.size(); counter++) { 		      
            ArrayList<String> eachData = new ArrayList<String>();
            eachData = fullData.get(counter);
            String[] finalData = {eachData.get(0),eachData.get(1),eachData.get(2),eachData.get(3)};
            table.addRow(finalData);
      }   	
    }
    
    public void displayVendor(DefaultTableModel table){  // same as displayUser() but only for vendor as it has an extra attribute (restaurantName)
        ArrayList<ArrayList<String>> fullData = new ArrayList<ArrayList<String>>();
        fullData = getVendor();
        
        for (int counter = 0; counter < fullData.size(); counter++) { 		      
            ArrayList<String> eachData = new ArrayList<String>();
            eachData = fullData.get(counter);
            String[] finalData = {eachData.get(0),eachData.get(1),eachData.get(2),eachData.get(3),eachData.get(4)};
            table.addRow(finalData);
      }   	
    }
    
    
    protected ArrayList<ArrayList<String>> getUser(String role){  // gets all user for a specific role and put it inside a nested arraylist<String>
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
    
    protected ArrayList<ArrayList<String>> getVendor(){ // same as getUser() but for vendor
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
            if(dataArr[4].equals("Vendor")){
                ArrayList<String> dataList = new ArrayList<String>();
                dataList.add(dataArr[0]);
                dataList.add(dataArr[5]);
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
    
    public void createAccount(){ //used to create account for an user. Takes all the attributes inside the created class and put it into the text file.
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
            
            JOptionPane.showMessageDialog(null, "The new ID assigned to this user is: " + accId);

        } catch (IOException e) {
            e.printStackTrace();
        }
    };
    
    @Override
    public void editAccount(){ //edits the account info through the ID
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
    
    public void displayTopUpReceipt(DefaultTableModel table, Customer custAcc){    // takes the table model and role and add the role info in the table
        ArrayList<ArrayList<String>> fullData = new ArrayList<ArrayList<String>>();
        fullData = getTopUpReceipt(custAcc);
        
        for (int counter = 0; counter < fullData.size(); counter++) { 		      
            ArrayList<String> eachData = new ArrayList<String>();
            eachData = fullData.get(counter);
            String[] finalData = {eachData.get(0),eachData.get(1),eachData.get(2),eachData.get(3), eachData.get(4)};
            table.addRow(finalData);
      }   	
    }
    
    
    
    public ArrayList<ArrayList<String>> getTopUpReceipt(Customer custAcc){
        ArrayList<ArrayList<String>> finalInfo = new ArrayList<ArrayList<String>>();
        try {
        File myObj = new File(transactionReceiptFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            
            String data = myReader.nextLine();
            
            if (data.equals("")){
                continue;
            }
            
            String[] dataArr = data.split(",");
            if(dataArr[4].equals(custAcc.getId())){
                ArrayList<String> dataList = new ArrayList<String>();
                dataList.add(dataArr[0]);
                dataList.add(dataArr[1]);
                dataList.add(dataArr[2]);
                dataList.add(dataArr[3]);
                dataList.add(dataArr[5]);
            
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
    
    public String getRole(){
        return "Administrator";
    }
    
    
    public Customer getCustomerData(String userID){
        Customer custObj = new Customer("-1");
        try {
            File usertext = new File(userFilePath);
            Scanner reader = new Scanner(usertext);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                if (data.equals("")){
                    continue;
                }
                String[] dataArr = data.split(",");
                
                if(dataArr[0].equals(userID)){
                    reader.close();
                    custObj = new Customer(dataArr[0],dataArr[1],dataArr[2],dataArr[3],Integer.parseInt(dataArr[5]));
                    return custObj;
                }
        }
        reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
        return custObj;
    }
    
    public Vendor getVendorData(String userID){
        Vendor vendObj = new Vendor("-1");
        try {
            File usertext = new File(userFilePath);
            Scanner reader = new Scanner(usertext);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                if (data.equals("")){
                    continue;
                }
                String[] dataArr = data.split(",");
                
                if(dataArr[0].equals(userID)){
                    reader.close();
                    vendObj = new Vendor(dataArr[0],dataArr[1],dataArr[2],dataArr[3],(dataArr[5]), dataArr[6]);
                    return vendObj;
                }
        }
        reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
        return vendObj;
    }
    
    public Runner getRunnerData(String userID){
        Runner runnerObj = new Runner("-1");
        try {
            File usertext = new File(userFilePath);
            Scanner reader = new Scanner(usertext);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                if (data.equals("")){
                    continue;
                }
                String[] dataArr = data.split(",");
                
                if(dataArr[0].equals(userID)){
                    reader.close();
                    runnerObj = new Runner(dataArr[0],dataArr[1],dataArr[2],dataArr[3],Integer.parseInt(dataArr[5]));
                    return runnerObj;
                }
        }
        reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
        return runnerObj;
    }
    
    public Administrator getAdminData(String userID){
        Administrator admObj = new Administrator("-1");
        try {
            File usertext = new File(userFilePath);
            Scanner reader = new Scanner(usertext);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                if (data.equals("")){
                    continue;
                }
                String[] dataArr = data.split(",");
                
                if(dataArr[0].equals(userID)){
                    reader.close();
                    admObj = new Administrator(dataArr[0],dataArr[1],dataArr[2],dataArr[3]);
                    return admObj;
                }
        }
        reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
        return admObj;
    }
    
    
    public ArrayList<ArrayList<String>> getDailyTopUpReceipt(Customer custAcc){
        ArrayList<ArrayList<String>> finalInfo = new ArrayList<ArrayList<String>>();
        try {
        File myObj = new File(transactionReceiptFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            
            String data = myReader.nextLine();
            
            if (data.equals("")){
                continue;
            }
            
            String[] dataArr = data.split(",");
            currentDate today = new currentDate();
            if(dataArr[4].equals(custAcc.getId()) && dataArr[1].equals(today.getDate()+"/"+today.getMonth()+"/"+today.getYear())){
                ArrayList<String> dataList = new ArrayList<String>();
                dataList.add(dataArr[0]);
                dataList.add(dataArr[1]);
                dataList.add(dataArr[2]);
                dataList.add(dataArr[3]);
                dataList.add(dataArr[5]);
            
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
    
    public void displayDailyTopUpReceipt(DefaultTableModel table, Customer custAcc){    // takes the table model and role and add the role info in the table
        ArrayList<ArrayList<String>> fullData = new ArrayList<ArrayList<String>>();
        fullData = getDailyTopUpReceipt(custAcc);
        
        for (int counter = 0; counter < fullData.size(); counter++) { 		      
            ArrayList<String> eachData = new ArrayList<String>();
            eachData = fullData.get(counter);
            String[] finalData = {eachData.get(0),eachData.get(1),eachData.get(2),eachData.get(3), eachData.get(4)};
            table.addRow(finalData);
      }   	
    }
    
    public ArrayList<ArrayList<String>> getMonthlyTopUpReceipt(Customer custAcc){
        ArrayList<ArrayList<String>> finalInfo = new ArrayList<ArrayList<String>>();
        try {
        File myObj = new File(transactionReceiptFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            
            String data = myReader.nextLine();
            
            if (data.equals("")){
                continue;
            }
            
            String[] dataArr = data.split(",");
            currentDate today = new currentDate();
            
            String[] transactionDateArr = dataArr[1].split("/");
            String transactionMonthAndYear = transactionDateArr[1] + "/" + transactionDateArr[2];
            if(dataArr[4].equals(custAcc.getId()) && transactionMonthAndYear.equals(today.getMonth()+"/"+today.getYear())){
                ArrayList<String> dataList = new ArrayList<String>();
                dataList.add(dataArr[0]);
                dataList.add(dataArr[1]);
                dataList.add(dataArr[2]);
                dataList.add(dataArr[3]);
                dataList.add(dataArr[5]);
            
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
    
    public void displayMonthlyTopUpReceipt(DefaultTableModel table, Customer custAcc){    // takes the table model and role and add the role info in the table
        ArrayList<ArrayList<String>> fullData = new ArrayList<ArrayList<String>>();
        fullData = getMonthlyTopUpReceipt(custAcc);
        
        for (int counter = 0; counter < fullData.size(); counter++) { 		      
            ArrayList<String> eachData = new ArrayList<String>();
            eachData = fullData.get(counter);
            String[] finalData = {eachData.get(0),eachData.get(1),eachData.get(2),eachData.get(3), eachData.get(4)};
            table.addRow(finalData);
      }   	
    }
    
    
    public ArrayList<ArrayList<String>> getYearlyTopUpReceipt(Customer custAcc){
        ArrayList<ArrayList<String>> finalInfo = new ArrayList<ArrayList<String>>();
        try {
        File myObj = new File(transactionReceiptFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            
            String data = myReader.nextLine();
            
            if (data.equals("")){
                continue;
            }
            
            String[] dataArr = data.split(",");
            currentDate today = new currentDate();
            
            String[] transactionDateArr = dataArr[1].split("/");
            String transactionMonthAndYear = transactionDateArr[2];
            if(dataArr[4].equals(custAcc.getId()) && transactionMonthAndYear.equals(today.getYear())){
                ArrayList<String> dataList = new ArrayList<String>();
                dataList.add(dataArr[0]);
                dataList.add(dataArr[1]);
                dataList.add(dataArr[2]);
                dataList.add(dataArr[3]);
                dataList.add(dataArr[5]);
            
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
    
    public void displayYearlyTopUpReceipt(DefaultTableModel table, Customer custAcc){    // takes the table model and role and add the role info in the table
        ArrayList<ArrayList<String>> fullData = new ArrayList<ArrayList<String>>();
        fullData = getYearlyTopUpReceipt(custAcc);
        
        for (int counter = 0; counter < fullData.size(); counter++) { 		      
            ArrayList<String> eachData = new ArrayList<String>();
            eachData = fullData.get(counter);
            String[] finalData = {eachData.get(0),eachData.get(1),eachData.get(2),eachData.get(3), eachData.get(4)};
            table.addRow(finalData);
      }   	
    }
     
}
