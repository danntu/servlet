package filter.authentication;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        String password = servletRequest.getParameter("password");
        if ("password".equals(password)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            writer.print("Username or password error");
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("index.html");
            dispatcher.include(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
}
