<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <title>Home Page</title>
    </head>
    <body>
	<div>
		<a href="account/registerme">New User - Spring Webflow Request</a>
	</div>
	<div>
		<a href="account/login?accountType=auto">Login Auto Insurance Account - Spring Webflow Request
	</div>
	
	<div>
		<a href="account/login?accountType=home">Login Home Insurance Account - Spring Webflow Request
	</div>

	<!-- this is a regular spring mvc request -->
	<form:form method="post" action="registerUser">
		<input type="submit" value="Spring MVC Request" />
	</form:form>

</body>
</html>