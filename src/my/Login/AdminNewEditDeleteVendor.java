/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my.Login;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import my.Classes.*;
/**
 *     
 * @author himagi
 */
public class AdminNewEditDeleteVendor extends javax.swing.JFrame {
    Administrator adminAcc;
    private DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){  // turn table into non-editable
            return false;
        }
    };
    private final String[] column = {"UserId", "Restaurant Name", "Full Name", "Password","Contact Number"};
    /**
     * Creates new form AdminNewEditDeleteCustomer
     */
    public AdminNewEditDeleteVendor() {
        initComponents();
    }
    
    public AdminNewEditDeleteVendor(Administrator adminAcc) {
        initComponents();
        this.adminAcc = adminAcc;
        tableDisplayVendor();
    }

    public void tableDisplayVendor(){
        model.setColumnIdentifiers(column);
        adminAcc.displayVendor(model); 
    }
    
    private void clearText(){
        tpUserID.setText("");
        tfFullName.setText("");
        tfPassword.setText("");
        tfContact.setText("");
        tfRestaurantName.setText("");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVendor = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfFullName = new javax.swing.JTextField();
        tfContact = new javax.swing.JTextField();
        tfPassword = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tpUserID = new javax.swing.JTextPane();
        btnCreate = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        tfRestaurantName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Vendor Create/Edit/Delete");

        tableVendor.setModel(model);
        tableVendor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableVendorMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableVendor);

        jLabel2.setText("Full name");

        jLabel3.setText("UserID");

        jLabel4.setText("Password");

        jLabel5.setText("Contact Number");

        tpUserID.setEditable(false);
        jScrollPane2.setViewportView(tpUserID);

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tfRestaurantName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRestaurantNameActionPerformed(evt);
            }
        });

        jLabel6.setText("RestaurantName");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCreate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEdit)
                                .addGap(64, 64, 64)
                                .addComponent(btnDelete)
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel3))
                                        .addGap(53, 53, 53)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfRestaurantName)
                                            .addComponent(jScrollPane2)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(53, 53, 53)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfContact, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(35, 35, 35)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfRestaurantName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete))
                        .addGap(62, 62, 62))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String vdrName = tfFullName.getText();
        String vdrPass = tfPassword.getText();
        String vdrContact = tfContact.getText();
        String vdrRestaurantName = tfRestaurantName.getText();
        try{
            String checkSpecialCharacters = vdrName + vdrPass + vdrContact + vdrRestaurantName;
            if (checkSpecialCharacters.contains(",")){
                throw new IllegalArgumentException("The character \",\" is not allowed");
            }  
            if (vdrName.equals("") || vdrPass.equals("") || vdrContact.equals("") || vdrRestaurantName.equals("")){
                throw new IllegalArgumentException("Please fill all of the infomation first");
            }
            if (vdrName.trim().equals("") || vdrRestaurantName.trim().equals("")){
                throw new IllegalArgumentException("Username must have at least 1 alphabets");
            }
            
            Vendor vendorAcc = new Vendor(vdrName,vdrPass,vdrContact, vdrRestaurantName);
            vendorAcc.createAccount();
            model.setRowCount(0);
            tableDisplayVendor();
            clearText();
        }catch (IllegalArgumentException e){
            String[] errMsgArr = e.toString().split("java.lang.IllegalArgumentException: ");
            JOptionPane.showMessageDialog(null, errMsgArr[1]);
        }
        
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String vdrId = tpUserID.getText();
        if (!vdrId.equals("")){
            String vdrRestaurantName = tfRestaurantName.getText();
            String newName = tfFullName.getText();
            String newPass = tfPassword.getText();
            String newContact = tfContact.getText();
            
            
            try{
            String checkSpecialCharacters = newName + newPass + newContact + vdrRestaurantName;
            if (checkSpecialCharacters.contains(",")){
                throw new IllegalArgumentException("The character \",\" is not allowed");
            }  
            if (newName.equals("") || newPass.equals("") || newContact.equals("") || vdrRestaurantName.equals("")){
                throw new IllegalArgumentException("Please fill all of the infomation first");
            }
            if (newName.trim().equals("") || vdrRestaurantName.trim().equals("")){
                throw new IllegalArgumentException("Username must have at least 1 alphabets");
            }
            Vendor editedVdr = new Vendor(vdrId);
            
            int i = editedVdr.getVdrDatafromID();
            if(i==0){
                editedVdr.setFullName(newName);
                editedVdr.setPassword(newPass);
                editedVdr.setContact(newContact);
                editedVdr.setRestaurantName(vdrRestaurantName);
                editedVdr.editAccount();
        
                model.setRowCount(0);
                tableDisplayVendor(); 
            }
            }catch (IllegalArgumentException e){
                String[] errMsgArr = e.toString().split("java.lang.IllegalArgumentException: ");
                JOptionPane.showMessageDialog(null, errMsgArr[1]);
            }
            
            
            
            
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select the user first", "None selected", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String vdrId = tpUserID.getText();
        if (!vdrId.equals("")){
            String delName = tfFullName.getText();
            String delPass = tfPassword.getText();
            String delContact = tfContact.getText();
            String delRestaurantName = tfRestaurantName.getText();
        
            Vendor deletedVdr = new Vendor(vdrId, delName, delPass, delContact,delRestaurantName);
        
            deletedVdr.deleteAccount();
        
            model.setRowCount(0);
            tableDisplayVendor();
            clearText();
        }
        else{
           JOptionPane.showMessageDialog(null, "Please select the user first", "None selected", JOptionPane.INFORMATION_MESSAGE); 
        }
        
        
    }//GEN-LAST:event_btnDeleteActionPerformed
    int row = -1;
    private void tableVendorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVendorMouseReleased
        this.row = tableVendor.getSelectedRow();
        
        String selectedRestaurantName = String.valueOf(model.getValueAt(row,1));
        String selectedId = String.valueOf(model.getValueAt(row,0));
        String selectedName = String.valueOf(model.getValueAt(row, 2));
        String selectedPassword = String.valueOf(model.getValueAt(row, 3));
        String selectedContact = String.valueOf(model.getValueAt(row, 4));
        
        tfRestaurantName.setText(selectedRestaurantName);
        tpUserID.setText(selectedId);
        tfFullName.setText(selectedName);
        tfPassword.setText(selectedPassword);
        tfContact.setText(selectedContact);
    }//GEN-LAST:event_tableVendorMouseReleased

    private void tfRestaurantNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRestaurantNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRestaurantNameActionPerformed

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
            java.util.logging.Logger.getLogger(AdminNewEditDeleteVendor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminNewEditDeleteVendor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminNewEditDeleteVendor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminNewEditDeleteVendor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminNewEditDeleteVendor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableVendor;
    private javax.swing.JTextField tfContact;
    private javax.swing.JTextField tfFullName;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfRestaurantName;
    private javax.swing.JTextPane tpUserID;
    // End of variables declaration//GEN-END:variables
}
