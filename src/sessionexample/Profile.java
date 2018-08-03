package sessionexample;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Profile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        req.getRequestDispatcher("link.html").include(req,resp);

        HttpSession session = req.getSession(false);
        if (session !=null){
            String name = (String) session.getAttribute("name");
            out.print("Hello, "+name+" Welcome to Profile");
        } else{
            out.print("Please login first");
            req.getRequestDispatcher("login.html").include(req,resp);
        }
        out.close();
    }
}
