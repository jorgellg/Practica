<%-- 
    Document   : listarPersons
    Created on : 29-sep-2016, 11:13:08
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <table>
            <thead>
                <tr>
                    <th>pUuid</th>
                    <th>lastSeen</th>
                    <th>lastClothing</th>
                    <th>comments</th>
                  
                </tr>
            </thead>
            <tbody>
                <c:forEach var="person" items="${persons}">
                    <tr>
                        <td>${person.pUuid}</td>
                        <td>${person.lastSeen}</td>
                        <td>${person.lastClothing}</td>
                        <td>${person.comments}</td>
                        <td><a href="PersonController?action=cambiar&p_uuid=${person.pUuid}">Cambiar</a></td>
                        <td><a href="PersonController?action=borrar&p_uuid=${person.pUuid}">Borrar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="PersonController?action=agregar">New Person</a>
        </p>
    </body>
</html>
