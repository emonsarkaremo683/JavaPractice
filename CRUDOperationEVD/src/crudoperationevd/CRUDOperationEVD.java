package crudoperationevd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUDOperationEVD {

    public static void main(String[] args) {
      saveData("Emon", "emonsarkar@gmail.com", 12000.00);
//        showData();

        // updateData(1, "Emon", "emon@gmail.com",50000.00);
        delete(2);
        showData();

    }

    static void saveData(String name, String email, double salary) {
        String sql = "insert into student(name, email, salary)"
                + " values(?,?,?)";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDouble(3, salary);
            ps.executeUpdate();
            System.out.println("Saved Data");
        } catch (SQLException ex) {
            Logger.getLogger(CRUDOperationEVD.class.getName()).log(Level.SEVERE, ex.getSQLState(), ex);
        }
    }

    static void showData() {
        String sql = "select * from student";
        try (PreparedStatement ps = getCon().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name") + "\n"
                        + "Email: " + rs.getString("email") + "\n"
                        + "Salary: " + rs.getDouble("salary")
                );

            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDOperationEVD.class.getName()).log(Level.SEVERE, ex.getSQLState(), ex);
        }
    }

    static void updateData(int id, String name, String email, double salary) {
        String sql = "update student set "
                + " name = ?, email = ?, salary = ?"
                + " where id = ?";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDouble(3, salary);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("Updated Data");
        } catch (SQLException ex) {
            Logger.getLogger(CRUDOperationEVD.class.getName()).log(Level.SEVERE, ex.getSQLState(), ex);
        }
    }

    static void delete(int id) {
        String sql = "delete from student where id = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, id);

            int status = ps.executeUpdate();
            if (status > 0) {
                System.out.println("Data Deleted");
            } else {
                System.out.println("Data not found");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUDOperationEVD.class.getName()).log(Level.SEVERE, ex.getSQLState(), ex);
        }

    }

    public static Connection getCon() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/practice";
        String user = "root";
        String pass = "1234";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CRUDOperationEVD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;

    }

}
