/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Subjects;

import App.DAC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Skshaya
 */
public class AddSubjects extends javax.swing.JFrame {

    /**
     * Creates new form AddSubjects
     */
    Connection conn = null;
    ResultSet rs = null;
    ResultSet rs2 = null;
    PreparedStatement pst = null;

    public AddSubjects() {
        initComponents();
        conn = DAC.ConnectDb();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        searchBar1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        all = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        nameL = new javax.swing.JList();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Subject");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 204, 0));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 640, 54));

        jLabel1.setBackground(new java.awt.Color(255, 204, 0));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 358, 640, 31));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Subject Details");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 330, 30));

        jLabel3.setText("Subject Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 100, -1));

        jLabel4.setText("Subject ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 80, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 140, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 140, -1));

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, -1, -1));

        searchBar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBar1ActionPerformed(evt);
            }
        });
        searchBar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBar1KeyReleased(evt);
            }
        });
        getContentPane().add(searchBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 190, 30));

        all.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        all.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(all);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 60, 170));

        nameL.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        jScrollPane3.setViewportView(nameL);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 130, 170));

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 80, -1));

        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

//Add New Subject
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int n = JOptionPane.showConfirmDialog(null, "Confirm Add!", "", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_NO_OPTION) {

            try {

                String sub_ID = jTextField2.getText();
                String sub_Name = jTextField1.getText();

                //Connection conn = DAC.ConnectDb();
                Statement stmt = conn.createStatement();
                String query = "INSERT INTO subject(id, name) VALUES ('" + sub_ID + "','" + sub_Name + "')";
                int a = stmt.executeUpdate(query);

            } catch (Exception e) {

            }
            JOptionPane.showMessageDialog(this, "Successfully Added!");
            int s = JOptionPane.showConfirmDialog(null, "Do you Want to Continue!", "", JOptionPane.YES_NO_OPTION);
            if (s == JOptionPane.YES_NO_OPTION) {
            } else {

                System.exit(0);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Cancelled Added!");
            System.exit(0);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    //Clear the Form
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultListModel m = new DefaultListModel();
        DefaultListModel m2 = new DefaultListModel();

        jTextField1.setText(null);
        jTextField2.setText(null);

        m.clear();
        nameL.setModel(m);
        m2.clear();
        all.setModel(m2);
    }//GEN-LAST:event_jButton1ActionPerformed


    private void searchBar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBar1ActionPerformed

    //To Search Teachers name and ID
    private void searchBar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBar1KeyReleased
        DefaultListModel m = new DefaultListModel();
        DefaultListModel m2 = new DefaultListModel();

        if (!searchBar1.getText().equals("")) {
            try {

                String sql = "SELECT * FROM subject";

                pst = conn.prepareStatement(sql);

                rs = pst.executeQuery();

                while (rs.next()) {

                    String sub_ID = rs.getString("id");
                    String sub_name = rs.getString("name");

                    m.addElement(sub_name);
                    m2.addElement(sub_ID);

                }

                nameL.setModel(m);
                all.setModel(m2);

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e, "error", JOptionPane.ERROR_MESSAGE);

            }finally {

            try {

                rs.close();
                pst.close();

            } catch (Exception e) {
            }

        }
        } else {

        }
    }//GEN-LAST:event_searchBar1KeyReleased

    //Click the needed Teacher's ID from list and add it in the Teacher's ID column.
    private void allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allMouseClicked
        String tmp = (String) all.getSelectedValue();
        String sql = "SELECT * FROM subject WHERE id=?";
        try {
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("name");

                searchBar1.setText("");
                String add2 = rs.getString("id");

                jTextField2.setText(add2);
            }

        } catch (Exception e) {

        }finally {

            try {

                rs.close();
                pst.close();

            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_allMouseClicked

    //Update the subject's details
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int n = JOptionPane.showConfirmDialog(null, "Confirm Update!", "", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_NO_OPTION) {
            try {
                String sql = "UPDATE subject SET name='" + jTextField1.getText() + "' WHERE id='" + jTextField2.getText() + "'";
                pst = conn.prepareStatement(sql);
                pst.executeUpdate();

            } catch (Exception e) {

            }finally {

            try {

                rs.close();
                pst.close();

            } catch (Exception e) {
            }

        }
            JOptionPane.showMessageDialog(this, "Successfully Updated!");
            int s = JOptionPane.showConfirmDialog(null, "Do you Want to Continue!", "", JOptionPane.YES_NO_OPTION);
            if (s == JOptionPane.YES_NO_OPTION) {
            } else {

                System.exit(0);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Cancelled Updated!");
            System.exit(0);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    //Search the particular details
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            Statement stmt = conn.createStatement();

            String query1 = "SELECT * FROM subject WHERE id='" + jTextField2.getText() + "'";

            rs = stmt.executeQuery(query1);

            while (rs.next()) {

                jTextField1.setText(rs.getString("name"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }finally {

            try {

                rs.close();
                pst.close();

            } catch (Exception e) {
            }

        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int n = JOptionPane.showConfirmDialog(null, "Confirm Delete", "", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_NO_OPTION) {

            try {

                String tmp = (String) all.getSelectedValue();
                pst = conn.prepareStatement("DELETE  FROM subject WHERE id =?");

                pst.setString(1, tmp);

                pst.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }finally {

            try {

                rs.close();
                pst.close();

            } catch (Exception e) {
            }

        }
            JOptionPane.showMessageDialog(this, "Successfully Deleted");
            int s = JOptionPane.showConfirmDialog(null, "Do you Want to Continue!", "", JOptionPane.YES_NO_OPTION);
            if (s == JOptionPane.YES_NO_OPTION) {
            } else {

                System.exit(0);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Cancelled delete!");
            System.exit(0);
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    //Main Method
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
            java.util.logging.Logger.getLogger(AddSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSubjects().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList all;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JList nameL;
    private javax.swing.JTextField searchBar1;
    // End of variables declaration//GEN-END:variables

}
