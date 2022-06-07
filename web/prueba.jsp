<%-- 
    Document   : prueba
    Created on : 24/05/2022, 05:05:15 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="css/jquery-ui.min.css">

    </head>


    <body style="background-color:#FF0000">
        <h1>Ejemplo datepicker</h1>
        <p>Fecha</p>

        <input id="datepicker" type="text"/>
        <script src="js/jquery.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script>
        $( "#datepicker" ).datepicker();
        </script>
    </body> 
</html>
