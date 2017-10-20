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
        <div class="wrap">
        
            <%@ include file="includes/header.jsp" %>
            
            <%@ include file="includes/menu.jsp" %>
        
        <div class="main">
        <h1>Imperial-Class Star Destroyers</h1>
        <%= table %>
        <br><br>
       
            
            <%@ include file="includes/footer.jsp" %>
            
        </div> 
    </body>
</html>
