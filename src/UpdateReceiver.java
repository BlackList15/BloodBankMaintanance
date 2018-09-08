
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ashik
 */
public class UpdateReceiver extends javax.swing.JFrame {
    Connection conn = null;
    /**
     * Creates new form UpdateReceiver
     */
    public UpdateReceiver() {
        initComponents();
        showReceiverList();
        tableReceiver.setAutoCreateRowSorter(true);
    }
    
     public ArrayList<Receiver> getReceiverList() {
        ArrayList<Receiver> receiverList = new ArrayList<Receiver>();
        conn = DbConnection.ConnectDb();
        String selectQuery = "SELECT * FROM receiver";
        
        try {
            PreparedStatement pst = conn.prepareStatement(selectQuery);
            ResultSet rs = pst.executeQuery();
            Receiver receiver;
            
            while(rs.next()) {
                receiver = new Receiver(rs.getString("patientName"),rs.getString("hospital"),rs.getString("hospitalAddress"),rs.getString("chiefDoctor"),rs.getString("bloodGroup"),rs.getString("donorId"),rs.getString("donorName"),rs.getString("bagNo"),rs.getString("transactionDate"));
                receiverList.add(receiver);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Donor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return receiverList; 
    }

     public void showReceiverList() {
        ArrayList<Receiver> list = getReceiverList();
        DefaultTableModel model = (DefaultTableModel) tableReceiver.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[9];
        for(int i=0; i < list.size(); i++) {
            
            row[0] = list.get(i).getPatientNm();
            row[1] = list.get(i).getHospital();
            row[2] = list.get(i).getHosAddress();
            row[3] = list.get(i).getChiefDoc();
            row[4] = list.get(i).getBlGroup();
            row[5] = list.get(i).getDonId();
            row[6] = list.get(i).getDonName();
            row[7] = list.get(i).getBgNo();
            row[8] = list.get(i).getTrDate();
                    
            model.addRow(row);
        }
        
    }
     
    public void searchReceiver(String query){
        DefaultTableModel model = (DefaultTableModel) tableReceiver.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
        tableReceiver.setRowSorter(trs);
        
        trs.setRowFilter(RowFilter.regexFilter(query));
    }
  
     public void showReceiver(int index) throws ParseException {
        AddReceiver ar = new AddReceiver();
        
        ar.txtPatient.setText(getReceiverList().get(index).getPatientNm());
        
        for(int i=0; i < ar.selectHospital.getItemCount(); i++) {
            String hos = getReceiverList().get(index).getHospital();
            if(ar.selectHospital.getItemAt(i).equals(hos)) {
                ar.selectHospital.setSelectedIndex(i);
                    }
        }
        
        ar.txtHospitalAddress.setText(getReceiverList().get(index).getHosAddress());
        
        ar.txtChiefDoctor.setText(getReceiverList().get(index).getChiefDoc());
        
        for(int i=0; i < ar.selectBloodGroup.getItemCount(); i++) {
            String bgrp = getReceiverList().get(index).getBlGroup();
            if(ar.selectBloodGroup.getItemAt(i).equals(bgrp)) {
                ar.selectBloodGroup.setSelectedIndex(i);
                    }
        }
        
        for(int i=0; i < ar.selectBloodBag.getItemCount(); i++) {
            String bgno = getReceiverList().get(index).getBgNo();
            if(ar.selectBloodBag.getItemAt(i).equals(bgno)) {
                ar.selectBloodBag.setSelectedIndex(i);
                    }
        }
        
        ar.txtDonorId.setText(getReceiverList().get(index).getDonId());
        ar.txtDonorName.setText(getReceiverList().get(index).getDonName());
       
        Date trDate = new SimpleDateFormat("yyyy-MMM-dd").parse((String)getReceiverList().get(index).getTrDate());
        ar.txtTransactionDate.setDate(trDate);
        
        
        ar.setVisible(true);
        ar.btnSave.setEnabled(false);
        ar.btnReset.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtReceiverBloodGroup = new javax.swing.JTextField();
        txtReceiverName = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableReceiver = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1928, 1081));

        jPanel2.setBackground(new java.awt.Color(51, 0, 102));

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        jLabel4.setText("Receiver");

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Blood Group");

        txtReceiverBloodGroup.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        txtReceiverBloodGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReceiverBloodGroupActionPerformed(evt);
            }
        });

        txtReceiverName.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        txtReceiverName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReceiverNameActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jButton3.setText("Add/View");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(937, 937, 937))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(155, 155, 155)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtReceiverBloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtReceiverName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addGap(102, 102, 102)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtReceiverName, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addComponent(txtReceiverBloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));

        tableReceiver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient Name", "Hospital", "Hospital Address", "Chief Doctor", "Blood Group", "Donor Id", "Donor Name", "Bag No", "Transaction Date"
            }
        ));
        tableReceiver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableReceiverMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableReceiver);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtReceiverBloodGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReceiverBloodGroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReceiverBloodGroupActionPerformed

    private void txtReceiverNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReceiverNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReceiverNameActionPerformed
    
    private void tableReceiverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableReceiverMouseClicked
         int index = tableReceiver.getSelectedRow();
        
        txtReceiverName.setText(getReceiverList().get(index).getPatientNm());
        txtReceiverBloodGroup.setText(getReceiverList().get(index).getBlGroup());
    }//GEN-LAST:event_tableReceiverMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int index = tableReceiver.getSelectedRow();
        if(tableReceiver.isRowSelected(index)) {
            try {
                showReceiver(index);
            } catch (ParseException ex) {
                Logger.getLogger(UpdateDonor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            AddReceiver addReceiver = new AddReceiver();
            addReceiver.setVisible(true);
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    
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
            java.util.logging.Logger.getLogger(UpdateReceiver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateReceiver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateReceiver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateReceiver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateReceiver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableReceiver;
    private javax.swing.JTextField txtReceiverBloodGroup;
    private javax.swing.JTextField txtReceiverName;
    // End of variables declaration//GEN-END:variables
}
