package my.Login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import my.Classes.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
 
/**  
 * 
 * @author Mohamed Abdihakim
 */
public class CustomerHISTORYDETAILS extends javax.swing.JFrame implements FileLocationInterface{

    Customer custAcc;
    Vendor vendorAcc;
    private JTable JTable1;
    private CustomerCART customerCart;

    private String selectedMenuId = "";
    private int row = -1;
    ArrayList<String> selectedMenus = new ArrayList<String>();
    ArrayList<FoodMenu> MenuInCart = new ArrayList<FoodMenu>();
    private FoodMenu foodItem;
    private DefaultTableModel Model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){  // turn table into non-editable
            return false;
    }
        
    };
    
    public CustomerHISTORYDETAILS() {
        initComponents();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
  
        historyDetailsTable = new JTable(Model);
    }

    private final String[] column = {"MENUID", "STATUS"};
     
    // Constructor with parameters for customer account
    public CustomerHISTORYDETAILS(Customer custAccount){
         initComponents();
         this.custAcc = custAccount;
         
          JTable1 = new JTable(Model);
          JTable1.setModel(Model);
        //  displayreorder();
          historyDetailsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            showOnLabel();
        }
    });
          
          
          this.customerCart = new CustomerCART();
          displayhistoryDetailsTable();
          
          
     }

     // Method to display order history details in the table
    public void displayhistoryDetailsTable(){
         Model.setColumnIdentifiers(column);
         custAcc.displayorderhistorydetails(Model, "done");
         
     }
      
    // Method to show details on labels based on table selection
    private void showOnLabel() {
    int selectedRow = historyDetailsTable.getSelectedRow();

    if (selectedRow != -1) {
        String orderId = (String) Model.getValueAt(selectedRow, 0);
        
 ArrayList<String> additionalDetails = custAcc.getAdditionalDetails(orderId);

        
        if (additionalDetails.size() >= 3) {
            
            jLabel5.setText(additionalDetails.get(0));
            jLabel6.setText(additionalDetails.get(1));
            jLabel7.setText(additionalDetails.get(2));
        } 
    }
}
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        historyDetailsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        reorderbtn = new javax.swing.JButton();
        feedbackBtn = new javax.swing.JButton();
        btnRunnerFeedback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        historyDetailsTable.setModel(Model);
        historyDetailsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                historyDetailsTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(historyDetailsTable);

        jLabel1.setText("ORDERID");

        jLabel2.setText("STATUS:");

        jLabel3.setText("DATE:");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        reorderbtn.setText("RE-ORDER");
        reorderbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reorderbtnActionPerformed(evt);
            }
        });

        feedbackBtn.setText("GIVE FEEDBACK");
        feedbackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedbackBtnActionPerformed(evt);
            }
        });

        btnRunnerFeedback.setText("GIVE RUNNER FEEDBACK");
        btnRunnerFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunnerFeedbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(feedbackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRunnerFeedback)
                        .addGap(54, 54, 54)
                        .addComponent(reorderbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reorderbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(feedbackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRunnerFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    // Method to handle re-order button action
    private void reorderbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reorderbtnActionPerformed

        CustomerVENDORS cv = new CustomerVENDORS(custAcc);
        cv.setVisible(true);

     
    }//GEN-LAST:event_reorderbtnActionPerformed

    private String selectedVendorId;

    
    private void historyDetailsTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyDetailsTableMouseReleased

        this.row = historyDetailsTable.getSelectedRow();

        
        String menuId = historyDetailsTable.getValueAt(this.row, 0).toString();

        
        String vendorId = getVendorIdFromMenuId(menuId);
         if (vendorId != null) {


        Vendor vendor = new Vendor(vendorId);
        vendor.getVdrDatafromID();
         }
         else {
        System.out.println("Vendor ID not found for Menu ID: " + menuId);
        }

    }//GEN-LAST:event_historyDetailsTableMouseReleased

    private void feedbackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feedbackBtnActionPerformed
        int selectedRow = historyDetailsTable.getSelectedRow();
    if (selectedRow != -1) {
        String menuId = historyDetailsTable.getValueAt(selectedRow, 0).toString();
        selectedVendorId = getVendorIdFromMenuId(menuId);

        if (selectedVendorId != null) {
            // Assuming custAcc is your customer account
            CustomerVENDORFEEDBACK cf = new CustomerVENDORFEEDBACK(custAcc, selectedVendorId);
            cf.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vendor ID not found for Menu ID: " + menuId);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row in the history details table.");
    } 
    }//GEN-LAST:event_feedbackBtnActionPerformed

    private void btnRunnerFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunnerFeedbackActionPerformed
        int selectedRow = historyDetailsTable.getSelectedRow();
        String selectedRunnerId = "";
        if (selectedRow != -1) {
            String menuId = historyDetailsTable.getValueAt(selectedRow, 0).toString();

            try {
                File myObj = new File(taskFilePath);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                  String data = myReader.nextLine();
                  if(data.equals("")){
                      continue;
                  }
                  String[] dataArr = data.split(",");
                  if(dataArr[0].equals(menuId)){
                      selectedRunnerId = dataArr[2];
                      CustomerRUNNERFEEDBACK c = new CustomerRUNNERFEEDBACK(custAcc, selectedRunnerId);
                      
                      c.setVisible(true);
                      break;
                           
                  }
                }
            myReader.close();
            } catch (FileNotFoundException e) {
              e.printStackTrace();
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row in the history details table.");
        }
    }//GEN-LAST:event_btnRunnerFeedbackActionPerformed

    //get vendor ID from Menu ID
    private String getVendorIdFromMenuId(String menuId) {
    String vendorId = null;
    try {
        File myObj = new File(ordersFilePath); 
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            if (!data.isEmpty()) {
                String[] dataArr = data.split(",");
                if (dataArr.length >= 7 && dataArr[0].equals(menuId)){
                    vendorId = dataArr[4];
                    break;
                }
            }
        }
        myReader.close();
    } catch (FileNotFoundException e) {
        
        e.printStackTrace();
    }
    return vendorId;
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
            java.util.logging.Logger.getLogger(CustomerDETAILS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerDETAILS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerDETAILS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerDETAILS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {   
         public void run() {
                new CustomerDETAILS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRunnerFeedback;
    private javax.swing.JButton feedbackBtn;
    private javax.swing.JTable historyDetailsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reorderbtn;
    // End of variables declaration//GEN-END:variables
}
