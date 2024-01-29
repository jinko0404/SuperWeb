<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 수정</title>
	</head>
	<body>
		<h1>공지사항 수정</h1>
		<form action="/notice/modify.do" method="post">
		<input type="hidden" name="notice-no" value="${notice.noticeNo}">
			<fieldset>
				<legend>공지사항 수정</legend>
					<ul>
						<li>
						<label>제목</label>
						<input type="text" name="notice-subject" value="${notice.noticeSubject}">
						</li>
						<li>
						<label>내용</label>
						<textarea rows="10" cols="40" name="notice-content">${notice.noticeContent}</textarea>
						</li>
					</ul>
			</fieldset>
			<input type="submit" value="수정하기">
		</form>
	</body>
</html>