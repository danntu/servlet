import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DemoServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out;

            resp.setContentType("text/html");
            out = resp.getWriter();

            ServletContext context = getServletContext();
            context.setAttribute("operator","Kcell");
            out.println("Welcome to first servlet");
            out.println("<a href='/servlet2'>visit</a>");
            out.close();

    }
}
