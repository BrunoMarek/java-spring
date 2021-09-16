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
    <a href="/">Dashboard</a>
    <h1>${findLanguage.id} info</h1>
    <p>Name: ${findLanguage.name}</p>
    <p>Creator: ${findLanguage.creator}</p>
    <p>Version: ${findLanguage.version}</p>

    <a href="/languages/edit/${findLanguage.id}">Edit</a> <br>
    <a href="/languages/delete/${findLanguage.id}">Delete</a>

</body>
</html>