
import java.beans.Statement;
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
public class UpdateDonor extends javax.swing.JFrame {
    Connection conn = null;
    
    

    /**
     * Creates new form Donor
     */
    public UpdateDonor() {
        initComponents();
        showDonorList(query);
        tableDonor.setAutoCreateRowSorter(true);
    }
    String query = "SELECT * FROM donor";
    public ArrayList<Donor> getDonorList(String SelectQuery) {
        ArrayList<Donor> donorList = new ArrayList<>();
        conn = DbConnection.ConnectDb();
        String selectQuery = "SELECT * FROM donor";
        
        try {
            PreparedStatement pst = conn.prepareStatement(selectQuery);
            ResultSet rs = pst.executeQuery();
            Donor donor;
            
            while(rs.next()) {
            String id1 = rs.getString("dId");
            String id2 = rs.getString("id");
                donor = new Donor(id1 + id2,rs.getString("name"),rs.getString("email"),rs.getString("address"),Integer.parseInt(rs.getString("contact")),
                rs.getString("gender"),rs.getString("dateOfBirth"),rs.getString("bloodGroup"));
                donorList.add(donor);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Donor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return donorList; 
    }
    
    
    public void showDonorList(String orderQuery) {
        ArrayList<Donor> list = getDonorList(orderQuery);
        DefaultTableModel model = (DefaultTableModel) tableDonor.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[8];
        for(int i=0; i < list.size(); i++) {
            
            row[0] = list.get(i).getDonorId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getEmail();
            row[3] = list.get(i).getAddress();
            row[4] = list.get(i).getContact();
            row[5] = list.get(i).getGender();
            row[6] = list.get(i).getDateOfBirth();
            row[7] = list.get(i).getBloodGroup();
            
            model.addRow(row);
        }
        tableDonor.setModel(model);
    }
    
    public void searchDonor(String query){
        DefaultTableModel model = (DefaultTableModel) tableDonor.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        tableDonor.setRowSorter(trs);
        
        trs.setRowFilter(RowFilter.regexFilter(query));
    }
    /*public void sort() {
        DefaultTableModel model = (DefaultTableModel) tableDonor.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        tableDonor.setRowSorter(sorter); 
    }*/
    
    public void showDonor(int index) throws ParseException {
        AddDonor ad = new AddDonor();
        
        ad.txtDonor.setText(getDonorList(query).get(index).getName());
        ad.txtEmail.setText(getDonorList(query).get(index).getEmail());
        ad.txtAddress.setText(getDonorList(query).get(index).getAddress());
        ad.txtContact.setText(Integer.toString(getDonorList(query).get(index).getContact()));
        
        if(getDonorList(query).get(index).getGender().equals("male")) {
                    ad.male.setSelected(true);
                    ad.female.setSelected(false);
                    ad.gender = "male";
                }
                else {
                    ad.female.setSelected(true);
                    ad.male.setSelected(false);
                    ad.gender = "female";
                }
        Date addDate = new SimpleDateFormat("yyyy-MMM-dd").parse((String)getDonorList(query).get(index).getDateOfBirth());
        ad.txtDateOfBirth.setDate(addDate);
        
        for(int i=0; i < ad.selectBlood.getItemCount(); i++) {
            String blood = getDonorList(query).get(index).getBloodGroup();
            if(ad.selectBlood.getItemAt(i).equals(blood)) {
                ad.selectBlood.setSelectedIndex(i);
                    }
        }
        ad.txtDonorId.setText(getDonorList(query).get(index).getDonorId().substring(3,6));
        ad.setVisible(true);
        ad.buttonSave.setEnabled(false);
        ad.buttonReset.setEnabled(false);
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
        txtBgroup = new javax.swing.JTextField();
        txtDname = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDonor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1928, 1081));

        jPanel1.setBackground(new java.awt.Color(51, 0, 102));

        txtBgroup.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        txtBgroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBgroupActionPerformed(evt);
            }
        });

        txtDname.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        txtDname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDnameActionPerformed(evt);
            }
        });

        txtId.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Blood Group");

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
        jLabel4.setText("Donor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBgroup, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(89, 89, 89)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDname, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel4))
                .addGap(133, 133, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDname, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBgroup, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        tableDonor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tableDonor.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        tableDonor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DonorId", "Name", "Email", "Address", "Contact", "Gender", "DateOfBirth", "BloodGrup"
            }
        ));
        tableDonor.setRowHeight(25);
        tableDonor.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                tableDonorAncestorRemoved(evt);
            }
        });
        tableDonor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDonorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDonor);
        if (tableDonor.getColumnModel().getColumnCount() > 0) {
            tableDonor.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 637, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1518, 697));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBgroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBgroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBgroupActionPerformed

    private void txtDnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDnameActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int index = tableDonor.getSelectedRow();
        if(tableDonor.isRowSelected(index)) {
            try {
                this.dispose();
                showDonor(index);
            } catch (ParseException ex) {
                Logger.getLogger(UpdateDonor.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else {
            this.dispose();
            AddDonor addDonor = new AddDonor();
            addDonor.setVisible(true);
            addDonor.buttonUpdate.setEnabled(false);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tableDonorAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tableDonorAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tableDonorAncestorRemoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!txtId.getText().equals("")) {
            conn = DbConnection.ConnectDb();
            String selectQuery = "DELETE FROM donor WHERE id =?";
            
            try {
                PreparedStatement pst = conn.prepareStatement(selectQuery);
                String donorId = txtId.getText();
                int id1 = Integer.parseInt(donorId);
                pst.setInt(1, id1);
                pst.executeUpdate();
                showDonorList(query);
                txtId.setText("");
                txtDname.setText("");
                txtBgroup.setText("");
                JOptionPane.showMessageDialog(null, "Donor deleted");
                
            } catch (SQLException ex) {
                Logger.getLogger(UpdateDonor.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Donor not deleted");
            }
        
        }
        else {
            JOptionPane.showMessageDialog(null, "Donor not deleted : No Id to Delete");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableDonorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDonorMouseClicked
        int index = tableDonor.getSelectedRow();
        
        String id = getDonorList(query).get(index).getDonorId().substring(3,6);
        txtId.setText(id);
        txtDname.setText(getDonorList(query).get(index).getName());
        txtBgroup.setText(getDonorList(query).get(index).getBloodGroup());
        
    }//GEN-LAST:event_tableDonorMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        /*int index = tableDonor.getRowCount();
        
        if(txtDname.getText().equals("") && txtBgroup.getText().equals("")) {
            for(int i = 0; i < index; i++) {
            String x = getDonorList(query).get(i).getDonorId();
            if(txtId.getText().equals(x)) {
                    String query2 = txtId.getText();
                    searchDonor(query2);
                }
            }
        }*/
        /*else if(txtId.getText().equals("") && txtBgroup.getText().equals("")) {
            for(int i = 0; i < index; i++) {
            String y = getDonorList(query).get(i).getName();
            if(txtDname.getText().equals(y)) {
                    String query1 = txtDname.getText();
                    searchDonor(query1);
                }
            }
        }*/
        if(txtDname.getText().equals("") && txtBgroup.getText().equals("")) {
            String id = txtId.getText().substring(3,6);
            String searchQuery = "SELECT * FROM donor WHERE id ='"+id+"'";
            try {
                PreparedStatement pst = conn.prepareStatement(searchQuery);
                ResultSet rs = pst.executeQuery();
                tableDonor.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                Logger.getLogger(UpdateDonor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(txtId.getText().equals("") && txtBgroup.getText().equals("")) {
            String name = txtDname.getText();
            String searchQuery = "SELECT * FROM donor WHERE name ='"+name+"'";
            try {
                PreparedStatement pst = conn.prepareStatement(searchQuery);
                ResultSet rs = pst.executeQuery();
                tableDonor.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                Logger.getLogger(UpdateDonor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(txtId.getText().equals("") && txtDname.getText().equals("")) {
            String blood = txtBgroup.getText();
            String searchQuery = "SELECT * FROM donor WHERE bloodGroup ='"+blood+"'";
            try {
                PreparedStatement pst = conn.prepareStatement(searchQuery);
                ResultSet rs = pst.executeQuery();
                tableDonor.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                Logger.getLogger(UpdateDonor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //String id = txtId.getText();
        /*query = "SELECT * FROM donor ORDER BY bloodGroup ASC";
        showDonorList(query);*/
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased

    }//GEN-LAST:event_txtIdKeyReleased

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
                new UpdateDonor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDonor;
    private javax.swing.JTextField txtBgroup;
    private javax.swing.JTextField txtDname;
    public javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
