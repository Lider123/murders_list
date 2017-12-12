<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Killer</title>
        <link rel='stylesheet' href='<c:url value="/resources/style.css" />' type='text/css' media='all' />
    </head>
    <body>
        <div align="center">
            <h1>New Killer</h1>
            <form:form action="addKiller" method="post" modelAttribute="killer">
            <table>
                <form:hidden path="id"/>
                <tr>
                    <td>Killer name:</td>
                    <td><form:input path="name" /></td>
                    <td><form:errors path="name" cssClass="error"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Save"></td>
                </tr>
            </table>
            </form:form>
        </div>
    </body>
</html>