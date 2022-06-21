<%-- 
    Document   : ModPerfil
    Created on : 20/06/2022, 09:10:35 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<%
    int ide=(int)request.getSession().getAttribute("ide");
    String corr=(String)request.getSession().getAttribute("corr");
    String nomb=(String)request.getSession().getAttribute("nomb");
    String apel=(String)request.getSession().getAttribute("apel");
    if(corr==null){ 
      request.getRequestDispatcher("Index.jsp").forward(request, response);   
    }
%>
<html>
    <head>
        <meta http-equiv="Expires" content="0">
        <meta http-equiv="Last-Modified" content="0">
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar perfil</title>
        <link href="CSS/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="/header.jsp"%>
        <form action="Validar" method="POST">
          <h1>MODIFICAR PERFIL</h1>
          <div class="inset">
          <p>
            <label for="nombres">NOMBRES</label>
            <input type="text" value="<%=nomb%>" name="nombres" id="email">
          </p>
          <p>
            <label for="apellidos">APELLIDOS</label>
            <input type="text" value="<%=apel%>" name="apellidos" id="email">
          </p>
          <p>
            <label for="email">CORREO</label>
            <input type="text" value="<%=corr%>" name="email" id="email">
          </p>
          </div>
          <p class="p-alternativo">
               <input type="submit" name="accion" value="Modificar"  class="btn-comun">
          </p>
        </form>
        <%@include file="/footer.jsp"%>
    </body>
</html>
