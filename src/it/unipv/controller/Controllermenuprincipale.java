
package it.unipv.controller;

import it.unipv.MainAppuntamento;
import it.unipv.MainFatturazione;
import it.unipv.MainPaziente;
import it.unipv.MainPrescrizioni;
import it.unipv.MainStatistica;
import it.unipv.MainTrattamento;
import it.unipv.model.ModelloMenuprincipale;
import it.unipv.view.Menuprincipale;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controllermenuprincipale {
     private ModelloMenuprincipale modelmenu;
     private Menuprincipale viewmenu;
     
     //variabili per chiamare le altre form rispetto alla scelta
     
     MainPaziente patient;
     MainAppuntamento appointment;
     MainTrattamento treatment;
     MainPrescrizioni prescription;
     MainStatistica statistic;
     MainFatturazione fattura;

    public Controllermenuprincipale(ModelloMenuprincipale modelmenu, Menuprincipale viewmenu) {
        this.modelmenu = modelmenu;
        this.viewmenu = viewmenu;
        patient = new   MainPaziente();
        appointment= new MainAppuntamento();
        treatment = new MainTrattamento();
        prescription = new MainPrescrizioni();
        statistic= new  MainStatistica();
        fattura= new MainFatturazione();
        assegnaAscoltatoreMenuprincipale();
    }

    private void assegnaAscoltatoreMenuprincipale() {
       viewmenu.getButtongestionepaziente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    patient.runMenuPaziente(modelmenu.getUsername());
            }
        });
       
        viewmenu.getButtongestioneappuntamenti().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   appointment.runAppuntamento(modelmenu.getUsername());
            }
        });
        
         viewmenu.getButtongestionetrattamenti().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   treatment.runTrattamento(modelmenu.getUsername());
            }
        });
         
          viewmenu.getButtongestioneprescrizioni().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    prescription.runPrescrizione(modelmenu.getUsername());
            }
        });
          
           viewmenu.getButtongestionefattura().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    fattura.runFatturazione(modelmenu.getUsername());
            }
        });
           
            viewmenu.getButtongestionestatistica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    statistic.runStatistica(modelmenu.getUsername());
            }
        });
            
             viewmenu.getButtontornaindietro1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    viewmenu.setVisible(false);
            }
        });
         
         
    }
     
     
}
