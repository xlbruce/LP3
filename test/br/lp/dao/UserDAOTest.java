package br.lp.dao;

import br.lp.javabeans.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bruce
 */
public class UserDAOTest {

    public UserDAOTest() {
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        User obj = new User("testing", "testing");
        UserDAO instance = new UserDAO();
        boolean expResult = true;
        boolean result = instance.insert(obj);
        assertEquals(expResult, result);
    }

    /*@Test
    public void testUpdate() {
    System.out.println("update");
    User old = new User(1, "admin", "admin");
    User newObj = new User("admin", "adminupdated");
    UserDAO instance = new UserDAO();
    boolean expResult = true;
    boolean result = instance.update(old, newObj);
    assertEquals(expResult, result);
    }
    
    @Test
    public void testDelete() {
    System.out.println("delete");
    User obj = new User(2, "Teste", "teste");
    UserDAO instance = new UserDAO();
    boolean expResult = true;
    boolean result = instance.delete(obj);
    assertEquals(expResult, result);
    }
    
    @Test
    public void testRead() {
    System.out.println("read");
    UserDAO instance = new UserDAO();
    int expResult = 1;
    List<User> result = instance.read();
    assertEquals(expResult, result.size());
    
    }*/

}
