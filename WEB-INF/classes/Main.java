import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends HttpServlet {

    private Connection connection;
    private Statement statement;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String query = request.getParameter("sqlStatement").toLowerCase();
        String[] querySplit = query.split(" ", 2);
        String firstWord = querySplit[0];

        init(); // Create the connection to the database

        if (firstWord.equals("select")) {
            try {
                statement.executeQuery(query);
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        } else {
            try {
                statement.executeUpdate(query);
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

    }

    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3310/project4", "root", "root");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }

    }

    public static void main(String[] args) {

    }
}
