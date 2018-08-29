package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jpa", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    public static int save(Emp emp) {
        int status = 0;

        try {
            Connection connection = EmpDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into user905(name,password,email,country) values (?,?,?,?)"
            );
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getPassword());
            preparedStatement.setString(3, emp.getEmail());
            preparedStatement.setString(4, emp.getCountry());

            status = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int update(Emp emp) {
        int status = 0;
        try {
            Connection connection = EmpDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update user905 set name=?,password=?," +
                    "email=?,country=? where id=?");
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getPassword());
            preparedStatement.setString(3, emp.getEmail());
            preparedStatement.setString(4, emp.getCountry());
            preparedStatement.setInt(5, emp.getId());

            status = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection connection = EmpDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from user905 where id=?");
            preparedStatement.setInt(1, id);
            status = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static Emp getEmployeeById(int id) {
        Emp emp = new Emp();

        try {
            Connection connection = EmpDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user905 where id=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                emp.setId(resultSet.getInt(1));
                emp.setName(resultSet.getString(2));
                emp.setPassword(resultSet.getString(3));
                emp.setEmail(resultSet.getString(4));
                emp.setCountry(resultSet.getString(5));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return emp;
    }

    public static List<Emp> getAllEmployees() {
        List<Emp> list = new ArrayList<Emp>();
        try {
            Connection connection = EmpDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user905");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Emp emp = new Emp();
                emp.setId(resultSet.getInt(1));
                emp.setName(resultSet.getString(2));
                emp.setPassword(resultSet.getString(3));
                emp.setEmail(resultSet.getString(4));
                emp.setCountry(resultSet.getString(5));
                list.add(emp);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
