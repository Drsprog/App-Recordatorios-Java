<%-- 
    Document   : Perfil
    Created on : 24/05/2022, 03:55:02 PM
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
        <title>JSP Page</title>
        <link href="CSS/pefilest.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <%@include file="/headerCuenta.jsp"%>
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
               <p>NOMBRES: <%=nomb%> </p>
            </div>
             <div>
               <p>APELLIDOS: <%=apel%> </p>
            </div>
             <div>
               <p> CORREO:  <%=corr%> </p>
            </div>
            <div>
               <a href="ModPerfil.jsp" class="btn">Modificar Datos</a>
               <a href="ContRecordatorio?accion=ListarRec" class="btn">Lista de Recordatorios</a>
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
