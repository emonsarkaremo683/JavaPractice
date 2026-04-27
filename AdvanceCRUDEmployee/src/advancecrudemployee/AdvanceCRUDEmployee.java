package advancecrudemployee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdvanceCRUDEmployee {

    public static void main(String[] args) {

    }

    static Connection getCon() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "1234");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdvanceCRUDEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;

    }

    static void saveEmployee(String name, String designation, double salary) {
        String sql = "insert into emoployee1(name, designation, salary) "
                + "values(?,?,?)";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, designation);
            ps.setDouble(3, salary);
            ps.executeUpdate();
            System.out.println("Data Saved");
        } catch (SQLException ex) {
            Logger.getLogger(AdvanceCRUDEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void updateEmployee(String name, String designation, double salary, int id) {
        String sql = "update emoployee1 set name =?, designation=?, salary=? where id = ?";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, designation);
            ps.setDouble(3, salary);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("\n Data Updated");
        } catch (SQLException ex) {
            Logger.getLogger(AdvanceCRUDEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void showAll() {
        String sql = "select * from emoployee1";
        try (PreparedStatement ps = getCon().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID:" + rs.getInt(1));
                System.out.println("Name:" + rs.getString(2));
                System.out.println("Designation:" + rs.getString(3));
                System.out.println("Salary:" + rs.getDouble(4));
                System.out.println("===========**===========");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdvanceCRUDEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void delete(int id) {
        String sql = "delete from emoployee1 where id =?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("\n Data Deleted");
        } catch (SQLException ex) {
            Logger.getLogger(AdvanceCRUDEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
