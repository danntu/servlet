import java.io.*;
import javax.servlet.*;

public class First implements Servlet{
    ServletConfig config = null;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config=config;
        System.out.println("servlet is initialized");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        out.print("<b>Hello simple servlet</b>");
        out.print("<br>"+getServletInfo());
        out.print("<br>"+getServletConfig());
    }

    @Override
    public String getServletInfo() {
        return "copyright 2018";
    }

    @Override
    public void destroy() {
        System.out.println("servlet is destroyed");
    }
}
