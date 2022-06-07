<%-- 
    Document   : CreaRecordatorio
    Created on : 24/05/2022, 03:53:43 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Agregar Recordatorio</title>
        <meta http-equiv="Expires" content="0">
        <meta http-equiv="Last-Modified" content="0">
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
        <meta http-equiv="Pragma" content="no-cache"><!-- para que se guareden los cambios --> 
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/EstRec.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/jquery-ui.min.css" rel="stylesheet" type="text/css"/>  
    </head>
    <body>
    <%@include file="/header.jsp"%>
    <div class="container">
        <form id="recordatorio">
            <div class="header">
                <h3>Registro de recordatorio</h3>             
                <p>Aca podra registrar sus recordatorios</p> 
            </div>
            <div class="sep"></div>
            <div class="inputs">
                <input type="TIT_REC" placeholder="Titulo" autofocus/>         
                <input type="SRV_REC" placeholder="Servicio" />
                <input type="INI_REC" placeholder="Inicio" />
                <input id="datepicker" type="FPG_REC" placeholder="Fecha de Pago" />
                <script src="js/jquery.js"></script>
                <script src="js/jquery-ui.min.js"></script>
                <script>
                $( "#datepicker" ).datepicker();
                </script>
                <input type="ALR_REC" placeholder="Alarma" />
                <input type="CLC_REC" placeholder="Ciclo" />
                <a id="submit" href="Recordatorio.jsp">REGISTRAR</a>
            </div>     
        </form>         
    </div>
     <%@include file="/footer.jsp"%>
    </body>
</html>
