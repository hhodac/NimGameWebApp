<%--
  Created by IntelliJ IDEA.
  User: u
  Date: 2019-07-27
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GameRunning</title>
    <link rel="stylesheet" href="main.css" type="text/css"/>
</head>
<body>

<body>
    <h1>Nim game is in progress</h1>
    <h3>SessionID: ${sessionid}</h3>
        <p>Number of stones left: ${gameinfo.getCurrentStone()}</p>
        <p>Limit of stone removal: ${gameinfo.getUpperbound()}</p><br>
        <p>Player's ${playername} turn:</p><br>

    <form action="gamerunning" method="post">
        <label for="rmvstone">Remove stones:</label>
        <input id = "rmvstone" type="number" name="stonesRemoved">
        <input type = "submit" value ="remove" id = "submit">
    </form>

</body>

</body>
</html>
