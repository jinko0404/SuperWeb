<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>선택 결과</title>
	</head>
	<body>
		<h1>선택 결과</h1>
		선택한 관광지는 
		<c:forEach items = "${requestScope.places}" var = "placename">
		${placename}
		</c:forEach>
		입니다
<%--		<% 
			for(int i = 0; i < places.length; i++){
		%>
		<%String nation = nameMap.get(places[i]);%>
			<%= nation%>
		<%} %> --%>
		
	</body>
</html>