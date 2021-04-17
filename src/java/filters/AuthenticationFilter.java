package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Authentication Filter for controlling access if there is no username
 *
 * @author Dan Quach
 */
public class AuthenticationFilter implements Filter {

    /**
     * Performs verification when trying to access any
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

        // code that is executed before the servlet
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        String user = (String) session.getAttribute("userName");

        if (user == null) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("login");
            return;
        }

        chain.doFilter(request, response); // execute the servlet
        // code that is executed after the servlet  
    }

    /**
     * Required for filters but no code body
     *
     * @param filterConfig takes filterConfig
     * @throws ServletException throws ServletException
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
