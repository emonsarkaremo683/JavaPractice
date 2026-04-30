package pos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pos.model.Sales;
import pos.util.DbUtil;
import pos.util.SalesUtil;

public class SalesDao {

    DbUtil db = new DbUtil();
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    SalesUtil su = new SalesUtil();

    public SalesDao() {
    }

    public int save(Sales e) {
        int salesId = 0;
        sql = "INSERT INTO sales(invoice_no,sales_date,customer_cell,total_amount) VALUES(?,?,?,?)";
        try {
            ps = db.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, e.getInvoiceNo());
            ps.setDate(2, e.getSqlsalesDate());
            ps.setString(3, e.getCustomerCell());
            ps.setDouble(4, e.getTotalAmount());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                salesId = rs.getInt(1);
            }

            ps.close();
            db.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
        return salesId;
    }

    public List<Sales> findAll() {
        List<Sales> list = new ArrayList<>();
        sql = "select * from sales order by sales_date desc";
        try {
            ps = db.getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sales s = new Sales(
                        rs.getInt("id"),
                        rs.getString("invoice_no"),
                        rs.getDate("sales_date"),
                        rs.getString("customer_cell"),
                        rs.getDouble("total_amount")
                );
                list.add(s);
            }
            ps.close();
            db.getCon().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
        return list;
    }
    public int count() {
        int count = 0;
        String sqlCount = "SELECT COUNT(*) FROM sales";
        try {
            ps = db.getCon().prepareStatement(sqlCount);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            ps.close();
            db.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
        return count;
    }

    public double sumTotalAmount() {
        double sum = 0;
        String sqlSum = "SELECT SUM(total_amount) FROM sales";
        try {
            ps = db.getCon().prepareStatement(sqlSum);
            rs = ps.executeQuery();
            if (rs.next()) {
                sum = rs.getDouble(1);
            }
            ps.close();
            db.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
        return sum;
    }
}
