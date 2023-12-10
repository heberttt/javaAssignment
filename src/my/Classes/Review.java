/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.Classes;
  
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
 
/**
 *
 * @author heber
 */
public class Review implements FileLocationInterface{
    private String ReviewID;
    private currentDate current;
    private Customer custAcc;
    private Vendor vdrAcc;
    private Runner rnrAcc;
    private int stars;
    private String feedback;
    
    
    public Review(Customer custAcc, Vendor vdrAcc, int stars, String feedback){
        this.custAcc = custAcc;
        this.vdrAcc = vdrAcc;
        this.stars = stars;
        this.feedback = feedback;
        this.current = new currentDate();
    }
    public Review(Customer custAcc, Runner rnrAcc, int stars, String feedback){
        this.custAcc = custAcc;
        this.rnrAcc = rnrAcc;
        this.stars = stars;
        this.feedback = feedback;
        this.current = new currentDate();
    }
    
    public void writeReview(){
        String finalFormat = String.valueOf(availableId()) + "," + current.getDate()+"/"+current.getMonth()+"/"+current.getYear() + "," + current.getCurrentTime()+ "," + custAcc.getId() + "," + vdrAcc.getId() + "," + String.valueOf(stars) + "," + feedback ;
        try {
            FileWriter writer = new FileWriter(reviewFilePath, true);
            writer.write(finalFormat + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing the review.");
            e.printStackTrace();
        }
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
    
    protected int availableRunnerReviewId(){
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
    
    public void writeRunnerReview(){
        String finalFormat = String.valueOf(availableId()) + "," + current.getDate()+"/"+current.getMonth()+"/"+current.getYear() + "," + current.getCurrentTime()+ "," + custAcc.getId() + "," + rnrAcc.getId() + "," + String.valueOf(stars) + "," + feedback ;
        try {
            FileWriter writer = new FileWriter(runnerReviewFilePath, true);
            writer.write(finalFormat + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing the review.");
            e.printStackTrace();
        }
    }
}
