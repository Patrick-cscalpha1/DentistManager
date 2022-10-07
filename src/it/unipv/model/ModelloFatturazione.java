
package it.unipv.model;

import it.unipv.DAO.ObjectFattura;
import java.sql.ResultSet;

public class ModelloFatturazione {
    ObjectFattura fattura;

    public ModelloFatturazione() {
        fattura = new ObjectFattura();
    }
     public ResultSet getdatitrattamento(String username){
    return  fattura.gettablefattura(username);
    }
}
