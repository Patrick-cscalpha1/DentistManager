
package it.unipv.controller;

import it.unipv.model.ModelloPrescrizione;
import it.unipv.view.Gestioneprescrizionefrm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class Controllerprescrizioni {
    private ModelloPrescrizione modelloprescrizione;
     private Gestioneprescrizionefrm viewprescrizione;

    public Controllerprescrizioni(ModelloPrescrizione modelloprescrizione, Gestioneprescrizionefrm viewprescrizione) {
        this.modelloprescrizione = modelloprescrizione;
        this.viewprescrizione = viewprescrizione;
        assegnaAscoltatoriPrescrizioni();
        stampatabella();
    }

    private void assegnaAscoltatoriPrescrizioni() {
             viewprescrizione.getButtonSalva().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    modelloprescrizione.verificaCampivuoti(viewprescrizione.getdatiGestioneprescrizionefrm());
                    modelloprescrizione.registerprescription(viewprescrizione.getdatiGestioneprescrizionefrm(),viewprescrizione.getCF(),viewprescrizione.getTrattamento(),viewprescrizione.getusername());
                    viewprescrizione.azzeracampi();
                     stampatabella();
            }
        });
        
         viewprescrizione.getButtonModifica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    modelloprescrizione.verificaCampivuoti(viewprescrizione.getdatiGestioneprescrizionefrm());
                    modelloprescrizione.modifyprescription(viewprescrizione.getdatiGestioneprescrizionefrm(),viewprescrizione.getID(),viewprescrizione.getCF(),viewprescrizione.getTrattamento(),viewprescrizione.getusername());
                viewprescrizione.azzeracampi();
                 stampatabella();
            }
        });
         
           viewprescrizione.getButtonCancella().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     modelloprescrizione.cancelprescription(viewprescrizione.getID());
                      viewprescrizione.azzeracampi();
                      stampatabella();
            }
        });
          
           viewprescrizione.getButtonChiudi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   viewprescrizione.setVisible(false);
            }
        });
           
             viewprescrizione.getButtonSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(viewprescrizione.getID().isEmpty())
                {
                     JOptionPane.showMessageDialog(null, "SEARCH ID VUOTO");

                }
                else{
                 viewprescrizione.RiempiCampi(modelloprescrizione.researchprescription(viewprescrizione.getID(),viewprescrizione.getusername()));
                }
                     stampatabella();
            }
        });
    }
     
     public void stampatabella() {
        viewprescrizione.stampatabellapaziente(modelloprescrizione.getprescription( viewprescrizione.getusername()));
   } 
}
