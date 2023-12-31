/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my.Login;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import my.Classes.*;
/**
 *
 * @author heber
 */
public class AdminTopUpAmount extends javax.swing.JFrame {
    Administrator adminAcc;
    Customer searchedCust;
    private DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){  // turn table into non-editable
            return false;
        }
    };
    
    ButtonGroup bg;
    
    private final String[] column = {"TransactionID","date", "time", "AdminID", "Top-Up Amount"};
    /**
     * Creates new form AdminTopUp
     */
    public AdminTopUpAmount() {
        initComponents();
    }
    
    public AdminTopUpAmount(Administrator adminAcc, Customer searchedCust) {
        initComponents();
        this.adminAcc = adminAcc;
        this.searchedCust = searchedCust;
        bg = new ButtonGroup();
        addButtonGroup(bg);
        rbAll.setSelected(true);
        displayDetail();
        tableDisplayReceipt();
    }
    
    public void addButtonGroup(ButtonGroup btnGrp){
        btnGrp.add(rbAll);
        btnGrp.add(rbYearly);
        btnGrp.add(rbMonthly);
        btnGrp.add(rbDaily);
    }
    
    public void displayDetail(){
        lblUserID.setText(searchedCust.getId());
        lblCreditAmount.setText("RM " + String.valueOf(searchedCust.getCredit()));
    }
    
    public void tableDisplayReceipt(){
        model.setRowCount(0);
        model.setColumnIdentifiers(column);
        adminAcc.displayTopUpReceipt(model, searchedCust); 
    }
    
    public void tableDisplayDailyReceipt(){
        model.setRowCount(0);
        model.setColumnIdentifiers(column);
        adminAcc.displayDailyTopUpReceipt(model, searchedCust); 
    }
    
    public void tableDisplayMonthlyReceipt(){
        model.setRowCount(0);
        model.setColumnIdentifiers(column);
        adminAcc.displayMonthlyTopUpReceipt(model, searchedCust); 
    }
    
    public void tableDisplayYearlyReceipt(){
        model.setRowCount(0);
        model.setColumnIdentifiers(column);
        adminAcc.displayYearlyTopUpReceipt(model, searchedCust); 
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
        jLabel3 = new javax.swing.JLabel();
        btnTopUp = new javax.swing.JButton();
        lblCreditAmount = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblUserID = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfTopUpAmount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableReceipt = new javax.swing.JTable();
        rbAll = new javax.swing.JRadioButton();
        rbYearly = new javax.swing.JRadioButton();
        rbMonthly = new javax.swing.JRadioButton();
        rbDaily = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Top-Up");

        jLabel3.setText("UserID");

        btnTopUp.setText("Top-Up");
        btnTopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopUpActionPerformed(evt);
            }
        });

        lblCreditAmount.setText("RM");

        jLabel5.setText("Credit Amount");

        lblUserID.setText("UserID");

        jLabel8.setText("Top-Up Amount");

        tfTopUpAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTopUpAmountActionPerformed(evt);
            }
        });

        jLabel7.setText("RM");

        tableReceipt.setModel(model);
        jScrollPane1.setViewportView(tableReceipt);

        rbAll.setText("All");
        rbAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAllActionPerformed(evt);
            }
        });

        rbYearly.setText("Yearly");
        rbYearly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbYearlyActionPerformed(evt);
            }
        });

        rbMonthly.setText("Monthly");
        rbMonthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMonthlyActionPerformed(evt);
            }
        });

        rbDaily.setText("Daily");
        rbDaily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDailyActionPerformed(evt);
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTopUpAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCreditAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTopUp)
                        .addGap(92, 92, 92)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(rbAll, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(rbDaily, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(rbMonthly, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbYearly, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbAll)
                            .addComponent(rbYearly)
                            .addComponent(rbMonthly)
                            .addComponent(rbDaily))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserID)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblCreditAmount))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfTopUpAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                        .addComponent(btnTopUp)
                        .addGap(64, 64, 64))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void btnTopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopUpActionPerformed
        int amount;
          
        try{
            amount = Integer.parseInt(tfTopUpAmount.getText());
            if (amount <= 0){
            throw new IllegalArgumentException("Amount must be more than 0");
            }
            searchedCust.topUpCredit(amount);
            int success = searchedCust.getCustDataFromId();
            if (success == 0){
                JOptionPane.showMessageDialog(null, "Top-Up successful");
            }
            displayDetail();
            TopUpTransaction receipt = new TopUpTransaction(searchedCust, amount);
            receipt.generateTransactionReceipt(adminAcc);
            String notificationText = String.valueOf(amount) + " RM is added to your credit";
            Notification notification = new Notification(adminAcc.getId(), searchedCust.getId(), notificationText);
            notification.sendCustomer();
            tfTopUpAmount.setText("");
        
            if(rbAll.isSelected()){
                tableDisplayReceipt();
            }
            else if(rbDaily.isSelected()){
                tableDisplayDailyReceipt();
            }
            else if(rbMonthly.isSelected()){
                tableDisplayMonthlyReceipt();
            }
            else if(rbYearly.isSelected()){
                tableDisplayYearlyReceipt();
            }
        
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "Amount must be more than 0");
        }
        
        
        
 
    }//GEN-LAST:event_btnTopUpActionPerformed

    private void tfTopUpAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTopUpAmountActionPerformed
        
        
    }//GEN-LAST:event_tfTopUpAmountActionPerformed

    private void rbAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAllActionPerformed
       tableDisplayReceipt();
    }//GEN-LAST:event_rbAllActionPerformed

    private void rbDailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDailyActionPerformed
       tableDisplayDailyReceipt();
    }//GEN-LAST:event_rbDailyActionPerformed

    private void rbMonthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMonthlyActionPerformed
       tableDisplayMonthlyReceipt();
    }//GEN-LAST:event_rbMonthlyActionPerformed

    private void rbYearlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbYearlyActionPerformed
        tableDisplayYearlyReceipt();
    }//GEN-LAST:event_rbYearlyActionPerformed

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
            java.util.logging.Logger.getLogger(AdminTopUpAmount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminTopUpAmount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminTopUpAmount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminTopUpAmount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminTopUpAmount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTopUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCreditAmount;
    private javax.swing.JLabel lblUserID;
    private javax.swing.JRadioButton rbAll;
    private javax.swing.JRadioButton rbDaily;
    private javax.swing.JRadioButton rbMonthly;
    private javax.swing.JRadioButton rbYearly;
    private javax.swing.JTable tableReceipt;
    private javax.swing.JTextField tfTopUpAmount;
    // End of variables declaration//GEN-END:variables
}
