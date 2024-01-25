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
		<title>라디오 체크 결과</title>
	</head>
	<body>
		<h1>라디오 체크 결과</h1>
		성별 : ${gender}<br>
		메일 수신 여부 : ${checkValue}<br>
	</body>
</html>