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
    <title>Title</title>
</head>
<body>

<body>
<h1>Nim game is in progress</h1>

<p>Stones left:</p>
<span>${user1.getUsername()}</span>
<p>Stones left:</p>
<span>${StonesLeft}</span>
<p>Limit of stone removal:</p>
<span>${LimitOfStonesRemoval}</span>
<form action="gameInProgress.jsp" method="post">
    <label>Remove stones:</label>
    <input type="text" name="stonesRemoved" >
    <input type = "submit" value ="Start Game" id = "submit">
</form>
</body>

</body>
</html>
