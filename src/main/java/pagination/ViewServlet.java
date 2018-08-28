package pagination;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/pagination/ViewServlet")
public class ViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String spageid = req.getParameter("page");
        int pageid = Integer.parseInt(spageid);
        int total = 5;
        if (pageid == 1) {

        } else {
            pageid = pageid - 1;
            pageid = pageid * total + 1;
        }
        List<Emp> list = EmpDao.getRecords(pageid, total);
        writer.print("<h1>Page No: " + spageid + "</h1>");
        writer.print("<table border='1' cellpadding='4' width='60%'>");
        writer.print("<tr><th>Id</th><th>Name</th><th>Salary</th>");
        for (Emp emp :
                list) {
            writer.print("<tr><td>" + emp.getId() + "</td><td>" + emp.getName() + "</td><td>" + emp.getSalary() + "</td></tr>");
        }
        writer.print("</table>");

        writer.print("<a href='ViewServlet?page=1'>1</a> ");
        writer.print("<a href='ViewServlet?page=2'>2</a> ");
        writer.print("<a href='ViewServlet?page=3'>3</a> ");

        writer.close();
    }
}
