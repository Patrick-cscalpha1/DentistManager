
package it.unipv.controller;

import it.unipv.model.ModelloPaziente;
import it.unipv.view.Gestionepazientefrm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


public class Controllerpaziente {
     private ModelloPaziente modelpaziente;
     private Gestionepazientefrm viewpaziente;

    public Controllerpaziente(ModelloPaziente modelpaziente, Gestionepazientefrm viewpaziente) {
        this.modelpaziente = modelpaziente;
        this.viewpaziente = viewpaziente;
        assegnaAscoltatoriPaziente();
        stampatabella();
    }

    private void assegnaAscoltatoriPaziente() {
  
        viewpaziente.getButtonSalva().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    modelpaziente.registerpatient(viewpaziente.getdatiGestionepazientefrm());
                    viewpaziente.azzeracampi();
                    stampatabella();
            }
        });
        
         viewpaziente.getButtonModifica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelpaziente.modifypatient(viewpaziente.getdatiGestionepazientefrm(),viewpaziente.getID());
                viewpaziente.azzeracampi();
                stampatabella();
                }
        });
          viewpaziente.getButtonCancella().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    modelpaziente.cancelpatient(viewpaziente.getID());
                     viewpaziente.azzeracampi();
                    stampatabella();
            }
        });
          
           viewpaziente.getButtonChiudi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    viewpaziente.setVisible(false);
            }
        });
           
            viewpaziente.getButtonSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(viewpaziente.getID().isEmpty())
                {
                     JOptionPane.showMessageDialog(null, "SEARCH ID VUOTO");

                }
                else{
                 viewpaziente.RiempiCampi(modelpaziente.researchpatient(viewpaziente.getID(),viewpaziente.getusername()));
                }
            }
        });
    }

    public void stampatabella() {
       viewpaziente.stampatabellapaziente(modelpaziente.getpatients(viewpaziente.getusername()));
   }
     
    
   
}
