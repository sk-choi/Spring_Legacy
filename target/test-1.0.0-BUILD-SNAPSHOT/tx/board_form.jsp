<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
게시물 입력<hr>

<form method="POST" action="/binsert">
<table border="1" width="300">
<tr><td>제목		<input type="text" name="title"></td></tr>
<tr><td>내용		<input type="text" name="contents"></td></tr>
<tr><td>글쓴이	<input type="text" name="regid"></td></tr>
<tr><td><input type="submit" value="글쓰기"></td></tr>
</table>
</form>
</body>
</html>