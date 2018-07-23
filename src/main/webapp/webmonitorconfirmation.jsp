<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web Monitor Confirm</title>
</head>
<body>
<h3>URL Monitor Confirmation</h3>
		<table id='tblResult'border="1">
			<thead>
			<tr>
			<td>URL</td>
			<td>STATUS</td>
			<td>Remarks</td>
			</tr>
			</thead>
			<c:forEach var="url" items="${urlModel.webModel}">
			<tr>
				<td>${url.url}</td>
				<td>${url.status}</td>
				<td>${url.error}</td>
			</tr>
			</c:forEach>

		</table>
</body>
</html>