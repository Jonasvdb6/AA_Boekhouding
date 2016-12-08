<%-- 
    Document   : inloggenError
    Created on : Nov 29, 2016, 5:55:46 PM
    Author     : simon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/inloggenError.css">
        <title>ERROR</title>
    </head>
    <body>
        <div class="container">
            <img class="headImg" src="images/loginErrorO.png"/></br>
            <div class="errorTekst">
                Er is een fout opgetreden bij het inloggen. Uw personeelsnummer
                of paswoord is fout.
            </div>
            <form method="post" action="Controller">
                <input class="errorBut" type="submit" value="OK" />
                <input type="hidden" name="goto" value="inloggenError"/>
            </form>
        </div>
    </body>
</html>
