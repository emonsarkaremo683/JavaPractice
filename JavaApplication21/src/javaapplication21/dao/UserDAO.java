package javaapplication21.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication21.config.DBConnection;
import javaapplication21.model.User;

public class UserDAO {

    DBConnection dbc = new DBConnection();
    private PreparedStatement ps;
    ResultSet rs;
    String sql = "";
    
    public void saveUser(User user){
        sql = "insert into user(username, pass) values(?, ?)";
        try {
            ps = dbc.getConn().prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPass());
            ps.executeUpdate();
            ps.close();
            dbc.getConn().close();
            System.out.println("Data Stored");
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public User showUser(){
        sql = "select * from user";
        User user = new User();
        try {
            ps = dbc.getConn().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPass(rs.getString("pass"));
                user.setRole();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
        
    }
    
}
