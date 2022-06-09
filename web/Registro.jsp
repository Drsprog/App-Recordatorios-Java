<%-- 
    Document   : Registro
    Created on : 24/05/2022, 03:53:58 PM
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
        <title>Registro</title>
        <link href="CSS/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="/header.jsp"%>
        <form action="Validar" method="POST">
          <h1>STARP REMINDER</h1>
          <div class="inset">
          <p>
            <label for="nombres">NOMBRES</label>
            <input type="text" name="nombres" id="email">
          </p>
          <p>
            <label for="apellidos">APELLIDOS</label>
            <input type="text" name="apellidos" id="email">
          </p>
          <p>
            <label for="email">CORREO</label>
            <input type="text" name="email" id="email">
          </p>
          <p>
            <label for="password">CONTRASEÑA</label>
            <input type="password" name="password" id="password">
          </p>
          <p>
            <input type="checkbox" name="remember" id="remember">
            <label for="remember">Recordarme</label>
          </p>  
          </div>
          <p class="p-recordatorio">   
            <a href="https://www.youtube.com/" style="color:#ffff00;">¿Se olvidó la contraseña?</a>       
          </p>
          <p class="p-alternativo">
               <input type="submit" name="accion" value="Registrar"  class="btn-comun">
          </p>
        </form>
        <%@include file="/footer.jsp"%>
    </body>
</html>
