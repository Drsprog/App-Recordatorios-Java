<%-- 
    Document   : CreaCategoria
    Created on : 24/05/2022, 03:54:31 PM
    Author     : USUARIO
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.Categoria"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int ide=(int)request.getSession().getAttribute("ide");
    String corr=(String)request.getSession().getAttribute("corr");
    if(corr==null){ 
      request.getRequestDispatcher("Index2.jsp").forward(request, response);   
    }
%>
<html>
    <head>
        <meta http-equiv="Expires" content="0">
        <meta http-equiv="Last-Modified" content="0">
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
        <meta http-equiv="Pragma" content="no-cache">
        <title>Agregar Servicio</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <%@include file="/header.jsp"%>
    <div class="container">          
        <form action="ContServicio" method="POST">
            <h1>REGISTRO DE SERVICIO</h1>
            <div class="inset">
            <input id="usuCor" name="ide" type="hidden" value="<%=ide%>">
            <p>
                <label for="nombres">NOMBRE</label>
                <input type="text" name="nombre" id="email">
            </p>
            <p>
                 <label for="apellidos">CATEGORIA</label>
            </p>
            <div class="content-select">
                <select name="categoria" id="servicio">
                    <% List<Categoria>lista=(List<Categoria>)request.getAttribute("categoria");
                    if (lista!=null)
                    for(Categoria categoria:lista){%>
                    <option value="<%=categoria.getIde_cat()%>"><%=categoria.getNom_cat()%></option>  
                    <% } %>
                </select>
            </div>
            <p>
                <label for="email">MONEDA</label>
            </p>
            <div class="content-select">
                <select name="moneda">
                    <option value="Soles">Soles</option>   
                    <option value="Dolares">Dólares</option>   
                </select>
            </div>       
            <p>
                <label for="password">PAGO</label>
                <input type="text" name="pago" id="email">
            </p>
            </div>
            <p class="p-alternativo">
                <input type="submit" name="accion" value="Registrar" class="btn-comun">
            </p>
        </form>  
    </div>
     <%@include file="/footer.jsp"%>
    </body>
</html>           
            