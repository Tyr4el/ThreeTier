import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Main extends HttpServlet {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public static void main(String[] args) {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        // Set the content type
        response.setContentType("text/html");
        // Set the PrintWriter
        PrintWriter out = response.getWriter();

        // Get the query from the HTML document
        String query = request.getParameter("sqlStatement").toLowerCase();
        // Split the query into an array
        String[] querySplit = query.split(" ", 2);
        // Get the first word to use later
        String firstWord = querySplit[0];

        // Create the connection to the database
        init();

        // Check if the first word of the query is "select"
        // Execute a query if so
        if (firstWord.equals("select")) {
            try {
                resultSet = statement.executeQuery(query);
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
            // Otherwise, perform an update
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

    // Method to create a connection to the SQL database
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

    // DESTROY ALL THE THINGS (or at least the connection things)!!!
    public void destroy() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }
}
