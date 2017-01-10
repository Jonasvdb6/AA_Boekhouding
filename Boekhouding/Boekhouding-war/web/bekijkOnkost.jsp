<%-- 
    Document   : bekijkOnkosten
    Created on : Nov 29, 2016, 10:47:26 AM
    Author     : simon
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bekijkOnkost.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <title>BEKIJK ONKOST</title>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $( function() {
                $( "#datepicker" ).datepicker({ dateFormat: 'dd/mm/yy' });
            } );
        </script>
    </head>
    <body>
        <div class="container">
            <c:choose>
                <c:when test="${Onkost.status == 'In aanmaak'}">
                    <form method="post" action="Controller" >
                        <div class="menubalkform">
                            <input type="image" src="images/saveOnkostO.png" alt="submit" name="goto" value="save" class="menubalkpict">
                            <input type="image" src="images/sendOnkostO.png" alt="submit" name="goto" value="send" class="menubalkpict">
                            <input type="image" src="images/deleteO.png" alt="submit" name="goto" value="delete" class="menubalkpict">
                            <input type="image" src="images/overzichtO.png" alt="submit" name="goto" value="overzicht" class="menubalkpict">
                            <input type="image" src="images/logoutO.png" alt="submit" name="goto" value="uitloggen" class="menubalklogout">
                        </div>
                        <hr class="menubalkhr">
                        <div class="titel">
                            Onkost bekijken
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
                                    <input type="text" id="datepicker" name="datum" value="<c:out value="${Onkost.datum}" default="error"/>">
                                </td>
                            </tr>
                            <tr>
                                <td></td><td></td>
                                <td>
                                    Bedrag
                                </td>
                                <td>
                                    <input type="number" name="bedrag" min="0" step="0.01" value="<c:out value="${Onkost.onkostenBedrag}" default="error"/>">
                                </td>
                            </tr>
                            <tr>
                                <td></td><td></td>
                                <td valign="top">
                                    Omschrijving
                                </td>
                                <td>
                                    <textarea name="omschrijving"><c:out value="${Onkost.omschrijving}" default="error"/></textarea>
                                </td>
                            </tr>
                        </table>
                    </form>
                </c:when>
                <c:otherwise>
                    <form method="post" action="Controller" >
                        <div class="menubalkform">
                            <input type="image" src="images/overzichtO.png" alt="submit" name="goto" value="overzicht" class="menubalkpict">
                            <input type="image" src="images/logoutO.png" alt="submit" name="goto" value="uitloggen" class="menubalklogout2">
                        </div>
                        <hr class="menubalkhr">
                        <div class="titel">
                            Onkost bekijken
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
                    </form>
                </c:otherwise>
            </c:choose> 
        </div>
    </body>
</html>
