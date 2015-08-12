package br.lp.commands;

import br.lp.dao.UserDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.lp.javabeans.User;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 *
 * @author 31409695
 */
public class Login implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        User user = new User(username, pass);
        UserDAO dao = new UserDAO();
        boolean registered = dao.isRegistered(user);
        if (registered) {
            try {
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                System.err.println("Erro ao redirecionar");
            }
        } else {
            try {
                request.getRequestDispatcher("loginerr.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                System.err.println("Erro ao redirecionar");
            }
        }        
    }    
}
