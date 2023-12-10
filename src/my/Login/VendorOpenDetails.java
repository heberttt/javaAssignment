package my.Login;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import my.Classes.*;
import static my.Classes.FileLocationInterface.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 * 
 * @author dvdmi
 */
public class VendorOpenDetails extends javax.swing.JFrame {
    Vendor vendorAcc;
    Customer custAcc;
    ArrayList<String> selectedOrder;
    int totalPrice = 0;
    /**
     * Creates new form VendorOpenDetails
     */
    public VendorOpenDetails() {
        initComponents();
    }
    
     public VendorOpenDetails(Vendor vendorAccount, ArrayList<String> selectedOrder) {
        initComponents();
        this.vendorAcc = vendorAccount;
        this.selectedOrder = selectedOrder;
        loadOrderDetails();
    }
     
 private void loadOrderDetails() {
    try {
        // Read order details from the file
        File ordersFile = new File(ordersFilePath);
        Scanner scanner = new Scanner(ordersFile);

        while (scanner.hasNextLine()) {
            String orderData = scanner.nextLine();
            String[] orderDetails = orderData.split(",");

            // Check if the OrderID matches the selected order
            if (orderDetails.length >= 9 && orderDetails[0].equals(selectedOrder.get(0))) {
                displayMenuDetails(orderDetails);
                break; // Exit the loop since the order is found
            }
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}

 private void displayMenuDetails(String[] orderDetails) {
    // Check if the OrderID matches the selected order
    if (orderDetails.length >= 9 && orderDetails[0].equals(selectedOrder.get(0))) {
        // Display order details
        lblOrderID.setText(orderDetails[0]);

        // Fetch customer's full name from Users.txt based on CustomerID
        String customerName = getCustomerFullName(orderDetails[3]);
        lblCustName.setText(customerName);

        // Create the table model and set column names
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("MenuID");
        model.addColumn("Food Name");
        model.addColumn("Quantity");
        model.addColumn("Price");

        // Display menu details in the table
        String menus = orderDetails[6];
        String[] menuItems = menus.split(";");

         // Initialize total price

        for (String menuItem : menuItems) {
            // Split each menu item using "!" to get menuID and quantity
            String[] menuDetails = menuItem.split("!");

            if (menuDetails.length >= 2) {
                String menuID = menuDetails[0];
                String quantity = menuDetails[1];

                // Calculate total price for the menu item
                String price = getFoodPrice(menuID, orderDetails[4]);
                model.addRow(new Object[]{menuID, getFoodName(menuID, orderDetails[4]), quantity, price});

                // Increment total price
                try {
                    int quantityValue = Integer.parseInt(quantity);
                    int priceValue = Integer.parseInt(price);
                    totalPrice += quantityValue * priceValue;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }

        // Set the model for the DetailsTable
        DetailsTable.setModel(model);

        // Set lblTotalPrice to the calculated total price
        lblTotalPrice.setText(String.valueOf(totalPrice));
        lblLocation.setText(orderDetails[8]);
    }
}


    private String getCustomerFullName(String customerID) {
        try {
            File usersFile = new File(userFilePath);
            Scanner scanner = new Scanner(usersFile);

            while (scanner.hasNextLine()) {
                String userData = scanner.nextLine();
                String[] userDetails = userData.split(",");

                if (userDetails.length >= 2 && userDetails[0].equals(customerID)) {
                    return userDetails[1]; // Full name
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "Unknown";
    }
private String calculateTotalPrice(String menuID, String quantity, String vendorID) {
    // Get the food price based on the menuID and vendorID
    String foodPrice = getFoodPrice(menuID, vendorID);

    // Parse the quantity and food price to calculate total price
    try {
        int quantityValue = Integer.parseInt(quantity);
        int priceValue = Integer.parseInt(foodPrice);

        int totalPrice = quantityValue * priceValue;
        return String.valueOf(totalPrice);
    } catch (NumberFormatException e) {
        e.printStackTrace();
    }
    return "Unknown";
}

private String getFoodName(String menuID, String vendorID) {
    try {
        // Read food menu details from the file
        File foodMenuFile = new File(foodMenuFilePath);
        Scanner scanner = new Scanner(foodMenuFile);

        while (scanner.hasNextLine()) {
            String foodData = scanner.nextLine();
            String[] foodDetails = foodData.split(",");

            // Check if the menuID and vendorID match the desired menu
            if (foodDetails.length >= 4 && foodDetails[0].equals(menuID) && foodDetails[3].equals(vendorID)) {
                return foodDetails[1]; // Food name
            }
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return "Unknown";
}
private String getFoodPrice(String menuID, String vendorID) {
    try {
        // Read food menu details from the file
        File foodMenuFile = new File(foodMenuFilePath);
        Scanner scanner = new Scanner(foodMenuFile);

        while (scanner.hasNextLine()) {
            String foodData = scanner.nextLine();
            String[] foodDetails = foodData.split(",");

            // Check if the menuID and vendorID match the desired menu
            if (foodDetails.length >= 4 && foodDetails[0].equals(menuID) && foodDetails[3].equals(vendorID)) {
                return foodDetails[2]; // Food price
            }
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return "Unknown";
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
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DetailsTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        lblOrderID = new javax.swing.JLabel();
        lblCustName = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        AcceptButton = new javax.swing.JButton();
        DeclineButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("OrderID:");

        jLabel3.setText("Customer Name:");

        jLabel4.setText("Total Price: ");

        DetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MenuID", "Food Name", "Quantity", "Price"
            }
        ));
        jScrollPane2.setViewportView(DetailsTable);
        if (DetailsTable.getColumnModel().getColumnCount() > 0) {
            DetailsTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel5.setText("Location:");

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        lblOrderID.setText("1");

        lblCustName.setText("Thalia");

        lblLocation.setText("APU");

        lblTotalPrice.setText("100");

        AcceptButton.setText("Accept");
        AcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptButtonActionPerformed(evt);
            }
        });

        DeclineButton.setText("Decline");
        DeclineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeclineButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(lblOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(AcceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(DeclineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblOrderID)
                    .addComponent(jLabel4)
                    .addComponent(lblTotalPrice))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblCustName))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblLocation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AcceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DeclineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        VendorOrders Vorder = new VendorOrders(vendorAcc, custAcc);
        Vorder.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void AcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptButtonActionPerformed
        // TODO add your handling code here:
    VendorFinishOrder Vorder = new VendorFinishOrder(vendorAcc, custAcc, selectedOrder);
    Vorder.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_AcceptButtonActionPerformed

    private void DeclineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeclineButtonActionPerformed
        // TODO add your handling code here:
        if (selectedOrder != null) {
        // Get customer ID from the selected order
        String customerID = selectedOrder.get(3);

        updateOrderStatusToCancelled(selectedOrder.get(0));
        String message = vendorAcc.getFullName() + " has declined the order.";
        Notification notification = new Notification(vendorAcc.getId(), customerID, message);
        notification.sendCustomer();
        Customer customer = new Customer(customerID);
        customer.getCustDataFromId();
        customer.topUpCredit(totalPrice);
        VendorOrders Vorder = new VendorOrders(vendorAcc, custAcc);
        Vorder.setVisible(true);
        this.dispose();
        }else{
        // Handle the case when custAcc is not initialized
        JOptionPane.showMessageDialog(this, "Error: Customer information not available.");
        }
}
        private void updateOrderStatusToCancelled(String orderID) {
    try {
        // Read the content of the Orders.txt file
        File ordersFile = new File(ordersFilePath);
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(ordersFile);

        while (scanner.hasNextLine()) {
            String orderData = scanner.nextLine();
            String[] orderDetails = orderData.split(",");

            // Check if the OrderID matches the desired order
            if (orderDetails.length >= 9 && orderDetails[0].equals(orderID)) {
                // Update the order status to "done"
                orderDetails[5] = "cancelled";
                orderData = String.join(",", orderDetails);
            }

            // Add the line to the list
            lines.add(orderData);
        }

        scanner.close();

        // Write the updated content back to the Orders.txt file
        FileWriter writer = new FileWriter(ordersFile);
        for (String line : lines) {
            writer.write(line + System.lineSeparator());
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_DeclineButtonActionPerformed

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
            java.util.logging.Logger.getLogger(VendorOpenDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendorOpenDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendorOpenDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendorOpenDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendorOpenDetails().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton DeclineButton;
    private javax.swing.JTable DetailsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCustName;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JLabel lblTotalPrice;
    // End of variables declaration//GEN-END:variables
}
