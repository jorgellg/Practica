<%-- 
    Document   : persons
    Created on : 29-sep-2016, 11:06:59
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <form action="PersonController" method="post">
            <fieldset>
                <div>
                <label>Person: </label>
                <input type="text" name="pUuid" value="${person.pUuid}"
                       placeholder="Person"
                       readonly="readonly"/>
                </div>
                       <div>
                <label>Last seen: </label>
                <input type="text" name="lastSeen" value="${person.lastSeen}"
                       placeholder="Last seen"/>
                       </div>
                       <div>       
                <label>Last clothing: </label>
                <input type="text" name="lastClothing" value="${person.lastClothing}"
                       placeholder="Last clothing"/>
                       </div>
                       <div>
                <label>Comments: </label>
                <input type="text" name="comments" value="${person.comments}"
                       placeholder="Comments"/>
                       </div>
               
                       <div>
                           <input type="submit" value="Guardar"/>
                       </div>
            </fieldset>
        </form>
    </body>
</html>
