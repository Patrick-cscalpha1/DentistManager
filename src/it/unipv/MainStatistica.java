
package it.unipv;

import it.unipv.controller.Controllerstatistica;
import it.unipv.model.ModelloStatistica;
import it.unipv.view.Statistica;


public class MainStatistica {
     public void runStatistica(String username) {
           ModelloStatistica modellostatistica = new ModelloStatistica();
           Statistica viewstatistica = new Statistica(username);
           Controllerstatistica  controllerstatisca = new  Controllerstatistica(modellostatistica,viewstatistica);
            viewstatistica.setVisible(true);
           }
}
