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
	<title>New University Page</title>
	<!-- Bootstrap Link -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<h1>Add a university</h1>
		<a href="/universities" class="btn btn-primary">All Universities</a>
		<form:form action="/universities/new" method="POST" modelAttribute="newUniversity"> <!-- match with addUniveristyToDB() and newUniversityPage() -->
			<p>
				<form:label path="city">City : </form:label>
				<form:errors path="city" class="text-danger"/>
				<form:input path="city"/>
			</p>
			<p>
				<form:label path="name">Name : </form:label>
				<form:errors path="name" class="text-danger"/>
				<form:input path="name"/>
			</p>
			<p>
				<form:label path="enrollment">Enrollment : </form:label>
				<form:errors path="enrollment"  class="text-danger"/>
				<form:input path="enrollment" type="number" min="1" max="999999"/>
			</p>
			<p>
				<form:label path="isOnline">Online : </form:label>
				<form:errors path="isOnline" class="text-danger"/>
				<form:radiobutton path="isOnline" value="1"/>Yes
				<form:radiobutton path="isOnline" value="0"/>No
			</p>
			<p>
				<form:label path="isInPerson">In Person : </form:label>
				<form:errors path="isInPerson" class="text-danger"/>
				<form:radiobutton path="isInPerson" value="1"/>Yes
				<form:radiobutton path="isInPerson" value="0"/>No
			</p>
			<p>
				<form:label path="yearFounded">Years Founded : </form:label>
				<form:errors path="yearFounded" class="text-danger"/>
				<form:input path="yearFounded" type="number" min="1"/>
			</p>
			
			<input type="submit" value="Add University" class="btn btn-primary"/>
		</form:form>
	</div>
</body>
</html>