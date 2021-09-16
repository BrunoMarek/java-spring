<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
    <H1>New Ninja</H1>

    <form:form action="/ninjas/create" method="post" modelAttribute="ninja">
        <p>
            <form:label path="dojo">Dojo</form:label>
            <form:errors path="dojo"/>
            <form:select path="dojo">
            <c:forEach items= '${allDojos}' var = 'dojo'>
                <option value="${dojo.id}">${dojo.name}</option>
            </c:forEach>    
        </form:select> 
    </p>
        <p>
            <form:label path="first_name">First Name</form:label>
            <form:errors path="first_name"/>
            <form:input path="first_name"/>
        </p>
        <p>
            <form:label path="last_name">Last Name</form:label>
            <form:errors path="last_name"/>
            <form:input path="last_name"/>
        </p>
        <p>
            <form:label path="age">Age</form:label>
            <form:errors path="age"/>
            <form:input type="number" path="age"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>  
</body>
</html>