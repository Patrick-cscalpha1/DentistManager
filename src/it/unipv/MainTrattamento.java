
package it.unipv;

import it.unipv.controller.Controllertrattamento;
import it.unipv.model.ModelloTrattamento;
import it.unipv.view.Gestionetrattamentofrm;


public class MainTrattamento {
     public void runTrattamento(String username) {
             ModelloTrattamento modellotrattamento = new  ModelloTrattamento();
            Gestionetrattamentofrm viewtrattamento = new Gestionetrattamentofrm(username);

            Controllertrattamento  controllertreatment = new Controllertrattamento(modellotrattamento,viewtrattamento);
            viewtrattamento.setVisible(true);
            }
}
