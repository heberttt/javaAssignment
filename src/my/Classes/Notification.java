/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.Classes;
 
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
public class Notification implements FileLocationInterface {
    String senderID,receiverID,content;
    String date;
    String time;
    
    public Notification(String senderID, String receiverID, String content){
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.content = content;
        currentDate c = new currentDate();
        this.date = c.getDate()+"/"+c.getMonth()+"/"+c.getYear();
        this.time = c.getCurrentTime();
    }
    
    public void sendCustomer(){
        int notificationId = availableId();
        
        String finalNotification = String.valueOf(notificationId) + "," + senderID + "," + receiverID + "," + date + "," + time + "," + content;
        
        try {
            // Create a BufferedWriter in append mode to write to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(CustomerNotificationsFilePath, true));

            writer.write(finalNotification + "\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    protected int availableId(){
       int biggestNum = 0;
       try {
        File myObj = new File(CustomerNotificationsFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            if(data.equals("")){
                continue;
            }
            String[] dataArr = data.split(",");
            data = dataArr[0];
            
            if(biggestNum <= Integer.parseInt(data)){
                biggestNum = Integer.parseInt(data);
            }
        }
        myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
       int availableId = biggestNum + 1;
       return availableId;
    }
      
    protected int availableVendorNotificationsId(){
       int biggestNum = 0;
       try {
        File myObj = new File(VendorNotificationsFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            if(data.equals("")){
                continue;
            }
            String[] dataArr = data.split(",");
            data = dataArr[0];
            
            if(biggestNum <= Integer.parseInt(data)){
                biggestNum = Integer.parseInt(data);
            }
        }
        myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
       int availableId = biggestNum + 1;
       return availableId;
    }
    
    public void sendVendor(){
        int notificationId = availableVendorNotificationsId();
        
        String finalNotification = String.valueOf(notificationId) + "," + senderID + "," + receiverID + "," + date + "," + time + "," + content;
        
        try {
            // Create a BufferedWriter in append mode to write to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(  VendorNotificationsFilePath, true));

            writer.write(finalNotification + "\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
