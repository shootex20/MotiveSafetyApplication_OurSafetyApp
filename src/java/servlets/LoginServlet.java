package servlets;

import domain.Logins;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("userName") != null) {
            response.sendRedirect("companyWelcome");
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AccountService acctServ = new AccountService();

        String username = request.getParameter("username_input");
        String password = request.getParameter("password_input");

        Logins user = acctServ.login(username, password);

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("loginMsg", "Be sure to fill in your log in credentials");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        if (user == null) {
            request.setAttribute("loginMsg", "Login unsuccessful.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("userName", user.getUsername());
        session.setAttribute("userID", user.getUserId());
        if (user.getIsAdmin() == 'T' && user.getIsActive() == 'T') {
            response.sendRedirect("admin");

        } else if (user.getIsActive() == 'T') {
            response.sendRedirect("companyWelcome");

        } else {
            request.setAttribute("loginMsg", "This account is inactive.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

}
