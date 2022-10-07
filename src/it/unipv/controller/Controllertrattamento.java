
package it.unipv.controller;

import it.unipv.model.ModelloTrattamento;
import it.unipv.view.Gestionetrattamentofrm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class Controllertrattamento {
      private ModelloTrattamento modellotrattamento;
     private Gestionetrattamentofrm viewtrattamento;

    public Controllertrattamento(ModelloTrattamento modellotrattamento, Gestionetrattamentofrm viewtrattamento) {
        this.modellotrattamento = modellotrattamento;
        this.viewtrattamento = viewtrattamento;
        assegnaAscoltatoriTrattamento();
        stampatabella();
        
    }

    private void assegnaAscoltatoriTrattamento() {
       
         viewtrattamento.getButtonSalva().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    modellotrattamento.registertreatment(viewtrattamento.getdatiGestionetrattamentofrm());
                    viewtrattamento.azzeracampi();
                     stampatabella();
            }
        });
        
         viewtrattamento.getButtonModifica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     modellotrattamento.modifytreatment(viewtrattamento.getdatiGestionetrattamentofrm(),viewtrattamento.getID());
                     viewtrattamento.azzeracampi();
                      stampatabella();
            }
        });
         
           viewtrattamento.getButtonCancella().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   modellotrattamento.canceltreatment(viewtrattamento.getID());
                viewtrattamento.azzeracampi();
                 stampatabella();
            }
        });
          
         viewtrattamento.getButtonChiudi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    viewtrattamento.setVisible(false);
            }
        });
           
             viewtrattamento.getButtonSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     if(viewtrattamento.getID().isEmpty())
                {
                     JOptionPane.showMessageDialog(null, "SEARCH ID VUOTO");

                }
                else{
                 viewtrattamento.RiempiCampi(modellotrattamento.researchtreatment(viewtrattamento.getID(),viewtrattamento.getusername()));
                }
                     stampatabella();
            }
        });
            
    }
    
    private void stampatabella(){
       viewtrattamento.stampatabellatrattamento(modellotrattamento.gettreatment(viewtrattamento.getusername()));
    }
     
 }
