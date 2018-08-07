import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("userName");
        String password = req.getParameter("userPass");
        if (password.equals("pass")){
            RequestDispatcher dispatcher = req.getRequestDispatcher("welcome");
            dispatcher.forward(req,resp);
        } else{
            out.print("Sorry username and password error");
            RequestDispatcher dispatcher = req.getRequestDispatcher("home.html");
            dispatcher.include(req,resp);
        }
    }
}
