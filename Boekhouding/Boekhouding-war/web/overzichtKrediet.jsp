<%-- 
    Document   : bekijkKrediet
    Created on : Nov 29, 2016, 10:46:45 AM
    Author     : simon
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/overzichtKrediet.css">
        <title>OVERZICHT KREDIETEN</title>
    </head>
    <body>
        <div class="container">
            <form method="post" action="Controller" >
                <div class="menubalkform">
                    <input type="image" src="images/overzichtO.png" alt="submit" name="action" value="overzicht" class="menubalkpict">
                    <input type="image" src="images/logoutO.png" alt="submit" name="action" value="uitloggen" class="menubalklogout">
                    <input type="hidden" name="goto" value="overzichtKredietStop"/>
                </div>
            </form>
            <hr class="menubalkhr">
            <div class="titel">
                Overzicht kredieten
            </div>
            <form method="post" action="Controller" >
                <table class="tableBekijk" align="center">
                    <tr>
                        <th width="18%">
                            Nummer
                        </th>
                        <th width="18%">
                            Saldo
                        </th>
                        <th width="18%">
                            Type
                        </th>
                        <th width="15%">
                            
                        </th>
                    </tr>
                    <c:forEach items="${requestScope.kredList}" var="kred">
                        <tr>
                            <td>
                                <c:out value="${kred.krNummer}"></c:out>
                            </td>
                            <td>
                                <c:out value="${kred.krSaldo}"></c:out>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${kred.krType == 1}">
                                        Niet-gewaarborgd
                                    </c:when>
                                    <c:otherwise>
                                        Gewaarborgd
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <button type="submit" name="krediet" value="${kred.krNummer}" class="bekijkBut">Bekijk</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <input type="hidden" name="goto" value="bekijkKrediet"/>
            </form>
        </div>
    </body>
</html>