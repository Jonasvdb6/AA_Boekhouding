<%-- 
    Document   : bekijkKrediet
    Created on : Dec 18, 2016, 4:50:59 PM
    Author     : simon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bekijkKrediet.css">
        <title>BEKIJK KREDIETEN</title>
    </head>
    <body>
        <div class="container">
            <form method="post" action="Controller" >
                <div class="menubalkform">
                    <input type="image" src="images/overzichtO.png" alt="submit" name="goto" value="overzicht" class="menubalkpict">
                    <input type="image" src="images/terug.png" alt="submit" name="goto" value="terugOverzichtKrediet" class="menubalkpict">
                    <input type="image" src="images/logoutO.png" alt="submit" name="goto" value="uitloggen" class="menubalklogout">
                </div>
            </form>
            <hr class="menubalkhr">
            <div class="titel">
                Overzicht onkosten
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
                    <c:forEach items="${onkList}" var="onk">
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
                                <button type="submit" name="onkostId" value="${onk.onkostId}" class="bekijkOnkostBut">Bekijk</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <input type="hidden" name="goto" value="infoOnkost"/>
            </form>
        </div>
    </body>
</html>
