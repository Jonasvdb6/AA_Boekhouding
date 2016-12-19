<%-- 
    Document   : infoOnkost
    Created on : Dec 19, 2016, 1:01:57 PM
    Author     : simon
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/infoOnkost.css">
        <title>ONKOST</title>
    </head>
    <body>
        <div class="container">
            <form method="post" action="Controller" >
                <div class="menubalkform">
                    <input type="image" src="images/overzichtO.png" alt="submit" name="action" value="overzicht" class="menubalkpict">
                    <input type="image" src="images/logoutO.png" alt="submit" name="action" value="uitloggen" class="menubalklogout">
                    <input type="hidden" name="goto" value="infoOnkostStop"/>
                </div>
            </form>
            <hr class="menubalkhr">
            <div class="titel">
                Onkost ID: <c:out value="${onkostId}"></c:out>
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
                        <b>ID</b>
                    </td>
                    <td>
                        <b><c:out value="${onkostId}" default="error"/></b>
                    </td>
                    <td></td>
                    <td>
                        <b>STATUS:</b>
                        <b><c:out value="${status}" default="error"/></b>
                    </td>
                </tr>
                <tr>
                    <td></td><td></td>
                    <td>
                        Datum
                    </td>
                    <td>
                        <c:out value="${datum}" default="error"/>
                    </td>
                </tr>
                <tr>
                    <td></td><td></td>
                    <td>
                        Bedrag
                    </td>
                    <td>
                        <c:out value="${onkostenBedrag}" default="error"/>
                    </td>
                </tr>
                <tr>
                    <td></td><td></td>
                    <td valign="top">
                        Omschrijving
                    </td>
                    <td>
                        <c:out value="${omschrijving}" default="error"/>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
