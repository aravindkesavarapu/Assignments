<%@page import="java.util.List"%>
<%@page import="com.capgemini.springmvc.beans.EmplooyeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	List<EmplooyeeInfoBean> emplooyeeInfoBean2 = (List<EmplooyeeInfoBean>) request.getAttribute("beanList");
	String errMsg = (String) request.getAttribute("zero");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
<div style="center">
	<a href="home">home</a>
	</div>
<fieldset>
		<legend>Search Employee></legend>
		<form action="getEmployee" method="get">
			<label>Employee Id:</label> <input type="text" name="empId" required><br>
			<input type="submit" value="Search">
		</form>
	</fieldset>
	<%
		if ((errMsg != null) && !errMsg.isEmpty()) {
	%>
	<h3 style="color: red;"><%=errMsg%></h3>
	<%
		}
	%>
	<%
		if (emplooyeeInfoBean2 != null) {
	%>
	<div align="center">
	<table border="1" style="width: 60%">
		<tr style="background: navy; color: white;">
			<th>empId</th>
			<th>Name</th>
			<th>age</th>
			<th>Designation</th>
			<th>Salary</th>
			<th>Password</th>
		</tr>
		<%for(EmplooyeeInfoBean emplooyeeInfoBean : emplooyeeInfoBean2){ %>
		<tr>
			<td><%=emplooyeeInfoBean.getEmpId()%></td>
			<td><%=emplooyeeInfoBean.getName() %></td>
			<td><%=emplooyeeInfoBean.getAge()%></td>
			<td><%=emplooyeeInfoBean.getDesignation()%></td>
			<td><%=emplooyeeInfoBean.getSalary()%></td>
			<td><%=emplooyeeInfoBean.getPassword()%></td>

		</tr>
		<% }%>
	</table>
	</div>
	<%} %>
</body>
</html>