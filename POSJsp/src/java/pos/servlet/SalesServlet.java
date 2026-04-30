package pos.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import pos.dao.ProductDao;
import pos.dao.SalesDao;
import pos.dao.SalesItemDAO;
import pos.model.Product;
import pos.model.Sales;
import pos.model.SalesItem;

@WebServlet(name = "SalesServlet", urlPatterns = {"/sales", "/sales-form", "/sales-save", "/sales-view"})
public class SalesServlet extends HttpServlet {

    private final SalesDao salesDao = new SalesDao();
    private final SalesItemDAO salesItemDAO = new SalesItemDAO();
    private final ProductDao productDao = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/sales-form":
                showSalesForm(request, response);
                break;
            case "/sales-view":
                // viewSalesDetails(request, response);
                break;
            default:
                listSales(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        saveSale(request, response);
    }

    private void listSales(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Sales> salesList = salesDao.findAll();
        request.setAttribute("salesList", salesList);
        request.getRequestDispatcher("pages/sales-list.jsp").forward(request, response);
    }

    private void showSalesForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products = productDao.findAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("pages/sales-form.jsp").forward(request, response);
    }

    private void saveSale(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String invoiceNo = request.getParameter("invoiceNo");
        String customerCell = request.getParameter("customerCell");
        double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));

        Sales sale = new Sales(invoiceNo, customerCell, totalAmount);
        int salesId = salesDao.save(sale);

        if (salesId > 0) {
            String[] productIds = request.getParameterValues("productId[]");
            String[] prices = request.getParameterValues("price[]");
            String[] quantities = request.getParameterValues("quantity[]");

            for (int i = 0; i < productIds.length; i++) {
                int productId = Integer.parseInt(productIds[i]);
                double unitPrice = Double.parseDouble(prices[i]);
                double quantity = Double.parseDouble(quantities[i]);
                double rowTotal = unitPrice * quantity;

                SalesItem item = new SalesItem(salesId, productId, quantity, unitPrice, rowTotal, 0, 0, rowTotal);
                salesItemDAO.saveSalesItem(item);
                
                // Update product quantity (decrement stock)
                Product product = productDao.findById(productId);
                if (product != null) {
                    product.setQuantity(product.getQuantity() - quantity);
                    productDao.update(product);
                }
            }
        }

        response.sendRedirect(request.getContextPath() + "/sales");
    }
}
