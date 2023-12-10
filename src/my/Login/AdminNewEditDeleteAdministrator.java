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
public class AdminNewEditDeleteAdministrator extends javax.swing.JFrame {
    private DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){  // turn table into non-editable
            return false;
        }
    };
    private final String[] column = {"UserId", "Full Name", "Password","Contact Number"};
    private Administrator adminAcc;
    /**
     * Creates new form AdminNewEditDeleteCustomer
     */
    public AdminNewEditDeleteAdministrator() {
        initComponents();
    }
    
    public AdminNewEditDeleteAdministrator(Administrator adminAcc) {
        initComponents();
        this.adminAcc = adminAcc;
        displayAdministrator();
    }
    
    public void displayAdministrator(){
        model.setColumnIdentifiers(column);
        adminAcc.displayUser(model, "Admin"); 
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
        tableAdmin = new javax.swing.JTable();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Administrator Create/Edit/Delete");

        tableAdmin.setModel(model);
        tableAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableAdminMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableAdmin);

        jLabel2.setText("Full name");

        jLabel3.setText("UserID");

        jLabel4.setText("Password");

        jLabel5.setText("Contact Number");

        tfFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFullNameActionPerformed(evt);
            }
        });

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
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfFullName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfContact, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCreate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(btnEdit)
                                .addGap(46, 46, 46)
                                .addComponent(btnDelete)
                                .addGap(20, 20, 20)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete))
                        .addGap(62, 62, 62))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void clearText(){
        tpUserID.setText("");
        tfFullName.setText("");
        tfPassword.setText("");
        tfContact.setText("");
    }
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String admName = tfFullName.getText();
        String admPass = tfPassword.getText();
        String admContact = tfContact.getText();
        
        try{
            String checkSpecialCharacters = admName + admPass + admContact;
            if (checkSpecialCharacters.contains(",")){
                throw new IllegalArgumentException("The character \",\" is not allowed");
            }  
            if (admName.equals("") || admPass.equals("") || admContact.equals("")){
                throw new IllegalArgumentException("Please fill all of the infomation first");
            }
            if (admName.trim().equals("")){
                throw new IllegalArgumentException("Username must have at least 1 alphabets");
            }
            
            
            Administrator adminNewAcc = new Administrator(admName,admPass,admContact);
            adminNewAcc.createAccount();
            model.setRowCount(0);
            displayAdministrator();
            clearText();
        }catch (IllegalArgumentException e){
            String[] errMsgArr = e.toString().split("java.lang.IllegalArgumentException: ");
            JOptionPane.showMessageDialog(null, errMsgArr[1]);
        }
        
        
    }//GEN-LAST:event_btnCreateActionPerformed

    
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String admId = tpUserID.getText();
        if(!admId.equals("")){
            String newName = tfFullName.getText();
            String newPass = tfPassword.getText();
            String newContact = tfContact.getText();
            
            try{
            String checkSpecialCharacters = newName + newPass + newContact;
            if (checkSpecialCharacters.contains(",")){
                throw new IllegalArgumentException("The character \",\" is not allowed");
            }  
            if (newName.equals("") || newPass.equals("") || newContact.equals("")){
                throw new IllegalArgumentException("Please fill all of the infomation first");
            }
            if (newName.trim().equals("")){
                throw new IllegalArgumentException("Username must have at least 1 alphabets");
            }
            Administrator editedAdm = new Administrator(admId, newName, newPass, newContact);
            editedAdm.editAccount();
            model.setRowCount(0);
            displayAdministrator();
            }catch (IllegalArgumentException e){
                String[] errMsgArr = e.toString().split("java.lang.IllegalArgumentException: ");
                JOptionPane.showMessageDialog(null, errMsgArr[1]);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select the user first", "None selected", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed
        int row = -1;
    private void tableAdminMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAdminMouseReleased
        this.row = tableAdmin.getSelectedRow();
        
        String selectedId = String.valueOf(model.getValueAt(row,0));
        String selectedName = String.valueOf(model.getValueAt(row, 1));
        String selectedPassword = String.valueOf(model.getValueAt(row, 2));
        String selectedContact = String.valueOf(model.getValueAt(row, 3));
        
        tpUserID.setText(selectedId);
        tfFullName.setText(selectedName);
        tfPassword.setText(selectedPassword);
        tfContact.setText(selectedContact);
    }//GEN-LAST:event_tableAdminMouseReleased

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String admId = tpUserID.getText();
        
        if(!admId.equals("")){
            String delName = tfFullName.getText();
            String delPass = tfPassword.getText();
            String delContact = tfContact.getText();
        
            Administrator deletedAdm = new Administrator(admId, delName, delPass, delContact);
        
            deletedAdm.deleteAccount();
        
            model.setRowCount(0);
            displayAdministrator();
            clearText();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select the user first", "None selected", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tfFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFullNameActionPerformed

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
            java.util.logging.Logger.getLogger(AdminNewEditDeleteAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminNewEditDeleteAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminNewEditDeleteAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminNewEditDeleteAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminNewEditDeleteAdministrator().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableAdmin;
    private javax.swing.JTextField tfContact;
    private javax.swing.JTextField tfFullName;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextPane tpUserID;
    // End of variables declaration//GEN-END:variables
}
