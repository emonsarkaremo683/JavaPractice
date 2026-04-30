package pos.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import pos.dao.CategoryDao;
import pos.model.Category;

@WebServlet(name = "CategoryServlet", urlPatterns = {"/categories", "/category-form", "/category-save", "/category-delete"})
public class CategoryServlet extends HttpServlet {

    private final CategoryDao categoryDao = new CategoryDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/category-form":
                showForm(request, response);
                break;
            case "/category-delete":
                deleteCategory(request, response);
                break;
            default:
                listCategories(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        saveCategory(request, response);
    }

    private void listCategories(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Category> categories = categoryDao.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("pages/category-list.jsp").forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        Category category = new Category();
        if (idStr != null && !idStr.isEmpty()) {
            category = categoryDao.findById(Integer.parseInt(idStr));
        }
        request.setAttribute("category", category);
        request.getRequestDispatcher("pages/category-form.jsp").forward(request, response);
    }

    private void saveCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");

        Category category = new Category(name);
        
        if (idStr != null && !idStr.isEmpty() && !idStr.equals("0")) {
            category.setId(Integer.parseInt(idStr));
            categoryDao.update(category);
        } else {
            categoryDao.save(category);
        }
        response.sendRedirect(request.getContextPath() + "/categories");
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        categoryDao.delete(id);
        response.sendRedirect(request.getContextPath() + "/categories");
    }
}
