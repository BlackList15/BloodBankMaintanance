
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ashik
 */
public class UpdateHospital extends javax.swing.JFrame {
    Connection conn = null;
    /**
     * Creates new form UpdateDonor
     */
    public UpdateHospital() {
        initComponents();
        showHospitalList();
        tableHospital.setAutoCreateRowSorter(true);
    }

     public ArrayList<Hospital> getHospitalList() {
        ArrayList<Hospital> hospitalList = new ArrayList<Hospital>();
        conn = DbConnection.ConnectDb();
        String selectQuery = "SELECT * FROM hospital";
        
        try {
            PreparedStatement pst = conn.prepareStatement(selectQuery);
            ResultSet rs = pst.executeQuery();
            Hospital hospital;
            
            while(rs.next()) {
            String id1 = rs.getString("hId");
            String id2 = rs.getString("id");
                hospital = new Hospital(id1 + id2,rs.getString("hosName"),Integer.parseInt(rs.getString("hosContact")),rs.getString("address"),Float.parseFloat(rs.getString("disFromHere")),
                rs.getString("cheifDocName"),Integer.parseInt(rs.getString("CheifDocCon")));
                hospitalList.add(hospital);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hospitalList; 
    }
     
      public void showHospitalList() {
        ArrayList<Hospital> list = getHospitalList();
        DefaultTableModel model = (DefaultTableModel) tableHospital.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[7];
        for(int i=0; i < list.size(); i++) {
            
            row[0] = list.get(i).getHospitalId();
            row[1] = list.get(i).getHosName();
            row[2] = list.get(i).getHosContact();
            row[3] = list.get(i).getAddress();
            row[4] = list.get(i).getDisFromHere();
            row[5] = list.get(i).getCheifDocName();
            row[6] = list.get(i).getCheifDocCon();
           
            
            model.addRow(row);
        }
        
    }
      
    public void searchHospital(String query){
        DefaultTableModel model = (DefaultTableModel) tableHospital.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
        tableHospital.setRowSorter(trs);
        
        trs.setRowFilter(RowFilter.regexFilter(query));
    }
    
     public void showHospitalList(int index) throws ParseException {
        AddHospital ah = new AddHospital();
        
        ah.txtHospital.setText(getHospitalList().get(index).getHosName());
        ah.txtContact.setText(Integer.toString(getHospitalList().get(index).getHosContact()));
        ah.txtAddress.setText(getHospitalList().get(index).getAddress());
        ah.txtDistance.setText(Float.toString(getHospitalList().get(index).getDisFromHere()));
        ah.txtDoctor.setText(getHospitalList().get(index).getCheifDocName());
        ah.txtDocContact.setText(Integer.toString(getHospitalList().get(index).getCheifDocCon()));
        ah.txtHospitalId.setText(getHospitalList().get(index).getHospitalId().substring(1,4));
        
        
       
        ah.setVisible(true);
        ah.btnSave.setEnabled(false);
        ah.btnReset.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtHospitalName = new javax.swing.JTextField();
        txtHospitalId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHospital = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1928, 1081));

        jPanel1.setBackground(new java.awt.Color(51, 0, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(545, 637));

        txtHospitalName.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        txtHospitalName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHospitalNameActionPerformed(evt);
            }
        });

        txtHospitalId.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        txtHospitalId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHospitalIdActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jButton3.setText("Add/Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        jLabel4.setText("Hospital");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHospitalName, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHospitalId, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(51, 146, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtHospitalId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHospitalName, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(936, 666));

        tableHospital.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        tableHospital.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hospital Id", "Hospital Name", "Hospital Contact", "Address", "Distance", "Chief Doctor", "Chief Doctor Contact"
            }
        ));
        tableHospital.setRowHeight(25);
        tableHospital.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHospitalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableHospital);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1518, 697));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtHospitalNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHospitalNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHospitalNameActionPerformed

    private void txtHospitalIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHospitalIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHospitalIdActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int index = tableHospital.getSelectedRow();
        if(tableHospital.isRowSelected(index)) {
            this.dispose();
            try {
                showHospitalList(index);
            } catch (ParseException ex) {
                Logger.getLogger(UpdateDonor.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else {
            this.dispose();
            AddHospital addHospital = new AddHospital();
            addHospital.setVisible(true);
            addHospital.updateButton.setEnabled(false);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if(!txtHospitalId.getText().equals("")) {
            conn = DbConnection.ConnectDb();
            String selectQuery = "DELETE FROM hospital WHERE id =?";
            
            try {
                PreparedStatement pst = conn.prepareStatement(selectQuery);
                String hospitalId = txtHospitalId.getText();
                int id1 = Integer.parseInt(hospitalId);
                pst.setInt(1, id1);
                pst.executeUpdate();
                showHospitalList();
                txtHospitalId.setText("");
                txtHospitalName.setText("");
                JOptionPane.showMessageDialog(null, "Hospital deleted");
                
            } catch (SQLException ex) {
                Logger.getLogger(UpdateDonor.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Hospital not deleted");
            }
        
        }
        else {
            JOptionPane.showMessageDialog(null, "Hospital not deleted : No Id to Delete");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        /*int index = tableHospital.getRowCount();
        
        if(txtHospitalName.getText().equals("")) {
            for(int i = 0; i < index; i++) {
            String x = getHospitalList().get(i).getHospitalId();
            if(txtHospitalId.getText().equals(x)) {
                    String query2 = txtHospitalId.getText();
                    searchHospital(query2);
                }
            }
        }
        else if(txtHospitalId.getText().equals("")) {
            String y = getHospitalList().get(i).getHosName();
            if(txtHospitalName.getText().equals(y)) {
                    String query = txtHospitalName.getText();
                    searchHospital(query);
                }
        }*/
        if(txtHospitalName.getText().equals("")) {
            String id = txtHospitalId.getText().substring(1,4);
            String searchQuery = "SELECT * FROM hospital WHERE id ='"+id+"'";
            try {
                PreparedStatement pst = conn.prepareStatement(searchQuery);
                ResultSet rs = pst.executeQuery();
                tableHospital.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                Logger.getLogger(UpdateDonor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(txtHospitalId.getText().equals("")) {
            String name = txtHospitalName.getText();
            String searchQuery = "SELECT * FROM hospital WHERE hosName ='"+name+"'";
            try {
                PreparedStatement pst = conn.prepareStatement(searchQuery);
                ResultSet rs = pst.executeQuery();
                tableHospital.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                Logger.getLogger(UpdateDonor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableHospitalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHospitalMouseClicked
        int index = tableHospital.getSelectedRow();
        
        txtHospitalId.setText(getHospitalList().get(index).getHospitalId().substring(1,4));
        txtHospitalName.setText(getHospitalList().get(index).getHosName());
    }//GEN-LAST:event_tableHospitalMouseClicked

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
            java.util.logging.Logger.getLogger(UpdateDonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateDonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateDonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateDonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateHospital().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableHospital;
    public javax.swing.JTextField txtHospitalId;
    private javax.swing.JTextField txtHospitalName;
    // End of variables declaration//GEN-END:variables
}
