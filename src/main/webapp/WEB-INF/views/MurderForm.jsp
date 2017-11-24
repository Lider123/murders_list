<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New/Edit Murder</title>
    </head>
    <body>
        <div align="center">
            <h1>New/Edit Murder</h1>
            <form:form action="saveMurder" method="post" modelAttribute="murder">
            <table>
                <form:hidden path="id"/>
                <tr>
                    <td>Victim name:</td>
                    <td><form:input path="victimName" /></td>
                </tr>
                <tr>
                    <td>Victim gender:</td>
                    <td><form:input path="victimGender" /></td>
                </tr>
                <tr>
                    <td>Victim address:</td>
                    <td><form:input path="victimAddress" /></td>
                </tr>
                <tr>
                    <td>Killer id:</td>
                    <td><form:input path="killerId" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Save"></td>
                </tr>
            </table>
            </form:form>
        </div>
    </body>
</html>