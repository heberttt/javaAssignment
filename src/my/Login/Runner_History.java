/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my.Login;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import my.Classes.Customer;
import static my.Classes.FileLocationInterface.foodMenuFilePath;
import static my.Classes.FileLocationInterface.ordersFilePath;
import static my.Classes.FileLocationInterface.taskFilePath;
import static my.Classes.FileLocationInterface.userFilePath;
import my.Classes.FoodMenu;
import my.Classes.Runner;
import my.Classes.runOrder;
import my.Classes.task;

/**
 *
 * @author Shenlung
 */
public class Runner_History extends javax.swing.JFrame {

    ArrayList<task> arrTask = new ArrayList<>();
    ArrayList<Customer> arrCust = new ArrayList<>();
    ArrayList<runOrder> arrOrders = new ArrayList<>();
    ArrayList<FoodMenu> arrMenu = new ArrayList<>();
    DefaultTableModel dtm = new DefaultTableModel();
    Runner runnerAcc;
    ArrayList<Integer> idxTask = new ArrayList<>();
    ArrayList<Integer> idxCust = new ArrayList<>();
    ArrayList<Integer> idxOrder = new ArrayList<>();
    
    int posClick = -1;
    
    /**
     * Creates new form Task
     */
    public Runner_History() {
        initComponents();
    }
    public void loadDataTask()
    {
        try{
            File task = new File(taskFilePath);
            Scanner myReader = new Scanner(task);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                String[] dataArr = data.split(",");
                if(dataArr[3].equalsIgnoreCase("true"))
                {
                arrTask.add(new task(Integer.parseInt(dataArr[0]),dataArr[1],
                        dataArr[2],dataArr[3]));
                }
            }
            myReader.close();
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
    }
    
    public void loadDataOrder()
    { 
        try{
            File Order = new File(ordersFilePath);
            Scanner myReader = new Scanner(Order);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                String[] dataArr = data.split(",");
                arrOrders.add(new runOrder(Integer.parseInt(dataArr[0]),dataArr[1],
                        dataArr[2],dataArr[3],dataArr[4],dataArr[5],dataArr[6],dataArr[8]));
            }
            myReader.close();
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void loadDataCustomer()
    {
        try{
            File cust = new File(userFilePath);
            Scanner myReader = new Scanner(cust);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                if(!data.equals(""))
                {
                    String[] dataArr = data.split(",");
                    if (dataArr[4].equals("Customer")){
                        arrCust.add(new Customer (dataArr[0],dataArr[1],
                        dataArr[2],dataArr[3],Integer.parseInt(dataArr[5])));
                    }
                
                }
            }
            myReader.close();
    }       catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void loadDataMenu()
    {
        try{
            File Menu = new File(foodMenuFilePath);
            Scanner myReader = new Scanner(Menu);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                String[] dataArr = data.split(",");
                arrMenu.add(new FoodMenu(dataArr[0],dataArr[1],dataArr[2],null));
            }
            myReader.close();
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void saveDataTask()
    {
        try{
            File f = new File(taskFilePath);
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            String line = "";
            for (int i = 0; i < arrTask.size(); i++) {
                line = arrTask.get(i).getOrderID() + "," + 
                       arrTask.get(i).getTime() + "," +
                       arrTask.get(i).getStatus()+ "," +
                       arrTask.get(i).getTaskFinished() + ",";
                bw.write(line + "\n");
            }
            bw.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public void showData()
    {
        History_table.setModel(dtm);
        dtm.addColumn("OrderID");
        dtm.addColumn("Time");
        
        dtm.addColumn("TaskFinished");
        String CustName = "";
        idxCust.clear();
        idxOrder.clear();
        idxTask.clear();
        for (int i = 0; i < arrTask.size(); i++) {
                System.out.println(arrTask.get(i).getOrderID());
                
                for (int j = 0; j < arrOrders.size(); j++) {
                    if(arrTask.get(i).getOrderID() == arrOrders.get(i).getOrderID()){
                        String CustID = arrOrders.get(j).getCustomerID();
                        
                        for (int k = 0; k < arrCust.size(); k++) {
                            if(arrCust.get(k).getId().equals(CustID)){
                            CustName = arrCust.get(i).getFullName();
                            idxTask.add(i);
                            idxOrder.add(j);
                            idxCust.add(k);
                            }
                        }
                    }
                }
                dtm.addRow(new Object[]{arrTask.get(i).getOrderID(), arrTask.get(i).getTime(),arrTask.get(i).getTaskFinished()});
            }
    }
    public Runner_History(Runner runnerAcc) {
        initComponents();
        this.runnerAcc = runnerAcc;
        loadDataTask();
        loadDataCustomer();
        loadDataOrder();
        loadDataMenu();
        showData();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        History_table = new javax.swing.JTable();
        btnBTMHistory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        History_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "OrderDate", "OrderID", "CustomerID", "VendorID", "CustomerName", "Location"
            }
        ));
        jScrollPane1.setViewportView(History_table);

        btnBTMHistory.setText("Back to Menu");
        btnBTMHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBTMHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnBTMHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBTMHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBTMHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBTMHistoryActionPerformed
        Runner_Menu m = new Runner_Menu (runnerAcc);
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBTMHistoryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Runner_History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Runner_History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Runner_History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Runner_History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Runner_History().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable History_table;
    private javax.swing.JButton btnBTMHistory;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
