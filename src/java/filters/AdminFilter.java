/*
 * Admin Filter for if the user is or is not an admin
 */
package filters;

import dataaccess.UserDB;
import domain.Logins;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class AdminFilter implements Filter {

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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
