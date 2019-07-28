import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "RemoveServlet")
public class RemoveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        Database db = new Database();
        db.setConnection();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>RemovePlayer</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center><h1>Remove username result</h1>");
        try {
            if (db.isUsernameExist(username)) {
                db.removeAccount(username);
                out.print("<p>Successfully removed " + username + "!</p><br>");
            } else out.println("Username not found!");
        }
        catch (SQLException err) {
            out.println("<p>An error occured while removing player from database: "
                    + err.toString() + "</p><br>");
        }
        out.println("</center>");
        out.println("<p>Click <a href='./index.jsp'>here</a> to return to homepage</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}




