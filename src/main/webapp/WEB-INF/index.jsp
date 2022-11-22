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
			<h1>Book Club!</h1>
			<p> A place for friends to share thoughts on books</p>
		</div>
		<div id="forms">
			<div class = "register">
				<h3>Register</h3>
				<form:form action="/register" method="post" modelAttribute="newUser">
					<p>
						<form:errors class="error" path="name"/>
					</p>
					<p>
						<form:errors class="error" path="email"/>
					</p>
						<form:errors class="error" path="password"/>
					<p>
						<form:errors class="error" path="confirm"/>
					</p>
					<p>
						<form:label path="name">Name: </form:label>
						<form:input path="name"/>
					</p>
					<p>
						<form:label path="email">Email: </form:label>
						<form:input path="email"/>
					</p>
					<p>
						<form:label path="password">Password: </form:label>
						<form:input path="password"/>
					</p>
					<p>
						<form:label path="confirm">Confirm PW:</form:label>
						<form:input path="confirm"/>
					</p>
					<div class="centerbtn">
						<input class="btn" type="submit" value="Register"/>	
					</div>
				</form:form>
			</div>
			<div class = "login">
				<h3>Login</h3>
				<form:form action="/login" method="post" modelAttribute="newLogin">
					<p> 
						<form:errors class="error" path="email"/>
					</p>
					<p>	
						<form:errors class="error" path="password"/>
					</p>
					<p>
						<form:label path="email">Email: </form:label>
						<form:input path="email"/>
					</p>
					<p>
						<form:label path="password">Password: </form:label>
						<form:input path="password"/>
					</p>
					<div class="centerbtn">
						<input class="btn" type="submit" value="Login"/>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>