
package it.unipv.DAO;

import it.unipv.JAVABEAN.Datapaziente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class ObjectPaziente implements Ipaziente {

    @Override
    public void insertpatient(Datapaziente patient) {
          try {
                 
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
            PreparedStatement pstm = conn.prepareStatement("insert into paziente values(?,?,?,?,?,?,?,?)");
            pstm.setInt(1, 0);
            pstm.setString(2, patient.getNome());
            pstm.setString(3, patient.getCognome());
            pstm.setString(4, patient.getCf());
            pstm.setString(5, patient.getIndirizzo());
            pstm.setString(6, patient.getEmailpaziente());
            pstm.setString(7, patient.getCellularepaziente());
            pstm.setString(8, patient.getNomeutentedentista());
            
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "PAZIENTE REGISTRATO CON SUCCESSO");
            
        } catch (Exception ex) {
           ex.printStackTrace();
        }
         }
     @Override
    public void modificapaziente(Datapaziente data,String id) {
         try {
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
           
             PreparedStatement pstm = conn.prepareStatement("update  paziente set Nome ='"+data.getNome()+"',Cognome ='"+data.getCognome()+"',CF ='"+data.getCf()+"',Indirizzo ='"+data.getIndirizzo()+"',Email ='"+data.getEmailpaziente()+"',Cellulare ='"+data.getCellularepaziente()+"' where Idpaziente=?");
              pstm.setString(1, id);
             pstm.executeUpdate();
             JOptionPane.showMessageDialog(null, "PAZIENTE MODIFICATO CON SUCCESSO");
            
       
          
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
    }
    
    
    @Override
    public void cancellapaziente(String id) {
           try {
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
            String sql = "delete from paziente where Idpaziente=?";
             PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
            pstm.executeUpdate();
             JOptionPane.showMessageDialog(null, "PAZIENTE CANCELLATO CON SUCCESSO");
            
       
          
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
      
    }

    @Override
    public Datapaziente ricercapaziente(String id,String username) {
        try {
            //abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
            String sql = "select * from paziente where Idpaziente=? and Nomeutente=?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
             pstm.setString(2, username);
            ResultSet rs= pstm.executeQuery();
            if(rs.next() == true){
            Datapaziente data = new Datapaziente(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),"");
            return data;
            }
            else {
            JOptionPane.showMessageDialog(null, "ID PAZIENTE NON TROVATO");
            JOptionPane.showMessageDialog(null, "RINSERISCI ID  DEL PAZIENTE");
            Datapaziente data1 = new Datapaziente("","","","","","","");
                return data1;
            }
          
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
        return null;
    }

    @Override
    public ResultSet gettablepaziente(String username) {
     try {
//abilitating my driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //collegamento con lo schema
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistmanager","root","Csc27alpha2022*" );
            //creazione delle preparedstatement per scrivere e eseguire le query
            String sql= "select Idpaziente,Nome,Cognome,CF,Indirizzo,Email,Cellulare from paziente where Nomeutente=? order by Nome";
            PreparedStatement pstm = conn.prepareStatement(sql);
             pstm.setString(1, username);
            ResultSet rs= pstm.executeQuery();
            return rs;
         
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
           return null; 
    }


   
    
    
    
    }

  
    


