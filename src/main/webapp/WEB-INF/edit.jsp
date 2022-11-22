<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
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
				<h1>Add a Book to Your Shelf!</h1>
			</div>
			<div>
				<p><a href="/books">Back to Shelves</a></p>
			</div>
		</div>
		<div>
			<form:form action="/books/${book.id}" method="post" modelAttribute="book">
			<input type="hidden" name="_method" value="put"/>
				<p>
					<form:errors class="error" path="title"/>
				</p>
				<p>
					<form:errors class="error" path="author"/>
				</p>
				<p>
					<form:errors class="error" path="thoughts"/>
				</p>
				<p>
					<form:errors class="error" path="user"/>
				</p>
				<p>
					<form:label path="title">Title: </form:label>
					<form:input path="title"/>
				</p>
				<p>
					<form:label path="author">Author: </form:label>
					<form:input path="author"/>
				</p>
				<p>
					<form:label path="thoughts">My Thoughts: </form:label>
					<form:input path="thoughts"/>
				</p>
				<p>
					<form:input type="hidden" path="user" value="${user.id}"/>
				</p>
				<div class="centerbtn">
					<input class="btn" type="submit" value="Submit"/>	
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>