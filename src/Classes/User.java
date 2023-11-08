/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
    
    
    protected int availableId(){
       int biggestNum = 0;
       try {
        File myObj = new File("C:\\javaAssignment\\src\\Classes\\Users.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
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