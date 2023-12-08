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
import static my.Classes.FileLocationInterface.userFilePath;
 
/**
 *
 * @author himagi
 */
abstract class User implements FileLocationInterface {
    protected String id;
    protected String fullName;
    protected String password;
    protected String contactNum;
    
    abstract void createAccount();
    abstract void editAccount();
    
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