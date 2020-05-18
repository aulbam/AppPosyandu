/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

/**
 *
 * @author Maulana
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Koneksi {
    
    public static Connection koneksi;
    public Statement st;
     private static  com.mysql.jdbc.Connection con;
    
    public static Connection getconnetion(){
        if(koneksi==null){
            try{
                String server="jdbc:mysql://localhost:3306/posyandu";
                String user="root";
                String password="";
                Class.forName("com.mysql.jdbc.Driver");
                koneksi=DriverManager.getConnection(server,user,password);               
            }catch(Exception x){
                JOptionPane.showMessageDialog(null,"Koneksi Gagal, Pesan error \n"+x);
            }                        
        }
        return koneksi;
    }
     public void koneksi(){
            try{
                getconnetion();
                st=koneksi.createStatement();
            }catch(Exception x){
                JOptionPane.showMessageDialog(null,"Koneksi ambil Gagal, Pesan error \n"+x);
            }          
    }
      public void tutupKoneksi(ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
            st.close();
            koneksi.close();
        }catch(Exception x){
            JOptionPane.showMessageDialog(null,"Tutup Koneksi Gagal, Pesan error \n"+x);
        }
    }
      
         public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
    
}
