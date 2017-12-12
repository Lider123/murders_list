<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New/Edit Murder</title>
        <link rel='stylesheet' href='<c:url value="/resources/style.css" />' type='text/css' media='all' />
    </head>
    <body>
        <div align="center">
            <h1>New/Edit Murder</h1>
            <form:form action="addMurder" method="post" modelAttribute="murder">
            <table>
                <form:hidden path="id"/>
                <tr>
                    <td>Victim name:</td>
                    <td><form:input path="victimName" /></td>
                    <td><form:errors path="victimName" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Victim gender:</td>
                    <td>
                    	<form:radiobutton path="victimGender" value="m" />male
                    	<form:radiobutton path="victimGender" value="f" />female
                    </td>
                    <td><form:errors path="victimGender" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Victim address:</td>
                    <td><form:input path="victimAddress" /></td>
                </tr>
                <tr>
                    <td>Killer id:</td>
                    <td>
	                    <form:select path="killerId">
	                    	<option value="">-Choose killer-</option>
	        				<form:options items="${killers}" itemValue="id" itemLabel="name" />
	    				</form:select>
	    			</td>
                    <td><form:errors path="killerId" cssClass="error"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Save"></td>
                </tr>
            </table>
            </form:form>
        </div>
    </body>
</html>