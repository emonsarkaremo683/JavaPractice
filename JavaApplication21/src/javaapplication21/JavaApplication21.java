
package javaapplication21;

import javaapplication21.dao.UserDAO;
import javaapplication21.model.User;



public class JavaApplication21 {

  
    public static void main(String[] args) {
        UserDAO udao = new UserDAO();
        User u = new User("BadRul2", "1234");
        
        udao.saveUser(u);
        
        System.out.println(udao.showUser());
        
    }
    
}
