<%-- 
    Document   : overzicht
    Created on : Nov 29, 2016, 10:30:28 AM
    Author     : simon
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    HttpSession sessie = request.getSession(); 
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/overzicht.css">
        <title>OVERZICHT</title>
    </head>
    <body>
        <div class="container">
                <c:choose>
                    <c:when test="${werkType == 1}"> <%--GEWOON--%>
                        <form method="post" action="Controller" class="menubalkform">
                            <input type="image" src="images/nieuwO.png" alt="submit" class="menubalkpict">
                            <input type="hidden" name="goto" value="nieuweOnkosten"/>
                        </form>
                    </c:when>
                    <c:when test="${werkType == 2}"> <%--BOEKHOUDER--%>
                        <form method="post" action="Controller" class="menubalkform">
                            <input type="image" src="images/nieuwO.png" alt="submit" class="menubalkpict">
                            <input type="hidden" name="goto" value="nieuweOnkosten"/>
                        </form>
                        <form method="post" action="Controller" class="menubalkform">
                            <input type="image" src="images/kredietenO.png" alt="submit" class="menubalkpict">
                            <input type="hidden" name="goto" value="overzichtKrediet"/>
                        </form>
                    </c:when>
                    <c:when test="${werkType == 3}"> <%--MANAGER--%>
                        <form method="post" action="Controller" class="menubalkform">
                            <input type="image" src="images/nieuwO.png" alt="submit" class="menubalkpict">
                            <input type="hidden" name="goto" value="nieuweOnkosten"/>
                        </form>
                        <form method="post" action="Controller" class="menubalkform">
                            <input type="image" src="images/goedkeurenO.png" alt="submit" class="menubalkpict">
                            <input type="hidden" name="goto" value="goedkeurenOnkost"/>
                        </form>
                    </c:when>
                    <c:when test="${werkType == 23}"> <%--BOEKHOUDER + MANAGER--%>
                        <form method="post" action="Controller" class="menubalkform">
                            <input type="image" src="images/nieuwO.png" alt="submit" class="menubalkpict">
                            <input type="hidden" name="goto" value="nieuweOnkosten"/>
                        </form>
                        <form method="post" action="Controller" class="menubalkform">
                            <input type="image" src="images/kredietenO.png" alt="submit" class="menubalkpict">
                            <input type="hidden" name="goto" value="overzichtKrediet"/>
                        </form>
                        <form method="post" action="Controller" class="menubalkform">
                            <input type="image" src="images/goedkeurenO.png" alt="submit" class="menubalkpict">
                            <input type="hidden" name="goto" value="goedkeurenOnkost"/>
                        </form>
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
                        <th width="15%">
                            
                        </th>
                    </tr>
                    <c:forEach items="${sessionScope.onkList}" var="onk">
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
                                <%--<input type="image" src="images/view.png" alt="submit" name="onkost" value="${onk.onkostId}" class="overzichPict">--%>
                                <button type="submit" name="onkostId" value="${onk.onkostId}" class="overzichBut">Bekijk</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <input type="hidden" name="goto" value="bekijkOnkost"/>
                </form>
                <c:out value="${sessionScope.test}"></c:out>
                
            baasnummer :
        </div>
    </body>
</html>
