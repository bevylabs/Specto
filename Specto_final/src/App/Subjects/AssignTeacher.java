/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Subjects;

import App.DAC;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Buddhika
 */
public class AssignTeacher extends javax.swing.JFrame {

    //private Object conn;
    private int id;
  Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
        ResultSet rs2 = null;
    PreparedStatement pst2 = null;
    /**
     * Creates new form Home
     */
    public AssignTeacher() {
        initComponents();
        setLocationRelativeTo(null);
         conn = DAC.ConnectDb();
        FillCombo();
        setKey();
        fillTable();
        clearForm();

 FillcomboSub();
 Fillcombo();
    }
    
    private void FillcomboSub() {
      //  searchCombo.removeAllItems();
        try {
             SubjectCombo.removeAllItems();
         SubjectCombo.addItem("Select");
            String sql = "SELECT * FROM subject";
            pst2 = conn.prepareStatement(sql);
            rs2 = pst2.executeQuery();

            while (rs2.next()) {
                String name = rs2.getString("name");
                SubjectCombo.addItem(name);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(null,"Connection Disconnected, Reconnecting... Please wait..", "error", JOptionPane.ERROR_MESSAGE);
        }finally {

            try {

                rs2.close();
                pst2.close();

            } catch (Exception e) {
            }

        }

    }
    
    private void Fillcombo() {
      //  searchCombo.removeAllItems();
        try {
             TeacherCombo.removeAllItems();
            TeacherCombo.addItem("Search");
            String sql = "SELECT * FROM teacher";
            pst2 = conn.prepareStatement(sql);
            rs2 = pst2.executeQuery();

            while (rs2.next()) {
                String name = rs2.getString("tID");
                TeacherCombo.addItem(name);
                TeacherCombo1.addItem(name);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(null,"Connection Disconnected, Reconnecting... Please wait..", "error", JOptionPane.ERROR_MESSAGE);
        }finally {

            try {

                rs2.close();
                pst2.close();

            } catch (Exception e) {
            }

        }

    }

    void setKey() {

        JRootPane a = getRootPane(); //not change
        InputMap im = a.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW); //not change
        ActionMap am = a.getActionMap(); //not change

        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);//enter the enterkey  to save the details
        im.put(enter, "enter");
        am.put("enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDataToTable();//call to loaddata
            }
        });
    }

    void loadDataToTable() {

        try {

            DefaultTableModel dtm = (DefaultTableModel) Table.getModel();
            Vector v = new Vector();
            v.add(GradeCombo.getSelectedItem());
            v.add(DivitionCombo.getSelectedItem());
            v.add(SubjectCombo.getSelectedItem());
            v.add(TeacherCombo.getSelectedItem());

            dtm.addRow(v);

        } catch (Exception e) {
        }

    }

    private void clearForm() {

        name.setText("");
        division.setText("");
        subject.setText("");
        TeacherCombo1.setSelectedItem(null);
    }

    private void FillCombo() {
        try {
            Class.forName("org.sqlite.JDBC");
               Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Buddhika\\Documents\\NetBeansProjects\\Specto_final\\spectoMe.sqlite");
            Statement stmt = conn.createStatement();

            String sql = "SELECT * from  teacher_Information";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                String name = rs.getString("t_firstname");
                String Lname = rs.getString("t_lastname");
                TeacherCombo.addItem(name + " " + Lname);
                TeacherCombo1.addItem(name + " " + Lname);

            }

            

            String sql4 = "SELECT DISTINCT c_divition from  class_Table";

            ResultSet rs4 = stmt.executeQuery(sql4);

            

        } catch (Exception e) {
        }
    }

    private void fillTable() {

        Vector title = new Vector();
        title.add("Class");
        title.add("Divition");
        title.add("Subject");
        title.add("Teacher");

        Vector outer = new Vector();

        try {
            Class.forName("org.sqlite.JDBC");
               Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Buddhika\\Documents\\NetBeansProjects\\Specto_final\\spectoMe.sqlite");
            String sql = "select * from Teacher_assign";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Vector inner = new Vector();
                String class1 = result.getString("c_name");
                String division = result.getString("c_divition");
                String subject = result.getString("sub_name");
                String teacher = result.getString("t_ID");

                inner.add(class1);
                inner.add(division);
                inner.add(subject);
                inner.add(teacher);

                outer.add(inner);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DefaultTableModel model = new DefaultTableModel(outer, title);
        TableResults.setModel(model);
    }

    public void fillForm(String cname) {

        try {

            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Buddhika\\Documents\\NetBeansProjects\\Specto_final\\spectoMe.sqlite");
            String sql = "select * from Teacher_assign where c_name" + cname;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            boolean b = result.next();

            this.id = result.getInt("rowid");
            String class1 = result.getString("c_name");
            String division = result.getString("c_divition");
            String subject = result.getString("sub_name");
            String teacher = result.getString("t_ID");

            GradeCombo.setSelectedItem(class1);
            DivitionCombo.setSelectedItem(division);
            SubjectCombo.setSelectedItem(subject);
            TeacherCombo.setSelectedItem(teacher);

        } catch (Exception e) {
            System.out.println(e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        UpdateButton = new javax.swing.JButton();
        ResignButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        division = new javax.swing.JTextField();
        subject = new javax.swing.JTextField();
        ClearFormButton = new javax.swing.JButton();
        TeacherCombo1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        DeleteRowButton = new javax.swing.JButton();
        ClearTableButton = new javax.swing.JButton();
        FillButton = new javax.swing.JButton();
        TeacherCombo = new javax.swing.JComboBox();
        SubjectCombo = new javax.swing.JComboBox();
        GradeCombo = new javax.swing.JComboBox();
        DivitionCombo = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableResults = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 204, 0));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1040, 50));

        jLabel8.setBackground(new java.awt.Color(0, 153, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 0));
        jLabel8.setText("Assign Subjects to Teacher");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 920, 80));

        jLabel2.setBackground(new java.awt.Color(255, 204, 0));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1040, 50));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        UpdateButton.setBackground(new java.awt.Color(51, 51, 51));
        UpdateButton.setForeground(new java.awt.Color(255, 255, 255));
        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        ResignButton.setBackground(new java.awt.Color(51, 51, 51));
        ResignButton.setForeground(new java.awt.Color(255, 255, 255));
        ResignButton.setText("Resign");
        ResignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResignButtonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Class");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Div");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Subject");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Teacher");

        name.setEditable(false);

        division.setEditable(false);

        subject.setEditable(false);

        ClearFormButton.setBackground(new java.awt.Color(51, 51, 51));
        ClearFormButton.setForeground(new java.awt.Color(255, 255, 255));
        ClearFormButton.setText("Clear");
        ClearFormButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearFormButtonActionPerformed(evt);
            }
        });

        TeacherCombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Search" }));
        TeacherCombo1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TeacherCombo1ItemStateChanged(evt);
            }
        });
        TeacherCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeacherCombo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(division)
                            .addComponent(subject)
                            .addComponent(TeacherCombo1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(ResignButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(ClearFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11))
                    .addComponent(division, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(TeacherCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResignButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 500, 220));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 760, 80));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Class");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Div");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Subject");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Teacher");

        SaveButton.setBackground(new java.awt.Color(0, 204, 0));
        SaveButton.setForeground(new java.awt.Color(255, 255, 255));
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        Table.setBackground(new java.awt.Color(204, 204, 0));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Class", "Division", "Subject", "Teacher"
            }
        ));
        jScrollPane2.setViewportView(Table);

        DeleteRowButton.setBackground(new java.awt.Color(255, 102, 0));
        DeleteRowButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteRowButton.setText("Delete A Row");
        DeleteRowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRowButtonActionPerformed(evt);
            }
        });

        ClearTableButton.setBackground(new java.awt.Color(255, 51, 0));
        ClearTableButton.setForeground(new java.awt.Color(255, 255, 255));
        ClearTableButton.setText("Clear");
        ClearTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearTableButtonActionPerformed(evt);
            }
        });

        FillButton.setBackground(new java.awt.Color(0, 204, 0));
        FillButton.setForeground(new java.awt.Color(255, 255, 255));
        FillButton.setText("Fill");
        FillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FillButtonActionPerformed(evt);
            }
        });

        TeacherCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Search" }));
        TeacherCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TeacherComboItemStateChanged(evt);
            }
        });
        TeacherCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeacherComboActionPerformed(evt);
            }
        });

        SubjectCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Geo", "History", "Science", "English", " " }));

        GradeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));

        DivitionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "A", "B", "C", "D", "E", "F", "G", "H", "I" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(GradeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(DivitionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(51, 51, 51))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(SubjectCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TeacherCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(DeleteRowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(ClearTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FillButton)
                    .addComponent(TeacherCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubjectCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GradeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DivitionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteRowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 500, 230));

        TableResults.setBackground(new java.awt.Color(153, 204, 255));
        TableResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Class", "Division", "Subject", "Teacher"
            }
        ));
        TableResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableResultsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableResults);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 406, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed

        try {
           

            DefaultTableModel dtm = (DefaultTableModel) Table.getModel();

            int rowCount = dtm.getRowCount();
            Object ob[] = new Object[4];

            for (int a = 0; a < rowCount; a++) {

                for (int b = 0; b <= 3; b++) {

                    ob[b] = dtm.getValueAt(a, b);

                }

                ResultSet r = conn.createStatement().executeQuery("select * from Teacher_assign where c_name='" + ob[0] + "' and c_divition='" + ob[1] + "' and sub_name='" + ob[2] + "' ");
                boolean b = false;
                while (r.next()) {
                    b = true;
                }
                if (!b) {
                    PreparedStatement p = conn.prepareStatement("insert into Teacher_assign values('" + ob[0] + "','" + ob[1] + "','" + ob[2] + "','" + ob[3] + "')");
                    p.executeUpdate();
                    p.close();
                    JOptionPane.showMessageDialog(rootPane, "Successfully Saved");
                } else {
                    JOptionPane.showMessageDialog(rootPane, ob[0] + "-" + ob[1] + " : " + ob[2] + " Is Already Saved.Click ok to Skip Saving the data");
                }

            }
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            model.setRowCount(0);

            fillTable();
            //JOptionPane.showMessageDialog(rootPane, "Successfully Saved");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_SaveButtonActionPerformed

    private void TableResultsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableResultsMouseClicked

        clearForm();

        DefaultTableModel dtm = (DefaultTableModel) TableResults.getModel();
        Object classN = dtm.getValueAt(TableResults.getSelectedRow(), 0);
        name.setText(classN + "");

        Object classD = dtm.getValueAt(TableResults.getSelectedRow(), 1);
        division.setText(classD + "");

        Object classS = dtm.getValueAt(TableResults.getSelectedRow(), 2);
        subject.setText(classS + "");

        Object classT = dtm.getValueAt(TableResults.getSelectedRow(), 3);
        TeacherCombo1.setSelectedItem(classT);


    }//GEN-LAST:event_TableResultsMouseClicked

    private void ResignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResignButtonActionPerformed

        String cname = name.getText();
        String cdivision = division.getText();
        String csubject = subject.getText();
        String cteacher = TeacherCombo1.getSelectedItem().toString();
        String nt = "Not Assigned";
        int a = JOptionPane.showConfirmDialog(null, "Are you sure want to Re-assign " + cteacher + " from " + cname + " " + cdivision + "-" + csubject + "");

        if (a == 0) {
            try {
                Class.forName("org.sqlite.JDBC");
                   Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Buddhika\\Documents\\NetBeansProjects\\Specto_final\\spectoMe.sqlite");
                Statement stmt = conn.createStatement();

                PreparedStatement p = conn.prepareStatement("update Teacher_assign set c_name='" + cname + "',c_divition='" + cdivision + "',sub_name='" + csubject + "',t_ID='" + nt + "' where c_name='" + cname + "' and c_divition='" + cdivision + "' and sub_name='" + csubject + "'");
                p.executeUpdate();
                p.close();

                JOptionPane.showMessageDialog(rootPane, "Successfully Resigned..");

                DefaultTableModel model = (DefaultTableModel) Table.getModel();
                model.setRowCount(0);

                clearForm();

                fillTable();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_ResignButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed

        try {
            Class.forName("org.sqlite.JDBC");
   Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Buddhika\\Documents\\NetBeansProjects\\Specto_final\\spectoMe.sqlite");
            Statement stmt = conn.createStatement();

            String cname = name.getText();
            String cdivision = division.getText();
            String csubject = subject.getText();
            Object cteacher = TeacherCombo1.getSelectedItem();

            PreparedStatement p = conn.prepareStatement("update Teacher_assign set c_name='" + cname + "',c_divition='" + cdivision + "',sub_name='" + csubject + "',t_ID='" + cteacher + "' where c_name='" + cname + "' and c_divition='" + cdivision + "' and sub_name='" + csubject + "'");
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(rootPane, "Successfully updated");

            clearForm();

            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            model.setRowCount(0);

            fillTable();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void DeleteRowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRowButtonActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            /* if (){
             
             JOptionPane.showMessageDialog(null, "canceled!! ");
             }else {
             
           
            
             }*/
            model.removeRow(Table.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Successfully deleted !!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Select a Row !!");
            //JOptionPane.showMessageDialog(null, "Are you sure you want to delete this row? ");

        }


    }//GEN-LAST:event_DeleteRowButtonActionPerformed

    private void ClearTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearTableButtonActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();

            for (int a = model.getRowCount(); a > 0; a--) {
                model.removeRow(a - 1);
            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_ClearTableButtonActionPerformed

    private void FillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FillButtonActionPerformed
        loadDataToTable();
    }//GEN-LAST:event_FillButtonActionPerformed

    private void ClearFormButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearFormButtonActionPerformed
        clearForm();
    }//GEN-LAST:event_ClearFormButtonActionPerformed

    private void TeacherComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TeacherComboItemStateChanged

        String sql = "SELECT * FROM teacher WHERE tID=?";
        try {

            String tmp = TeacherCombo.getSelectedItem().toString();
            pst = conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {

                String add0 = rs.getString("tID");
                String add1 = rs.getString("fname");

                String add2 = rs.getString("lname");

                String add3 = rs.getString("contactno");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String add5 = rs.getString("email");
                String add6 = rs.getString("gender");

                String add7 = rs.getString("address");
                String add8 = rs.getString("subject");
                //  String add9 = rs.getString("div");

             //   sidTxt.setText(add0);
             //   fnTxt.setText(add1);
             //   lnTxt.setText(add2);
             //   contact.setText(add3);
                // jd.setDate(add4);
            //    emailTxt.setText(add5);
            //    addTxt.setText(add7);

                if("M".equals(add6)){
               //     jRadioButton1.setSelected(true);
                }else{
               //     jRadioButton2.setSelected(true);
                }

                GradeCombo.setSelectedItem(add8);

                byte[] imagedata = rs.getBytes("image");
           //     format = new ImageIcon(imagedata);
           //     imgTxt.setIcon(format);
                // searchBar.setText("");
                // String add3=rs.getString("Emp_ID");

                // pl.setText(add3);
            }

        } catch (Exception e) {
        }finally {

            try {

                rs.close();
                pst.close();

            } catch (Exception e) {
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherComboItemStateChanged

    private void TeacherComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeacherComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherComboActionPerformed

    private void TeacherCombo1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TeacherCombo1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherCombo1ItemStateChanged

    private void TeacherCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeacherCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherCombo1ActionPerformed

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
            java.util.logging.Logger.getLogger(AssignTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssignTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssignTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssignTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                try {
                    LookAndFeel look = new GraphiteLookAndFeel();
                    UIManager.setLookAndFeel(look);
                } catch (Exception e) {
                }
                new AssignTeacher().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearFormButton;
    private javax.swing.JButton ClearTableButton;
    private javax.swing.JButton DeleteRowButton;
    private javax.swing.JComboBox DivitionCombo;
    private javax.swing.JButton FillButton;
    private javax.swing.JComboBox GradeCombo;
    private javax.swing.JButton ResignButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JComboBox SubjectCombo;
    private javax.swing.JTable Table;
    private javax.swing.JTable TableResults;
    private javax.swing.JComboBox TeacherCombo;
    private javax.swing.JComboBox TeacherCombo1;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JTextField division;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField name;
    private javax.swing.JTextField subject;
    // End of variables declaration//GEN-END:variables
}
