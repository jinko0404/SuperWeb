<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>���� ���</title>
	</head>
	<body>
		<h1>���� ���</h1>
		������ �������� 
		<c:forEach items = "${requestScope.places}" var = "placename">
		${placename}
		</c:forEach>
		�Դϴ�
<%--		<% 
			for(int i = 0; i < places.length; i++){
		%>
		<%String nation = nameMap.get(places[i]);%>
			<%= nation%>
		<%} %> --%>
		
	</body>
</html>