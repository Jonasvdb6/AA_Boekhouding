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
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <title>NIEUWE ONKOST</title>
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
            <form method="post" action="Controller" >
            <div class="menubalkform">
                <input type="image" src="images/saveOnkostO.png" alt="submit" name="action" value="save" class="menubalkpict">
                <input type="image" src="images/sendOnkostO.png" alt="submit" name="action" value="send" class="menubalkpict">
                <input type="image" src="images/overzichtO.png" alt="submit" name="action" value="overzicht" class="menubalkpict">
                <input type="image" src="images/logoutO.png" alt="submit" name="action" value="uitloggen" class="menubalklogout">
                <input type="hidden" name="goto" value="saveOnkost"/>
            </div>
            <hr class="menubalkhr">
            <div class="titel">
                Nieuwe onkost toevoegen
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
                    </tr>
                    <tr>
                        <td></td><td></td>
                        <td>
                            Datum
                        </td>
                        <td>
                            <input type="text" id="datepicker" name="datum" placeholder="01/01/2017">
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
                 </table>
            </form>
        </div>
    </body>
</html>
