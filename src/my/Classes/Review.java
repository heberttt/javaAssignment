/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static my.Classes.FileLocationInterface.userFilePath;

/**
 *
 * @author heber
 */
public class Review implements FileLocationInterface{
    String ReviewID;
    currentDate current;
    Customer custAcc;
    Vendor vdrAcc;
    int stars;
    String feedback;
    
    
    public Review(Customer custAcc, Vendor vdrAcc, int stars, String feedback){
        this.custAcc = custAcc;
        this.vdrAcc = vdrAcc;
        this.stars = stars;
        this.feedback = feedback;
        this.current = new currentDate();
    }
    
    public void writeReview(){
        String finalFormat = String.valueOf(availableId()) + "," + current.getDate()+"/"+current.getMonth()+"/"+current.getYear() + "," + current.getCurrentTime()+ "," + custAcc.getId() + "," + vdrAcc.getId() + "," + String.valueOf(stars) + "," + feedback ;
    }
    
    protected int availableId(){
       int biggestNum = 0;
       try {
        File myObj = new File(reviewFilePath);
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
