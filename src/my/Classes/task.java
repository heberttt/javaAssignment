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
    private String status;
    private String taskFinished;

    public task(int OrderID, String time, String status, String taskFinished) {
        this.OrderID = OrderID;
        this.time = time;
        this.status = status;
        this.taskFinished = taskFinished;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskFinished() {
        return taskFinished;
    }

    public void setTaskFinished(String taskFinished) {
        this.taskFinished = taskFinished;
    }

    
}
