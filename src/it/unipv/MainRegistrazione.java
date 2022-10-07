
package it.unipv;

import it.unipv.controller.Controllerregistrazione;
import it.unipv.model.ModelloRegistrazione;
import it.unipv.view.Registrazionefrm;

public class MainRegistrazione {
    
     
           public void runRegistration() {
           ModelloRegistrazione modelregistration = new ModelloRegistrazione();
           Registrazionefrm viewregistration = new Registrazionefrm();
           Controllerregistrazione  controllerRegister = new Controllerregistrazione(modelregistration,viewregistration);
            viewregistration.setVisible(true);
           }
        
}
