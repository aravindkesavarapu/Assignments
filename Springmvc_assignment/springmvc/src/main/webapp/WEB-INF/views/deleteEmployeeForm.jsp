<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div style="center">
	<a href="home">home</a>
	</div>
	<fieldset>
		<legend>Delete Employee Form</legend>
		<form action="deleteEmployee" >
			<table>
				<tr>
					<td>EmployeeId</td>
					<td><input type="text" id="empId" name="empId"></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="submit">
					</td>
				</tr>

			</table>
		</form>
	</fieldset>
</body>
</html>