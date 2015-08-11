<%-- 
    Document   : index
    Created on : 11/08/2015, 07:35:06
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
        <section>
            <form action="FrontController" method="POST">
                <p>Login: <input type="text" name="username" required/></p>
                <p>Password: <input type="password" name="password" required/></p>
                <p><input type="submit" value="Enviar"/></p>
                <input type="hidden" name="command" value="Login"/>
            </form>
        </section>
    </body>
</html>
