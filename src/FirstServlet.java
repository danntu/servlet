import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String usernameValue = req.getParameter("userName");
        out.print("Welcome " + usernameValue);

        Cookie cookie = new Cookie("uname",usernameValue);
        resp.addCookie(cookie);

        out.print("<form action='second' method='post'>");
        out.print("<input type='submit' value='go'>");
        out.print("</form>");

        out.close();
    }
}
