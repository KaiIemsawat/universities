<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSTL -->
<!-- c: -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- Form/Submit workflows -->
<!-- form: -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- The&nbsp;'isErrorPage'&nbsp;attribute indicates that the current JSP can be used as the error page for another JSP. -->
<%@ page isErrorPage="true" %>
<!-- The&nbsp;errorPage&nbsp;attribute tells the JSP engine which page to display if there is an error while the current page runs. The value of the errorPage attribute is a relative URL. -->
<%@ page errorPage = "MyErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>All Universities Page</title>
	<!-- Bootstrap Link -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<h1>All Universities</h1>
		<table class=table>
			<thead>
				<tr>
					<th>ID</th>
					<th>University Name</th>
					<th>City</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${universities}"> <!-- items="${itemsName}" <-- match with model.addAttribute("itemsName") -->
					<tr>
						<td><c:out value="${u.id}"/></td>
						<td><c:out value="${u.name}"/></td>
						<td><c:out value="${u.city}"/></td>
						<td>
							<a href="/universities/${u.id}" class="btn btn-primary">View</a>
							<a href="/universities/${u.id}/edit" class="btn btn-secondary">Edit</a>
							<a href="/universities/${u.id}/delete" class="btn btn-danger">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p><a href="/universities/new">Add a university</a></p>
	
	</div>
</body>
</html>