
package POS.model;


public class User {
    private int id;
    private String username;
    private String pass;
    private String role;

    public User() {
    }

    public User(String username, String pass) {
       
        this.username = username;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole() {
        this.role = "Admin";
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", pass=" + pass + ", role=" + role + '}';
    }
    
    
    
}
