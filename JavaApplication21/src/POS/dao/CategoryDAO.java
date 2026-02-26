package POS.dao;

import POS.config.DBConnection;
import POS.model.Category;
import POS.service.DaoService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CategoryDAO implements DaoService<Category> {

    DBConnection dbc = new DBConnection();
    private PreparedStatement ps;
    ResultSet rs;
    String sql = "";
    Category c;

    @Override
    public void save(Category e) {
        sql = "insert into category(name) values(?)";

        try {
            ps = dbc.getConn().prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.executeUpdate();
            ps.close();
            dbc.getConn().close();
            JOptionPane.showMessageDialog(null, "Saved");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "not Saved");
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Category> findAll() {
        sql = "select * from category";
        List<Category> list = new ArrayList<>();
        try {
            ps = dbc.getConn().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                list.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void update(Category e) {
        sql = "update category set name = ? where id = ?";


        try {
            ps = dbc.getConn().prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.setInt(2, e.getId());
            ps.executeUpdate();
            ps.close();
            dbc.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Category findById(int id) {
        sql = "select * from category where id = ?";
        c = new Category();
        try {
            ps = dbc.getConn().prepareStatement(sql);
            rs = ps.executeQuery();

            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public void delete(int id) {
        sql = "delete from category where Id = ?";
        try {
            ps = dbc.getConn().prepareStatement(sql);
            ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

}
