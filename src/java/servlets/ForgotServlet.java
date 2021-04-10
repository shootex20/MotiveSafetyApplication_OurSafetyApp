package servlets;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.PasswordStorage;

public class ForgotServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        UUID uuid = UUID.randomUUID();
        String token = uuid.toString();
        request.getSession().setAttribute("token", token);
        request.setAttribute("token", token);

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

        String tokenInput = request.getParameter("token");

        if (tokenInput != null) {
            String tokenSession = (String) request.getSession().getAttribute("token");

            if (tokenInput.equals(tokenSession)) {

                String userName = request.getParameter("username_input");

                if (userName == null || userName.isEmpty()) {

                    request.setAttribute("resetMsg", "Be sure to fill in your information");
                    getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
                    return;
                }

                PasswordStorage ps = new PasswordStorage();

                try {
                    ps.passwordReset(userName);
                } catch (Exception e) {
                    request.setAttribute("resetMsg", "Be sure to fill your correct information");
                    getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
                    return;
                }

                response.sendRedirect("login");
            }
        }
    }

}
