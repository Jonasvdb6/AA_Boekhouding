<%-- 
    Document   : infoKrediet
    Created on : 10-jan-2017, 13:52:05
    Author     : jonas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/infoKrediet.css">
        <link rel='shortcut icon' type='image/x-icon' href='images/favicon.ico' />
        <title>E-Finances</title>
    </head>
    <body>
        <div class="container">
            <form method="post" action="Controller" >
                <div class="menubalkform">
                    <input type="image" src="images/overzichtO.png" alt="submit" name="goto" value="overzicht" class="menubalkpict">
                    <input type="image" src="images/logoutO.png" alt="submit" name="goto" value="uitloggen" class="menubalklogout">
                </div>
            </form>
            <hr class="menubalkhr">
            
            <div class="titel">
                Krediet
            </div>
            <table class="tableOnkost" align="center">
                <thead>
                    <tr>
                        <th width="5%"/>
                        <th width="5%"/>
                        <th width="10%"/>
                        <th width="60%"/>
                        <th width="5%"/>
                        <th width="5%"/>
                    </tr>
                </thead>
                <tr>
                    <td>
                        <b>Kredietnummer</b>
                    </td>
                    <td>
                        <b><c:out value="${Krediet.krNummer}" default="error"/></b>
                    </td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td><td></td>
                    <td>
                        Bedrag
                    </td>
                    <td>
                        <c:out value="${Krediet.krSaldo}" default="error"/>
                    </td>
                </tr>
                <tr>
                    <td></td><td></td>
                    <td valign="top">
                        Type
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${Krediet.krType == 1}">
                                Gewoon krediet
                            </c:when>
                            <c:when test="${Krediet.krType == 2}">
                                Gewaarborgd krediet
                            </c:when>
                        </c:choose>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
