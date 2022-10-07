
package it.unipv.controller;

import it.unipv.model.ModelloStatistica;
import it.unipv.view.Statistica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controllerstatistica {
    
     private final ModelloStatistica modellostatistica;
     private final Statistica viewstatistica;

    public Controllerstatistica(ModelloStatistica modellostatistica, Statistica viewstatistica) {
        this.modellostatistica = modellostatistica;
        this.viewstatistica = viewstatistica;
        assegnaAscoltatoriStatistica();
        fillstatistics();
    }

    private void assegnaAscoltatoriStatistica() {
        
         viewstatistica.getButtonChiudi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  viewstatistica.setVisible(false);
            }
        });
       }
      private void fillstatistics()
      {
      viewstatistica.RiempiCampi(modellostatistica.getdatastatistics(viewstatistica.getusername()));
      }
     
}
