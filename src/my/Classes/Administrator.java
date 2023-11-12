/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

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
    
    public void createAccount(){};
}
