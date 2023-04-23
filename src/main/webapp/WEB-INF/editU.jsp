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
	<title>Edit ${university.name}</title>
	<!-- Bootstrap Link -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
	<h1>Edit a university</h1>
	<a href="/universities" class="btn btn-primary">All Universities</a>
	<form:form action="/universities/${university.id}/delete" method="POST" modelAttribute="university"> <!-- match with editUniveristyInDB() and editUniversityPage() -->
		<input type="hidden" name="_method" value="DELETE"/> <!-- Use this line when perform 'DELETE' method -->
		<input type="submit" class="btn btn-danger" value="Delete University"/>
	</form:form>
	<form:form action="/universities/${university.id}/edit" method="POST" modelAttribute="university"> <!-- match with editUniveristyInDB() and editUniversityPage() -->
		<input type="hidden" name="_method" value="PUT"/> <!-- Use this line when perform 'PUT' method -->
		<form:errors path="id" class="text-danger"/>
		<form:hidden path="id"/>
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
		
		<input type="submit" class="btn btn-primary" value="Edit University"/>
	</form:form>

</body>
</html>