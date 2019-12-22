<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/JavaScript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js" ></script>
<script src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
  <script src="//cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
  
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css" />
  <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/css/dataTables.bootstrap.min.css" />
  <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.1.0/css/responsive.bootstrap.min.css" type="text/css" />
  <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.2.1/css/buttons.bootstrap.min.css" type="text/css" />
  
<script type='text/javascript' src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.4.0/bootbox.min.js"></script>

<script src="${contextPath}/resources/js/adminHome.js" type="text/javascript" ></script>
  
<title>Admin Home</title>
</head>

<body style="background-color: #ebebe0;">
	<div class="col-xs-12">
		<div align="center"><h3>Employee Data</h3></div>
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
	</div>
	<div id="userTable" align="center" style="margin-left: 20px; margin-right: 20px;">
			<table id="test" class="table table-striped table-bordered table-hover" border="1" cellspacing="0">
				<thead>
					<th>Name</th>
					<th>Designation</th>
					<th>DOB</th>
					<th>Salary</th>
					<th>Options</th>
				</thead>
				<tbody>
					<c:forEach var="employee" items="${list}">
						<tr>
							<th>${employee.name}</th>
							<th>${employee.designation}</th>
							<th>${employee.dateOfBirth}</th>
							<th>${employee.salary}</th>
							<th>
								<button class="edit" empId="${employee.id}" name="${employee.name}" designation="${employee.designation}" dob="${employee.dateOfBirth}" salary="${employee.salary}">Edit</button>
								<button class="delete" empId="${employee.id}">Delete</button>
							</th>
						</tr>
					</c:forEach>
				</tbody>
				
			</table>
		</div>
	</div>
</body>
</html>