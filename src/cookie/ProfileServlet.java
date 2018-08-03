package cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        req.getRequestDispatcher("link.html").include(req,resp);

        Cookie cookie[] = req.getCookies();

        if (cookie != null){
            String name = cookie[0].getValue();
            if (!name.equals("") || name !=null){
                out.print("<b>Welcome to Profile</b>");
                out.print("<br> Welcome, "+name);
            }
        } else{
            out.print("Please login first");
            req.getRequestDispatcher("link.html").include(req,resp);
        }
        out.close();
    }
}
