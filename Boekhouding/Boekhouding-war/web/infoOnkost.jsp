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
        <link rel='shortcut icon' type='image/x-icon' href='images/favicon.ico' />
        <title>E-Finances</title>
    </head>
    <body>
        <div class="container">
            <form method="post" action="Controller" >
                <div class="menubalkform">
                    <input type="image" src="images/overzichtO.png" alt="submit" name="goto" value="overzicht" class="menubalkpict">
                    <input type="image" src="images/terug.png" alt="submit" name="goto" value="terugOverzichtOnkost" class="menubalkpict">
                    <input type="image" src="images/logoutO.png" alt="submit" name="goto" value="uitloggen" class="menubalklogout">
                </div>
            </form>
            <hr class="menubalkhr">
            
            <div class="titel">
                Onkost ID: <c:out value="${Onkost.onkostId}"></c:out>
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
                        <b><c:out value="${Onkost.onkostId}" default="error"/></b>
                    </td>
                    <td></td>
                    <td>
                        <b>STATUS:</b>
                        <b><c:out value="${Onkost.status}" default="error"/></b>
                    </td>
                </tr>
                <tr>
                    <td></td><td></td>
                    <td>
                        Datum
                    </td>
                    <td>
                        <c:out value="${Onkost.datum}" default="error"/>
                    </td>
                </tr>
                <tr>
                    <td></td><td></td>
                    <td>
                        Bedrag
                    </td>
                    <td>
                        <c:out value="${Onkost.onkostenBedrag}" default="error"/>
                    </td>
                </tr>
                <tr>
                    <td></td><td></td>
                    <td valign="top">
                        Omschrijving
                    </td>
                    <td>
                        <c:out value="${Onkost.omschrijving}" default="error"/>
                    </td>
                </tr>
            </table>
                    
        </div>
    </body>
</html>
