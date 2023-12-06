/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.Classes;

/**
 *
 * @author Shenlung
 */
public class task {
    private int OrderID;
    private String time;
    private String OrderDate;
    private String CustomerName;
    private String Location;

    public task(int OrderID, String time, String OrderDate, String CustomerName, String Location) {
        this.OrderID = OrderID;
        this.time = time;
        this.OrderDate = OrderDate;
        this.CustomerName = CustomerName;
        this.Location = Location;
    }

    public int getOrderID() {
        return OrderID;
    }

    public String getTime() {
        return time;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getLocation() {
        return Location;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }
}
