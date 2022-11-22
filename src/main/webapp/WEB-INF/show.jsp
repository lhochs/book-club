<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Read Share</title>
	<link rel="stylesheet" type="text/css" href="/css/main.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>

<body>
	<div id="container">
		<div class="nav-bar">
			<div>
				<h1><c:out value="${book.title}"></c:out></h1>
			</div>
			<div>
				<p><a href="/books">back to the shelves</a></p>
			</div>
		</div>
		<h2><c:out value="${user.name}"/> read <c:out value="${book.title}"/> by 
		<c:out value ="${book.author}"/>.</h2>
		<p>Here are <c:out value="${user.name}"/>'s thoughts: </p>
		<p><c:out value="${book.thoughts}"/></p>
		<a href="/books/edit/${book.id}">edit</a>
	</div>
</body>
</html>