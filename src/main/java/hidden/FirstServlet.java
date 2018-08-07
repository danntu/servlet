package hidden;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("userName");
        out.print("Welcome "+name);

        out.print("<form action='hiddenServlet2'>");
        out.print("<input type='hidden' name='uname' value='"+name+"'>");
        out.print("<input type='submit' value='go'>");
        out.print("</form>");
        out.close();

    }
}
