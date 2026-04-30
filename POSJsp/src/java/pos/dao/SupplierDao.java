/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pos.model.Supplier;
import pos.service.DaoService;
import pos.util.DbUtil;

/**
 *
 * @author Admin
 */
public class SupplierDao implements DaoService<Supplier> {

    DbUtil db = new DbUtil();
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    @Override
    public void save(Supplier e) {

        sql = "insert into supplier(name, cell, contactPersonName, contactPersonCell,address) values(?,?,?,?,?)";
        try {
            ps = db.getCon().prepareStatement(sql);

            ps.setString(1, e.getName());
            ps.setString(2, e.getCell());
            ps.setString(3, e.getContactPersonName());
            ps.setString(4, e.getContactPersonCell());
            ps.setString(5, e.getAddress());

            ps.executeUpdate();

            ps.close();
            db.getCon().close();

            System.out.println("Supplier Added");

        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }

    }

    @Override
    public List<Supplier> findAll() {
        List<Supplier> list = new ArrayList<>();

        sql = "select * from supplier";
        try {
            ps = db.getCon().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                Supplier s = new Supplier(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("cell"),
                        rs.getString("contactPersonName"),
                        rs.getString("contactPersonCell"),
                        rs.getString("address")
                );

                list.add(s);
            }

            ps.close();
            db.getCon().close();
            rs.close();

            // JOptionPane.showConfirmDialog(null, "Supplier Added");
        } catch (SQLException ex) {
            // JOptionPane.showConfirmDialog(null, "Supplier not Add");

            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
        return list;
    }

    @Override
    public Supplier findById(int id) {
        Supplier s = null;
        sql = "select * from supplier where id = ?";
        try {
            ps = db.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                s = new Supplier(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("cell"),
                        rs.getString("contactPersonName"),
                        rs.getString("contactPersonCell"),
                        rs.getString("address")
                );
            }
            ps.close();
            db.getCon().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
        return s;
    }

    @Override
    public void delete(int id) {
        sql = "delete from supplier where id = ?";
        try {
            ps = db.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            db.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
    }

    @Override
    public void update(Supplier e) {
        sql = "update supplier set name = ?, cell =?, contactPersonName =?, contactPersonCell =? , address = ?  where id =?";
        try {
            ps = db.getCon().prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.setString(2, e.getCell());
            ps.setString(3, e.getContactPersonName());
            ps.setString(4, e.getContactPersonCell());
            ps.setString(5, e.getAddress());
            ps.setInt(6, e.getId());
            ps.executeUpdate();
            ps.close();
            db.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
    }
    
    public List<String> getAllSupplierName() {
        List<String> list = new ArrayList<>();
        sql = "Select name from supplier";

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
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int getIdByName(String supplierName) {

        sql = "Select id from supplier where name = ?";

        int id=0;

        try {
            ps = db.getCon().prepareStatement(sql);
            ps.setString(1, supplierName);

            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
            }

            ps.close();
            rs.close();
            db.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
        return id;
    }

    public int count() {
        int count = 0;
        String sqlCount = "SELECT COUNT(*) FROM supplier";
        try {
            ps = db.getCon().prepareStatement(sqlCount);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            ps.close();
            db.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
        return count;
    }
}
