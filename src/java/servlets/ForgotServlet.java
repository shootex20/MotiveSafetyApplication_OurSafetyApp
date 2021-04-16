package servlets;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.PasswordStorage;

/**
 * The forgotten password servlet for handling the routing to and from the
 * forgot.jsp
 *
 * @author Dan Quach
 */
public class ForgotServlet extends HttpServlet {

    /**
     * When an action is GET will route to the forgot.jsp page
     *
     * @param request HTTP request object
     * @param response HTTP response object
     * @throws IOException When there is an error with input/output operations
     * @throws ServletException When there is an error with the servlets
     */
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

    /**
     * When the action is POST this will perform the forgotten password process
     *
     * @param request HTTP request object
     * @param response HTTP response object
     * @throws IOException When there is an error with input/output operations
     * @throws ServletException When there is an error with the servlets
     */
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
