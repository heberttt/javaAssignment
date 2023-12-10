/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.Classes;
import java.util.Date;
/**
 *
 * @author himagi
 */
public class currentDate {
    
    private String currentDate,currentDay,currentMonth,currentYear,currentTime,timeZone;
      
    public currentDate(){
        java.util.Date date = new java.util.Date();
        String dates = date.toString();
        
        String[] dateArr = dates.split(" ");
        
        currentDay = dateArr[0];
        currentMonth = dateArr[1];
        currentDate = dateArr[2];
        currentTime = dateArr[3];
        timeZone = dateArr[4];
        currentYear = dateArr[5];
    } 
    
    public String getYear(){
        return currentYear;
    }
    
    public String getDate(){
        return currentDate;
    }
    
    public String getDay(){
        return currentDay;
    }
    
    public String getMonth(){
        return currentMonth;
    }
    
    public String getCurrentTime(){
        return currentTime;
    }
    
    public String getTimeZone(){
        return timeZone;
    }   
    
}
