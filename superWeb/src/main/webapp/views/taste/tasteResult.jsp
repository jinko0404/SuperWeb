<%--<%@ page import= "java.util.*" %> --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%
	String name = request.getParameter("name");
	String color = request.getParameter("color");
	String animal = request.getParameter("animal");
	String[] food = request.getParameterValues("food");
	Map<String, String> map = new HashMap<String, String>();
	map.put("red", "빨강색");
	map.put("blue", "파랑색");
	map.put("yellow", "노랑색");
	map.put("green", "초록색");
	
	map.put("dog", "강아지");
	map.put("cat", "고양이");
	map.put("lizard", "도마뱀");
	map.put("turtle", "거북이");
	
	map.put("jjajang", "짜장면");
	map.put("jjambbong", "짬뽕");
	map.put("tangsuyuk", "탕수육");
	map.put("yangjyangpi", "양장피");
	map.put("palbochae", "팔보채");
	
	String colorKo = map.get(color);
	String animalKo = map.get(animal);
	String mappedFood = "";
--%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>개인 취향 테스트 결과</title>
	</head>
	<body>
		<h1>개인 취향 테스트 결과</h1>
		<%--<%=name 님의 개인 취향 색깔은 <%= colorKo %>을 좋아하고
		 동물은 <%=animalKo %>를 좋아하고 음식은
		 <%
		 for(int i = 0; i < food.length; i++) {
			 mappedFood = map.get(food[i]);
		 %>
		 <%= mappedFood %>
		 <%if(i != food.length - 1) {%>
		 ,
		 <%} %>
		 <%
		 }
		 %>--%>
		 ${name}님이 좋아하는 색깔은 ${colorKo}이고
		 동물은 ${animalKo} 이며
		 음식은
		 <c:forEach items = "${requestScope.food}" var = "foodName">
		 ${foodName }
		 </c:forEach>
		 입니다.
	</body>
</html>







