
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ashik
 */
public class BloodStocks extends javax.swing.JFrame {
    
    Connection conn = null;
    /**
     * Creates new form BloodStocks
     */
    public BloodStocks() throws ParseException {
        initComponents();
        showBloodList();
        showBloodExpirationdateList();
        tableStock.setAutoCreateRowSorter(true);
    }
    
    public ArrayList<Blood> getBloodList() {
        ArrayList<Blood> bloodList = new ArrayList<>();
        conn = DbConnection.ConnectDb();
        String selectQuery = "SELECT * FROM bloodbag";
        
        try {
            PreparedStatement pst = conn.prepareStatement(selectQuery);
            ResultSet rs = pst.executeQuery();
            Blood blood;
            
            while(rs.next()) {
                blood = new Blood(rs.getString("Bgroup"),rs.getString("Bvolume"));
                bloodList.add(blood);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Donor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bloodList; 
    }
    
    int volumeOp,volumeOn,volumeAp,volumeAn,volumeBp,volumeBn,volumeABp,volumeABn;
    public void showBloodList() {
        ArrayList<Blood> list = getBloodList();
        DefaultTableModel model = (DefaultTableModel) tableBlood.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[8];
        volumeOp = 0;
        volumeOn = 0;
        volumeAp = 0;
        volumeAn = 0;
        volumeBp = 0;
        volumeBn = 0;
        volumeABp = 0;
        volumeABn = 0;
        for(int i=0; i < list.size(); i++) {
            String bloodgroup = list.get(i).getbGroup();
            int volume = Integer.parseInt(list.get(i).getbVolume());
            
            switch(bloodgroup) {
                case "O+" : volumeOp = volumeOp + volume; break;
                case "O-" : volumeOn = volumeOn + volume; break;
                case "A+" : volumeAp = volumeAp + volume; break;
                case "A-" : volumeAn = volumeAn + volume; break;
                case "B+" : volumeBp = volumeBp + volume; break;
                case "B-" : volumeBn = volumeBn + volume; break;
                case "AB+" : volumeABp = volumeABp + volume; break;
                case "AB-" : volumeABn = volumeABn + volume; break;
                }
            }
            row[0] = volumeOp;
            row[1] = volumeOn;
            row[2] = volumeAp;
            row[3] = volumeAn;
            row[4] = volumeBp;
            row[5] = volumeBn;
            row[6] = volumeABp;
            row[7] = volumeABn;
            model.addRow(row);
        
    }
    
    public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
				
		return cal.getTime();
    }
    
    
    public ArrayList<Blood> getBloodExpirationdateList() throws ParseException {
        ArrayList<Blood> ExpirationList = new ArrayList<>();
        conn = DbConnection.ConnectDb();
        String selectQuery = "SELECT * FROM bloodbag";
        
        try {
            PreparedStatement pst = conn.prepareStatement(selectQuery);
            ResultSet rs = pst.executeQuery();
            Blood blood;
            
            while(rs.next()) {
                String id1 = rs.getString("bId");
                String id2 = rs.getString("Bno");
                
                String date1 = rs.getString("Ddate");
                Date date = new SimpleDateFormat("yyyy-MMM-dd").parse(date1);
                /*GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(date);
                cal.add(Calendar.MONTH, 3);
                Date edate = (Date) cal.getTime();*/
                Date edate = addDays(date, 90);
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd");
                String Edate = dateFormat.format(edate.getTime());
                
                blood = new Blood(id1 + id2,rs.getString("Bgroup"),rs.getString("Ddate"),Edate);
                ExpirationList.add(blood);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Donor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ExpirationList; 
    }
    int i=0;
    public void showBloodExpirationdateList() throws ParseException {
        ArrayList<Blood> list = getBloodExpirationdateList();
        DefaultTableModel model = (DefaultTableModel) tableStock.getModel();
        
        model.setRowCount(0);

        Object[] row = new Object[4];
        for(i=0; i < list.size(); i++) {
            
            row[0] = list.get(i).getBBid();
            row[1] = list.get(i).getbGroup();
            row[2] = list.get(i).getDdate();
            row[3] = list.get(i).getEdate();
            
            model.addRow(row);
        }
        tableStock.setModel(model);
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBlood = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableStock = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1928, 1081));

        jPanel.setBackground(new java.awt.Color(51, 0, 102));

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 993, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        tableBlood.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        tableBlood.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-"
            }
        ));
        tableBlood.setRowHeight(30);
        jScrollPane1.setViewportView(tableBlood);
        if (tableBlood.getColumnModel().getColumnCount() > 0) {
            tableBlood.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableBlood.getColumnModel().getColumn(1).setPreferredWidth(30);
            tableBlood.getColumnModel().getColumn(2).setPreferredWidth(30);
            tableBlood.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableBlood.getColumnModel().getColumn(4).setPreferredWidth(30);
            tableBlood.getColumnModel().getColumn(5).setPreferredWidth(30);
            tableBlood.getColumnModel().getColumn(6).setPreferredWidth(30);
            tableBlood.getColumnModel().getColumn(7).setPreferredWidth(30);
        }

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 102));
        jButton1.setText("Show BarChart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tableStock.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        tableStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BloodBag No", "Blood Group", "Donation Date", "Expiration date"
            }
        ));
        tableStock.setRowHeight(20);
        jScrollPane2.setViewportView(tableStock);

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 102));
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 102));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 102));
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 102));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 102));
        jButton4.setText("Show PieChart");
        jButton4.setPreferredSize(new java.awt.Dimension(220, 49));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 133, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1668, 1047));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultCategoryDataset barchartdata = new DefaultCategoryDataset();
        barchartdata.setValue(volumeOp, "Stock Volume", "O+");
        barchartdata.setValue(volumeOn, "Stock Volume", "O-");
        barchartdata.setValue(volumeAp, "Stock Volume", "A+");
        barchartdata.setValue(volumeAn, "Stock Volume", "A-");
        barchartdata.setValue(volumeBp, "Stock Volume", "B+");
        barchartdata.setValue(volumeBn, "Stock Volume", "B-");
        barchartdata.setValue(volumeABp, "Stock Volume", "AB+");
        barchartdata.setValue(volumeABn, "Stock Volume", "AB-");
        
        JFreeChart barchart = ChartFactory.createBarChart("Blood Stock Record", "Blood Group", "Blood Volume", barchartdata, PlotOrientation.VERTICAL, true, true, false);
        
        CategoryPlot plot = new CategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        
        ChartFrame chartfrm = new ChartFrame("Blood Stock Record", barchart, true);
        chartfrm.setVisible(true);
        chartfrm.setLocation(130, 570);
        chartfrm.setSize(1000,500);
        chartfrm.setAlwaysOnTop(rootPaneCheckingEnabled);
        ChartPanel chartpanel = new ChartPanel(barchart);
        jPanel.removeAll();;
        jPanel.add(chartpanel, BorderLayout.CENTER);
        jPanel.validate();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int index = tableStock.getSelectedRow();
        if(tableStock.isRowSelected(index)) {
            conn = DbConnection.ConnectDb();
            String selectQuery = "DELETE FROM bloodbag WHERE Bno =?";
            
            try {
                try {
                    PreparedStatement pst = conn.prepareStatement(selectQuery);
                    String id = getBloodExpirationdateList().get(index).getBBid();
                    int id1 = Integer.parseInt(id.substring(2,5));
                    pst.setInt(1, id1);
                    pst.executeUpdate();
                    showBloodExpirationdateList();
                    showBloodList();
                } catch (ParseException ex) {
                    Logger.getLogger(BloodStocks.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Bloodbag Record deleted");
                
            } catch (SQLException ex) {
                Logger.getLogger(UpdateDonor.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Bloodbag Record not deleted");
            }
        
        }
        else {
            JOptionPane.showMessageDialog(null, "Hospital not deleted : No Id to Delete");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultPieDataset pieDataSet = new DefaultPieDataset();
        pieDataSet.setValue("O+", volumeOp);
        pieDataSet.setValue("O-", volumeOn);
        pieDataSet.setValue("A+", volumeAp);
        pieDataSet.setValue("A-", volumeAn);
        pieDataSet.setValue("B+", volumeBp);
        pieDataSet.setValue("B-", volumeBn);
        pieDataSet.setValue("AB+", volumeABp);
        pieDataSet.setValue("AB-", volumeABn);
        
        JFreeChart chart = ChartFactory.createPieChart("Blood Stock Record", pieDataSet, true, true, true);
        PiePlot p = (PiePlot) chart.getPlot();
        ChartFrame chartfrme = new ChartFrame("Blood Stock Record", chart);
        chartfrme.setVisible(true);
        chartfrme.setSize(1000,500);
        chartfrme.setLocation(130,70);
        chartfrme.setAlwaysOnTop(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(BloodStocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BloodStocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BloodStocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BloodStocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BloodStocks().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(BloodStocks.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableBlood;
    private javax.swing.JTable tableStock;
    // End of variables declaration//GEN-END:variables
}
