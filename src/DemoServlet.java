import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("Welcome to DemoServlet<br>");
        out.print("<b>Using init-param web.xml Driver is"+getServletConfig().getInitParameter("driver")+"</b><br>");

        out.print(" getInitParameterNames");
        Enumeration<String> e = getServletConfig().getInitParameterNames();
        String str="";
        while(e.hasMoreElements()){
            str=e.nextElement();
            out.print("<br>Name: "+str);
            out.print(" value: "+getServletConfig().getInitParameter(str));
        }

        out.print("<br><br><b>ServletContext</b><br>");
        ServletContext context = getServletContext();
        out.print("driver name is = "+context.getInitParameter("drivername"));
        out.print("<br>");

        e=context.getInitParameterNames();

        str="";
        while(e.hasMoreElements()){
            str=e.nextElement();
            out.print("<br> "+context.getInitParameter(str));
        }

        out.print("<br>");
        out.print(""+context.getRealPath(req.getServletPath()));

        //resp.sendRedirect("http://google.kz");
        out.close();
    }
}
