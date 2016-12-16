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
                <div class="titel">
                    Overzicht
                </div>
                <form method="post" action="Controller" >
                <table class="tableOnkost" align="center">
                    <tr>
                        <th>
                            Datum
                        </th>
                        <th>
                            Bedrag
                        </th>
                        <th>
                            Status
                        </th>
                        <th width="10%">
                            
                        </th>
                    </tr>
                    <c:forEach items="${requestScope.onkList}" var="onk">
                        <tr>
                            <td>
                                <c:out value="${onk.datum}"></c:out>
                            </td>
                            <td>
                                <c:out value="${onk.onkostenBedrag}"></c:out>
                            </td>
                            <td>
                                <c:out value="${onk.status}"></c:out>
                            </td>
                            <td>
                                <button type="submit" name="onkost" value="${onk.onkostId}">Bekijk</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <input type="hidden" name="goto" value="bekijkOnkost"/>
                </form>
                
                
            baasnummer :
            <%
                HttpSession sessie = request.getSession();
                Integer bNummer = (Integer) sessie.getAttribute("bNummer");
                out.println(Integer.toString(bNummer));
            %> 
        </div>
    </body>
</html>
