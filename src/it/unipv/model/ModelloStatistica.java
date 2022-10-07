
package it.unipv.model;

import it.unipv.DAO.ObjectStatistica;
import it.unipv.JAVABEAN.Datastatistica;


public class ModelloStatistica {
     ObjectStatistica statistics;

    public ModelloStatistica() {
        statistics = new ObjectStatistica();
    }
    
    public Datastatistica getdatastatistics(String username){
    return statistics.numerodati(username);
    }
}
