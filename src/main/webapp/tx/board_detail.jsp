<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form id = "myForm">      
<input type = "hidden" name = "bseq" value = "${MY_KEY_BVO.bseq}">

<h2>게시글</h2>

<table class="datatable-table">
    <tbody>
        <tr>
            <th>글번호</th>
            <td>${MY_KEY_BVO.bseq}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td><input type = "text" name = "title" size = "80" value = "${MY_KEY_BVO.title}"></td>
            
        </tr>
        <tr>
            <th>글쓴이</th>
            <td>${MY_KEY_BVO.regid}</td>
        </tr>
        <tr>
            <th>날짜</th>
            <td>${MY_KEY_BVO.regdate}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name = "contents" rows = "5" cols = "100">${MY_KEY_BVO.contents}</textarea></td>
        </tr>
    </tbody>
    
    <tfoot>
    	<tr>
    		<td colspan="2" align="center">
    			<input type="submit" value="  수정  " id="updateBtn">
    			<input type="submit" value="  삭제  " id="deleteBtn">
    			<input type="submit" value="  목록  " id="listBtn">
    		</td>
    	</tr>
    </tfoot>
</table>

</form>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
	$( document ).ready(function() {
		$("#listBtn").click( function() {  
	    	$("#myForm").attr("method", "get");
	    	$("#myForm").attr("action", "/blist");
	    	$("#myForm").submit();
	    } );
	    
	
		$("#updateBtn").click( function() {  
	    	$("#myForm").attr("method", "post");
	    	$("#myForm").attr("action", "/bupdate");
	    	$("#myForm").submit();
	    } );
	    
		$("#deleteBtn").click( function() {  
	    	$("#myForm").attr("method", "post");
	    	$("#myForm").attr("action", "/bdelete");
	    	$("#myForm").submit();
	    } );
	    
	});
	
	
</script>

</body>
</html>