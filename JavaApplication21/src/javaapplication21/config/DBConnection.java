
package javaapplication21.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private final String url = "jdbc:mysql://localhost:3306/jeestore";
    private final String user = "root";
    private final String pass = "1234";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private Connection con = null;
    
    public  Connection getConn(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            return con;
        
    }
    
 
}
