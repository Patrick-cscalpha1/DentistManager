
package it.unipv;

import it.unipv.controller.Controllerprescrizioni;
import it.unipv.model.ModelloPrescrizione;
import it.unipv.view.Gestioneprescrizionefrm;


public class MainPrescrizioni {
      public void runPrescrizione(String username) {
            ModelloPrescrizione modelloprescrizione = new ModelloPrescrizione();
            Gestioneprescrizionefrm viewprescrizione = new Gestioneprescrizionefrm(username);
            Controllerprescrizioni  controllerprescription = new Controllerprescrizioni(modelloprescrizione,viewprescrizione);
            viewprescrizione.setVisible(true);
            }
}
