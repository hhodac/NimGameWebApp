import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RemoveStoneServlet")
public class RemoveStoneServlet extends HttpServlet {
    private boolean turn;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String mySessionID = session.getId();
        NimGame game = (NimGame) session.getAttribute("nimgame");

        int currentStone = game.getCurrentStone();
        int removeStone = Integer.parseInt(request.getParameter("stonesRemoved"));

        currentStone = currentStone - removeStone;

        if (currentStone == 0) {
            session.removeAttribute("nimgame");
            String url = "/winer.jsp";
            request.setAttribute("sessionid", mySessionID);
            if (game.getPlayer1().getTurn().equals("ON")) {
                request.setAttribute("winner", game.getPlayer2().getUsername());
            } else request.setAttribute("winner", game.getPlayer1().getUsername());
            getServletContext().getRequestDispatcher(url).forward(request,response);

        } else {
            game.setCurrentStone(currentStone);

            game.getPlayer1().flipTurn();
            game.getPlayer2().flipTurn();

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
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
