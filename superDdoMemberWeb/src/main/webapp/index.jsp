<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>슈퍼 또 멤버웹</title>
	</head>
	<body>
		<h1>슈퍼 또 멤버웹</h1>
		<h3>방문을 진심으로 환영합니다.</h3>
		<fieldset>
			<legend>로그인</legend>
			<form action="/memberDdo/login.do" method="post">
				ID<input type="text" placeholder="아이디를 입력해주세요" name = "member-id"><br>
				PW<input type="password" placeholder="비밀번호를 입력해주세요" name = "member-pw"><br>
				<div>
					<input type="submit" value="로그인">
					<a href="/memberDdo/register.do">회원가입</a>
				</div>
			</form>
		</fieldset>
	</body>
</html>
