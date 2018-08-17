package filter.usefulexamples;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter2 implements Filter {
    static int count = 0;

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter writer = servletResponse.getWriter();
        filterChain.doFilter(servletRequest, servletResponse);
        writer.print("Total visitors " + (++count));
        writer.close();
    }

    public void destroy() {

    }
}
