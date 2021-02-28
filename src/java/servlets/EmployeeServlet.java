package servlets;

import dataaccess.LoginDB;
import domain.Logins;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 809968
 */
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // DQ: This segment will probably be replaced by a filter
        if (session.getAttribute("userName") == null) {
            response.sendRedirect("login");
            return;
        }

        int userID = (Integer) session.getAttribute("userID");
        Logins logins = new Logins();
        String logout = request.getParameter("logout");
        String company = request.getParameter("company");
        String equipment = request.getParameter("equipment");
        String companyWelcome = request.getParameter("companyWelcome");
        String manual = request.getParameter("manual");
        LoginDB logindb = new LoginDB();

        try {
            List<Logins> loginList = logindb.getAll();
            for (Logins login : loginList) {
                if (login.getUserId() == userID) {
                    logins = login;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(companyWelcomeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("companyName", logins.getCompanyID().getDescription());
        try {
            if (company != null) {
                response.sendRedirect("company");
                return;
            } else if (equipment != null) {
                response.sendRedirect("equipmentmanager");
                return;
            } else if (companyWelcome != null) {
                response.sendRedirect("companyWelcome");
                return;
            } else if (manual != null) {
                response.sendRedirect("manual");
                return;
            } else if (logout != null) {
                session.invalidate();
                session = request.getSession();
                response.sendRedirect("login");
                return;
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        

        getServletContext().getRequestDispatcher("/WEB-INF/employee.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/employee.jsp").forward(request, response);

    }
}
