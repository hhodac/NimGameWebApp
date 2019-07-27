import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        Database db = new Database();
        String username = request.getParameter("uname");
        String password = request.getParameter("upass");
        db.setConnection();
        try {
            if (db.addAccount(username)) {
                writer.println("<html>");
                writer.println("<body>");
                writer.println("<h1>Successfully created new account.</h1>");
                writer.println("<br>");
                writer.println("<p>Click <a href='./index.jsp'>here</a> to return to homepage</h1>");
                writer.println("</body>");
                writer.println("</html>");
            } else {
                writer.println("<html>");
                writer.println("<body>");
                writer.println("<h1> created new account.</h1>");
                writer.println("<br>");
                writer.println("<p>Click <a href='./index.jsp'>here</a> to return to homepage</h1>");
                writer.println("</body>");
                writer.println("</html>");
            }
        }
        catch (MySQLIntegrityConstraintViolationException err) {
            writer.println("<html>");
            writer.println("<body>");
            writer.println("<h1>"+username+" is already exist.</h1>");
            writer.println("<br>");
            writer.println("<p>Click <a href='./index.jsp'>here</a> to return to homepage</h1>");
            writer.println("</body>");
            writer.println("</html>");
        }
        catch (SQLException err) {
            writer.println("<html>");
            writer.println("<body>");
            writer.println("<h1>SQL invalid.</h1>");
            writer.println("<br>");
            writer.println("<p>Click <a href='./index.jsp'>here</a> to return to homepage</h1>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
