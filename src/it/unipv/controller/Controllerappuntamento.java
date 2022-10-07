
package it.unipv.controller;

import it.unipv.model.ModelloAppuntamento;
import it.unipv.view.Gestioneappuntamentofrm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class Controllerappuntamento {
    
     private ModelloAppuntamento modelloappuntamento;
     private Gestioneappuntamentofrm viewappuntamento;

    public Controllerappuntamento(ModelloAppuntamento modelloappuntamento, Gestioneappuntamentofrm viewappuntamento) {
        this.modelloappuntamento = modelloappuntamento;
        this.viewappuntamento = viewappuntamento;
        assegnaAscoltatoriAppuntamento();
        stampatabella();
    }

    private void assegnaAscoltatoriAppuntamento() {
          viewappuntamento.getButtonSalva().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    modelloappuntamento.verificaCampivuoti(viewappuntamento.getdatiGestioneappuntamentofrm());
                    modelloappuntamento.registerappointment(viewappuntamento.getdatiGestioneappuntamentofrm(),viewappuntamento.getCF(),viewappuntamento.getTrattamento(),viewappuntamento.getusername());
                    viewappuntamento.azzeracampi();
                    stampatabella();
            }
        });
        
         viewappuntamento.getButtonModifica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  modelloappuntamento.verificaCampivuoti(viewappuntamento.getdatiGestioneappuntamentofrm());
                  modelloappuntamento.modifyappointment(viewappuntamento.getdatiGestioneappuntamentofrm(),viewappuntamento.getID(),viewappuntamento.getCF(),viewappuntamento.getTrattamento(),viewappuntamento.getusername());
                 viewappuntamento.azzeracampi();
                stampatabella();
            }
        });
         
           viewappuntamento.getButtonCancella().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    modelloappuntamento.cancelappointment(viewappuntamento.getID());
                     viewappuntamento.azzeracampi();
                    stampatabella();
            }
        });
          
           viewappuntamento.getButtonChiudi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    viewappuntamento.setVisible(false);
            }
        });
           
             viewappuntamento.getButtonSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  if(viewappuntamento.getID().isEmpty())
                {
                     JOptionPane.showMessageDialog(null, "SEARCH ID VUOTO");

                }
                else{
                 viewappuntamento.RiempiCampi(modelloappuntamento.researchappointment(viewappuntamento.getID(),viewappuntamento.getusername()));
                }
            }
        });
    }
     
      public void stampatabella() {
        viewappuntamento.stampatabellaappuntamento(modelloappuntamento.getappointment( viewappuntamento.getusername()));
   } 
}
