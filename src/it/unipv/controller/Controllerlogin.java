
package it.unipv.controller;
import it.unipv.MainMenuprincipale;
import it.unipv.MainRegistrazione;
import it.unipv.model.ModelloLogin;
import it.unipv.view.Loginfrm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class Controllerlogin {
 
private ModelloLogin modellogin;
private Loginfrm viewlogin;

//variabile per chiamare la Main della registrazione
MainRegistrazione register ;



    public Controllerlogin(ModelloLogin modellogin, Loginfrm viewlogin) {
        this.modellogin = modellogin;
        this.viewlogin = viewlogin;
        register = new MainRegistrazione();
        assegnaAscoltatoriLoginfrm();
    }

    private void assegnaAscoltatoriLoginfrm() {
        viewlogin.getButtonlogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modellogin.VerificaLogin(viewlogin.getdatiloginfrm(),viewlogin.getName());
                viewlogin.azzeracampi();
                
            }
        });
        
        viewlogin.getButtonRegistrarti().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register.runRegistration();
              
            }
        });
    }
    


}
