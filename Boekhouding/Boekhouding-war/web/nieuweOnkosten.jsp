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
        <link rel="stylesheet" type="text/css" href="css/overzicht.css">
        <title>NIEUWE ONKOST</title>
    </head>
    <body>
        <div class="container">
            <form method="post" action="Controller" class="menubalkform">
                <input type="image" src="images/saveOnkost.png" alt="submit" class="menubalkpict">
                <input type="hidden" name="goto" value="save"/>
            </form>
            <form method="post" action="Controller" class="menubalkform">
                <input type="image" src="images/sendOnkost.png" alt="submit" class="menubalkpict">
                <input type="hidden" name="goto" value="sendOnkost"/>
            </form>
            <form method="post" action="Controller" class="menubalkform">
                <input type="image" src="images/overzicht.png" alt="submit" class="menubalkpict">
                <input type="hidden" name="goto" value="overzicht"/>
            </form>
            <form method= "post" action="Controller">
                <input type="image" src="images/logoutO.png" alt="submit" class="menubalklogout">
                <input type="hidden" name="goto" value="uitloggen"/>
            </form>
            <hr class="menubalkhr">
            <div>
                <form method="post" action="Controller" >
                    <table class="onkostTable" width="80%" align="center">
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
                                <input type="number" name="bedrag" min="0">
                            </td>
                        </tr>
                        <tr>
                            <td></td><td></td>
                            <td>
                                Omschrijving
                            </td>
                            <td>
                                <textarea name="omschrijving" rows="4" cols="100%">Algemene omschrijving nieuwe onkost.</textarea>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
