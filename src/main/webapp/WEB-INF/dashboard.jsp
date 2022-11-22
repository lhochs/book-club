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
				<h1>Welcome, <c:out value="${user.name}"></c:out>!</h1>
				<p>Books from everyone's shelves:</p>
			</div>
			<div class="box">
				<p><a href="/logout">Logout</a></p>
				<p><a href="/books/new">+ Add a book to my shelf!</a></p>
			</div>
		</div>
		<div id="shelf">
			<table>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Posted By</th>
					<th>Actions</th>
				</tr>
					<c:forEach var="book" items="${books}">
				<tr>
					<td><c:out value="${book.id}"/></td>
					<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
					<td><c:out value="${book.author}"/></td>
					<td><c:out value="${book.user.name}"/></td>
					<td>
					<form action="/books/${book.id}" method="POST">
					<input type="hidden" name="_method" value="delete"/>
					<input type="submit" value="delete"/></form>
					</td>
				</tr>
					</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>