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
import static my.Classes.FileLocationInterface.userFilePath;
   
/**
 *
 * @author himagi
 */
public class TopUpTransaction implements FileLocationInterface{
    int topUpTransactionID;
    Customer custAcc;
    String date;
    String time;
    int topUpAmount;
    
    public TopUpTransaction(Customer custAcc, int topUpAmount){
        this.custAcc = custAcc;
        this.topUpAmount = topUpAmount;
        currentDate c = new currentDate();
        date = c.getDate()+"/"+c.getMonth()+"/"+c.getYear();
        time = c.getCurrentTime();
    }
     
    public void generateTransactionReceipt(Administrator adminAcc){
        this.topUpTransactionID = availableId();
        
        String receiptId = String.valueOf(this.topUpTransactionID);
        String custId = custAcc.getId();
        String receiptDate = this.date;
        String receiptTime = this.time;
        String receiptAmount = String.valueOf(topUpAmount);
        
        String receiptData = receiptId + "," + receiptDate + "," + receiptTime + "," + adminAcc.getId() + "," + custId + "," + receiptAmount;//continue
        
        try {
            // Create a BufferedWriter in append mode to write to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(transactionReceiptFilePath, true));

            writer.write(receiptData + "\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    protected int availableId(){
       int biggestNum = 0;
       try {
        File myObj = new File(transactionReceiptFilePath);
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
    
     public void generateReceipt(Administrator adminAcc, Customer custAcc){
        this.topUpTransactionID = availableId();
        
        String receiptId = String.valueOf(this.topUpTransactionID);
        String custId = custAcc.getId();
        String receiptDate = this.date;
        String receiptTime = this.time;
        String receiptAmount = String.valueOf(topUpAmount);
        
        String receiptData = receiptId + "," + receiptDate + "," + receiptTime + "," + adminAcc.getId() + "," + custId + "," + receiptAmount;//continue
        
        try {
            // Create a BufferedWriter in append mode to write to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(transactionReceiptFilePath, true));

            writer.write(receiptData + "\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
