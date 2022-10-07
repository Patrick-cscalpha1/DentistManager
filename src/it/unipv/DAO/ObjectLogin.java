
package it.unipv.DAO;

import it.unipv.JAVABEAN.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ObjectLogin implements Ilogin {
    private ResultSet  rs;
    @Override
    public ResultSet cercadentista(Login dentist) {
                try {
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
           String sql="select * from dentista where Nomeutente=? and PasswordDentista=?"; 
              
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, dentist.getUsername());
            pstm.setString(2, dentist.getPassword());
            rs =  pstm.executeQuery();
          
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
   return rs;
    }

}
