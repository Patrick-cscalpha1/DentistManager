
package it.unipv;
import it.unipv.controller.Controllerappuntamento;
import it.unipv.model.ModelloAppuntamento;
import it.unipv.view.Gestioneappuntamentofrm;


public class MainAppuntamento {
    public void runAppuntamento(String username) {
            ModelloAppuntamento modelloappuntamento = new ModelloAppuntamento();
            Gestioneappuntamentofrm viewappuntamento = new Gestioneappuntamentofrm(username);
            Controllerappuntamento  controllerappointment = new Controllerappuntamento(modelloappuntamento,viewappuntamento);
            viewappuntamento.setVisible(true);
            }
}
