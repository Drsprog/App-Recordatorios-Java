<%-- 
    Document   : Recordatorio
    Created on : 22/05/2022, 09:07:05 PM
    Author     : USUARIO
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.RecVista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<%
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
            <div class="bloqueTit">
                <form action="ContRecordatorio">
                    <input name="txt" placeholder="Buscar recordatorio..." type="search">
                    &nbsp
                    <input name="accion" type="submit" value="Buscar" class="btn-comun">
                </form>
                <a href="ContRecordatorio?accion=ListarServ" class="fa-solid fa-plus"></a>    
            </div>
        </div>
        <% List<RecVista>lista=(List<RecVista>)request.getAttribute("recordatorio");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        if (!lista.isEmpty()){
        for(RecVista recordatorio:lista){%>
        <div class="bloque1">
            <img src="Imágenes/Hourglass.svg" type="img/svg">
        </div>
        <div class="bloque2">
            <input id="usuCor" name="ideRec" type="hidden" value="<%=recordatorio.getIDE_REC()%>">
            <p>   
                <%=recordatorio.getTIT_REC()%>
            </p> 
            <p>
                <%=recordatorio.getNOM_SRV()%>
            </p> 
            <p>
                Fecha de inicio: <%=formato.format(recordatorio.getINI_REC())%>
            </p> 
            <p>
                Fecha de pago: <%=formato.format(recordatorio.getFPG_REC())%>
            </p> 
            <p>
                Fecha de alerta: <%=formato.format(recordatorio.getALR_REC())%>
            </p> 
            <p>
                Ciclo de pago: <%=recordatorio.getCLC_REC()%>
            </p> 
        </div>
        <div class="bloque3">
            <a href="ContRecordatorio?accion=ModificarRec&ideRec=<%=recordatorio.getIDE_REC()%>" class="fa-solid fa-pencil"></a>
            <a href="ContRecordatorio?accion=EliminarRec&ideRec=<%=recordatorio.getIDE_REC()%>" class="fa-solid fa-trash-can"></a> 
        </div>   
        <% } 
        }
        else{
        %>
        <div class="bloque2aviso">
                USTED NO TIENE RECORDATORIOS 
        </div>
        <%}%>
    </div>
    <%@include file="/footer.jsp"%>
    </body>
</html>
