/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Buddhika
 */
public class DAC {
    Connection conn=null;
    public static Connection ConnectDb(){
      try{  
        Class.forName("org.sqlite.JDBC");
Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\sksha\\Desktop\\Specto_final\\spectoMe.sqlite");
       //JOptionPane.showMessageDialog(null, "Connected");
         return conn;
      }catch(Exception e){
      
          JOptionPane.showMessageDialog(null, e.getMessage());
       return null;
      
      }  
    }
}
