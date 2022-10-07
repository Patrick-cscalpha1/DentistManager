
package it.unipv;

import it.unipv.controller.Controllerpaziente;
import it.unipv.model.ModelloPaziente;
import it.unipv.view.Gestionepazientefrm;


public class MainPaziente {
   public void runMenuPaziente(String username) {
           ModelloPaziente modelpaziente = new ModelloPaziente();
           Gestionepazientefrm viewpaziente = new Gestionepazientefrm(username);
           Controllerpaziente  controllerpatient = new  Controllerpaziente(modelpaziente,viewpaziente);
            viewpaziente.setVisible(true);
           }  
}
