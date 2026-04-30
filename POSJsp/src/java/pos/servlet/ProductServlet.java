package pos.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import pos.dao.CategoryDao;
import pos.dao.ProductDao;
import pos.dao.SupplierDao;
import pos.model.Product;

@WebServlet(name = "ProductServlet", urlPatterns = {"/products", "/product-form", "/product-save", "/product-delete"})
public class ProductServlet extends HttpServlet {

    private final ProductDao productDao = new ProductDao();
    private final CategoryDao categoryDao = new CategoryDao();
    private final SupplierDao supplierDao = new SupplierDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/product-form":
                showForm(request, response);
                break;
            case "/product-delete":
                deleteProduct(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        saveProduct(request, response);
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products = productDao.findAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("pages/product-list.jsp").forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        Product product = new Product();
        if (idStr != null && !idStr.isEmpty()) {
            product = productDao.findById(Integer.parseInt(idStr));
        }
        request.setAttribute("product", product);
        request.setAttribute("categories", categoryDao.findAll());
        request.setAttribute("suppliers", supplierDao.findAll());
        request.getRequestDispatcher("pages/product-form.jsp").forward(request, response);
    }

    private void saveProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        double quantity = Double.parseDouble(request.getParameter("quantity"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int supplierId = Integer.parseInt(request.getParameter("supplierId"));

        Product product = new Product(name, price, quantity, supplierId, categoryId);
        
        if (idStr != null && !idStr.isEmpty() && !idStr.equals("0")) {
            product.setId(Integer.parseInt(idStr));
            productDao.update(product);
        } else {
            productDao.save(product);
        }
        response.sendRedirect(request.getContextPath() + "/products");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDao.delete(id);
        response.sendRedirect(request.getContextPath() + "/products");
    }
}
