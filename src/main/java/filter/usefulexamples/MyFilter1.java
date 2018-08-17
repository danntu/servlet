package filter.usefulexamples;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter1 implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter writer = servletResponse.getWriter();
        writer.print("This site is underconstruction");
        writer.close();
    }

    public void destroy() {

    }
}
