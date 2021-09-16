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
    <h1>Info about ${state.name} </h1>
    <h3>Capital: ${state.capital}</h3>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">#ID</th>
                <th scope="col">Name</th>
                <th scope="col">Age</th>

            </tr>
        </thead>
        <tbody>
                <c:forEach items= '${state.residents}' var = 'resident'>
            <tr>
                <th scope="row">${resident.id}</th>
                <td>${resident.name}</td>
                <td>${resident.age}</td>
            </tr>
        </c:forEach>
            </tbody>
        </table>
</body>
</html>