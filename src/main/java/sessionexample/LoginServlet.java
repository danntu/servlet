package sessionexample;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        req.getRequestDispatcher("link.html").include(req,resp);

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if ("admin".equals(password)){
            out.print("Welcome name ,"+name);
            HttpSession session = req.getSession();
            session.setAttribute("name",name);
        } else{
            out.print("Sorry, username or password error!");
        }
        out.close();
    }
}
