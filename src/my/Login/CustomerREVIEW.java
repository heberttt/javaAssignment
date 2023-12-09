package my.Login;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import my.Classes.*;
public class CustomerREVIEW extends javax.swing.JFrame implements FileLocationInterface{

  Customer custAcc;
  private javax.swing.JList<String> reviewsList;
    /**
     * Creates new form REVIEW
     */
    public CustomerREVIEW() {
        initComponents();
    }
 
    
     public CustomerREVIEW(Customer custAccount) {
        initComponents();
        this.custAcc = custAccount;
        
        reviewsList = new javax.swing.JList<>(); // Initialize reviewsList
        reviewsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(reviewsList); // Set reviewsList to jScrollPane3

        jLabel1 = new javax.swing.JLabel(); // Initialize vendorIdLabel
        jLabel1.setText("Vendor ID: " + custAcc.getId());
        jScrollPane2.setViewportView(jLabel1);
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REVIEWS");
        jScrollPane1.setViewportView(jLabel1);

        jScrollPane3.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(333, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void setReviews(List<String> reviews) {
        StringBuilder reviewsText = new StringBuilder("<html>");
        for (String review : reviews) {
            reviewsText.append(review).append("<br>");
        }
        reviewsText.append("</html>");

        jLabel1.setText(reviewsText.toString());
    }
    
     public static List<String> fetchReviewsFromFeedbackFile() {
        List<String> reviews = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(reviewFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                reviews.add( line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reviews;
    }
    
     public List<String> fetchReviewsForVendor() {
        List<String> reviews = new ArrayList<>();
        DefaultListModel<String> model = new DefaultListModel<>(); // Use DefaultListModel to dynamically update JList

        String vendorId = custAcc.getId(); // Use the getVendorId method
        try (BufferedReader reader = new BufferedReader(new FileReader(reviewFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] reviewData = line.split(",");
                if (reviewData.length == 7 && reviewData[4].equals(vendorId)) {
                    String formattedReview = String.format(
                            "Vendor ID: %s, Review ID: %s, Date: %s, Time: %s, Customer ID: %s, Rating: %s, Feedback: %s",
                            reviewData[4], reviewData[0], reviewData[1], reviewData[2], reviewData[3],
                            reviewData[5], reviewData[6]
                    );
                    reviews.add(formattedReview);
                    model.addElement(formattedReview); // Add formatted review to the model
                }
            }
            reviewsList.setModel(model); // Set the model to the reviewsList
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reviews;
    }
    public static void main(String args[]) {
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerREVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerREVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerREVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerREVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Customer customer = new Customer("1");
                CustomerREVIEW reviewForm = new CustomerREVIEW();
                List<String> reviews = fetchReviewsFromFeedbackFile();
                reviewForm.setReviews(reviews);
                reviewForm.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

   
}
