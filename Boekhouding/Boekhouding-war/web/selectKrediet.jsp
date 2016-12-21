<%-- 
    Document   : selectKrediet
    Created on : Nov 29, 2016, 10:45:39 AM
    Author     : simon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/selectKrediet.css">
        <title>SELECT KREDIET</title>
    </head>
    <body>
        <div class="container">
            <form method="post" action="Controller" >
                <div class="menubalkform">
                    <input type="image" src="images/overzichtO.png" alt="submit" name="action" value="overzicht" class="menubalkpict">
                    <input type="image" src="images/logoutO.png" alt="submit" name="action" value="uitloggen" class="menubalklogout2">
                    <input type="hidden" name="goto" value="selectKredietStop"/>
                </div>
            </form>
            <hr class="menubalkhr">
            <div class="titel">
                Krediet selecteren
            </div>
            <form method="post" action="Controller" >
                <table class="tableSelect" align="center">
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
                    <c:forEach items="${kredList}" var="kred">
                        <c:choose>
                            <c:when test="${negatief == 0}">
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
                                        <button type="submit" name="krediet" value="${kred.krNummer}" class="selectBut">Selecteer</button>
                                    </td>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td>
                                        <c:out value="${kred.krNummer}"></c:out>
                                    </td>
                                    <td>
                                        <c:out value="${kred.krSaldo}"></c:out>
                                    </td>
                                    <td>
                                        <c:out value="${kred.krType}"></c:out>
                                    </td>
                                    <td>
                                        <input type="radio" name="krediet" value="${kred.krNummer}" required=""> 
                                    </td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </table>
                <input type="hidden" name="goto" value="selectKrediet"/>
            </form>
        </div>
    </body>
</html>
