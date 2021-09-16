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
    <div class="container">
        <h1>Heloo mf</h1>
        <a href="/resident/new">Create a new resident</a>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Capital</th>
                    <th scope="col">Animal</th>
                </tr>
            </thead>
            <tbody>
                    <c:forEach items= '${allStates}' var = 'state'>
                <tr>
                    <th scope="row">${state.id}</th>
                    <td><a href="/state/${state.id}">${state.name}</a></td>
                    <td>${state.description}</td>
                    <td>${state.capital}</td>
                    <td>${state.animal}</td>
                </tr>
            </c:forEach>
                </tbody>
            </table>
        <h3>Add a new State</h3>
        <form:form action="/state/create" method="post" modelAttribute="state">
        <p>
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="description">Description</form:label>
            <form:errors path="description"/>
            <form:textarea path="description"/>
        </p>
        <p>
            <form:label path="capital">Capital</form:label>
            <form:errors path="capital"/>
            <form:input path="capital"/>
        </p>
        <p>
            <form:label path="animal">Animal</form:label>
            <form:errors path="animal"/>     
            <form:input path="animal"/>
        </p>    
        <input type="submit" value="Submit"/>
    </form:form>  
    </div>

</body>
</html>