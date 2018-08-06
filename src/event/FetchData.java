package event;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try{
            ServletContext servletContext = getServletContext();
            Connection connection = (Connection) servletContext.getAttribute("myconnection");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from emp32",
                    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                out.print("<br>"+resultSet.getString(1)+" "+resultSet.getString(2));
            }
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
