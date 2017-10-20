<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Ships"%>
<% Ships ship = (Ships) request.getAttribute("ship"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./stylesheet.css">
        <title>Update a Star Destroyer</title>
    </head>
    <body>
        <h1>Update a Star Destroyer Record</h1>
        <div>
        <form name="updateForm" action="updateShip" method="get">
            
            <label>Destroyer Name:</label>
            <input type="text" name="shipName" value="<%= ship.getShipName() %>" />
            <br>
            <label>Date Built:</label>
            <input type="text" name="dateBuilt" value="<%= ship.getDateBuilt() %>" />
            <br>
            <label>Fleet:</label>
            <input type="text" name="fleet" value="<%= ship.getFleet() %>" />
            <br>
            <label>Crew Size:</label>
            <input type="text" name="crewSize" value="<%= ship.getCrewSize() %>" />
            <br>
            <label>Commander:</label>
            <input type="text" name="commander" value="<%= ship.getCommander() %>" />
            <br>
            <label>Status:</label>
            <input type="text" name="status" value="<%= ship.getStatus() %>" />
            <br>
            <label>Destroyer ID:</label>
            <input type="text" name="shipID" value="<%= ship.getShipID() %>" readonly/>
            <br>
            <input type="submit" name="submit" value="Update" />        
        </form>
        </div>
    </body>
</html>
