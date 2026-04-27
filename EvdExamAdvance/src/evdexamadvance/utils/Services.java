package evdexamadvance.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Services {
    PreparedStatement ps;
    ResultSet rs;

    public Services() {
    }

    public static Connection getCon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "1234");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    //Inserting Data
    public void saveData(String name, String designation, Date date, Double salary) {
        String sql = "insert into employee(name, designation, joiningDate, salary) values(?,?,?,?)";

        try {
            ps = getCon().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, designation);
            ps.setDate(3, date);
            ps.setDouble(4, salary);
            ps.executeUpdate();

            ps.close();
            getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Reading Data
    public void showAll() {
        String sql = "select * from employee";
        try {
            ps = getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Designation: " + rs.getString("designation"));
                System.out.println("Joining Date: " + rs.getDate("joiningDate"));
                System.out.println("Salary: " + rs.getInt("salary"));
                System.out.println("======= ** =========");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Updating data
    public void updateData(int id, String name, String designation, Date date, Double salary) {
        String sql = "update employee set name=?, designation=?, joiningDate=?, salary=? where id =?";

        try {
            ps = getCon().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, designation);
            ps.setDate(3, date);
            ps.setDouble(4, salary);
            ps.setInt(5, id);
            ps.executeUpdate();

            ps.close();
            getCon().close();
            System.out.println("====== * Data Updated * ========");

        } catch (SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //deleting data
    public void deleteData(int id) {
        String sql = "delete from employee where id =?";

        try {
            ps = getCon().prepareStatement(sql);
            ps.setInt(1, id);
            int val = ps.executeUpdate();
            
            ps.close();
            getCon().close();
            if(val == 1){
                System.out.println("====== * Data Deleted * ========");
            } else {
                System.out.println("No Data exists in this given id");
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
