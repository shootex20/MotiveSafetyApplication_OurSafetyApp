package filters;

import dataaccess.UserDB;
import domain.Logins;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Admin Filter for controlling access to pages whether if the user is or is not
 * an admin
 *
 * @author Dan Quach
 */
public class AdminFilter implements Filter {

    /**
     * Performs verification when trying to access the admin.jsp
     *
     * @param request HTTP request object
     * @param response HTTP response object
     * @param chain To chain with the authentication filter
     * @throws IOException When there is an error with input/output operations
     * @throws ServletException When there is an error with the servlets
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        UserDB udb = new UserDB();

        Logins user = udb.getUser((String) session.getAttribute("userName"));

        if (user.getIsAdmin() == 'F') {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("companyWelcome");
            return;
        }

        chain.doFilter(request, response); // forward on to the servlet, or next filter
        // this code will execute after the servlet
    }

    /**
     * Required for filters but no code body
     *
     * @param filterConfig the filter config
     * @throws ServletException throws servlet exception
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * Required for filters but no code body
     */
    @Override
    public void destroy() {
    }
}
