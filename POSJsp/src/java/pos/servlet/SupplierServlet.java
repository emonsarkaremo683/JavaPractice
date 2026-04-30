package pos.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import pos.dao.SupplierDao;
import pos.model.Supplier;

@WebServlet(name = "SupplierServlet", urlPatterns = {"/suppliers", "/supplier-form", "/supplier-save", "/supplier-delete"})
public class SupplierServlet extends HttpServlet {

    private final SupplierDao supplierDao = new SupplierDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/supplier-form":
                showForm(request, response);
                break;
            case "/supplier-delete":
                deleteSupplier(request, response);
                break;
            default:
                listSuppliers(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        saveSupplier(request, response);
    }

    private void listSuppliers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Supplier> suppliers = supplierDao.findAll();
        request.setAttribute("suppliers", suppliers);
        request.getRequestDispatcher("pages/supplier-list.jsp").forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        Supplier supplier = new Supplier();
        if (idStr != null && !idStr.isEmpty()) {
            supplier = supplierDao.findById(Integer.parseInt(idStr));
        }
        request.setAttribute("supplier", supplier);
        request.getRequestDispatcher("pages/supplier-form.jsp").forward(request, response);
    }

    private void saveSupplier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String cell = request.getParameter("cell");
        String contactPersonName = request.getParameter("contactPersonName");
        String contactPersonCell = request.getParameter("contactPersonCell");
        String address = request.getParameter("address");

        Supplier supplier = new Supplier(name, cell, contactPersonName, contactPersonCell, address);
        
        if (idStr != null && !idStr.isEmpty() && !idStr.equals("0")) {
            supplier.setId(Integer.parseInt(idStr));
            supplierDao.update(supplier);
        } else {
            supplierDao.save(supplier);
        }
        response.sendRedirect(request.getContextPath() + "/suppliers");
    }

    private void deleteSupplier(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        supplierDao.delete(id);
        response.sendRedirect(request.getContextPath() + "/suppliers");
    }
}
