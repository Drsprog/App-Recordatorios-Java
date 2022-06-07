<%-- 
    Document   : Perfil
    Created on : 24/05/2022, 03:55:02 PM
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
        <link href="CSS/pefilest.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <%@include file="/header.jsp"%>
         <div class="card-container">
            <div class="upper-container">
                <div class="image-container">
                   <!-- <img src="Imágenes/perfimg.jpeg" alt=""/> -->
                </div>
            </div>
         <div class="lower-container">
           <div>
               <h3>PERFIL DE USUARIO</h3>
            </div>
             <br>
            <div>
               <p>NOMBRE: Juan </p>
            </div>
             <div>
               <p>APELLIDO: Montañez Hernandez</p>
            </div>
             <div>
               <p> CORREO: Juanchi12202@gmail.com</p>
            </div>
            <div>
               <a href="Registro.jsp" class="btn">Modificar Datos</a>
                <a href="Recordatorio.jsp" target="_blank" class="btn">Lista de Recordatorio</a>
            </div>
            <div> 
                <p class="linker">
                <a href= "#" target="_blank">
                     Cambiar contraseña</a>
                </p>
             </div>

         </div>
      </div>
     <%@include file="/footer.jsp"%>
    </body>
</html>
