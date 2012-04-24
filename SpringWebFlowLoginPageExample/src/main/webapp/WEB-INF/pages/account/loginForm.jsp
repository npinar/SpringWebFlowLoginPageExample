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

<title>Existing User Login Page</title>
</head>
<body>
	<h2>Please enter your user name and password!</h2>
	<h3>This is an example of how validation can be done in action class</h3>
	<h4>Use npinar for user id to generate user not existing flow</h4>

	<div>
		<form:form modelAttribute="loginInfo">
			<table>
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
					<td><input type="submit" name="_eventId_loginUser"
						value="login" /></td>
					<td><input type="submit" name="_eventId_reset"
						value="Reset" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>