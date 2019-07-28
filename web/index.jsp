
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="main.css" type="text/css"/>
  <title>Homepage</title>
</head>
<body>
  <h1>Welcome to the game of Nim</h1>
  <h5>It is a two player game, and the rules of the version used here are as follows</h5><br>

  <h3>Instructions:</h3>
  <div>
    <ul>
      <li>The game begins with a number of objects (e.g., stones placed on a table).</li>
      <li>Each player takes turns removing objects from the table.</li>
      <li>
        <p>On each turn, a player must remove at least one stone. In addition, there is an upper bound on</p>
        <p>the number of stones that can be removed in a single turn. For example, if this upper bound is 3,</p>
        <p>a player has the voice of removing 1,2 or 3 stones on each turn.</p>
      </li>
      <li>
        <p>The game ends there are no more stones remaining. The player who removes the last stone, loses.</p>
        <p>The other player is, of course, the winner.</p>
      </li>
      <li>
        <p>Both the initial number of stones, and the upper bound on the number that can be removed, can</p>
        <p>be varied from game to game, and must be chosen before a game commences.</p>
      </li>
    </ul>
  </div>

  <h4>Here is an example play-through of the game, using 12 initial stones, and an upper bound of 3 stones removed per turn.</h4>
  <div>
    <ul>
      <li>There are 12 stones on the table.</li>
      <li>Player 1 removes 3 stones. 9 stones remain.</li>
      <li>Player 2 removes 1 stone. 8 stones remain.</li>
      <li>Player 1 removes 1 stone. 7 stones remain.</li>
      <li>Player 2 removes 2 stone. 5 stones remain.</li>
      <li>Player 1 removes 3 stone. 2 stones remain.</li>
      <li>Player 2 removes 1 stone. 1 stones remain.</li>
      <li>Player 1 removes 1 stone. 0 stones remain.</li>
      <li>Player 2 wins. Player 1 loses.</li>
    </ul>
  </div>
  <br>

  <form action = playerSignUp.html>
    <button type = "submit">New player sign up</button>
  </form>
  <br>

  <form action = playerSearch.jsp>
    <button type = "submit">Search for players</button>
  </form>
  <br>

  <form action = playerRemove.jsp>
    <button type = "submit">Remove a player</button>
  </form>
  <br>

  <form action = playerNamePage.html>
    <button type = "submit"><strong>Play Now!</strong></button>
  </form>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>