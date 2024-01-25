<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>계산 결과</title>
</head>
<body>
	<h1>계산 결과</h1>
<%--	<h1><%= firstNum %> <%= operator %> <%= secondNum %> = <%= answer %></h1> --%>
	<h1>${requestScope.firstNum} ${operator} ${secondNum} = ${answer}</h1>
</body>
</html>