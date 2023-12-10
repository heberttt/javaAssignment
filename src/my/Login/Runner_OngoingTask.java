/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my.Login;

import java.awt.Menu;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import my.Classes.Customer;
import static my.Classes.FileLocationInterface.foodMenuFilePath;
import static my.Classes.FileLocationInterface.taskFilePath;
import my.Classes.FoodMenu;
import my.Classes.Runner;
import my.Classes.runOrder;
import my.Classes.task;

/** 
 *
 * @author Shenlung
 */
public class Runner_OngoingTask extends javax.swing.JFrame {

    Runner runnerAcc;
    Runner_ViewTask rv;
    DefaultTableModel dtm = new DefaultTableModel();
    Runner_History rh;
    ArrayList<task> allTask;
    
    /**
     * Creates new form Runner_ViewTask
     */
    public Runner_OngoingTask() {
        initComponents();
    }
    public Runner_OngoingTask(Runner runnerAcc,Runner_ViewTask rv)
    {
        initComponents();
        this.runnerAcc = runnerAcc;
        this.rv = rv;
        OngoingTask_Table.setModel(dtm);
        btnFinishTask.setText("Accept");
        showData();
    }
    public Runner_OngoingTask(Runner runnerAcc,ArrayList<Customer>arrCust, 
            ArrayList<runOrder>arrOrders,  ArrayList<FoodMenu>arrMenu,
            ArrayList<task> allTask)
    {
        initComponents();
        this.runnerAcc = runnerAcc;
        //this.rv = rv;
        OngoingTask_Table.setModel(dtm);
        btnFinishTask.setText("Finish");
        OngoingTask_Table.setModel(dtm);
        dtm.addColumn("MenuID");
        dtm.addColumn("Menu Name");
        dtm.addColumn("Quantity");

        lblCustID.setText(arrCust.get(0).getId());
        lblCustName.setText(arrCust.get(0).getFullName());
        lblCustLocation.setText(arrOrders.get(0).getLocation());
        lblCustContact.setText(arrCust.get(0).getContactNum());
        String temp = arrOrders.get(0).getMenu();
        String t[]= temp.split(";");
        for (int i = 0; i < t.length; i++) {
            String[]tt = t[i].split("!");
            String menuName = "";
            for (int j = 0; j < arrMenu.size(); j++) {
                if(arrMenu.get(j).getId().equalsIgnoreCase(tt[0]))
                {
                    menuName = arrMenu.get(j).getName();
                }
                
            }
            dtm.addRow(new Object[]{tt[0], menuName ,tt[1]});
        }
        this.allTask = allTask;
    }

    public void showData()
    {
        OngoingTask_Table.setModel(dtm);
        dtm.addColumn("MenuID");
        dtm.addColumn("Menu Name");
        dtm.addColumn("Quantity");
        
        int idxCust = rv.idxCust.get(rv.posClick);
        lblCustID.setText(rv.arrCust.get(idxCust).getId());
        lblCustName.setText(rv.arrCust.get(idxCust).getFullName());
        lblCustLocation.setText(rv.arrOrders.get(idxCust).getLocation());
        lblCustContact.setText(rv.arrCust.get(idxCust).getContactNum());
        int idxOrder = rv.idxOrder.get(rv.posClick);
        String temp = rv.arrOrders.get(idxOrder).getMenu();
        String t[]= temp.split(";");
        for (int i = 0; i < t.length; i++) {
            String[]tt = t[i].split("!");
            String menuName = "";
            for (int j = 0; j < rv.arrMenu.size(); j++) {
                if(rv.arrMenu.get(j).getId().equalsIgnoreCase(tt[0]))
                {
                    menuName = rv.arrMenu.get(j).getName();
                }
                
            }
            dtm.addRow(new Object[]{tt[0], menuName ,tt[1]});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        OngoingTask_Table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnFinishTask = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCustName = new javax.swing.JLabel();
        lblCustID = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCustLocation = new javax.swing.JLabel();
        lblCustContact = new javax.swing.JLabel();
        btnBTMOngoing = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("CustomerName =");

        OngoingTask_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "MenuID", "FoodName", "Quantity"
            }
        ));
        jScrollPane2.setViewportView(OngoingTask_Table);

        jLabel2.setText("Status =");

        btnFinishTask.setText("Finish Task");
        btnFinishTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishTaskActionPerformed(evt);
            }
        });

        jLabel3.setText("CustomerID =");

        lblCustName.setText("jLabel5");

        lblCustID.setText("CustomerID");

        jLabel7.setText("ContactNumber =");

        jLabel8.setText("CustomerLocation =");

        lblCustLocation.setText("jLabel5");

        lblCustContact.setText("jLabel5");

        btnBTMOngoing.setText("Back to Menu");
        btnBTMOngoing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBTMOngoingActionPerformed(evt);
            }
        });

        lblStatus.setText("Ongoing...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCustName)
                                    .addComponent(lblCustID)
                                    .addComponent(lblCustLocation))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblStatus)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCustContact)
                                    .addComponent(jLabel4))))
                        .addContainerGap(121, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFinishTask, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBTMOngoing)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblCustID)
                            .addComponent(jLabel7)
                            .addComponent(lblCustContact))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(lblCustName)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(lblStatus))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblCustLocation))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinishTask, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBTMOngoing))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBTMOngoingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBTMOngoingActionPerformed
        Runner_Menu m = new Runner_Menu (runnerAcc);
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBTMOngoingActionPerformed

    private void btnFinishTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishTaskActionPerformed
        if (btnFinishTask.getText().equalsIgnoreCase("Accept")){
            rv.arrTask.get(rv.posClick).setStatus(rv.runnerAcc.getId());
            rv.saveDataTask();
            JOptionPane.showMessageDialog(this,"Your task is successfully Accepted!");
            Runner_Menu m = new Runner_Menu (runnerAcc);
            m.setVisible(true);
            dispose();
        }else{ //if finished
            for (int i = 0; i < allTask.size(); i++) {
                if (allTask.get(i).getStatus().equalsIgnoreCase(runnerAcc.getId()) &&
                    allTask.get(i).getTaskFinished().equalsIgnoreCase("false")){
                    allTask.get(i).setTaskFinished("true");
                    lblStatus.setText("Delivered");
                    runnerAcc.addRevenue();
                    JOptionPane.showMessageDialog(this,"Your task is successfully Finished!");
                    Runner_Menu m = new Runner_Menu (runnerAcc);
                    m.setVisible(true);
                    dispose();
                }
            } 
            saveTask();
        }
        
    }//GEN-LAST:event_btnFinishTaskActionPerformed
    
    public void saveTask()
    {
        try{
            File f = new File(taskFilePath);
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            String line = "";
            for (int i = 0; i < allTask.size(); i++) {
                line = allTask.get(i).getOrderID() + "," + 
                       allTask.get(i).getTime() + "," +
                       allTask.get(i).getStatus()+ "," +
                       allTask.get(i).getTaskFinished();
                bw.write(line + "\n");
            }
            bw.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
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
            java.util.logging.Logger.getLogger(Runner_OngoingTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Runner_OngoingTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Runner_OngoingTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Runner_OngoingTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Runner_OngoingTask().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable OngoingTask_Table;
    private javax.swing.JButton btnBTMOngoing;
    private javax.swing.JButton btnFinishTask;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCustContact;
    private javax.swing.JLabel lblCustID;
    private javax.swing.JLabel lblCustLocation;
    private javax.swing.JLabel lblCustName;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables

}
