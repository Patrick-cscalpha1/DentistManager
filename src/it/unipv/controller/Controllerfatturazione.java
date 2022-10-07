
package it.unipv.controller;

import it.unipv.model.ModelloFatturazione;
import it.unipv.view.GestioneFattura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class Controllerfatturazione {
     private ModelloFatturazione modellofatturazione;
     private GestioneFattura viewfatturazione;

    public Controllerfatturazione(ModelloFatturazione modellofatturazione, GestioneFattura viewfatturazione) {
        this.modellofatturazione = modellofatturazione;
        this.viewfatturazione = viewfatturazione;
        assegnaAscoltatoriFatturazione();
        gettablefatturazione();
    }

    private void assegnaAscoltatoriFatturazione() {
        
            viewfatturazione.getButtonStampa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    viewfatturazione.stampa();
                    viewfatturazione.azzeracampi();
            }
        });
            
            viewfatturazione.getButtonChiudi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    viewfatturazione.setVisible(false);
            }
        });
                
        }
     
   private void  gettablefatturazione(){
     viewfatturazione.stampatabellafattura(modellofatturazione.getdatitrattamento( viewfatturazione.getusername()));
   }
}
