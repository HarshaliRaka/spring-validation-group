<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ValidationGroup Form</title>
</head>
<body>
	<h2>ValidationGroup Form</h2>
	<div>
		<h3>Validation Group 1</h3>
		<form:form action="validate1.htm" method="post"
			modelAttribute="testForm1" role="form">
			<div>
				<form:label path="field1" for="field1">field1</form:label>
				<form:input path="field1" id="field1" />
				<form:errors path="field1" style="color:red"></form:errors>
			</div>
			<div>
				<form:label path="field2" for="field2">field2</form:label>
				<form:input path="field2" id="field2" />
				<form:errors path="field2" style="color:red"></form:errors>
			</div>
			<div>
				<form:button type="submit">Submit</form:button>
			</div>
		</form:form>
	</div>
	<div>
		<h3>Validation Group 2</h3>
		<form:form action="validate2.htm" method="post"
			modelAttribute="testForm2" role="form">
			<div>
				<form:label path="field1" for="field1">field1</form:label>
				<form:input path="field1" id="field1" />
				<form:errors path="field1" style="color:red"></form:errors>
			</div>
			<div>
				<form:label path="field2" for="field2">field2</form:label>
				<form:input path="field2" id="field2" />
				<form:errors path="field2" style="color:red"></form:errors>
			</div>
			<div>
				<form:button type="submit">Submit</form:button>
			</div>
		</form:form>
	</div>

</body>
</html>