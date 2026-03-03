package POS;

import POS.dao.CategoryDAO;
import POS.model.Category;

public class POS {

    public static void main(String[] args) {
//        UserDAO udao = new UserDAO();
//        User u = new User("BadRul2", "1234");
//        
//        udao.saveUser(u);

        Category c = new Category(1, "Banana");
        CategoryDAO cd = new CategoryDAO();
        cd.update(c);
    }

}
