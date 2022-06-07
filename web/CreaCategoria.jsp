<%-- 
    Document   : CreaCategoria
    Created on : 24/05/2022, 03:54:31 PM
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
        <title>Agregar Servicio</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/EstiloServ.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <%@include file="/header.jsp"%>
    <div class="container">          
        <form id="servicio">
        <div class="header">       
            <h3>Registro de Servicio</h3>
            <p>Aca podra registrar sus servicios</p>
        </div>
        <div class="sep"></div>
        <div class="inputs">
            <input type="NOM_SRV" placeholder="Titulo del Servicio" autofocus/>
            <input type="MON_SRV" placeholder="Monto del Servicio" />
            <input type="PAG_SRV" placeholder="Pago del Servicio" />
            <div class="selects">        
                <select name="Tipo"> 
                    <option>S/. soles</option>
                    <option>$/. dolares</option>
                </select>
            </div> 
            <div class="selects">        
                <select name="Categoria"> 
                    <option>Entretenimiento</option>
                    <option>Tienda</option>
                    <option>Pagina Web</option>
                    <option>Factura</option>
                </select>
            </div>          
                <a id="submit" href="#">REGISTRAR</a>
        </div>
        </form>
    </div>
     <%@include file="/footer.jsp"%>
    </body>
</html>           
            