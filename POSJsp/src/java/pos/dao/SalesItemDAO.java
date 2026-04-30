package pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pos.model.SalesItem;
import pos.util.DbUtil;

public class SalesItemDAO {

    private final DbUtil db = new DbUtil();

    public void saveSalesItem(SalesItem item) {
        String sql = "INSERT INTO sales_items(sales_id,product_id,quantity,unit_price,total_price,discount_rate,discount,actual_price) VALUES(?,?,?,?,?,?,?,?)";
        
        try (Connection con = db.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, item.getSalesId());
            ps.setInt(2, item.getProductId());
            ps.setDouble(3, item.getQuantity());
            ps.setDouble(4, item.getUnitPrice());
            ps.setDouble(5, item.getTotalPrice());
            ps.setDouble(6, item.getDiscountRate());
            ps.setDouble(7, item.getDiscount());
            ps.setDouble(8, item.getActualPrice());

            ps.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(SalesItemDAO.class.getName()).log(Level.SEVERE, "Error saving sales item", e);
        }
    }
}
