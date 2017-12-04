<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Database Manager Home</title>
    </head>
    <body>
        <div align="center">
            <h1>Murder List</h1>
            <h3><a href="tables">Tables</a></h3>
            <table border="1">
                <tr>
                    <th>No</th>
                    <th>Victim name</th>
                    <th>Victim gender</th>
                    <th>Victim address</th>
                    <th>Killer name</th>
                </tr>
                
                <c:forEach var="murder" items="${listMurderWithKiller}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${murder.victimName}</td>
                    <td>${murder.victimGender}</td>
                    <td>${murder.victimAddress}</td>
                    <td>${murder.killerName}</td>
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>