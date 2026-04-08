package crudemployee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrudEmployee {

    static PreparedStatement ps;
    static ResultSet rs;

    public static void main(String[] args) {
        delete(9);

        read();

    }

    static Connection getCon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "1234");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CrudEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    static void save(String name, double salary, String designation) {
        String sql = "insert into employee(name, salary, designation) "
                + "values(?,?,?)";
        try {
            ps = getCon().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(3, designation);
            ps.setDouble(2, salary);

            ps.executeUpdate();

            ps.close();
            getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(CrudEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void read() {
        String sql = "select * from employee";

        try {
            ps = getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Salary: " + rs.getDouble(3));
                System.out.println("Designation: " + rs.getString(4));

                System.out.println("========**========");
            }
            ps.close();
            getCon().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CrudEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void update(int id, String name, double salary, String designation) {
        String sql = "update employee set name = ?, salary =?, designation =? where id = ?";
        try {
            ps = getCon().prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setString(3, designation);
            ps.setInt(4, id);
            ps.executeUpdate();
            ps.close();
            getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(CrudEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void delete(int id) {
        String sql = "delete from employee where id = ?";
        try {
            ps = getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(CrudEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
