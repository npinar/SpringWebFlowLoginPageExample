<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}
</style>

<title>Registeration Page</title>
</head>
<body>
	<h2>Model Validation example.</h2>

	<div>
	${userIsNotExistingMessage}

		<form:form modelAttribute="userInfo">
			<table>
				<tr>
					<td><form:label path="firstName">First Name</form:label></td>
					<td><form:input path="firstName" /></td>
					<td><form:errors path="firstName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name</form:label></td>
					<td><form:input path="lastName" /></td>
					<td><form:errors path="lastName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="userId">User Id</form:label></td>
					<td><form:input path="userId" /></td>
					<td><form:errors path="userId" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password</form:label></td>
					<td><form:input path="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				<tr>
					<td><input type="submit" name="_eventId_submitRegistration"
						value="Submit" /></td>
					<td><input type="submit" name="_eventId_reset" value="Reset" /></td>

					<td><input type="submit" name="_eventId_cancel" value="Cancel" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>