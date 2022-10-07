
package it.unipv.controller;
import it.unipv.model.ModelloRegistrazione;
import it.unipv.view.Registrazionefrm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controllerregistrazione {
private ModelloRegistrazione modelregistration;
private Registrazionefrm viewregistration;
ResultSet result;


    public Controllerregistrazione(ModelloRegistrazione modelregistration, Registrazionefrm viewregistration) {
        this.modelregistration = modelregistration;
        this.viewregistration = viewregistration;
         assegnaAscoltatoriRegistrazionefrm();

    }

    private void assegnaAscoltatoriRegistrazionefrm() {
        viewregistration.getButtonconfermaregistrazione().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               result= modelregistration.cercanomeutente(viewregistration.getusername());
                try {
                    if(result.next()){
                        JOptionPane.showMessageDialog(null, "USERNAME GIA' USATO,CAMBI IL USERNAME");
                    }
                    else{
                         modelregistration.RegisterDentist(viewregistration.getdatiregistrazionefrm());
                        viewregistration.azzeracampi();
                       
                        }
                     } catch (Exception ex) {
                     ex.printStackTrace();
          
                       }
            }
        });
        
        viewregistration.getButtontornaindietro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewregistration.setVisible(false);
                   // JOptionPane.showMessageDialog(null, "TORNA INDIETRO");
            }
        });
    }

    
}
