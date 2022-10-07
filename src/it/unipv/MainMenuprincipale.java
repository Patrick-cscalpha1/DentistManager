
package it.unipv;

import it.unipv.controller.Controllermenuprincipale;
import it.unipv.model.ModelloMenuprincipale;
import it.unipv.view.Menuprincipale;

public class MainMenuprincipale {
    
   
    
   
     public void runMenuPrincipale(String name) {
           ModelloMenuprincipale modelmenu = new ModelloMenuprincipale(name);
           Menuprincipale viewmenu = new Menuprincipale();
            Controllermenuprincipale  controllermenu = new  Controllermenuprincipale(modelmenu,viewmenu);
            viewmenu.setVisible(true);
           }
}
