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
	<title>About ${thisHall.hallName}</title>
	<!-- Bootstrap Link -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar">
		<div class="container-fluid">
			<a class="navbar-brand" href="/">University Directory</a>
			<ul class="nav nav-pills">
				<li class="nav-item">
					<a class="nav-link" href="/halls">All Halls</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container-fluid">
		<!-- <a href="/halls" class="btn btn-primary">All universities</a> -->
		<h1>About ${thisHall.hallName}</h1> <!-- ${thisValue} <-- matched with viewUniversity()-->
		<p>Located at : ${thisHall.university.name}</p>
		<p>Is a residential hall : ${thisHall.isResidential}</p>
		<p>Floors : ${thisHall.floors}</p>
		<p>Has lecture rooms : ${thisHall.hasLectureRoom}</p>
	</div>
</body>
</html>