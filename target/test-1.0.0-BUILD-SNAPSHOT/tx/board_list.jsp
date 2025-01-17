<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 	uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
게시물 목록<hr>

<!-- --------------------------------------------------------- -->         
<a href="tx/board_form.jsp"  >입력 폼</a>                   
<table border="1" width="300">
	    <tr>
	        <th>글번호</th>
	        <th>제목</th>
	        <th>글쓴이</th>
	        <th>날짜</th>
	    </tr>

<c:forEach var="bvo" items="${MY_KEY_BLIST}">
        <tr>
            <td>${bvo.bseq}</td>
            <td>
            	<a href="/bdetail?bseq=${bvo.bseq}">${bvo.title}</a>
            </td>
            <td>${bvo.regid}</td>
            <td>${bvo.regdate}</td>
        </tr>
</c:forEach>        
    
    </tbody>
</table>

</body>
</html>