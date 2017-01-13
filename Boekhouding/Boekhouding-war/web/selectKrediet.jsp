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
        <link rel='shortcut icon' type='image/x-icon' href='images/favicon.ico' />
        <title>E-Finances</title>
    </head>
    <body>
        <div class="container">
            <form method="post" action="Controller" >
                <div class="menubalkform">
                    <input type="image" src="images/overzichtO.png" alt="submit" name="goTo" value="overzicht" class="menubalkpict">
                    <input type="image" src="images/logoutO.png" alt="submit" name="goTo" value="uitloggen" class="menubalklogout2">
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
                            <c:when test="${kred.negatief == 0}">
                                <tr>
                            </c:when>
                            <c:otherwise>
                                <tr Style= "background-color: red; font-style: italic;">
                            </c:otherwise>
                        </c:choose>
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
                    </c:forEach>
                    <!-- Om de pagina 1 keer te reloaden zodat je css aangepast wordt de rijen up-to-date wordt gehouden naar een al dan niet rode achtergrond kleur -->
                    <script type="text/javascript">
                        window.onload = function() 
                        {
                            if(!window.location.hash) 
                            {
                                window.location = window.location + '#';
                                window.location.reload();
                            }
                        };
                    </script>
                </table>
                <input type="hidden" name="goto" value="selectKrediet"/>
            </form>
        </div>
    </body>
</html>