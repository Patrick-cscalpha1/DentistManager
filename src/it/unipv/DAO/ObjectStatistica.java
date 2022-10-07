
package it.unipv.DAO;

import it.unipv.JAVABEAN.Datastatistica;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class ObjectStatistica implements Istatistica {

    @Override
    public Datastatistica numerodati(String username) {
         try {
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
           String sql1="select count(*)  from paziente where Nomeutente=? "; 
           PreparedStatement pstm1 = conn.prepareStatement(sql1);
           pstm1.setString(1, username);
            ResultSet rs1 = pstm1.executeQuery();
            //Retrieving the result
            rs1.next();
            int numeroPaziente = rs1.getInt(1);
             String sql2="select count(*)  from trattamento where Nomeutente=? "; 
           PreparedStatement pstm2 = conn.prepareStatement(sql2);
           pstm2.setString(1, username);
            ResultSet rs2 = pstm2.executeQuery();
            //Retrieving the result
            rs2.next();
            int numeroTrattamento = rs2.getInt(1);
            
           String sql3="select count(*)  from prescrizione where Nomeutente=? "; 
           PreparedStatement pstm3 = conn.prepareStatement(sql3);
           pstm3.setString(1, username);
            ResultSet rs3 = pstm3.executeQuery();
            //Retrieving the result
            rs3.next();
            int numeroPrescrizione = rs3.getInt(1);
            Datastatistica data = new Datastatistica(numeroPaziente,numeroTrattamento,numeroPrescrizione);
           return data;
          
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
   
         return null;
    }
    
}
