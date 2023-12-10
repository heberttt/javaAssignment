/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.Classes;

/**
 * 
 * @author Shenlung 
 */ 
public class RunnerReview {
    private String ReviewID;
    private String Date;
    private String time;
    private String customerID;
    private String VendorID;
    private String Star;
    private String feedback;

    public RunnerReview(String ReviewID, String Date, String time, String customerID, String VendorID, String Star, String feedback) {
        this.ReviewID = ReviewID;
        this.Date = Date;
        this.time = time;
        this.customerID = customerID;
        this.VendorID = VendorID;
        this.Star = Star;
        this.feedback = feedback;
    }

    public String getReviewID() {
        return ReviewID;
    }

    public void setReviewID(String ReviewID) {
        this.ReviewID = ReviewID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getVendorID() {
        return VendorID;
    }

    public void setVendorID(String VendorID) {
        this.VendorID = VendorID;
    }

    public String getStar() {
        return Star;
    }

    public void setStar(String Star) {
        this.Star = Star;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}


