<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./stylesheet.css">
        <title>Results</title>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>Imperial-Class Star Destroyers</h1>
        <%= table %>
        <br><br>
        <a href ="add">Add A Star Destroyer</a>
        <br><br>
        <a href="search.jsp">Search Star Destroyers</a>
    </body>
</html>
