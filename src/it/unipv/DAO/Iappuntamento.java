
package it.unipv.DAO;

import it.unipv.JAVABEAN.Dataappuntamento;
import java.sql.ResultSet;
public interface Iappuntamento {
    
  public  void insertappuntamento(Dataappuntamento patient);
  public void modificappuntamento(Dataappuntamento data,String id);
  public void cancellappuntamento(String id);
  public  ResultSet gettableappuntamento(String username);
  public  Dataappuntamento ricercaappuntamento(String id,String username);
  public ResultSet cercacfTrattamento(String cf,String treatment,String username);
}
