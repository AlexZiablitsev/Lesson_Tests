package services;

import core.ReadProperties;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection con = null;
    private static ReadProperties prop = new ReadProperties();

    static {
        String url = prop.getDbURL();
        String username = prop.getDbUser();
        String pass = prop.getDbPSW();

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url,username,pass);
        }catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }

     public static Connection getConnection (){
        return con;
     }

}
