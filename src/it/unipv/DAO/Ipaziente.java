
package it.unipv.DAO;

import it.unipv.JAVABEAN.Datapaziente;
import java.sql.ResultSet;
public interface Ipaziente {
    
  public  void insertpatient(Datapaziente patient);
  public  Datapaziente ricercapaziente(String id,String username);
  public void cancellapaziente(String id);
  public void modificapaziente(Datapaziente data,String id);
  public  ResultSet gettablepaziente(String username);
}
