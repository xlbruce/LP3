<%-- 
    Document   : loginerr
    Created on : 11/08/2015, 08:56:07
    Author     : 31409695
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Usuário ou senha inválidos</h1>
        <p>Você será redirecionado em 5 segundos</p>
    </body>
    <script type="text/javascript">
        setTimeout("document.location = 'index.jsp'",5000);
    </script>
</html>
