<%-- 
    Document   : CreaRecordatorio
    Created on : 24/05/2022, 03:53:43 PM
    Author     : USUARIO
--%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Servicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<%
    SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar = Calendar.getInstance();
    Date dateObj = calendar.getTime();
    String formattedDate = dtf.format(dateObj);
    String corr=(String)request.getSession().getAttribute("corr");
    if(corr==null){ 
      request.getRequestDispatcher("Index2.jsp").forward(request, response);   
    }
%>
<html>
    <head>
        <title>Agregar Recordatorio</title>
        <meta http-equiv="Expires" content="0">
        <meta http-equiv="Last-Modified" content="0">
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
        <meta http-equiv="Pragma" content="no-cache"><!-- para que se guareden los cambios --> 
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">  
        <link href="CSS/estilo.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" 
        integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" 
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <%@include file="/headerCuenta.jsp"%>
        <form action="ContRecordatorio" method="POST">
        <h1>REGISTRO DE RECORDATORIO</h1>
        <div class="inset">
        <p>
            <label for="nombres">TITULO</label>
            <input type="text" name="titulo" id="email">
        </p>
        <div class="parrafo">
            <div>
                <label for="apellidos">SERVICIO</label>
            </div>
            <div class="separabtn"> 
                <a href="ContServicio?accion=Categoria" class="fa-solid fa-plus"></a> 
                <button id="btnBor" formaction="ContRecordatorio?accion=BorrarRec" type="submit">
                    <i class="fa-solid fa-trash-can"></i>
                </button>
            </div>    
        </div>
        <div class="content-select">
            <select name="servicio" id="servicio">
                <%List<Servicio>lista=(List<Servicio>)request.getAttribute("servicio");
                if (lista!=null)
                for(Servicio servicio:lista){%>
                <option value="<%=servicio.getIDE_SRV()%>"><%=servicio.getNOM_SRV()%></option>  
                <% } %>
            </select>
        </div>  
        <p>
            <label for="password">FECHA DE INICIO</label>
            <input type="date" name="inicio" value="<%=formattedDate%>" id="password">
        </p>
        <p>
            <label for="password">FECHA DE PAGO</label>
            <input type="date" name="pago" value="<%=formattedDate%>" id="password">
        </p>
        <p>
            <label for="password">FECHA DE ALARMA</label>
            <input type="date" name="alarma" value="<%=formattedDate%>" id="password">
        </p>
        <p>
            <label for="password">CICLO</label>
        </p>
        <div class="content-select" id="ciclo">
            <select name="ciclo">
               <option value="Mensual">Mensual</option> 
               <option value="Trimestral">Trimestral</option> 
               <option value="Semestral">Semestral</option> 
               <option value="Anual">Anual</option> 
            </select>
        </div>
        </div>
        <p class="p-alternativo">
            <input type="submit" name="accion" value="Registrar"  class="btn-comun">
        </p>
    </form>   
     <%@include file="/footer.jsp"%>
    </body>
</html>
