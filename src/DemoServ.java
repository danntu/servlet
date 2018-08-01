import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class DemoServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer =  resp.getWriter();
        writer.print("Welcome " +req.getParameter("name"));
        writer.println("HTTP headers sent by your client:<br>");
        Enumeration<String> enumeration = req.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String headerName = (String) enumeration.nextElement();
            String headerValue = req.getHeader(headerName);
            writer.print("<b>"+headerName + "</b>: ");
            writer.println(headerValue + "<br>");
        }
        writer.close();
    }
}
