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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Inloggen</h1>
        <form method= "post" action="j_security_check" >
            <input type="text" name= "j_username" >
            <input type="password" name= "j_password" >
        </form>
        <%-- 
        <form method="post" action="Controller">
            <table>
                <tr>
                    <td>Personeelsnummer :</td>
                    <td><input type="Text" name="pnummer"/></td>
                </tr>
                <tr>
                    <td>Paswoord:</td>
                    <td><input type="Text" name="pswd"/></td>   
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Inloggen"/></td>
                </tr>
            </table>
            <input type="hidden" name="indexhidden" value="inloggen"/>
        </form>
        --%>
    </body>
</html>
