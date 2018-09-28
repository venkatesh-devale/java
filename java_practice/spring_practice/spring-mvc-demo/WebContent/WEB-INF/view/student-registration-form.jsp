
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>
<html>

<head>
	
</head>

<body>
	
	<h2> Spring MVC Demo - Student Registration Page</h2>
	
	<hr>
	
	<form:form action="processForm" modelAttribute="student">
		First Name: <form:input path="firstName"/>
		<br><br>
		Last Name: <form:input path="lastName"/>
		<input type="submit" />
	</form:form>
	

</body>

</html>