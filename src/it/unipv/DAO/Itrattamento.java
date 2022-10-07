
package it.unipv.DAO;

import it.unipv.JAVABEAN.Datatrattamento;
import java.sql.ResultSet;


public interface Itrattamento {
  
  public  void inserttrattamento(Datatrattamento patient);
  public void modificatrattamento(Datatrattamento data,String id);
  public void cancellatrattamento(String id);
  public  Datatrattamento ricercatrattamento(String id,String username);
  public  ResultSet gettabletrattamento(String username);
}
