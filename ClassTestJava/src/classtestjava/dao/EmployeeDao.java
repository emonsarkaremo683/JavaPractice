/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classtestjava.dao;

import classtestjava.config.DBConnection;
import classtestjava.model.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class EmployeeDao {

    DBConnection dbc = new DBConnection();
    String sql;
    PreparedStatement ps;
    ResultSet rs;

    public void saveUser(Employee e) {
        sql = "insert into employee(name, email, salary) values(?, ?, ?)";
        try {
            ps = dbc.getCon().prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setDouble(3, e.getSalary());
            ps.executeUpdate();
            ps.close();
            dbc.getCon().close();
            System.out.println("Data Stored");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public List<Employee> findAll() {
        sql = "select * from employee";
        List<Employee> list = new ArrayList<>();
        Employee c;
        try {
            ps = dbc.getCon().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Employee();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setEmail(rs.getString("email"));
                c.setSalary(rs.getDouble("salary"));
                list.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    public void update(Employee e) {
        sql = "update employee set name = ?, email =?, salary =? where id = ?";

        try {
            ps = dbc.getCon().prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setDouble(3, e.getSalary());
            ps.setInt(4, e.getId());
            ps.executeUpdate();
            ps.close();
            dbc.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public void delete(int id) {
        sql = "delete from employee where Id = ?";
        try {
            ps = dbc.getCon().prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            dbc.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
