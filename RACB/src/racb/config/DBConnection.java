
package racb.config;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection {
    String url = "jdbc:mysql://localhost:3306/racb";
    String user = "root";
    String pass = "1234";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    
    private Connection con;
    
    public Connection getCon(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
    
}
