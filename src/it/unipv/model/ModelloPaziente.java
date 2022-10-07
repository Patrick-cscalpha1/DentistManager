
package it.unipv.model;

import it.unipv.DAO.ObjectPaziente;
import it.unipv.JAVABEAN.Datapaziente;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


public class ModelloPaziente {
    ObjectPaziente patient;

    public ModelloPaziente() {
        patient = new ObjectPaziente();
    }
    
    public void registerpatient(Datapaziente pat){
    if(pat.getNome().isEmpty() || pat.getCognome().isEmpty() || pat.getCf().isEmpty() || pat.getIndirizzo().isEmpty() || pat.getEmailpaziente().isEmpty() || pat.getCellularepaziente().isEmpty())
    {
    JOptionPane.showMessageDialog(null, "PRESENZA DI CAMPI VUOTI");
    }
    else{
    patient.insertpatient(pat);
    }
    }
    
    public void modifypatient(Datapaziente data,String ID)
    {
    if(data.getNome().isEmpty() || data.getCognome().isEmpty() || data.getCf().isEmpty() || data.getIndirizzo().isEmpty() || data.getEmailpaziente().isEmpty() || data.getCellularepaziente().isEmpty())
    {
    JOptionPane.showMessageDialog(null, "PRESENZA DI CAMPI VUOTI");
    }
    else{
    patient.modificapaziente(data,ID);
    }
    }
    
    
    public void cancelpatient(String ID){
        if(ID.isEmpty()){
               JOptionPane.showMessageDialog(null, "CAMPO ID VUOTO");
        }
        else{
    patient.cancellapaziente(ID);
           }
        }
    
    
    public Datapaziente researchpatient(String ID,String username)
    {
    return patient.ricercapaziente(ID,username);
    }
    
    public ResultSet getpatients(String username){
    return patient.gettablepaziente(username);
    }
    
    
    
}
