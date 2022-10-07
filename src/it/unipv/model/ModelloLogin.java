
package it.unipv.model;

import it.unipv.DAO.ObjectLogin;
import it.unipv.JAVABEAN.Login;
import it.unipv.MainMenuprincipale;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ModelloLogin {
    //variabile per chiamare i metodi dell'oggetto DAO per la Login che implementa i metodi dell'interfaccia Iregistrazione
    ObjectLogin result;
    MainMenuprincipale menu;
    ResultSet rs1;

    public ModelloLogin() {
        result = new  ObjectLogin();
        menu = new MainMenuprincipale();
    }
    
    
    
    public void VerificaLogin(Login log,String name){
     if(log.getUsername().isEmpty() || log.getPassword().isEmpty()){
      
     JOptionPane.showMessageDialog(null, "PRESENZA DI CAMPI VUOTI");
   
     }
     else {
      rs1 = result.cercadentista(log);
        try {
            if(rs1.next())
            {
                JOptionPane.showMessageDialog(null, "LOGIN CON SUCCESSO");
                 //call menu principale frame
                menu.runMenuPrincipale(name);
            } 
        
            else{
              JOptionPane.showMessageDialog(null, "DATI SBAGLIATO RIPROVA LOGIN");
            }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
     
     }
}
    
}
