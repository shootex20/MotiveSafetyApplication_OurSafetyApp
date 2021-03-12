package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.PasswordStorage;

/**
 *
 * @author Daniel Quach
 */
public class ForgotServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("userName") != null) {
            response.sendRedirect("companyWelcome");
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("usern_input");
        String email = request.getParameter("email_input");
        String firstName = request.getParameter("firstn_input");
        String lastName = request.getParameter("lastn_input");
        String dob = request.getParameter("dob_input");
        String phone = request.getParameter("phone_input");

        if (userName == null || userName.isEmpty() || email == null || email.isEmpty() || firstName == null
                || firstName.isEmpty() || lastName == null || lastName.isEmpty() || dob == null || dob.isEmpty()
                || phone == null || phone.isEmpty()) {

            request.setAttribute("resetMsg", "Be sure to fill in all of your information");
            getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
            return;
        }
        
        PasswordStorage ps = new PasswordStorage();
        
        try {
        ps.passwordReset(userName, email, firstName, lastName, dob, phone);
        } catch (Exception e) {
            response.sendRedirect("login");
            request.setAttribute("resetMsg", "Be sure to fill your correct information");
            getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
            return;
        }

        response.sendRedirect("login");
    }

}
