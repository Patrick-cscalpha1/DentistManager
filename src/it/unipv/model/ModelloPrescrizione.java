
package it.unipv.model;

import it.unipv.DAO.ObjectPrescrizione;
import it.unipv.JAVABEAN.Dataprescrizione;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ModelloPrescrizione {
        ObjectPrescrizione prescription;
        private ResultSet rs1;
    public ModelloPrescrizione() {
        prescription = new ObjectPrescrizione();
    }
     public void verificaCampivuoti(Dataprescrizione presc){
    if(presc.getCfpaziente().isEmpty() || presc.getNometrattamento().isEmpty() || presc.getDataprescrizione().isEmpty() || presc.getNomeprescrizione().isEmpty() || presc.getQuantita().isEmpty())
    {
    JOptionPane.showMessageDialog(null, "PRESENZA DI CAMPI VUOTI");
    }
    }
    
    public void registerprescription(Dataprescrizione presc,String cf,String treatment,String username){
         rs1=prescription.cercacfTrattamento(cf,treatment,username);
        try {
            if(rs1.next()){
                  prescription.insertprescription(presc);
                  
                }

            else{
              JOptionPane.showMessageDialog(null, "CF O TRATTAMENTO SBAGLIATO");
            }
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }
  
    }
    
    public void modifyprescription(Dataprescrizione presc,String ID,String cf,String treatment,String username)
    {
  rs1=prescription.cercacfTrattamento(cf,treatment,username);
        try {
            if(rs1.next()){
               prescription.modificaprescrizione(presc, ID);
                  
                }

            else{
              JOptionPane.showMessageDialog(null, "CF O TRATTAMENTO SBAGLIATO");
            }
        } catch (Exception ex) {
           ex.printStackTrace();
          
        }

     
      
    }
    
    
    public void cancelprescription(String ID){
        if(ID.isEmpty()){
               JOptionPane.showMessageDialog(null, "CAMPO ID VUOTO");
        }
        else{
    prescription.cancellaprescrizione(ID);
           }
        }
    
    
    public Dataprescrizione researchprescription(String ID,String username)
    {
    return prescription.ricercaprescrizione(ID, username);
    }
    
    public ResultSet getprescription(String username){
    return prescription.gettableprescrizione(username);
    }
    
    
    
}
