<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>슈퍼 또 멤버웹</title>
	</head>
<body>
	<h1>슈퍼 또 멤버웹</h1>
	<c:if test="${sessionScope.memberId ne null }">
		${sessionScope.memberName}님 환영합니다~<br>
		<a href="javascript:void(0)" onclick="checkLogout()">로그아웃</a>
		<a href="/memberDdo/Mypage.do?memberId=${sessionScope.memberId}">마이페이지</a>
	</c:if>
	<script>
		function checkLogout(){
			if(confirm("로그아웃 하시겠습니까?")){
				location.href = "/memberDdo/Logout.do";
			}
		}
	</script>
</body>
</html>