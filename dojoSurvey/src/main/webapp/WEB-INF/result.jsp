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
	<h1>Submitted Info</h1>
	Name: <c:out value= "${name}"/> <br>
	Location: <c:out value= "${dojo_location}"/> <br>
	Favorite Language: <c:out value= "${favorite_language}"/> <br>
	Comment: <c:out value= "${comment}"/> <br>
	
</body>
</html>