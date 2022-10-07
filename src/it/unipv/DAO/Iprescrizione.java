
package it.unipv.DAO;

import it.unipv.JAVABEAN.Dataprescrizione;
import java.sql.ResultSet;


public interface Iprescrizione {
        
  public  void insertprescription(Dataprescrizione patient);
  public  Dataprescrizione ricercaprescrizione(String id,String username);
  public void cancellaprescrizione(String id);
  public void modificaprescrizione(Dataprescrizione data,String id);
  public  ResultSet gettableprescrizione(String username);
  public ResultSet cercacfTrattamento(String cf,String treatment,String username);
}
