
package it.unipv.model;

import it.unipv.DAO.ObjectRegistrazione;
import it.unipv.JAVABEAN.Datadentista;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ModelloRegistrazione {
   //variabile per chiamare i metodi dell'oggetto DAO registrazione che implementa i metodi dell'interfaccia Iregistrazione
    ObjectRegistrazione res;

    public ModelloRegistrazione() {
         res = new  ObjectRegistrazione();
    }

   
    
    public ResultSet cercanomeutente(String username){
    return res.cercausername(username);
   }
    
    public void RegisterDentist(Datadentista data1){
    if(data1.getNome().isEmpty() || data1.getCognome().isEmpty() || data1.getNomeutente().isEmpty() || data1.getPassword().isEmpty() || data1.getEmaildentista().isEmpty() || data1.getCellularedentista().isEmpty())
    {
     JOptionPane.showMessageDialog(null, "PRESENZA DI CAMPI VUOTI");
    }
    else{
        res.InsertDatiDentista(data1);
    }
    
    }
    
}
