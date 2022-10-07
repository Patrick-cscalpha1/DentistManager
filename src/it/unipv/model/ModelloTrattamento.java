
package it.unipv.model;


import it.unipv.DAO.ObjectTrattamento;
import it.unipv.JAVABEAN.Datatrattamento;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ModelloTrattamento {
      ObjectTrattamento treatment;

    public ModelloTrattamento() {
        treatment = new ObjectTrattamento();
    }
    
    public void registertreatment(Datatrattamento treat){
    if(treat.getNometrattamento().isEmpty() || treat.getCosto().isEmpty() || treat.getNomeutentedentista().isEmpty())
    {
    JOptionPane.showMessageDialog(null, "PRESENZA DI CAMPI VUOTI");
    }
    else{
    treatment.inserttrattamento(treat);
    }
    }
    
    public void modifytreatment(Datatrattamento treat,String ID)
    {
    if(treat.getNometrattamento().isEmpty() || treat.getCosto().isEmpty() || treat.getNomeutentedentista().isEmpty())
    {
    JOptionPane.showMessageDialog(null, "PRESENZA DI CAMPI VUOTI");
    }
    else{
    treatment.modificatrattamento(treat,ID);
    }
    }
    
    
    public void canceltreatment(String ID){
        if(ID.isEmpty()){
               JOptionPane.showMessageDialog(null, "CAMPO ID VUOTO");
        }
        else{
    treatment.cancellatrattamento(ID);
           }
        }
    
    
    public Datatrattamento researchtreatment(String ID,String username)
    {
    return treatment.ricercatrattamento(ID,username);
    }
    
    public ResultSet gettreatment(String username){
    return treatment.gettabletrattamento(username);
    }
    
}
