<%-- 
    Document   : goedkeurenOnkost
    Created on : Dec 17, 2016, 4:18:08 PM
    Author     : simon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/goedkeurenOnkost.css">
        <title>ONKOST GOEDKEUREN</title>
    </head>
    <body>
        <div class="container">
            <form method="post" action="Controller" >
            <div class="menubalkform">
                <input type="image" src="images/overzichtO.png" alt="submit" name="action" value="overzicht" class="menubalkpict">
                <input type="image" src="images/logoutO.png" alt="submit" name="action" value="uitloggen" class="menubalklogout">
                <input type="hidden" name="goto" value="goedkeurenOnkostUpdate"/>
            </div>
            </form>
            <form method="post" action="Controller" >
                <div class="menubalkform">
                    <input type="image" src="images/goedkeurenO.png" alt="submit" name="action" value="goedkeuren" class="menubalkpict">
                    <input type="image" src="images/goedkeurenO.png" alt="submit" name="action" value="afkeuren" class="menubalkpict">
                    <input type="image" src="images/goedkeurenO.png" alt="submit" name="action" value="bekijkOnkost" class="menubalkpict">
                    <input type="image" src="images/goedkeurenO.png" alt="submit" name="action" value="bekijkKrediet" class="menubalkpict">
                    
                </div>
                <hr class="menubalkhr">
                <div class="titel">
                    Onkosten goedkeuren
                </div>
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
                                <input type="radio" alt="submit" name="onkostId" value="${onk.onkostId}" class="onkostOption">
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <input type="hidden" name="goto" value="goedkeurenOnkostUpdate"/>
            </form>
        </div>
    </body>
</html>
