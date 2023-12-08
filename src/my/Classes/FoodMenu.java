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
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
 
/** 
 * 
 * @author heber
 */
public class FoodMenu implements FileLocationInterface {
    String id;

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public int getQuantity() {
        return quantity;
    }
    String price;
    String name;
    Vendor vendor;
    int quantity = 0;
    
    public FoodMenu(String id, String name, String price, Vendor vendor){
        this.vendor = vendor;
        this.id = id;
        this.price = price;
        this.name = name;
    }
    
    public FoodMenu(String id, String name, String price, Vendor vendor, int quantity){
        this.vendor = vendor;
        this.id = id;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }
    
   public void addMenu(){
       try {
            // Create a BufferedWriter in append mode to write to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(foodMenuFilePath, true));
            
            String menuData = String.valueOf(availableId()) + "," + this.name + "," + this.price + "," + vendor.getId();
            writer.write(menuData + "\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
   }
   
   protected int availableId(){
       int biggestNum = 0;
       try {
        File myObj = new File(foodMenuFilePath);
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
   
   
    
    
}
