import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        String username = request.getParameter("uname");
        Database db = new Database();
        db.setConnection();
        try {
            if(db.removeAccount(username)) {
                writer.println("<html>");
                writer.println("<body>");
                writer.println("<h1>Successfully removed "+username+" account.</h1>");
                writer.println("<br>");
                writer.println("<p>Click <a href='./index.jsp'>here</a> to return to homepage</h1>");
                writer.println("</body>");
                writer.println("</html>");
            }
        }
        catch (SQLException err) {
            writer.println("<html>");
            writer.println("<body>");
            writer.println("<h1>"+err.getMessage()+"</h1>");
            writer.println("<br>");
            writer.println("<p>Click <a href='./index.jsp'>here</a> to return to homepage</h1>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }
}
