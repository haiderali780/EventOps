import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class RoleFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        // Check if session exists and is valid
        if (session == null || session.getAttribute("username") == null) {
            // No valid session, redirect to login page
            res.sendRedirect("index.jsp");
        } else {
            // Check the user role
            String role = (String) session.getAttribute("role");

            // Get the requested URL
            String requestURI = req.getRequestURI();

            // Check access control for admin pages
            if ((requestURI.contains("adminhomepage.jsp") || requestURI.contains("addevent.jsp")) && !"admin".equals(role)) {
                res.sendRedirect("index.jsp"); // Redirect to index if not admin
            } else if (requestURI.contains("regularuser.jsp") && (!"admin".equals(role) && !"regular".equals(role))) {
                res.sendRedirect("index.jsp"); // Redirect to index if role is neither admin nor regular
            } else {
                // Valid session and role, proceed to the requested page
                chain.doFilter(request, response);
            }
        }
    }

    public void destroy() {}
}
