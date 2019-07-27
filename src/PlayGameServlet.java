import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "PlayGameServlet")
public class PlayGameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");

        Database db = new Database();
        db.setConnection();
        String p1name = request.getParameter("player1");
        String p2name = request.getParameter("player2");
        int initStone = request.getIntHeader("initialStones");
        int removeStone = request.getIntHeader("stonesRemoved");
        try {
            db.addAccount(p1name);
            db.addAccount(p2name);
        }
        catch (SQLException err) {
            err.printStackTrace();
        }
        Player p1 = new Player(p1name);
        Player p2 = new Player(p2name);
        String url = "/gameInProgress.jsp";
        request.setAttribute("user1", p1);
        request.setAttribute("user2", p2);
        request.setAttribute("StonesLeft", 5);
        request.setAttribute("LimitOfStonesRemoval", removeStone);
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
