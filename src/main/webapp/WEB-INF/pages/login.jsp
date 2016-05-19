<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>${pageTitle}</title>
</head>
<body>
	<h2>${pageHeading2}</h2>
	<h3>Login with Username and Password</h3>

	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>

	<form name='loginForm' action="<c:url value='/login' />" method='POST'>
		<table>
			<tr>
				<td>Username:</td>
				<td>
					<input type='text' name='username' value=''>
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td>
					<input type='password' name='password' />
				</td>
			</tr>
			<tr>
				<td colspan='2'>
					<input name="submit" type="submit" value="submit" />
				</td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>