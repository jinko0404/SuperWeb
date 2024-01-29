<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이페이지</title>
	</head>
	<body>
		<h1>마이페이지</h1>
		<form action="/member/mypage.do" method="post">
			<fieldset>
			<legend>마이페이지</legend>
			<ul>
				<li>
					<label for="member-id">아이디</label>
					${member.memberId}
				</li>
				<li>
					<label for="member-pw">비밀번호</label>
					${member.memberPwd}
				</li>
				<li>
					<label for="member-name">이름</label>
					${member.memberName}
				</li>
				<li>
					<label for="age">나이</label>
					${member.age}
				</li>
				<li>
					<label for="gender">성별</label>
					남<input type="radio" name="gender" id="gender" value="M" <c:if test= "${member.gender.toString() eq 'M'}">checked</c:if> disabled="disabled">
					여<input type="radio" name="gender" id="gender" value="F" <c:if test= "${member.gender.toString() eq 'F'}">checked</c:if> disabled="disabled">
				</li>
				<li>
					<label for="email">이메일</label>
					${member.email}
				</li>
				<li>
					<label for="phone">전화번호</label>
					${member.phone}
				</li>
				<li>
					<label for="address">주소</label>
					${member.address}
				</li>
				<li>
					<label for="hobby">취미</label>
					${member.hobby}
				</li>
			</ul>
			</fieldset>
			<a href="/member/Modify.do?memberId=${member.memberId}">정보수정</a><br>
			<a href="javascript:void(0)" onclick="deleteCheck()">회원탈퇴</a> <br>
			<a href="/">이전으로</a><br>
		</form>
		<script>
			function deleteCheck() {
				if(confirm("탈퇴 하시겠습니까?")){
					var memberId = "${member.memberId }";
					console.log("Member ID:", memberId);
					location.href = "/member/delete.do";
				}
			}
		</script>
	</body>
</html>











