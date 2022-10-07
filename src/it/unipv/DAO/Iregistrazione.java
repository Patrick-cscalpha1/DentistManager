
package it.unipv.DAO;

import it.unipv.JAVABEAN.Datadentista;
import java.sql.ResultSet;


public interface Iregistrazione {
    public void InsertDatiDentista(Datadentista dentist);
    public ResultSet cercausername(String dentistusername);
}
