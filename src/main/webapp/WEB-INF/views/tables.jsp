<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Database Manager Home</title>
    </head>
    <body>
    	<h1><a href="/DatabaseInterface">Home</a></h1>
        <div align="center">
            <h1>Murders List</h1>
            <h3><a href="tables/addMurder">Add murder</a></h3>
            <table border="1">
                <tr>
                    <th>No</th>
                    <th>Victim name</th>
                    <th>Victim gender</th>
                    <th>Victim address</th>
                    <th>Killer No</th>
                    <th></th>
                </tr>
                
                <c:forEach var="murder" items="${listMurder}">
                <tr>
                    <td>${murder.id}</td>
                    <td>${murder.victimName}</td>
                    <td>${murder.victimGender}</td>
                    <td>${murder.victimAddress}</td>
                    <td>${murder.killerId}</td>
                    <td><a href="tables/editMurder?id=${murder.id}">Edit</a><a href="tables/deleteMurder?id=${murder.id}">Delete</a></td>
                </tr>
                </c:forEach>             
            </table>
        </div>
        <div align="left">
            <h1>Killers List</h1>
            <h3><a href="tables/addKiller">Add killer</a></h3>
            <table border="1">
                <tr>
                    <th>No</th>
                    <th>Killer name</th>
                    <th></th>
                </tr>
                
                <c:forEach var="killer" items="${listKiller}">
                <tr>
                    <td>${killer.id}</td>
                    <td>${killer.name}</td>
                    <td><a href="tables/deleteKiller?id=${killer.id}">Delete</a></td>
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>