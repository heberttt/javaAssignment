/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.Classes;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author himagi
 */
public class main {
    public static void main(String[] args){
       
        JOptionPane.showMessageDialog(null, "Hello, this is a message dialog!");
        java.util.Date date = new java.util.Date();
        String dates = date.toString();
        System.out.println(dates);
        
        Customer cust = new Customer("1");
      
        TopUpTransaction receipt = new TopUpTransaction(cust, 20);
        
        int a = receipt.availableId();
        System.out.println(a);
    }
} 
