package my.Login;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import my.Classes.*;
import static my.Classes.FileLocationInterface.foodMenuFilePath;
import static my.Classes.FileLocationInterface.ordersFilePath;
import static my.Classes.FileLocationInterface.taskFilePath;
import static my.Classes.FileLocationInterface.userFilePath;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Shenlung
 */

// This class represents the main menu for a Runner user in a GUI application.
public class Runner_Menu extends javax.swing.JFrame {
    
    // Instance variables to store information about the runner, tasks, orders, customers, and menus.
    Runner runnerAcc;
    ArrayList<task> arrTask = new ArrayList<>();
    ArrayList<task> arrAllTask = new ArrayList<>();
    ArrayList<Customer> arrCust = new ArrayList<>();
    ArrayList<runOrder> arrOrders = new ArrayList<>();
    ArrayList<FoodMenu> arrMenu = new ArrayList<>();
    
    // Index variables to keep track of the selected task, customer, and order.
    int idxTask = -1;
    int idxCust = -1;
    int idxOrder = -1;
    
    // Strings to store the current order and customer IDs.
    String orderID = "";
    String customerID = "";
    
    // Boolean flag to indicate whether the runner is on duty.
    boolean onDuty = false;

    public Runner_Menu() {
        initComponents();
    }
    
    public Runner_Menu(Runner runnerAcc) {
        initComponents();
        this.runnerAcc = runnerAcc;
    }
    
    // Method to load order data from a file.
    public void loadDataOrder() {

        try {
            File Order = new File(ordersFilePath);
            Scanner myReader = new Scanner(Order);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (!data.equals("")) {
                    String[] dataArr = data.split(",");
                    if (dataArr[0].equalsIgnoreCase(orderID)) {
                        arrOrders.add(new runOrder(Integer.parseInt(dataArr[0]), dataArr[1],
                                dataArr[2], dataArr[3], dataArr[4], dataArr[5], dataArr[6], dataArr[8]));
                        customerID = dataArr[3];
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    // Method to load Customer data from a file.
    public void loadDataCustomer() {
        try {
            File cust = new File(userFilePath);
            Scanner myReader = new Scanner(cust);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (!data.equals("")) {
                    String[] dataArr = data.split(",");
                    if (dataArr[4].equals("Customer")) {
                        if (dataArr[0].equalsIgnoreCase(customerID)) {
                            arrCust.add(new Customer(dataArr[0], dataArr[1],
                                    dataArr[2], dataArr[3], Integer.parseInt(dataArr[5])));
                        }
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    // Method to load Menu data from a file.
    public void loadDataMenu() {
        try {
            File Menu = new File(foodMenuFilePath);
            Scanner myReader = new Scanner(Menu);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals("")){
                    continue;
                }
                String[] dataArr = data.split(",");
                arrMenu.add(new FoodMenu(dataArr[0], dataArr[1], dataArr[2], null));
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    // Method to load Task data from a file.
    public void loadDataTask() {
        try {
            File task = new File(taskFilePath);
            Scanner myReader = new Scanner(task);
            arrAllTask.clear();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] dataArr = data.split(",");

                if (dataArr[2].equalsIgnoreCase(runnerAcc.getId()) && dataArr[3].equalsIgnoreCase("false")) {
                    onDuty = true;
                    orderID = dataArr[0];
                }
                arrAllTask.add(new task(Integer.parseInt(dataArr[0]), dataArr[1], dataArr[2], dataArr[3]));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRevenue = new javax.swing.JButton();
        btnReview = new javax.swing.JButton();
        btnViewTask = new javax.swing.JButton();
        btnTaskHistory = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRevenue.setText("Revenue Dashboard");
        btnRevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevenueActionPerformed(evt);
            }
        });

        btnReview.setText("Review");
        btnReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewActionPerformed(evt);
            }
        });

        btnViewTask.setText("View Task");
        btnViewTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewTaskActionPerformed(evt);
            }
        });

        btnTaskHistory.setText("Task History");
        btnTaskHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaskHistoryActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Felix Titling", 1, 18)); // NOI18N
        jLabel3.setText("WELCOME");

        jLabel1.setFont(new java.awt.Font("Felix Titling", 1, 18)); // NOI18N
        jLabel1.setText("Runner");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnViewTask, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTaskHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRevenue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReview, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(237, 237, 237))
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(215, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addComponent(btnViewTask, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReview, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTaskHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Event handler for the "View Task" button.
    private void btnViewTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewTaskActionPerformed
        // Load task data and decide whether the runner is on duty.
        loadDataTask();
        
        // If on duty, load order, customer, and menu data.
        if (onDuty) {
            loadDataOrder();
            loadDataCustomer();
            loadDataMenu();
            Runner_OngoingTask rot = new Runner_OngoingTask(runnerAcc, arrCust, arrOrders, arrMenu, arrAllTask);
            rot.setVisible(true);
        } else {
            // If not on duty, open the View Task window.
            Runner_ViewTask rvt = new Runner_ViewTask(runnerAcc);
            rvt.setVisible(true);
        }
        dispose();

    }//GEN-LAST:event_btnViewTaskActionPerformed
    
    // Event handler for the "Review" button.
    private void btnReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReviewActionPerformed
        Runner_Review r = new Runner_Review(runnerAcc);
        r.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnReviewActionPerformed
    
    // Event handler for the "Task History" button.
    private void btnTaskHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaskHistoryActionPerformed
        Runner_History h = new Runner_History(runnerAcc);
        h.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTaskHistoryActionPerformed

     // Event handler for the "Revenue Dashboard" button.
    private void btnRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevenueActionPerformed
        Runner_RevenueDashboard rd = new Runner_RevenueDashboard(runnerAcc);
        rd.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRevenueActionPerformed

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
            java.util.logging.Logger.getLogger(Runner_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Runner_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Runner_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Runner_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Runner_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRevenue;
    private javax.swing.JButton btnReview;
    private javax.swing.JButton btnTaskHistory;
    private javax.swing.JButton btnViewTask;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
