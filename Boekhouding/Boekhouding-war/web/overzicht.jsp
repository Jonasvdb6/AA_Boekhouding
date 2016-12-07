<%-- 
    Document   : overzicht
    Created on : Nov 29, 2016, 10:30:28 AM
    Author     : simon
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/overzicht.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
                <c:set var="werkType" scope="session" value="${3}"/>
                <c:choose>
                    <c:when test="${werkType == 1}">
                        <img class="menubalkpict" src="images/nieuwO.png">
                    </c:when>
                    <c:when test="${werkType == 2}">
                        <img class="menubalkpict" src="images/nieuwO.png">
                        <img class="menubalkpict" src="images/kredietenO.png">
                    </c:when>
                    <c:when test="${werkType == 3}">
                        <a href="onkosten.jsp">
                            <img class="menubalkpict" src="images/nieuwO.png">
                        </a>
                        <img class="menubalkpict" src="images/kredietenO.png">
                        <img class="menubalkpict" src="images/goedkeurenO.png">
                    </c:when>
                    <c:when test="${werkType == 23}">
                        23
                    </c:when>
                </c:choose>
                <form method= "post" action="<%= response.encodeURL("ControllerDo")%>">
                     <input type="image" src="images/logoutO.png" alt="submit" class="menubalklogout">
                     <input type="hidden" name="goto" value="uitloggen"/>       
                </form>
                <hr class="menubalkhr">
                
                
                
                
            <h1>OVERZICHT</h1>
            personeelnummer :
            <%
                HttpSession sessie = request.getSession();
                Integer pNummer = (Integer) sessie.getAttribute("pNummer");
                out.println(Integer.toString(pNummer));
            %>
        </div>
    </body>
</html>
