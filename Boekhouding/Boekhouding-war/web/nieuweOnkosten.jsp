<%-- 
    Document   : onkosten
    Created on : Nov 29, 2016, 10:44:45 AM
    Author     : simon
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/nieuweOnkosten.css">
        <title>NIEUWE ONKOST</title>
    </head>
    <body>
        <div class="container">
            <form method="post" action="Controller" >
            <div class="menubalkform">
                <input type="image" src="images/saveOnkost.png" alt="submit" name="action" value="save" class="menubalkpict">
                <input type="image" src="images/sendOnkost.png" alt="submit" name="action" value="send" class="menubalkpict">
                <input type="image" src="images/overzicht.png" alt="submit" name="action" value="overzicht" class="menubalkpict">
                <input type="image" src="images/logoutO.png" alt="submit" name="action" value="uitloggen" class="menubalklogout">
                <input type="hidden" name="goto" value="saveOnkost"/>
            </div>
            <hr class="menubalkhr">
            <div class="onkostveld">
                <div class="onkostId">
                    ID <c:out value="${onkostId}" default="error"/>
                </div>
                <div class="datum">
                    DATUM <c:out value="${datum}" default="error"/>
                </div>
            </div>
            <%--
                <table class="tableOnkost" align="center">
                    <thead>
                        <tr>
                            <th width="10%"/>
                            <th width="10%"/>
                            <th width="10%"/>
                            <th width="30%"/>
                            <th width="10%"/>
                            <th width="10%"/>
                        </tr>
                    </thead>
                    <tr>
                        <td>
                            ID
                        </td>
                        <td>
                            <c:out value="${onkostId}" default="error"/>
                        </td>
                        <td></td><td></td>
                        <td>
                            DATUM
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
                            <input type="number" name="bedrag" min="0" step="0.01" placeholder="00.00">
                        </td>
                    </tr>
                    <tr>
                        <td></td><td></td>
                        <td valign="top">
                            Omschrijving
                        </td>
                        <td>
                            <textarea name="omschrijving" placeholder="Algemene omschrijving nieuwe onkost"></textarea>
                        </td>
                    </tr>
                 </table>--%>
            </form>
        </div>
    </body>
</html>
