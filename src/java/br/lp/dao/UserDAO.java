package br.lp.dao;

import br.lp.javabeans.User;
import br.lp.connectionfactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31409695
 */
public class UserDAO implements DAO<User>{
    
    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;

    public UserDAO() {
        try {
            connection = new ConnectionFactory().getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Erro ao realizar a conexão");
            System.err.println(ex.getMessage());
        }        
    }
    
    /*private User getUserById(int id) {
    String sql = "SELECT * FROM usuario WHERE id = ?";
    User user = new User("", "");
    try {
    ps = connection.prepareStatement(sql);
    ps.setInt(1, id);
    rs = ps.executeQuery();
    rs.first();
    user = new User(rs.getString(1), rs.getString(2));
    return user;
    } catch (SQLException ex) {
    System.err.println("Erro  na leitura (User)");
    System.err.println(ex.getMessage());
    }
    return null;
    }*/

    public boolean isRegistered(User u) {
        String sql = "SELECT * FROM usuario WHERE username = ? "
                + "AND password = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            rs = ps.executeQuery();            
            return rs.first();
        } catch (SQLException ex) {
            System.err.println("Erro ao consultar usuário cadastrado");
            System.err.println(ex.getMessage());
        }
        return false;
    }
    
    @Override
    public boolean insert(User obj) { 
        String sql = "INSERT INTO usuario (username, password) "
                + "VALUES (?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, obj.getUsername());
            ps.setString(2, obj.getPassword());
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro na execução do SQL (Inserting user)");
            System.err.println(ex.getMessage());
        }       
        
        return false;        
    }

    @Override
    public boolean update(User old, User newObj) {
        if (old.getId() == -1) return false;
        
        String sql = "UPDATE usuario SET username = ?, password = ? "
                + "WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, newObj.getUsername());
            ps.setString(2, newObj.getPassword());
            ps.setInt(3, old.getId());
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar");
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(User obj) {
        String sql= "DELETE FROM usuario WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, obj.getId());
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar");
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<User> read() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getString("username"), 
                        rs.getString("password")));
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao fazer a leitura no banco de dados");
            System.err.println(ex.getMessage());
        }
        return users;
    }
    
}
