import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "PlayGameServlet")
public class PlayGameServlet extends HttpServlet {
    private NimGame game;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String mySessionID = session.getId();

        String p1name = request.getParameter("player1");
        String p2name = request.getParameter("player2");
        int initStone = Integer.parseInt(request.getParameter("initialStones"));
        int upperbound = Integer.parseInt(request.getParameter("upperbound"));

        NimHumanPlayer p1 = new NimHumanPlayer(p1name);
        NimHumanPlayer p2 = new NimHumanPlayer(p2name);

        NimGame game = new NimGame(p1, p2, initStone, upperbound);
        game.startGame();

        // Assign current "game" class to "nimgame" in current session
        request.getSession().setAttribute("nimgame", game);


        String url = "/gameInProgress.jsp";
        request.setAttribute("sessionid", mySessionID);
        request.setAttribute("gameinfo", game);
        if (game.getPlayer1().getTurn().equals("ON")) {
            request.setAttribute("playername", game.getPlayer1().getUsername());
        } else {
            request.setAttribute("playername", game.getPlayer2().getUsername());
        }

        getServletContext().getRequestDispatcher(url).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
