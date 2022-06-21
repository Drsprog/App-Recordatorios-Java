<%-- 
    Document   : ModRecordatorio
    Created on : 20/06/2022, 05:28:29 PM
    Author     : USUARIO
--%>
<%@page import="Modelo.Recordatorio"%>
<%@page import="Modelo.RecVista"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Servicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar recordatorio</title>
        <link href="CSS/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <% RecVista recV=(RecVista)request.getAttribute("datrecor");
        String fecIni = dtf.format(recV.getINI_REC());
        String fecPag = dtf.format(recV.getFPG_REC());
        String fecAle = dtf.format(recV.getALR_REC());
        %>
        <%@include file="/headerCuenta.jsp"%>
        <form action="ContRecordatorio" method="POST">
        <h1>MODIFICACIÓN DE RECORDATORIO</h1>
        <div class="inset">
        <input id="usuCor" name="ideRec" type="hidden" value="<%=recV.getIDE_REC()%>">
        <p>
            <label for="nombres">TITULO</label>
            <input type="text" value="<%=recV.getTIT_REC()%>" name="titulo" id="email">
        </p>
        <p class="parrafo">
             <label for="apellidos">SERVICIO</label>
             <a href="ContServicio?accion=Categoria" class="fa-solid fa-plus"></a> 
        </p>
        <div class="content-select">
            <select name="servicio" id="servicio">
                <% List<Servicio>lista=(List<Servicio>)request.getAttribute("servicio");
                String selec;
               
                if (lista!=null)
                for(Servicio servicio:lista){
                    String nombreSv=servicio.getNOM_SRV();
                    String nombreRv=recV.getNOM_SRV();
                    if(nombreSv.toLowerCase().equals(nombreRv.toLowerCase())){
                    selec="selected";
                    }
                    else{
                    selec="false";
                    }
                %>
                <option <%=selec%> value="<%=servicio.getIDE_SRV()%>"><%=servicio.getNOM_SRV()%></option>    
                <%
                }
                %>
            </select>
        </div>  
        <p>
            <label for="password">FECHA DE INICIO</label>
            <input type="date" name="inicio" value="<%=fecIni%>" id="password">
        </p>
        <p>
            <label for="password">FECHA DE PAGO</label>
            <input type="date" name="pago" value="<%=fecPag%>" id="password">
        </p>
        <p>
            <label for="password">FECHA DE ALARMA</label>
            <input type="date" name="alarma" value="<%=fecAle%>" id="password">
        </p>
        <p>
            <label for="password">CICLO</label>
        </p>
        <div class="content-select" id="ciclo">
            <select name="ciclo">
               <%
               String selecClc1="false";
               String selecClc2="false";
               String selecClc3="false";
               String selecClc4="false";
               if(recV.getCLC_REC()!=null){
                    if(recV.getCLC_REC().toLowerCase().equals("mensual")){
                        selecClc1="selected";     
                    }
                    else if (recV.getCLC_REC().toLowerCase().equals("trimestral")){
                        selecClc2="selected";
                    }
                    else if (recV.getCLC_REC().toLowerCase().equals("semestral")){
                        selecClc3="selected";
                    }
                    else {
                         if (recV.getCLC_REC().toLowerCase().equals("anual")){
                            selecClc4="selected";
                         }
                    }
               %>
               <option <%=selecClc1%> value="Mensual">Mensual</option> 
               <option <%=selecClc2%> value="Trimestral">Trimestral</option> 
               <option <%=selecClc3%> value="Semestral">Semestral</option> 
               <option <%=selecClc4%> value="Anual">Anual</option> 
               <%
                }
               %>
            </select>
        </div>
        </div>
        <p class="p-alternativo">
            <input type="submit" name="accion" value="Modificar"  class="btn-comun">
        </p>
    </form>   
     <%@include file="/footer.jsp"%>
    </body>
</html>
