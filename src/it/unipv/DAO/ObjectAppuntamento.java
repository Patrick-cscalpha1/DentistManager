
package it.unipv.DAO;

import it.unipv.JAVABEAN.Dataappuntamento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ObjectAppuntamento implements Iappuntamento {
   private ResultSet  rs;
    @Override
    public void insertappuntamento(Dataappuntamento appointment) {
       try {
                 
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
            PreparedStatement pstm = conn.prepareStatement("insert into appuntamento values(?,?,?,?,?,?)");
            pstm.setInt(1, 0);
            pstm.setString(2, appointment.getDataappuntamento());
            pstm.setString(3, appointment.getCfpaziente());
            pstm.setString(4, appointment.getTrattamento());
            pstm.setString(5, appointment.getOrario());
            pstm.setString(6, appointment.getNomeutentedentista());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "APPUNTAMENTO REGISTRATO CON SUCCESSO");
            
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
    
     
    @Override
    public void modificappuntamento(Dataappuntamento data, String id) {
        try {
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
           
             PreparedStatement pstm = conn.prepareStatement("update  appuntamento set DataAppuntamento ='"+data.getDataappuntamento()+"',CF ='"+data.getCfpaziente()+"',Trattamento ='"+data.getTrattamento()+"',Orario ='"+data.getOrario()+"' where IdAppuntamento=?");
              pstm.setString(1, id);
             pstm.executeUpdate();
             JOptionPane.showMessageDialog(null, "APPUNTAMENTO MODIFICATO CON SUCCESSO");
            
       
          
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
    }
    
    @Override
    public void cancellappuntamento(String id) {
        try {
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
            String sql = "delete from appuntamento where IdAppuntamento=?";
             PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
            pstm.executeUpdate();
             JOptionPane.showMessageDialog(null, "APPUNTAMENTO CANCELLATO CON SUCCESSO");
            
       
          
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
    }

    @Override
    public Dataappuntamento ricercaappuntamento(String id, String username) {
      try {
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
            String sql = "select * from appuntamento where IdAppuntamento=? and Nomeutente=?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
             pstm.setString(2, username);
            ResultSet rs= pstm.executeQuery();
            if(rs.next() == true){
            Dataappuntamento data = new Dataappuntamento(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),"");
            return data;
            }
            else {
            JOptionPane.showMessageDialog(null, "ID APPUNTAMENTO NON TROVATO");
            JOptionPane.showMessageDialog(null, "RINSERISCI ID  DELL'APPUNTAMENTO");
            Dataappuntamento data1 = new Dataappuntamento("","","","","");
                return data1;
            }
          
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
        return null;
    }

    @Override
    public ResultSet gettableappuntamento(String username) {
       try {
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
            String sql= "select IdAppuntamento,DataAppuntamento,CF,Trattamento,Orario from appuntamento where Nomeutente=? order by DataAppuntamento";
            PreparedStatement pstm = conn.prepareStatement(sql);
             pstm.setString(1, username);
            ResultSet rs= pstm.executeQuery();
            return rs;
         
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
           return null; 
    }

    @Override
    public ResultSet cercacfTrattamento(String cf,String treatment,String username) {
            try {
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
           String sql="select * from paziente natural join trattamento where CF=? and Trattamento=? and Nomeutente=? "; 
              
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, cf);
            pstm.setString(2, treatment);
            pstm.setString(3, username);
            
            rs =  pstm.executeQuery();
          
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
   return rs;
    }

    
}
