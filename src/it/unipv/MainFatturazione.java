
package it.unipv;

import it.unipv.controller.Controllerfatturazione;
import it.unipv.model.ModelloFatturazione;
import it.unipv.view.GestioneFattura;


public class MainFatturazione {
    public void runFatturazione(String username) {
           ModelloFatturazione modellofatturazione = new ModelloFatturazione();
           GestioneFattura viewfatturazione = new GestioneFattura(username);
           Controllerfatturazione  controllerscatisca = new  Controllerfatturazione(modellofatturazione,viewfatturazione);
            viewfatturazione.setVisible(true);
           }
}
