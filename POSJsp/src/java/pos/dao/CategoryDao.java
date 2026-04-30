package pos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import pos.model.Category;
import pos.service.DaoService;
import pos.util.DbUtil;

public class CategoryDao implements DaoService<Category> {

    DbUtil db = new DbUtil();
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    @Override
    public void save(Category e) {

        sql = "insert into category(name) values(?)";
        try {
            ps = db.getCon().prepareStatement(sql);
            ps.setString(1, e.getName());

            ps.executeUpdate();

            ps.close();
            db.getCon().close();

            

            System.out.println("Done");

        } catch (SQLException ex) {
            
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }

    }

    @Override
    public List<Category> findAll() {
        List<Category> cList = new ArrayList<>();
        sql = "Select id, name from category order by id";
        try {
            ps = db.getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category s = new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                cList.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
        return cList;
    }

    @Override
    public void update(Category e) {
        sql = "update category set name = ? where id = ?";

        try {
            ps = db.getCon().prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.setInt(2, e.getId());

            ps.executeUpdate();

            ps.close();
            db.getCon().close();



        } catch (SQLException ex) {

            
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }

    }

    @Override
    public Category findById(int id) {
        Category category = null;
        sql = "Select id, name from category where id = ?";
        try {
            ps = db.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                category = new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }
            ps.close();
            rs.close();
            db.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
        return category;
    }

    @Override
    public void delete(int id) {
        sql = "delete from category where id = ?";
        try {
            ps = db.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            db.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
    }

    public List<String> getAllCategoryName() {
        List<String> list = new ArrayList<>();
        sql = "Select name from category";

        try {
            ps = db.getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("name"));
            }
            ps.close();
            rs.close();
            db.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
        return list;
    }

    public int getIdByName(String categoryName) {

        sql = "Select id from category where name = ?";

        int id=0;

        try {
            ps = db.getCon().prepareStatement(sql);
            ps.setString(1, categoryName);

            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
            }

            ps.close();
            rs.close();
            db.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
        return id;
    }

    public int count() {
        int count = 0;
        String sqlCount = "SELECT COUNT(*) FROM category";
        try {
            ps = db.getCon().prepareStatement(sqlCount);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            ps.close();
            db.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
        return count;
    }
}
