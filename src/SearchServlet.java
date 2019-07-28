import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        Database db = new Database();
        db.setConnection();
        ResultSet rs = null;

        out.println("<html>");
        out.println("<head>");
        out.println("<title>SearchResult</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center><h1>Search username result</h1>");
        try {
            rs = db.searchUsername(username);
            if (rs.next()) {
                do {
                    int playerid = rs.getInt("playerid");
                    String playerusername = rs.getString("username");
                    out.print("<p>PlayerID: " + playerid + "&nbsp;&nbsp;&nbsp;&nbsp;");
                    out.print("Username: " + playerusername + "</p>");
                    out.println();
                } while(rs.next());
            } else out.println("Username not found!");
        }
        catch (SQLException err) {
            out.println("An error occured while retrieving player's username: "
                    + err.toString());
        }
        out.println("</center>");
        out.println("<p>Click <a href='./index.jsp'>here</a> to return to homepage</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
