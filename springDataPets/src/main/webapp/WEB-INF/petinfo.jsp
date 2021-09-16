<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Hero goes the pet ${petToDisplay.id} info</h1>
    <p>Name: ${petToDisplay.name}</p>
    <p>Age: ${petToDisplay.age}</p>
    <p>Description: ${petToDisplay.description}</p>

</body>
</html>