/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.teacher;

import App.DAC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Buddhika
 */
public class MarksAllocation extends javax.swing.JFrame {
   int count = 0;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    ResultSet rs2 = null;
    PreparedStatement pst2 = null;
    /**
     * Creates new form Home
     */
    public MarksAllocation() {
        initComponents();
        conn = DAC.ConnectDb();
jTextField3.setText("100");
FillcomboSub();
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
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        presentStd = new javax.swing.JTable();
        classCombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        divCombo = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        nameTxt = new javax.swing.JTextField();
        idTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Mytb3 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        imsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 204, 0));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 830, 31));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Exam Mark Allocation");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 230, 20));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Students"));

        presentStd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "SID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        presentStd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                presentStdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(presentStd);
        if (presentStd.getColumnModel().getColumnCount() > 0) {
            presentStd.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        classCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));
        classCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classComboActionPerformed(evt);
            }
        });

        jLabel5.setText("Class");

        jLabel6.setText("Division");

        divCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "A", "B", "C", "D", "E", "F", "G", "H", "I" }));
        divCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                divComboItemStateChanged(evt);
            }
        });
        divCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                divComboMouseClicked(evt);
            }
        });
        divCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(classCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(divCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(classCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(divCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 117, 250, 330));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Student Mark Allocation"));

        nameTxt.setEditable(false);

        idTxt.setEditable(false);

        jLabel8.setText("SID");

        jLabel7.setText("Name");

        jLabel15.setText("Marks Out of");

        jTextField3.setEditable(false);

        jLabel16.setText("Marks Obtain");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idTxt))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameTxt))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(jTextField4))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(97, 97, 97))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, 320));

        jLabel2.setBackground(new java.awt.Color(255, 204, 0));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 830, 54));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Marked Students"));

        Mytb3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "SID", "Subject", "Mark"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Mytb3);
        if (Mytb3.getColumnModel().getColumnCount() > 0) {
            Mytb3.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 260, 310));

        jButton2.setText("Enter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 150, -1));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "1st", "2nd", "3rd" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 70, -1));

        jLabel12.setText("Term");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        jComboBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox8ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 110, -1));

        jLabel14.setText("Subject");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        imsg.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(imsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 260, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void fillData() {
        try {

            String sql = "SELECT sID, fname,lname FROM student WHERE class='" + classCombo.getSelectedIndex() + "' AND div='" + divCombo.getSelectedItem().toString() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            presentStd.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "error", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(null,"Connection Disconnected, Reconnecting... Please wait..", "error", JOptionPane.ERROR_MESSAGE);

        } finally {

            try {

                rs.close();
                pst.close();

            } catch (Exception e) {
            }

        }

    }
 private void FillcomboSub() {
      //  searchCombo.removeAllItems();
        try {
             jComboBox8.removeAllItems();
         jComboBox8.addItem("Select");
            String sql = "SELECT * FROM subject";
            pst2 = conn.prepareStatement(sql);
            rs2 = pst2.executeQuery();

            while (rs2.next()) {
                String name = rs2.getString("name");
                jComboBox8.addItem(name);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(null,"Connection Disconnected, Reconnecting... Please wait..", "error", JOptionPane.ERROR_MESSAGE);
        }finally {

            try {

                rs2.close();
                pst2.close();

            } catch (Exception e) {
            }

        }

    }
  private void fillDataMarked() {
        try {

            String sql = "SELECT sID,subject,mark FROM mark WHERE term='" + jComboBox6.getSelectedItem().toString()+ "' AND subject='" + jComboBox8.getSelectedItem().toString() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Mytb3.setModel(DbUtils.resultSetToTableModel(rs));
           // System.out.println(sql);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(null,"Connection Disconnected, Reconnecting... Please wait..", "error", JOptionPane.ERROR_MESSAGE);

        } finally {

            try {

                rs.close();
                pst.close();

            } catch (Exception e) {
            }

        }

    }
    private void divComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_divComboMouseClicked
        //fillData();        // TODO add your handling code here:
    }//GEN-LAST:event_divComboMouseClicked

    private void divComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_divComboItemStateChanged
        fillData();   // TODO add your handling code here:
    }//GEN-LAST:event_divComboItemStateChanged

    private void presentStdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_presentStdMouseClicked
        try {
            int row = presentStd.getSelectedRow();
            String table_click = presentStd.getModel().getValueAt(row, 0).toString();
            System.out.println(table_click);
            String sql = "SELECT * FROM student WHERE sID='"+table_click+"' " ;
            pst2 = conn.prepareStatement(sql);
            rs2 = pst2.executeQuery();
            if (rs2.next()) {

                String add1 = rs2.getString("sID");
                idTxt.setText(add1);
                System.out.println(add1);
                String add2 = rs2.getString("fname");
            
                String add4 = rs2.getString("lname");
                nameTxt.setText(add2 + " " + add4);
                

            } else {
                System.out.println("Error!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {

            try {

                rs2.close();
                pst2.close();

            } catch (Exception e) {
            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_presentStdMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 try {

            String sql = "INSERT INTO mark(term,subject,sID,mark) VALUES(?,?,?,?)";

            pst = conn.prepareStatement(sql);
            pst.setString(1, jComboBox6.getSelectedItem().toString());
            pst.setString(2, jComboBox8.getSelectedItem().toString());
            pst.setString(3, idTxt.getText());
            pst.setString(4, jTextField4.getText());
         

            int a = pst.executeUpdate();
            if (a > 0) {
 
       /// Fillcombo();  
                //  String sql2="INSERT INTO student(sID,fname,lname,contactno,DOB,email,gender,address) VALUES(?,?,?,?,?,?,?,?)";
                JOptionPane.showMessageDialog(null, "SAVED", "Successful", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "NOTSAVED", "NOTSuccessful", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            // conn = Mysqlconnect.ConnDb();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(null,"Connection Disconnected, Reconnecting... Please wait..", "error", JOptionPane.ERROR_MESSAGE);

        }finally {

            try {

                rs.close();
                pst.close();

            } catch (Exception e) {
            }

        }
 
fillDataMarked();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void classComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classComboActionPerformed

    private void divComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_divComboActionPerformed

    private void jComboBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox8ActionPerformed

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
                if ("GTK".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MarksAllocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarksAllocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarksAllocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarksAllocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarksAllocation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Mytb3;
    private javax.swing.JComboBox classCombo;
    private javax.swing.JComboBox divCombo;
    private javax.swing.JTextField idTxt;
    private javax.swing.JLabel imsg;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTable presentStd;
    // End of variables declaration//GEN-END:variables
}
