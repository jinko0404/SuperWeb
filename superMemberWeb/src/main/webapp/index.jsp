<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>슈퍼 멤버쉽</title>
	</head>
	<body>
		<c:if test="${sessionScope.memberId eq null }">
		<fieldset>
			<legend>로그인</legend>
			 <form action="/login.do" method="post">
			 	<input type="text"		name = "member-id"><br>
			 	<input type="password"	name = "member-pw"><br>
			 	<div>
			 		<input type= "submit" value="로그인">
			 		<input type="reset" value="취소">
			 	</div>
			 </form>
		</fieldset>
		</c:if>
		<c:if test="${sessionScope.memberId ne null }">
		${sessionScope.memberName}님 환영합니다~<br>
		<a href="/logout.do">로그아웃</a>
		</c:if>
	</body>
</html>