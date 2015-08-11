package br.lp.javabeans;

/**
 *
 * @author 31409695
 */
public class User {
    
    private int id;
    private String username, password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }  

    public int getId() {
        return id;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + '}';
    }
    
}
