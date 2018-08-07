package event.sessioneventandlistener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class First extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("username");
        out.print("Welcome "+name);

        HttpSession session = req.getSession();
        session.setAttribute("username",name);

        ServletContext servletContext = getServletContext();
        int t = (Integer) servletContext.getAttribute("totalusers");
        int c = (Integer) servletContext.getAttribute("currentusers");

        out.print("<br> total users = "+t);
        out.print("<br> current users = "+c);

        out.print("<br><a href='LogoutServlet'>logout</a>");
        out.close();
    }
}
