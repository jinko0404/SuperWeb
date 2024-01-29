<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="/member/Modify.do" method="post">
			<fieldset>
			<legend>회원정보수정</legend>
			<ul>
				<li>
					<label for="member-id">아이디</label>
					<input type="text" name = "member-id" id = "member-id"
					value = "${member.memberId}" readonly="readonly">
				</li>
				<li>
					<label for="member-pw">비밀번호</label>
					<input type="password" name = "member-pw" id = "member-pw"
					value = "${member.memberPwd}">
				</li>
				<li>
					<label for="member-name">이름</label>
					<input type="text" name = "member-name" id = "member-name"
					value = "${member.memberName}" readonly="readonly">
				</li>
				<li>
					<label for="age">나이</label>
					<input type="text" name = "age" id = "age"
					value = "${member.age}" readonly="readonly">
				</li>
				<li>
					<label for="gender">성별</label>
					남<input type="radio" name="gender" id="gender" value="M" <c:if test="${member.gender.toString() eq 'M'}">checked</c:if> disabled="disabled">
					여<input type="radio" name="gender" id="gender" value="F" <c:if test="${member.gender.toString() eq 'F'}">checked</c:if> disabled="disabled">
				</li>
				<li>
					<label for="email">이메일</label>
					<input type="text" name = "email" id = "email"
					value = "${member.email}">
				</li>
				<li>
					<label for="phone">전화번호</label>
					<input type="text" name = "phone" id = "phone"
					value = "${member.phone}">
				</li>
				<li>
					<label for="address">주소</label>
					<input type="text" name = "address" id = "address"
					value = "${member.address}">
				</li>
				<li>
					<label for="hobby">취미</label>
					<input type="text" name = "hobby" id = "hobby"
					value = "${member.hobby}">
				</li>
			</ul>
			</fieldset>
			<input type="submit" value="수정하기">
			<input type="reset" value="초기화">
			<a href="/member/mypage.do">이전으로</a><br>
			</form>
	</body>
</html>