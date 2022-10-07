
package it.unipv.model;
import it.unipv.DAO.ObjectAppuntamento;
import it.unipv.JAVABEAN.Dataappuntamento;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModelloAppuntamento {
    ObjectAppuntamento appointment;
    private ResultSet rs1;
    public ModelloAppuntamento() {
        appointment = new ObjectAppuntamento();
    }
    public void verificaCampivuoti(Dataappuntamento appoint){
    if(appoint.getCfpaziente().isEmpty() || appoint.getTrattamento().isEmpty() || appoint.getDataappuntamento().isEmpty() || appoint.getOrario().isEmpty())
    {
    JOptionPane.showMessageDialog(null, "PRESENZA DI CAMPI VUOTI");
    }
    }
     public void registerappointment(Dataappuntamento appoint,String cf,String treatment,String username){
    
    rs1=appointment.cercacfTrattamento(cf,treatment,username);
        try {
            if(rs1.next()){
                  appointment.insertappuntamento(appoint);
              
                }

            else{
              JOptionPane.showMessageDialog(null, "CF O TRATTAMENTO SBAGLIATO");
            }
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
    }
     
     public void modifyappointment(Dataappuntamento appoint,String ID,String cf,String treatment,String username)
    {
 rs1=appointment.cercacfTrattamento(cf,treatment,username);
        try {
            if(rs1.next()){
                  appointment.modificappuntamento(appoint, ID);
              
                }

            else{
              JOptionPane.showMessageDialog(null, "CF O TRATTAMENTO SBAGLIATO");
            }
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
   
   
    
    }
     
      public void cancelappointment(String ID){
        if(ID.isEmpty()){
               JOptionPane.showMessageDialog(null, "CAMPO ID VUOTO");
        }
        else{
    appointment.cancellappuntamento(ID);
           }
        }
      public Dataappuntamento researchappointment(String ID,String username)
    {
    return appointment.ricercaappuntamento(ID,username);
    }
    public ResultSet getappointment(String username){
    return appointment.gettableappuntamento(username);
    }
    
}
