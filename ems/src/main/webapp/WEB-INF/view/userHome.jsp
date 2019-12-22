<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js" ></script>
<script src="${contextPath}/resources/js/userHome.js" type="text/javascript" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${msg}</title>
</head>
<body>
	<div class="pull-right">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<a onclick="document.forms['logoutForm'].submit()">Logout</a>
			</h2>
		</c:if>
	</div>
	<div><button id="test">Test Button</button></div>
<div>
	<c:if test="${employee != null}">
		Employee Id:<input type="text" value="${employee.id}" disabled/></br>
		Employee Name:<input type="text" value="${employee.name}" disabled/></br>
		Employee Designation:<input type="text" value="${employee.designation}" disabled/></br>
		Employee DOB:<input type="text" value="${employee.dateOfBirth}" disabled/></br>
		Employee Salary:<input type="text" value="${employee.salary}" disabled/></br>
    </c:if>
		<c:if test="${employee == null}">
				Name:<br> <input type="text" name="name" id="name"> <br>
				Designation:<br> <input type="text" name="designation"
					id="designation"> <br> DOB:<br> <input
					type="text" name="dateOfBirth" id="dateOfBirth"> <br>
				Salary:<br> <input type="text" name="salary" id="salary">
				<br> <br> <button type="submit" id="submit" value="Submit">Submit</button>
				
		</c:if>
	</div>
<h1>Welcome:${msg}</h1>
</body>
</html>