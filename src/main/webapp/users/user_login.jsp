<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 	uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>로그인하식객민우 ㅋㅋㅋㅋ</title>
</head>
<body>
	<h2>로그인</h2>

    <!-- 폼 시작 -->
    <form action="/users/login" method="POST">
        <div>
            <label for="usersId">아이디:</label>
            <input type="text" id="usersId" name="usersId" required>
        </div>

        <div>
            <label for="usersPw">비밀번호:</label>
            <input type="password" id="usersPw" name="usersPw" required>
        </div>

        <div>
            <button type="submit">로그인</button>
        </div>
    </form>
</body>
</html>