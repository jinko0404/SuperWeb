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
	map.put("red", "������");
	map.put("blue", "�Ķ���");
	map.put("yellow", "�����");
	map.put("green", "�ʷϻ�");
	
	map.put("dog", "������");
	map.put("cat", "�����");
	map.put("lizard", "������");
	map.put("turtle", "�ź���");
	
	map.put("jjajang", "¥���");
	map.put("jjambbong", "«��");
	map.put("tangsuyuk", "������");
	map.put("yangjyangpi", "������");
	map.put("palbochae", "�Ⱥ�ä");
	
	String colorKo = map.get(color);
	String animalKo = map.get(animal);
	String mappedFood = "";
--%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>���� ���� �׽�Ʈ ���</title>
	</head>
	<body>
		<h1>���� ���� �׽�Ʈ ���</h1>
		<%--<%=name ���� ���� ���� ������ <%= colorKo %>�� �����ϰ�
		 ������ <%=animalKo %>�� �����ϰ� ������
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
		 ${name}���� �����ϴ� ������ ${colorKo}�̰�
		 ������ ${animalKo} �̸�
		 ������
		 <c:forEach items = "${requestScope.food}" var = "foodName">
		 ${foodName }
		 </c:forEach>
		 �Դϴ�.
	</body>
</html>







