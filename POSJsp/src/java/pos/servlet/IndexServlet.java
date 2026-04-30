package pos.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import pos.dao.CategoryDao;
import pos.dao.ProductDao;
import pos.dao.SalesDao;
import pos.dao.SupplierDao;

@WebServlet(name = "IndexServlet", urlPatterns = {"/index", ""})
public class IndexServlet extends HttpServlet {

    private final ProductDao productDao = new ProductDao();
    private final CategoryDao categoryDao = new CategoryDao();
    private final SupplierDao supplierDao = new SupplierDao();
    private final SalesDao salesDao = new SalesDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("totalProducts", productDao.count());
        request.setAttribute("totalCategories", categoryDao.count());
        request.setAttribute("totalSuppliers", supplierDao.count());
        request.setAttribute("totalSales", salesDao.count());
        request.setAttribute("totalRevenue", salesDao.sumTotalAmount());
        
        // Also get recent sales for activity list
        request.setAttribute("recentSales", salesDao.findAll());

        request.getRequestDispatcher("pages/index.jsp").forward(request, response);
    }
}
