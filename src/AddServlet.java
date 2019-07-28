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
        String username = request.getParameter("username");
        db.setConnection();
        try {
           db.addAccount(username);
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>SignupSuccess</title>");
            writer.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");
            writer.println("<link rel=\"stylesheet\" href=\"main.css\" type=\"text/css\"/>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>Successfully added "+username+" account.</h1>");
            writer.println("<br>");
            writer.println("<p>Click <a href='./index.jsp'>here</a> to return to homepage</h1>");
            writer.println("</body>");
            writer.println("</html>");
        }
        catch (MySQLIntegrityConstraintViolationException err) {
            String url = "/playerInvalidSignUp.jsp";
            String errorMessage = username + "  is already exists.";
            request.setAttribute("errorMessage", errorMessage);
            getServletContext().getRequestDispatcher(url).forward(request,response);
        }
        catch (SQLException err) {
            String url = "/playerInvalidSignUp.jsp";
            String errorMessage = username + "SQL invalid.";
            request.setAttribute("errorMessage", errorMessage);
            getServletContext().getRequestDispatcher(url).forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
