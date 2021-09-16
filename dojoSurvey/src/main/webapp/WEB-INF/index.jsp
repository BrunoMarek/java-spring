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
	<form action="/process" method="POST">
		
		<div class="container mx-auto">
		
			<div class="form-group mx-auto">
				<label for="name">Name</label>
				<input type="text" class="text form-control w-50">
			</div>
			<div class="form-group">
				<label for="dojo_location">Dojo Location</label>
				<select name="dojo_location" class="form-control">
					<option value="Chicago">Chicago</option>
					<option value="Dallas">Dallas</option>
					<option value="NYC">NYC</option>
					<option value="Seatle">Seatle</option>
				</select>
			</div>
			<div class="form-group mx-auto">
				<label for="favorite_language">Dojo Location</label>
				<select name="favorite_language" class="form-control">
					<option value="Python">Python</option>
					<option value="JS">JS</option>
					<option value="Java">Java</option>
					<option value="Ruby">Ruby</option>
				</select>
			</div>
			<div class="form-group">
				<label for="comment">Comment</label>
				<textarea name="comment" cols="50" rows="10"></textarea>
			</div>
		<button>Submit</button>
		</div>


	</form>
	
</body>
</html>