package my.Login;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import my.Classes.*;


public class CustomerMENU extends javax.swing.JFrame implements FileLocationInterface {
    Customer custAcc;
    String vendorId;
    Vendor vendorAcc;
    
    String selectedID = "";
    String selectedFoodName = "";
    String selectedPrice = "";
    ArrayList<String> selectedMenus = new ArrayList<String>();
    ArrayList<FoodMenu> MenuInCart = new ArrayList<FoodMenu>();
    
    public CustomerMENU(Customer custAcc, String vendorId) {
        this.custAcc = custAcc;
        this.vendorId = vendorId;
        initComponents();
        
    }
    
    
    public CustomerMENU(Customer custAcc, Vendor vendorAcc) {
        this.custAcc = custAcc;
        this.vendorAcc = vendorAcc;
        initComponents();
        displaytableMenu(vendorAcc.getId());
        displaytableReview(vendorAcc.getId());
        lblMenu.setText(vendorAcc.getRestaurantName() + "'s Menu");
        
    }
    
    private DefaultTableModel Model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){  // turn table into non-editable
            return false;
        }
    };
    private DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){  // turn table into non-editable
            return false;
        }
    };
    private final String[] column = {"MenuID", "FoodName", "price"};
    
     private final String[] Column = {"STARS", "CUSTOMERID", "FEEDBACK"};
    
       public CustomerMENU() {
        initComponents();
  }
       
    public CustomerMENU(Vendor vendor) {
      initComponents();
      
     
 }
 
    public void displaytableMenu(String id){
        Model.setColumnIdentifiers(column);
        custAcc.displaytableMenu(Model, vendorAcc.getId());
        tableMenu.setModel(Model);
    }
    public void displaytableReview(String id){
        model.setColumnIdentifiers(Column);
        custAcc.displaytableReview(model, vendorAcc.getId());
        feedbackTable.setModel(model);
    }

    
    
//    public void CustomerMENU() {
//        initComponents();
//        tableMenu.setModel(Model);
//        // Display the menu when the frame is created
//        displaytableMenu("1");
//    }
//
//    public CustomerMENU(Customer custAcc) {
//        initComponents();
//        this.custAcc = custAcc;
//        // Set the model for the tableMenu
//        tableMenu.setModel(Model);
//        // Display the menu when the frame is created
//        displaytableMenu("2");
//    }
//    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        checkbox1 = new java.awt.Checkbox();
        lblMenu = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMenu = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnOpenCart = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        feedbackTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        checkbox1.setLabel("checkbox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblMenu.setText("MENU");

        tableMenu.setModel(Model);
        tableMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMenuMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMenuMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tableMenu);

        btnAdd.setText("ADD TO CART");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnOpenCart.setText("OPEN CART");
        btnOpenCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenCartActionPerformed(evt);
            }
        });

        feedbackTable.setModel(model);
        jScrollPane3.setViewportView(feedbackTable);

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOpenCart, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(lblMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(338, 338, 338))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMenu)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnOpenCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    
   
    private void tableMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMenuMouseClicked
     
    }//GEN-LAST:event_tableMenuMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!(row == -1)){
            if(!selectedMenus.contains(this.selectedID)){
                selectedMenus.add(this.selectedID);
                int quantity = showIntegerInputDialog("Enter amount: ");
                FoodMenu aMenu = new FoodMenu(this.selectedID,this.selectedFoodName, this.selectedPrice, vendorAcc, quantity);
                MenuInCart.add(aMenu);
                JOptionPane.showMessageDialog(null, "Menu added to cart");
            }
            else{
                JOptionPane.showMessageDialog(null, "You have selected that menu");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a menu");
        }
    }//GEN-LAST:event_btnAddActionPerformed
    private int showIntegerInputDialog(String message){
        int userInput = -1;
        try {
                String inputString = JOptionPane.showInputDialog(null, message);

                userInput = Integer.parseInt(inputString);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please Enter an amount:");
            }
        
        
        return userInput;
    }
    int row = -1;
    private void tableMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMenuMouseReleased
        this.row = tableMenu.getSelectedRow();
        this.selectedID = tableMenu.getValueAt(this.row, 0).toString();
        this.selectedFoodName = tableMenu.getValueAt(this.row, 1).toString();
        this.selectedPrice = tableMenu.getValueAt(this.row, 2).toString();
    }//GEN-LAST:event_tableMenuMouseReleased

    private void btnOpenCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenCartActionPerformed
        CustomerCART cart = new CustomerCART(custAcc, vendorAcc, MenuInCart);
        cart.setVisible(true);
        
    }//GEN-LAST:event_btnOpenCartActionPerformed

    
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 CustomerMENU menuFrame = new CustomerMENU();
            menuFrame.setVisible(true);
            
            }
        });
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnOpenCart;
    private java.awt.Checkbox checkbox1;
    private javax.swing.JTable feedbackTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JTable tableMenu;
    // End of variables declaration//GEN-END:variables
}
