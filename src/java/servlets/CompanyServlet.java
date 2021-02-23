package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CompanyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session = request.getSession();
        String linkAction = request.getParameter("action");

        if (linkAction != null && linkAction.equals("logout")) {
            session.invalidate();
            session = request.getSession();
            request.setAttribute("loginMsg", "You have successfully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        if (session.getAttribute("userName") == null) {
            response.sendRedirect("login");
            return;

        } else if (session.getAttribute("userName") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/companyManagement.jsp").forward(request, response);
        }


        getServletContext().getRequestDispatcher("/WEB-INF/companyManagement.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/companyManagement.jsp").forward(request, response);

    }

}
