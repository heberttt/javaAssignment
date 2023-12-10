package my.Login;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import my.Classes.Administrator;
import my.Classes.Customer;
import static my.Classes.FileLocationInterface.foodMenuFilePath;
import static my.Classes.FileLocationInterface.ordersFilePath;
import static my.Classes.FileLocationInterface.taskFilePath;
import static my.Classes.FileLocationInterface.userFilePath;
import my.Classes.FoodMenu;
import my.Classes.Runner;
import my.Classes.Vendor;
import my.Classes.runOrder;
import my.Classes.task;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Shenlung
 */

public class Runner_ViewTask extends javax.swing.JFrame {
    
    ArrayList<task> arrTask = new ArrayList<>();
    ArrayList<task> arrAllTask = new ArrayList<>();
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
    public Runner_ViewTask() {
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
                
                if(dataArr[2].equalsIgnoreCase("none"))
                {
                    if(dataArr[3].equalsIgnoreCase("false"))
                    {
                        arrTask.add(new task(Integer.parseInt(dataArr[0]),dataArr[1],dataArr[2],dataArr[3]));
                    }
                }
                arrAllTask.add(new task(Integer.parseInt(dataArr[0]),dataArr[1],dataArr[2],dataArr[3]));
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
                if(!data.equals("")){
                    String[] dataArr = data.split(",");
                    arrOrders.add(new runOrder(Integer.parseInt(dataArr[0]),dataArr[1],
                            dataArr[2],dataArr[3],dataArr[4],dataArr[5],dataArr[6],dataArr[7]));
                } else {
                }
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
        for (int i = 0; i < arrTask.size(); i++) {
            System.out.println(arrAllTask.get(i).getOrderID());
            System.out.println(arrAllTask.get(i).getStatus());
            System.out.println(arrAllTask.get(i).getTaskFinished());
        }
        
        for(int i=0; i<arrTask.size(); i++){
            for (int j = 0; j < arrAllTask.size(); j++) {
                if (arrTask.get(i).getOrderID() == arrAllTask.get(j).getOrderID()){
                    arrAllTask.get(j).setStatus(arrTask.get(i).getStatus());
                    arrAllTask.get(j).setTaskFinished(arrTask.get(i).getTaskFinished());
                }
                
            }
        }
        
        for (int i = 0; i < arrTask.size(); i++) {
            System.out.println(arrAllTask.get(i).getOrderID());
            System.out.println(arrAllTask.get(i).getStatus());
            System.out.println(arrAllTask.get(i).getTaskFinished());
        }
        
        try{
            File f = new File(taskFilePath);
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            String line = "";
            for (int i = 0; i < arrAllTask.size(); i++) {
                line = arrAllTask.get(i).getOrderID() + "," + 
                       arrAllTask.get(i).getTime() + "," +
                       arrAllTask.get(i).getStatus()+ "," +
                       arrAllTask.get(i).getTaskFinished();
                bw.write(line + "\n");
            }
            bw.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void showData() 
    {
        ViewTask_table.setModel(dtm);
        dtm.addColumn("OrderID");
        dtm.addColumn("Time");
        dtm.addColumn("Customer Name");
        
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
                            CustName = arrCust.get(k).getFullName();
                            idxTask.add(i);
                            idxOrder.add(j);
                            idxCust.add(k);
                            }
                        }
                    }
                }
                dtm.addRow(new Object[]{arrTask.get(i).getOrderID(), arrTask.get(i).getTime(),
                                    CustName});
            }
    }
    public Runner_ViewTask(Runner runnerAcc) {
        initComponents();
        this.runnerAcc = runnerAcc;
        loadDataTask();
        loadDataCustomer();
        loadDataOrder();
        loadDataMenu();
        showData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAcceptTask = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ViewTask_table = new javax.swing.JTable();
        btnBTMView = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAcceptTask.setText("View");
        btnAcceptTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptTaskActionPerformed(evt);
            }
        });

        ViewTask_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "OrderDate", "Time", "OrderID", "CustomerName", "Location"
            }
        ));
        ViewTask_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewTask_tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ViewTask_table);

        btnBTMView.setText("Back to Menu");
        btnBTMView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBTMViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBTMView)
                        .addGap(205, 205, 205)
                        .addComponent(btnAcceptTask, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAcceptTask, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBTMView)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBTMViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBTMViewActionPerformed
        Runner_Menu m = new Runner_Menu (runnerAcc);
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBTMViewActionPerformed

    private void btnAcceptTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptTaskActionPerformed
        if(posClick > -1){
        Runner_OngoingTask ot = new Runner_OngoingTask(runnerAcc,this);
        ot.setVisible(true);
        dispose();
        }
        
        
        
    }//GEN-LAST:event_btnAcceptTaskActionPerformed

    private void ViewTask_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewTask_tableMouseClicked
        posClick = ViewTask_table.getSelectedRow();
    }//GEN-LAST:event_ViewTask_tableMouseClicked

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
            java.util.logging.Logger.getLogger(Runner_ViewTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Runner_ViewTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Runner_ViewTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Runner_ViewTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Runner_ViewTask().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ViewTask_table;
    private javax.swing.JButton btnAcceptTask;
    private javax.swing.JButton btnBTMView;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
