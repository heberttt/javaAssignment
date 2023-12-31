/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my.Login;
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import my.Classes.*;  

/**
 *
 * @author heber
 */
public class LoginUI extends javax.swing.JFrame implements FileLocationInterface {

    /**
     * Creates new form LoginUI
     */
    public LoginUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextBoxUsername = new javax.swing.JTextField();
        TextBoxPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();
        lblResult1 = new javax.swing.JLabel();
        lblResult2 = new javax.swing.JLabel();
        lblResult3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextBoxUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextBoxUsernameActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblResult1.setText("UserID");

        lblResult2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        lblResult2.setText("LOGIN");

        lblResult3.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblResult1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResult3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogin)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TextBoxPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                .addComponent(TextBoxUsername))
                            .addComponent(lblResult2))
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblResult2)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextBoxUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResult1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextBoxPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResult3))
                .addGap(26, 26, 26)
                .addComponent(lblResult)
                .addGap(31, 31, 31)
                .addComponent(btnLogin)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        //if ((TextBoxUsername.getText()).equals("Bob") && (TextBoxPassword.getText()).equals("123")){
          //  lblResult.setText("Success!");
            //FormDemo frame = new FormDemo();
            //frame.setVisible(true);
            //this.dispose();  
            
        //}
        //else{
         //   lblResult.setText("Fail");
        //}
        try{
            File user = new File(userFilePath);
            Scanner myReader = new Scanner(user);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                String[] dataArr = data.split(",");
            
                if(TextBoxUsername.getText().equals(dataArr[0]) && TextBoxPassword.getText().equals(dataArr[2])){
                    myReader.close();
                    lblResult.setText("Success!");
                    if (dataArr[4].equals("Customer")){
                        Customer custAccount = new Customer(dataArr[0], dataArr[1], dataArr[2], dataArr[3], Integer.parseInt(dataArr[5]));
                        CustomerHOMEPAGE customer = new CustomerHOMEPAGE(custAccount);
                        customer.setVisible(true);
                        this.dispose();
                        break;
                    }
                    else if (dataArr[4].equals("Admin")){
                        Administrator adminAccount = new Administrator(dataArr[0],dataArr[1],dataArr[2],dataArr[3]);
                        AdministratorHomepage admin = new AdministratorHomepage(adminAccount);
                        admin.setVisible(true);
                        this.dispose();
                        break;
                    }
                    else if (dataArr[4].equals("Vendor")){
                        Vendor vendorAccount = new Vendor(dataArr[0],dataArr[1],dataArr[2],dataArr[3],dataArr[5],dataArr[6]);
                        VendorHomepage vendor = new VendorHomepage(vendorAccount); 
                        vendor.setVisible(true);
                        this.dispose();
                        break;
                    }
                    else if (dataArr[4].equals("Runner")){
                        Runner runnerAccount = new Runner(dataArr[0], dataArr[1], dataArr[2], dataArr[3], Integer.parseInt(dataArr[5]));
                        Runner_Menu runner = new Runner_Menu(runnerAccount);
                        runner.setVisible(true);
                        this.dispose();
                        break;
                    }
                }
            }
            lblResult.setText("Wrong Username or passcode");
            myReader.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void TextBoxUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextBoxUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextBoxUsernameActionPerformed

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
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField TextBoxPassword;
    private javax.swing.JTextField TextBoxUsername;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblResult1;
    private javax.swing.JLabel lblResult2;
    private javax.swing.JLabel lblResult3;
    // End of variables declaration//GEN-END:variables
}
