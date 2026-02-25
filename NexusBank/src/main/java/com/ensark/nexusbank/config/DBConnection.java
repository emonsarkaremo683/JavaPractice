
package com.ensark.nexusbank.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private final String url = "jdbc:mysql://localhost:3306/jeestore";
    private final String username = "root";
    private final String pass = "1234";
    
    public  Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("org.mysql.Driver");
        return DriverManager.getConnection(url, username, pass);
    }
}
