
package it.unipv.DAO;

import it.unipv.JAVABEAN.Dataprescrizione;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ObjectPrescrizione implements Iprescrizione {
 private ResultSet  rs;
    @Override
    public void insertprescription(Dataprescrizione prescription) {
    try {
                 
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
            PreparedStatement pstm = conn.prepareStatement("insert into prescrizione values(?,?,?,?,?,?,?)");
            pstm.setInt(1, 0);
            pstm.setString(2, prescription.getNomeprescrizione());
            pstm.setString(3, prescription.getQuantita());
            pstm.setString(4, prescription.getDataprescrizione());
            pstm.setString(5, prescription.getNometrattamento());
            pstm.setString(6, prescription.getCfpaziente());
            pstm.setString(7, prescription.getNomeutentedentista());
            
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "PRESCRIZIONE REGISTRATO CON SUCCESSO");
            
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }

     @Override
    public void modificaprescrizione(Dataprescrizione data, String id) {
     try {
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
           
             PreparedStatement pstm = conn.prepareStatement("update  prescrizione set Prescrizione ='"+data.getNomeprescrizione()+"',Quantita ='"+data.getQuantita()+"',Dataprescrizione ='"+data.getDataprescrizione()+"',Trattamento ='"+data.getNometrattamento()+"',CF ='"+data.getCfpaziente()+"' where IdPrescrizione=?");
              pstm.setString(1, id);
             pstm.executeUpdate();
             JOptionPane.showMessageDialog(null, "PRESCRIZIONE MODIFICATO CON SUCCESSO");
            
       
          
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
    }
    
   
    @Override
    public void cancellaprescrizione(String id) {
        try {
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
            String sql = "delete from prescrizione where IdPrescrizione=?";
             PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
            pstm.executeUpdate();
             JOptionPane.showMessageDialog(null, "PRESCRIZIONE CANCELLATO CON SUCCESSO");
            
       
          
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
    }

   
    
     @Override
    public Dataprescrizione ricercaprescrizione(String id, String username) {
     try {
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
            String sql = "select * from prescrizione where IdPrescrizione=? and Nomeutente=?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
             pstm.setString(2, username);
            ResultSet rs= pstm.executeQuery();
            if(rs.next() == true){
            Dataprescrizione data = new Dataprescrizione(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),"");
            return data;
            }
            else {
            JOptionPane.showMessageDialog(null, "ID PRESCRIZIONE NON TROVATO");
            JOptionPane.showMessageDialog(null, "RINSERISCI ID  DEL PAZIENTE");
            Dataprescrizione data1 = new Dataprescrizione("","","","","","");
                return data1;
            }
          
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
        return null;
    }


    @Override
    public ResultSet gettableprescrizione(String username) {
      try {
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
            String sql= "select IdPrescrizione,Prescrizione,Quantita,Dataprescrizione,Trattamento,CF from prescrizione where Nomeutente=? order by Prescrizione";
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
    public ResultSet cercacfTrattamento(String cf, String treatment,String username) {
          try {
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
           String sql="select * from paziente natural join trattamento where CF=? and Trattamento=? and Nomeutente=?"; 
              
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
