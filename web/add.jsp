<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./stylesheet.css">
        <title>Add a Star Destroyer</title>
    </head>
    <body>
        <div class="wrap">
        
            <%@ include file="includes/header.jsp" %>
            
            <%@ include file="includes/menu.jsp" %>
        
        <div class="main">
        <h1>Add a Star Destroyer</h1>
        <div>
        <form name="addForm" action="addShip" method="get">
            
            <label>Destroyer Name:</label>
            <input type="text" name="shipName" value="" />
            <br>
            <label>Date Built:</label>
            <input type="text" name="dateBuilt" value="" />
            <br>
            <label>Fleet:</label>
            <input type="text" name="fleet" value="" />
            <br>
            <label>Crew Size:</label>
            <input type="text" name="crewSize" value="" />
            <br>
            <label>Commander:</label>
            <input type="text" name="commander" value="" />
            <br>
            <label>Status:</label>
            <input type="text" name="status" value="" />
            <br>
            <input type="submit" name="submit" value="Submit" />        
        </form>
        </div>
        </div>
            
            <%@ include file="includes/footer.jsp" %>
            
        </div> 
    </body>
</html>
