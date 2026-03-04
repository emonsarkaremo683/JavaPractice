package jeestudent.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jeestudent.config.DBConnection;
import jeestudent.model.Student;
import jeestudent.service.DaoService;

public class StudentDao implements DaoService<Student> {

    DBConnection dbc = new DBConnection();
    Student student;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    @Override
    public void save(Student e) {
        sql = "insert into student(name, email, courseName) values(?,?,?)";

        try {
            ps = dbc.getCon().prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getCourseName());
            ps.executeUpdate();

            ps.close();
            dbc.getCon().close();
            JOptionPane.showMessageDialog(null, "Data Saved");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data not Saved");
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Student e) {
        sql = "update student set name = ?, email = ?, courseName = ? where id = ?";
        try {
            ps = dbc.getCon().prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getCourseName());
            ps.setInt(4, e.getId());
            ps.executeUpdate();

            ps.close();
            dbc.getCon().close();
            JOptionPane.showMessageDialog(null, "Data Updated");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data not Updated");
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Student> findAll() {
        List<Student> sList = new ArrayList<>();
        sql = "select * from student";
        try {
            ps = dbc.getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                student = new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("courseName")
                );
                sList.add(student);

            }
            ps.close();
            rs.close();
            dbc.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sList;
    }

    @Override
    public void delete(int id) {
        
        sql = "delete from student where id = ?";
         try {
            ps = dbc.getCon().prepareStatement(sql);
            ps.setInt(1, id);          
            ps.executeUpdate();
            ps.close();
            dbc.getCon().close();
            JOptionPane.showMessageDialog(null, "Data Deleted");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data not deleted");
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        

    }

}
