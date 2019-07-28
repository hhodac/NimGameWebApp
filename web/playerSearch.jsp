<%--
  Created by IntelliJ IDEA.
  User: haiho
  Date: 2019-07-28
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="main.css" type="text/css"/>
</head>
<body>
    <h1>Search for players</h1>
    <form method = "get" action= "search">
        <label for = "uname"></label>
        <p>Search for username: <input id = "uname" type = "text" name = "username" required"></p>
        <button type="submit">Submit!</button>
    </form>

    <p>Click <a href='./index.jsp'>here</a> to return to homepage.</p>
</body>
</html>
