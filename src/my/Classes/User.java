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
abstract class User implements UserInterface {
    protected String id;
    protected String fullName;
    protected String password;
    protected String contactNum;
    
    abstract void createAccount();
    abstract void editAccount();
    abstract void deleteAccount();
    
    protected int getUserTextLine(String UserID){
       try {
            File usertext = new File(userFilePath);
            Scanner reader = new Scanner(usertext);
            int location = 0;
            while (reader.hasNextLine()) {
                location++;
                String data = reader.nextLine();
                if (data.equals("")){
                    continue;
                }
                String[] dataArr = data.split(",");
                
                if(dataArr[0].equals(UserID)){
                    reader.close();
                    return location;
                }
        }
        reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
        return 1;
    }
    
    protected int availableId(){
       int biggestNum = 0;
       try {
        File myObj = new File(userFilePath);
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