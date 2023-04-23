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
	<title>Create a new hall</title>
	<!-- Bootstrap Link -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<h1>Add a Hall</h1>
		<a href="/halls" class="btn btn-primary">All Halls</a>
		<form:form action="/halls/new" method="POST" modelAttribute="newHall"> <!-- match with addAHallToDB() and newHallPage() -->
			<p> 
				<form:label path="hallName">Name : </form:label>
				<form:errors path="hallName" class="text-danger"/>
				<form:input path="hallName"/>
			</p>
			<p>
				<form:label path="isResidential">Is Residential : </form:label>
				<form:errors path="isResidential" class="text-danger"/>
				<form:radiobutton path="isResidential" value="1"/>Yes
				<form:radiobutton path="isResidential" value="0"/>No
			</p>
			<p>
				<form:label path="floors">Floors : </form:label>
				<form:errors path="floors"  class="text-danger"/>
				<form:input path="floors" type="number" min="1" max="999999"/>
			</p>
			<p>
				<form:label path="hasLectureRoom">Has lecture room : </form:label>
				<form:errors path="hasLectureRoom" class="text-danger"/>
				<form:radiobutton path="hasLectureRoom" value="1"/>Yes
				<form:radiobutton path="hasLectureRoom" value="0"/>No
			</p>
			<form:label path="university">University : </form:label>
			<div class="col">
				<form:select path="university" class="col-3">
					<!-- ${universities} comes from 'model.addAttribute("universities", uServ.getAllUniversities());' in 'newHallPage' -->
					<!-- 'itemLabel="name"' needs to match with variable name in University.java -->
					<!-- 'itemValue="id" needs to match with id in University.java -->
					<form:options items="${universities}" itemLabel="name" itemValue="id" class="col-1 form-check-input mx-2"/> 
				</form:select>
			</div>
			
			<input type="submit" value="Add Hall" class="btn btn-primary"/>
		</form:form>
	</div>
</body>
</html>