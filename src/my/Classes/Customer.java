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
/**
 *
 * @author himagi
 */
public class Customer extends User{
    
    protected int credit;
    
    public Customer(String id, String fullName, String password, String contactNum, int credit){
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.contactNum = contactNum;
        this.credit = credit;
    }
    
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
    
    public Customer(String id){
        this.id = id;
    }
    
    @Override
    public void createAccount(){ //write account inside the Users.txt
        String accName = this.fullName;
        String accPassword = this.password;
        String contactNum = this.contactNum;
        
        String accId = String.valueOf(availableId());
        
        String accountData = accId + "," + accName + "," + accPassword + "," + contactNum + ",Customer,0";
        
        try {
            // Create a BufferedWriter in append mode to write to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(userFilePath, true));

            writer.write(accountData + "\n");

            writer.close();
            
            JOptionPane.showMessageDialog(null, "The new ID assigned to this user is: " + accId);

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
    
    
    @Override
    public void editAccount(){
       int lineNum = getUserTextLine(this.id);
       String newText = this.id + "," + this.fullName + "," + this.password + "," + this.contactNum + ",Customer," + String.valueOf(credit);
       


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
    
    public int getCustDataFromId(){
        String userId = this.id;
        
        String userFullName= "";
        String userPassword= "";
        String userContact = "";
        String userRole = "";
        String userCredit = "";
        
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
                
                if (dataArr[0].equals(userId) && dataArr[4].equals("Customer")){
                    userFullName = dataArr[1];
                    userPassword = dataArr[2];
                    userContact = dataArr[3];
                    userRole = dataArr[4];
                    userCredit = dataArr[5];
                    
                    flag = true;
                    myReader.close();
                    break;
                }
                
            }
            if (flag == false){
                JOptionPane.showMessageDialog(null, "User doesn't exist or the user is not a customer");
                myReader.close();
                return 1;
            }
            else{
                this.fullName = userFullName;
                this.password = userPassword;
                this.contactNum = userContact;
                this.credit = Integer.parseInt(userCredit);
                return 0;
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return -1;
    }
    
    public int getCredit(){
        return credit;
    }
    
    public String getId(){
        return id;
    }
    
    public void topUpCredit(int amount){
       int updatedCredit = credit + amount;
       int lineNum = getUserTextLine(this.id);
       String newText = this.id + "," + this.fullName + "," + this.password + "," + this.contactNum + ",Customer,"+ String.valueOf(updatedCredit);
       


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

    

    public String getContactNum() {
        return contactNum;
    }
    
    public void setFullName(String newName){
        this.fullName = newName;
    }
    public void setPassword(String newPassword){
        this.password = newPassword;
    }
      
    public void setContact(String newContact){
        this.contactNum = newContact;
    } 
    
    
    public void displayNotification(DefaultTableModel table, String receiverID){    // takes the table model and role and add the role info in the table
        ArrayList<ArrayList<String>> fullData = new ArrayList<ArrayList<String>>();
        fullData = getUserNotification(receiverID);
        
        for (int counter = 0; counter < fullData.size(); counter++) { 		      
            ArrayList<String> eachData = new ArrayList<String>();
            eachData = fullData.get(counter);
            String[] finalData = {eachData.get(0),eachData.get(1),eachData.get(2),eachData.get(3), eachData.get(4)};
            table.addRow(finalData);
      }   	
    }
    
    public String getRole(){
        return "Customer";
    }
    
    public String getFullName(){
        return this.fullName;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getContact(){
        return this.contactNum;
    }
    
    private ArrayList<ArrayList<String>> getUserNotification(String id){  // gets all user for a specific role and put it inside a nested arraylist<String>
        ArrayList<ArrayList<String>> finalInfo = new ArrayList<ArrayList<String>>();
        try {
        File myObj = new File(CustomerNotificationsFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            
            String data = myReader.nextLine();
            
            if (data.equals("")){
                continue;
            }
            
            String[] dataArr = data.split(",");
            if(dataArr[2].equals(id)){
                ArrayList<String> dataList = new ArrayList<String>();
                dataList.add(dataArr[0]);
                dataList.add(dataArr[3]);
                dataList.add(dataArr[4]);
                dataList.add(dataArr[1]);
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
    public void displayVendor(DefaultTableModel table, String Vendor){    // takes the table model and role and add the role info in the table
        ArrayList<ArrayList<String>> fullData = new ArrayList<ArrayList<String>>();
        fullData = getVendor(Vendor);
        
        for (int counter = 0; counter < fullData.size(); counter++) { 		      
            ArrayList<String> eachData = new ArrayList<String>();
            eachData = fullData.get(counter);
            String[] finalData = {eachData.get(0),eachData.get(1),eachData.get(2)};
            table.addRow(finalData);
      }   	
    }
    
    private ArrayList<ArrayList<String>> getVendor(String Vendor){  // gets all user for a specific role and put it inside a nested arraylist<String>
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
            if(dataArr[4].equals(Vendor)){
                ArrayList<String> dataList = new ArrayList<String>();
                dataList.add(dataArr[0]);
                dataList.add(dataArr[1]);
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
    
    public void displaytableMenu(DefaultTableModel table, String vendorId){  // same as displayUser() but only for vendor as it has an extra attribute (restaurantName)
        ArrayList<ArrayList<String>> fullData = new ArrayList<ArrayList<String>>();
        fullData = getMenu(vendorId);
        for (int counter = 0; counter < fullData.size(); counter++) { 		      
            ArrayList<String> eachData = new ArrayList<String>();
            eachData = fullData.get(counter);
            String[] finalData = {eachData.get(0),eachData.get(1),eachData.get(2),eachData.get(3)};
            table.addRow(finalData);

            
       }   	
        
    }
     
    public  ArrayList<ArrayList<String>> getMenu(String vendorId){  // gets all user for a specific role and put it inside a nested arraylist<String>
        ArrayList<ArrayList<String>> finalInfo = new ArrayList<ArrayList<String>>();
        try {
        File myObj = new File(foodMenuFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            
            String data = myReader.nextLine();
            
            if (data.equals("")){
                continue;
            }
             
            String[] dataArr = data.split(",");
            if(dataArr[3].equals(vendorId)){
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
     public void displayorderTable(DefaultTableModel table, String status){  // same as displayUser() but only for vendor as it has an extra attribute (restaurantName)
        ArrayList<ArrayList<String>> fullData = getorder(status);  
        for (int counter = 0; counter < fullData.size(); counter++) { 		      
            ArrayList<String> eachData = fullData.get(counter);
            String[] finalData = {eachData.get(0),eachData.get(1),eachData.get(2),eachData.get(3)};
            table.addRow(finalData);
            System.out.println(eachData.get(1));
            
       }   	
        
    }
     public  ArrayList<ArrayList<String>> getorder(String status){  // gets all user for a specific role and put it inside a nested arraylist<String>
        ArrayList<ArrayList<String>> finalInfo = new ArrayList<>();
        try {
        File myObj = new File(ordersFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            
            String data = myReader.nextLine();
            
            if (data.equals("")){
                continue;
            }
             
            String[] dataArr = data.split(",");
            if(dataArr[5].equals(status)){
                ArrayList<String> dataList = new ArrayList<>();
                dataList.add(dataArr[0]);
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
        public void displaydetails(DefaultTableModel table){    // takes the table model and role and add the role info in the table
        ArrayList<ArrayList<String>> fullData = getdetails();
        for (int counter = 0; counter < fullData.size(); counter++) { 		      
            ArrayList<String> eachData = fullData.get(counter);
            String[] finalData = {eachData.get(0),eachData.get(1)};
            table.addRow(finalData);
            System.out.println(eachData.get(1));
      }   	
    }
      
    public void reduceCredit(int amount){
       int updatedCredit = credit - amount - 5;
       int lineNum = getUserTextLine(this.id);
       String newText = this.id + "," + this.fullName + "," + this.password + "," + this.contactNum + ",Customer,"+ String.valueOf(updatedCredit);
       


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
    
    private ArrayList<ArrayList<String>> getdetails() {
    ArrayList<ArrayList<String>> finalInfo = new ArrayList<>();
    try {
        File myObj = new File(ordersFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {

            String data = myReader.nextLine();

            if (data.equals("")) {
                continue;
            }

            String[] dataArr = data.split(",");

            ArrayList<String> dataList = new ArrayList<>();
            dataList.add(dataArr[0]);

            // Split array index 6 into menu and quantity
           String[] menuQuantityArr = dataArr[6].split(";");
            for (String menuQuantity : menuQuantityArr) {
                String[] menuQuantityParts = menuQuantity.split("!");
                if (menuQuantityParts.length == 2) {
                    // Assuming menu ID is the first part and quantity is the second part
                    String menuID = menuQuantityParts[0];
                    String quantity = menuQuantityParts[1];
                    dataList.add(menuID);
                    dataList.add(quantity);
                }
            }

            finalInfo.add(dataList);
        }
        myReader.close();
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

    return finalInfo;
}
    public ArrayList<String> getAdditionalDetails(String orderId) {
    ArrayList<String> additionalDetails = new ArrayList<>();

    try {
        File myObj = new File(ordersFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();

            if (data.contains(orderId)) {
                String[] dataArr = data.split(",");
                additionalDetails.add(dataArr[0]);
                additionalDetails.add(dataArr[1]); 
                additionalDetails.add(dataArr[5]); 
                break;
            }
        }
        myReader.close();
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

    return additionalDetails;
}
    
     public void displayorderhistory(DefaultTableModel table,String Status){    // takes the table model and role and add the role info in the table
        ArrayList<ArrayList<String>> fullData = getorderhistory(Status);
        
        

        for (int counter = 0; counter < fullData.size(); counter++) { 		      
            ArrayList<String> eachData = fullData.get(counter);
            String[] finalData = {eachData.get(0),eachData.get(1),eachData.get(2),eachData.get(3)};
            table.addRow(finalData);
      }   	
    }
    
    public ArrayList<ArrayList<String>> getorderhistory(String Status){  // gets all user for a specific role and put it inside a nested arraylist<String>
        ArrayList<ArrayList<String>> finalInfo = new ArrayList<ArrayList<String>>();
        try {
        File myObj = new File(ordersFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            
            String data = myReader.nextLine();
            
            if (data.equals("")){
                continue;
            }
    
            String[] dataArr = data.split(",");
            if (dataArr[5].trim().equalsIgnoreCase(Status.trim())) {
                ArrayList<String> dataList = new ArrayList<String>();
                dataList.add(dataArr[0]);
                dataList.add(dataArr[1]);
                dataList.add(dataArr[2]);
                dataList.add(dataArr[7]);
                
            
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
    public void displayorderhistorydetails(DefaultTableModel table, String Status){    // takes the table model and role and add the role info in the table
        ArrayList<ArrayList<String>> fullData = getorderhistorydetails(Status);
        for (int counter = 0; counter < fullData.size(); counter++) { 		      
            ArrayList<String> eachData = fullData.get(counter);
            String[] finalData = {eachData.get(0),eachData.get(1)};
            table.addRow(finalData);
            System.out.println(eachData.get(1));
      }   	
    }
    public  ArrayList<ArrayList<String>> getorderhistorydetails(String status){  // gets all user for a specific role and put it inside a nested arraylist<String>
        ArrayList<ArrayList<String>> finalInfo = new ArrayList<>();
        try {
        File myObj = new File(ordersFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            
            String data = myReader.nextLine();
            
            if (data.equals("")){
                continue;
            }
             
            String[] dataArr = data.split(",");
            if(dataArr[5].equals(status)){
                ArrayList<String> dataList = new ArrayList<>();
                dataList.add(dataArr[0]);
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
    
    public void displaytransactionTable(DefaultTableModel table, String transactionId){  // same as displayUser() but only for vendor as it has an extra attribute (restaurantName)
        ArrayList<ArrayList<String>> fullData = new ArrayList<ArrayList<String>>();
        fullData = getTransaction(transactionId);
        for (int counter = 0; counter < fullData.size(); counter++) { 		      
            ArrayList<String> eachData = new ArrayList<String>();
            eachData = fullData.get(counter);
            String[] finalData = {eachData.get(0),eachData.get(1),eachData.get(2),eachData.get(3),eachData.get(4)};
            table.addRow(finalData);
            System.out.println(eachData.get(1));
            
       }   	
        
    }
     
    public  ArrayList<ArrayList<String>> getTransaction(String transactionId){  // gets all user for a specific role and put it inside a nested arraylist<String>
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
            if(dataArr[3].equals(transactionId)){
                ArrayList<String> dataList = new ArrayList<String>();
                dataList.add(dataArr[0]);
                dataList.add(dataArr[1]);
                dataList.add(dataArr[2]);
                dataList.add(dataArr[5]);
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
    public void displaytableReview(DefaultTableModel table, String vendorId){  // same as displayUser() but only for vendor as it has an extra attribute (restaurantName)
         ArrayList<ArrayList<String>> fullData = getFeedback(vendorId);
    for (int counter = 0; counter < fullData.size(); counter++) {
        ArrayList<String> eachData = fullData.get(counter);
        table.addRow(new Object[]{eachData.get(0), eachData.get(1), eachData.get(2)});
            
       }   	
        
    }
     
    public  ArrayList<ArrayList<String>> getFeedback(String vendorId){  // gets all user for a specific role and put it inside a nested arraylist<String>
        ArrayList<ArrayList<String>> finalInfo = new ArrayList<ArrayList<String>>();
        try {
        File myObj = new File(reviewFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            
            String data = myReader.nextLine();

            if (data.equals("")){
                continue;
            }
             
            String[] dataArr = data.split(",");
            if (dataArr.length >= 6 && dataArr[4].equals(vendorId)){
                ArrayList<String> dataList = new ArrayList<String>();
                dataList.add(dataArr[5]);
                dataList.add(dataArr[3]);
                dataList.add(dataArr[6]);
            
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
    public FoodMenu readFoodMenuData(String orderID) {
    // Replace "path/to/your/foodmenu.txt" with the actual path to your food menu text file
    String filePath = foodMenuFilePath;

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;

        while ((line = reader.readLine()) != null) {
            // Assuming your food menu file has a specific format (e.g., CSV) where each line represents an item
            String[] data = line.split(",");

            // Assuming the order ID is in the first column
            String itemID = data[0].trim();

            if (itemID.equals(orderID)) {
              String itemId = data[0].trim(); // Replace with the actual column index for the ID
              String itemName = data[1].trim(); // Replace with the actual column index for the name
              String itemPriceString = data[2].trim(); // Replace with the actual column index for the price
              String vendorId = data[3].trim(); // Replace with the actual column index for the vendor ID
              int itemQuantity = Integer.parseInt(data[4].trim()); // Replace with the actual column index for the quantity

// Assuming you have a Vendor object. Replace Vendor instantiation with your actual logic.
Vendor vendor = new Vendor(vendorId);

// Create and return the FoodMenu object
return new FoodMenu(itemId, itemName, itemPriceString, vendor, itemQuantity);
            }
        }
    } catch (IOException e) {
        e.printStackTrace(); // Handle the exception based on your application's requirements
    }

    // Return null if the order ID is not found
    return null;
}
     public void displayreorder(DefaultTableModel table, String orderId){  // same as displayUser() but only for vendor as it has an extra attribute (restaurantName)
        ArrayList<ArrayList<String>> fullData = new ArrayList<ArrayList<String>>();
        fullData = getMenu(orderId);
        for (int counter = 0; counter < fullData.size(); counter++) { 		      
            ArrayList<String> eachData = new ArrayList<String>();
            eachData = fullData.get(counter);
            String[] finalData = {eachData.get(0),eachData.get(1),eachData.get(2),eachData.get(3)};
            table.addRow(finalData);
            System.out.println(eachData.get(1));
            
       }   	
        
    }
     
    public  ArrayList<ArrayList<String>> getreorder(String orderId){  // gets all user for a specific role and put it inside a nested arraylist<String>
        ArrayList<ArrayList<String>> finalInfo = new ArrayList<ArrayList<String>>();
        try {
        File myObj = new File(foodMenuFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            
            String data = myReader.nextLine();
            
            if (data.equals("")){
                continue;
            }
             
            String[] dataArr = data.split(",");
            if(dataArr[3].equals(orderId)){
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
    
     private int getorderDatafromID(){
        String orderId = this.id;
        
        String Name = "";
        String price= "";
        

        
        boolean flag = false;
        try {
            File myObj = new File(foodMenuFilePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                
                String data = myReader.nextLine();
                if (data.equals("")){
                    continue;
                }
                String[] dataArr = data.split(",");
                
                if (dataArr[0].equals(orderId)){
                    Name = dataArr[1];
                    price = dataArr[2];

 
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
                this.fullName = Name;
                this.password = price;
                return 0;
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return -1;
    }
}
 