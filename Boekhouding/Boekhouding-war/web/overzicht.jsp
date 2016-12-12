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
        <title>OVERZICHT</title>
    </head>
    <body>
        <div class="container">
                <c:set var="werkType" scope="session" value="${3}"/> <%--TIJDELIJK--%>
                <c:choose>
                    <c:when test="${werkType == 1}">
                        <form method="post" action="Controller" class="menubalkform">
                            <input type="image" src="images/nieuwO.png" alt="submit" class="menubalkpict">
                            <input type="hidden" name="goto" value="nieuweOnkosten"/>
                        </form>
                    </c:when>
                    <c:when test="${werkType == 2}">
                        <form method="post" action="Controller" class="menubalkform">
                            <input type="image" src="images/nieuwO.png" alt="submit" class="menubalkpict">
                            <input type="hidden" name="goto" value="nieuweOnkosten"/>
                        </form>
                        <form method="post" action="Controller" class="menubalkform">
                            <input type="image" src="images/kredietenO.png" alt="submit" class="menubalkpict">
                            <input type="hidden" name="goto" value="bekijkKrediet"/>
                        </form>
                    </c:when>
                    <c:when test="${werkType == 3}">
                        <form method="post" action="Controller" class="menubalkform">
                            <input type="image" src="images/nieuwO.png" alt="submit" class="menubalkpict">
                            <input type="hidden" name="goto" value="nieuweOnkosten"/>
                        </form>
                        <form method="post" action="Controller" class="menubalkform">
                            <input type="image" src="images/kredietenO.png" alt="submit" class="menubalkpict">
                            <input type="hidden" name="goto" value="bekijkKrediet"/>
                        </form>
                        <form method="post" action="Controller" class="menubalkform">
                            <input type="image" src="images/goedkeurenO.png" alt="submit" class="menubalkpict">
                            <input type="hidden" name="goto" value="goedkeurenKrediet"/>
                        </form>
                    </c:when>
                    <c:when test="${werkType == 23}">
                        23
                    </c:when>
                </c:choose>
                <form method= "post" action="Controller">
                     <input type="image" src="images/logoutO.png" alt="submit" class="menubalklogout">
                     <input type="hidden" name="goto" value="uitloggen"/>
                </form>
                <hr class="menubalkhr">
                <c:forTokens items="test,edw,start,begin" delims="," var="name">
                    <c:out value="${name}"/><p>
                </c:forTokens>
                <c:out value="${pNummer}" default="error"/>
                
                
<%--        <h1>OVERZICHT</h1>
            personeelnummer :
            <%
                HttpSession sessie = request.getSession();
                Integer pNummer = (Integer) sessie.getAttribute("pNummer");
                out.println(Integer.toString(pNummer));
            %> 
--%>
        </div>
    </body>
</html>
