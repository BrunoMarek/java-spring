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
<title>Language</title>
</head>
<body>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Creator</th>
            <th scope="col">Version</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items ="${ allLanguage }" var="l">
        <tr>
            <th scope="row"><a href="/languages/info/${l.id}">${l.name}</a></th>
            <td>${l.creator}</td>
            <td>${l.version}</td>
            <td><a href="/languages/delete/${l.id}">Delete</a> | <a href="/languages/edit/${l.id}">Edit</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <br><br>
    <body>
        <form:form action="/languages/create" method="post" modelAttribute="languages">
        <p>
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="creator">Creator</form:label>
            <form:errors path="creator"/>
            <form:textarea path="creator"/>
        </p>
        <p>
            <form:label path="version">Version</form:label>
            <form:errors path="version"/>
            <form:input type="number" path="version"/>
        </p>  
        <input type="submit" value="Submit"/>
    </form:form> 
</body>
</html>