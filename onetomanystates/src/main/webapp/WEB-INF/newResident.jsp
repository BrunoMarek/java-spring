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
    <h1>Create a new reisdent</h1>
    <form:form action="/resident/create" method="post" modelAttribute="resident">
        <p>
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="age">Age</form:label>
            <form:errors path="age"/>
            <form:input type="number" path="age"/>
        </p>
        <p>
            <form:label path="state">State</form:label>
            <form:errors path="state"/>
            <form:select path="state">
                <c:forEach items= '${allStates}' var = 'state'>
            <option value="${state.id}">${state.name}</option>
                </c:forEach>    
            </form:select> 
        </p>
        <input type="submit" value="Submit"/>
    </form:form>  

</body>
</html>