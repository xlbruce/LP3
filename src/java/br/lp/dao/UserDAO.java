package br.lp.dao;

import br.lp.javabeans.User;
import com.br.cacique.MVCModel.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            connection = ConnectionFactory.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Erro ao realizar a conexão");
            System.err.println(ex.getMessage());
        }        
    }
    
    private User getUserById(int id) {
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
    }

    @Override
    public boolean insert(User obj) {        
        boolean success = false;
        String sql = "INSERT INTO usuario (username, password) "
                + "VALUES (?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, obj.getUsername());
            ps.setString(2, obj.getPassword());
            success = ps.execute();
            connection.close();
        } catch (SQLException ex) {
            System.err.println("Erro na execução do SQL (Inserting user)");
            System.err.println(ex.getMessage());
        }       
        
        return success;        
    }

    @Override
    public boolean update(User old, User newObj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
