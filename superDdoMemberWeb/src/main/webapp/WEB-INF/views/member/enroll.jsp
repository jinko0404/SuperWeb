<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>회원가입</title>
</head>
	<body>
		<h1>회원가입</h1>
		<h3>회원정보를 입력하세요</h3>
		<form action="/memberDdo/register.do" method="post">
			<fieldset>
				<legend>회원가입</legend>
				<li>
					<label for="member-id">아이디</label>
					<input type="text" name = "member-id" id = "member-id">
				</li>
				<li>
					<label for="member-pw">비밀번호</label>
					<input type="password" name = "member-pw" id = "member-pw">
				</li>
				<li>
					<label for="member-name">이름</label>
					<input type="text" name = "member-name" id = "member-name">
				</li>
				<li>
					<label for="age">나이</label>
					<input type="text" name = "age" id = "age">
				</li>
				<li>
					<label for="gender">성별</label>
					남<input type="radio" name = "gender" id = "gender" value="M">
					여<input type="radio" name = "gender" id = "gender" value="F">
				</li>
				<li>
					<label for="email">이메일</label>
					<input type="text" name = "email" id = "email">
				</li>
				<li>
					<label for="phone">전화번호</label>
					<input type="text" name = "phone" id = "phone">
				</li>
				<li>
					<label for="address">주소</label>
					<input type="text" name = "address" id = "address">
				</li>
				<li>
					<label for="hobby">취미</label>
					<input type="text" name = "hobby" id = "hobby">
				</li>
				<input type="submit" value="가입하기">
				<input type="reset" value="초기화">
			</fieldset>
			
		</form>
	</body>
</html>