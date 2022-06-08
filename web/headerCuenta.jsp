<%-- 
    Document   : headerCuenta
    Created on : 25/05/2022, 01:03:30 AM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/estilo2.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" 
        integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" 
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <header>
            <nav>
            <input type="checkbox" id="check">
            <label for="check" class="checkbtn">
            <i class="fas fa-bars"></i>
            </label>
            <a href="#" class="enlace">
                <img src="Imágenes/logo.png" alt="" class="logo"/>
            </a>
            <ul>
                 <li><a href="Controlador?menu=Inicio2">Inicio</a></li>
                <li><a href="Recordatorio.jsp">Recordatorios</a></li>
                <li><a href="Validar?conf=0">Cerrar Sesión</a></li>
                <li>
                <a href="Perfil.jsp" class="fa-regular fa-circle-user"></a>
                </li>
            </ul>
            </nav>
        </header>
    </body>
</html>
