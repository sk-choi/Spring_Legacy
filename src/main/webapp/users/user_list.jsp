<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 	uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어서오시오</title>
</head>
<body>

사용자 목록 보기 :: ${sessionScope.SESS_USER_ID} ${sessionScope.SESS_ROLES} <hr>
<c:if test="${not empty sessionScope.SESS_USER_ID}">
	<a href="/users/logout">로그아웃</a> 
</c:if>
<a href="${pageContext.request.contextPath}/users/login_ready">
   <button>로그인 페이지로 이동</button>
</a>

<table border="1" width="300">
 <tbody>
 
 	<tr>
        <th>글번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>날짜</th>
    </tr>
	<c:forEach var="uvo" items="${ULIST}">
        <tr>
            <td>${uvo.usersSeq}</td>
            <td>
            	<a href="${pageContext.request.contextPath}/users/detail?usersSeq=${uvo.usersSeq}">${uvo.usersName}</a>
            </td>
            <td>${uvo.usersId}</td>
            <td>${uvo.regdate}</td>
        </tr>
	</c:forEach>
</tbody>     
</table>   
</body>
</html>