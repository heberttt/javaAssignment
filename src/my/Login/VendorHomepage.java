package my.Login;
import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import my.Classes.*;
import static my.Classes.FileLocationInterface.VendorNotificationFilePath;

public class VendorHomepage extends javax.swing.JFrame {
    Vendor vendorAcc;

    public VendorHomepage() {
        initComponents();
    }
    
    public VendorHomepage(Vendor vendorAcc) {
        initComponents();
        this.vendorAcc = vendorAcc;
        lblWelcome.setText("Welcome " + vendorAcc.getFullName());
        
        LoadVendorNotificationData();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        MenuButton = new javax.swing.JButton();
        OrdersButton = new javax.swing.JButton();
        OrderHistoryButton = new javax.swing.JButton();
        CustomerReviewButton = new javax.swing.JButton();
        RevenueDashboardButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        NotificationTable = new javax.swing.JTable();
        lblWelcome = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MenuButton.setText("MENU");
        MenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuButtonActionPerformed(evt);
            }
        });

        OrdersButton.setText("ORDERS");
        OrdersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdersButtonActionPerformed(evt);
            }
        });

        OrderHistoryButton.setText("ORDER HISTORY");
        OrderHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderHistoryButtonActionPerformed(evt);
            }
        });

        CustomerReviewButton.setText("CUSTOMER REVIEW");
        CustomerReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerReviewButtonActionPerformed(evt);
            }
        });

        RevenueDashboardButton.setText("REVENUE DASHBOARD");
        RevenueDashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RevenueDashboardButtonActionPerformed(evt);
            }
        });

        NotificationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, ""},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NotifID", "SenderID", "Messages"
            }
        ));
        NotificationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NotificationTableMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(NotificationTable);

        lblWelcome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblWelcome.setText("Welcome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OrdersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OrderHistoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CustomerReviewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RevenueDashboardButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(OrdersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(OrderHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CustomerReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RevenueDashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadVendorNotificationData() {
    try {
        File Vfile = new File(VendorNotificationFilePath);
        Scanner scanner = new Scanner(Vfile);

        ArrayList<ArrayList<String>> notificationData = new ArrayList<ArrayList<String>>();

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            String[] dataArr = data.split(",");

            // Ensure that the line has enough parts to avoid ArrayIndexOutOfBoundsException
            if (dataArr.length >= 3) {
                // Convert vendorAcc.getVendorID() to String for proper comparison
                if (dataArr[2].equals(String.valueOf(vendorAcc.getVendorID()))) {
                    // Add only the required columns to the list
                    ArrayList<String> notification = new ArrayList<String>();
                    notification.add(dataArr[0]);
                    notification.add(dataArr[1]);
                    notification.add(dataArr[5]);

                    notificationData.add(notification);
                }
            }
        }

        // Assuming you have a JTable component named NotificationTable
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NotifID");
        model.addColumn("SenderID");
        model.addColumn("Messages");

        for (ArrayList<String> notification : notificationData) {
            model.addRow(notification.toArray());
        }

        NotificationTable.setModel(model);

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }}

    private void MenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuButtonActionPerformed
        // TODO add your handling code here:
        VendorMenu menu = new VendorMenu(vendorAcc); // to go to the VendorMenu
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MenuButtonActionPerformed

    private void OrdersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdersButtonActionPerformed
        // TODO add your handling code here:
        VendorOrders order = new VendorOrders(vendorAcc);
        order.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_OrdersButtonActionPerformed

    private void OrderHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderHistoryButtonActionPerformed
        // TODO add your handling code here:
        VendorOrderHistory orderH = new VendorOrderHistory(vendorAcc);
        orderH.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_OrderHistoryButtonActionPerformed

    private void CustomerReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerReviewButtonActionPerformed
        // TODO add your handling code here:
        VendorCustReview custRev = new VendorCustReview(vendorAcc);
        custRev.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CustomerReviewButtonActionPerformed

    private void RevenueDashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RevenueDashboardButtonActionPerformed
        // TODO add your handling code here:
        VendorRevDashboard revDash = new VendorRevDashboard(vendorAcc);
        revDash.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RevenueDashboardButtonActionPerformed

    private void NotificationTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotificationTableMouseReleased
        // TODO add your handling code here:   
    }//GEN-LAST:event_NotificationTableMouseReleased

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
            java.util.logging.Logger.getLogger(VendorHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendorHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendorHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendorHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendorHomepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CustomerReviewButton;
    private javax.swing.JButton MenuButton;
    private javax.swing.JTable NotificationTable;
    private javax.swing.JButton OrderHistoryButton;
    private javax.swing.JButton OrdersButton;
    private javax.swing.JButton RevenueDashboardButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
