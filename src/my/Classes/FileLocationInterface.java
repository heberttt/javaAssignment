/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package my.Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author himagi
 */
public interface FileLocationInterface {
    final String path = "C:\\javaAssignment\\src\\my\\Classes\\";
    public final String userFilePath = path + "Users.txt";
    public final String transactionReceiptFilePath = path + "transactionReceipt.txt";
    public final String CustomerNotificationsFilePath = path + "CustomerNotifications.txt";
}   
