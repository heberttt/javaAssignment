/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.Classes;

/** 
 *
 * @author Shenlung
 */ 
public class History {
    
    private String taskID;
    private String orderDate;
    private String orderID;
    private String customerID;
    private String customerName;
    private String location;
    private String vendorName;

    public History(String taskID, String orderDate, String orderID, String customerID, String customerName, String location, String vendorName) {
        this.taskID = taskID;
        this.orderDate = orderDate;
        this.orderID = orderID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.location = location;
        this.vendorName = vendorName;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
    
}
