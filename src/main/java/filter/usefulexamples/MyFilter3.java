package filter.usefulexamples;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter3 implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter writer = servletResponse.getWriter();
        long before = System.currentTimeMillis();

        filterChain.doFilter(servletRequest, servletResponse);
        long after = System.currentTimeMillis();
        writer.print("Total responce time " + (after - before) + " miliseconds");
        writer.close();
    }

    public void destroy() {

    }
}
