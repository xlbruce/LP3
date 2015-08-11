package br.lp.commands;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31409695
 */
public class Login implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        
        if ("admin".equals(user) && "admin".equals(pass)) {
            try {
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                System.err.println("Erro ao redirecionar");
            }
        } else {
            try {
                request.getRequestDispatcher("loginerr.jsp").forward(request, response);
            } catch (IOException | ServletException ex) {
                System.err.println("Erro ao redirecionar");
            }
        }
    }
    
}
