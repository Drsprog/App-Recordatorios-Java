<%-- 
    Document   : Recordatorio
    Created on : 22/05/2022, 09:07:05 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Expires" content="0">
        <meta http-equiv="Last-Modified" content="0">
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/estilo3.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" 
        integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" 
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
    <%@include file="/headerCuenta.jsp"%>
    <div class="bloque" >
        <div class="titulo1">
            <h2>LISTA DE RECORDATORIOS</h2>
        </div>
        <div class="bloque1">
            <img src="Imágenes/netflix_logo_icon_170919.svg" type="img/svg">
        </div>
        <div class="bloque2">
            <p>
                NETFLIX
            </p> 
            <p>
                Streaming
            </p> 
            <p>
                Fecha de inicio: 28/03/22
            </p> 
            <p>
                Fecha de pago: 28/05/22
            </p> 
            <p>
                Fecha de alarma: 22/05/22
            </p> 
            <p>
                Ciclo de alarma: Diario
            </p> 
            <p>
                Ciclo de pago: Mensual
            </p> 
        </div>
        <div class="bloque3">
            <a href="CreaRecordatorio.jsp" class="fa-solid fa-pencil"></a>
            <a href="CreaCategoria.jsp" class="fa-solid fa-trash-can"></a> 
        </div>       
        <div class="bloque1">
        <i class="fa-brands fa-spotify"></i>
        </div>
        <div class="bloque2">
            <p>
                SPOTIFY 
            </p> 
            <p>
                Streaming
            </p> 
            <p>
                Fecha de inicio: 27/04/22
            </p> 
            <p>
                Fecha de pago: 27/05/22
            </p> 
            <p>
                Fecha de alarma: 22/05/22
            </p> 
            <p>
                Ciclo de alarma: Diario
            </p> 
            <p>
                Ciclo de pago: Mensual
            </p> 
        </div>
        <div class="bloque3">
            <a href="CreaRecordatorio.jsp" class="fa-solid fa-pencil"></a>
            <a href="CreaCategoria.jsp" class="fa-solid fa-trash-can"></a> 
        </div>
    </div>
    <%@include file="/footer.jsp"%>
    </body>
</html>
