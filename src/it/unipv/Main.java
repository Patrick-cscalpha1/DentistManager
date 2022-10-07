

package it.unipv;

import it.unipv.controller.Controllerlogin;
import it.unipv.model.ModelloLogin;
import it.unipv.view.Loginfrm;
import javax.swing.SwingUtilities;



public class Main {
      /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
            ModelloLogin modellogin = new ModelloLogin();
            Loginfrm viewlogin = new Loginfrm();
            Controllerlogin  controller = new Controllerlogin(modellogin,viewlogin);
            viewlogin.setVisible(true);
            }
        
        });
    }
}
