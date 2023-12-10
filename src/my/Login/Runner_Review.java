package my.Login;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import static my.Classes.FileLocationInterface.ordersFilePath;
import static my.Classes.FileLocationInterface.reviewFilePath;
import static my.Classes.FileLocationInterface.runnerReviewFilePath;
import my.Classes.Runner;
import my.Classes.RunnerReview;
import my.Classes.runOrder;
 
/*   
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Shenlung
 */
public class Runner_Review extends javax.swing.JFrame {

    Runner runnerAcc;
    ArrayList <RunnerReview> arrReview = new ArrayList<>();
    DefaultTableModel dtm = new DefaultTableModel();
    /**
     * Creates new form Review
     */
    public Runner_Review() {
        initComponents();
    }
    public Runner_Review(Runner runnerAcc) {
        initComponents();
        this.runnerAcc = runnerAcc;
        loadDataReview();
        showData();
    }
    
    public void loadDataReview()
    {
        try{
            File Review = new File(runnerReviewFilePath);
            Scanner myReader = new Scanner(Review);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                String[] dataArr = data.split(",");
                if(dataArr[4].equalsIgnoreCase(runnerAcc.getId()))
                
                arrReview.add(new RunnerReview(dataArr[0],dataArr[1],
                        dataArr[2],dataArr[3],dataArr[4],dataArr[5],dataArr[6]));
            }
            myReader.close();
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void showData()
    {
        Review_table.setModel(dtm);
        dtm.addColumn("Customer ID");
        dtm.addColumn("Date");
        dtm.addColumn("Stars");
        dtm.addColumn("Feedback");
        for (int i = 0; i < arrReview.size(); i++) 
        {
            System.out.println(arrReview.get(i).getCustomerID());
            System.out.println(arrReview.get(i).getDate());
            System.out.println(arrReview.get(i).getStar());
            System.out.println(arrReview.get(i).getFeedback());
            dtm.addRow(new Object[]{arrReview.get(i).getCustomerID(), arrReview.get(i).getDate(), arrReview.get(i).getStar(), arrReview.get(i).getFeedback()});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Review_table = new javax.swing.JTable();
        btnBTMReview = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Review_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "OrderID", "Stars", "Feedback"
            }
        ));
        jScrollPane1.setViewportView(Review_table);

        btnBTMReview.setText("Back to Menu");
        btnBTMReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBTMReviewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBTMReview))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnBTMReview)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBTMReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBTMReviewActionPerformed
        Runner_Menu m = new Runner_Menu (runnerAcc);
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBTMReviewActionPerformed

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
            java.util.logging.Logger.getLogger(Runner_Review.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Runner_Review.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Runner_Review.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Runner_Review.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Runner_Review().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Review_table;
    private javax.swing.JButton btnBTMReview;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
