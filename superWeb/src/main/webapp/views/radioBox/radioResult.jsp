<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String gender = request.getParameter("gender");
	String checkValue = request.getParameter("check-mail");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>���� üũ ���</title>
	</head>
	<body>
		<h1>���� üũ ���</h1>
		���� : ${gender}<br>
		���� ���� ���� : ${checkValue}<br>
	</body>
</html>