
package it.unipv.DAO;

import it.unipv.JAVABEAN.Login;
import java.sql.*;

public interface Ilogin {
    public ResultSet cercadentista(Login dentist);
}
