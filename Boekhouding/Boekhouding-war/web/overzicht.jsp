<%-- 
    Document   : overzicht
    Created on : Nov 29, 2016, 10:30:28 AM
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
        <h1>OVERZICHT</h1>
        personeelnummer :
        <%
            HttpSession sessie = request.getSession();
            Integer pNummer = (Integer) sessie.getAttribute("pNummer");
            out.println(Integer.toString(pNummer));
        %>
    </body>
</html>
