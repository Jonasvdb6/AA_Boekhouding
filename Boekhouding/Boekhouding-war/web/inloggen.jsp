<%-- 
    Document   : inloggen
    Created on : Nov 29, 2016, 10:44:27 AM
    Author     : simon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/inloggen.css">
        <title>LOGIN</title>
    </head>
    <body>
        <div class="container">
            <img src="images/loginO.png">
            <form method= "post" action="j_security_check" >
                <input class="user-input" type="text" name= "j_username" placeholder="Personeelsnummer" required="">
                <input class="pswd-input" type="password" name= "j_password"  placeholder="Paswoord" required=""></br>
                <input class="login-but" type="submit" value="LOGIN">
                <input type="hidden" name="goto" value="inloggen"/>
            </form>
        </div>
    </body>
</html>
