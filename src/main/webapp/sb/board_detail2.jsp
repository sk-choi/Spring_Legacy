<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 	uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" 	uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="sql" 	uri="http://java.sun.com/jsp/jstl/sql" %>    
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="/sb/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        
        
<jsp:include page="${pageContext.request.contextPath}/sb/common_top.jsp" />
        
        
        
        <div id="layoutSidenav">
            
            
            
            
<jsp:include page="${pageContext.request.contextPath}/sb/common_side.jsp" />            
            
            
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Dashboard</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Dashboard  > <font color=blue>게시판 상세보기</font></li>
                        </ol>
                        
                        
                        
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                <b>게시판 상세보기</b>
                            </div>
                            <div class="card-body">
                            
                            
                            
                            
<!-- --------------------------------------------------------- -->   

<!--  MY_KEY_BVO -->      
<form id = "myForm">      
<input type = "hidden" name = "bseq" value = "${MY_KEY_BVO_RLIST.bseq}">
<input type = "hidden" name = "gubun">

<h2>게시글</h2>

<table class="datatable-table">
    <tbody>
        <tr>
            <th>글번호</th>
            <td>${MY_KEY_BVO_RLIST.bseq}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td><input type = "text" name = "title" size = "60" value = "${MY_KEY_BVO_RLIST.title}"></td>
            
        </tr>
        <tr>
            <th>글쓴이</th>
            <td>${MY_KEY_BVO_RLIST.regid}</td>
        </tr>
        <tr>
            <th>날짜</th>
            <td>${MY_KEY_BVO_RLIST.regdate}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td><input type = "text" name = "contents" size = "60" rows = "5" value = "${MY_KEY_BVO_RLIST.contents}"></td>
        </tr>
    </tbody>
    
    <tfoot>
    	<tr>
    		<td colspan="2" align="center">
    			<input type="submit" value="  수정  " name = "update" id="updateBtn">
    			<input type="submit" value="  삭제  " name = "delete" id="deleteBtn">
    			<input type="submit" value="  목록  " id="listBtn">
    		</td>
    	</tr>
    </tfoot>
</table>
</form>

<!-- ---------------------------------------------------------------------------- -->

<h3>댓글</h3>
<!-- MY_KEY_RLIST -->
<c:choose>
<c:when test = "${fn:length(MY_KEY_BVO_RLIST.rlist) <= 0}"> 
	해당 게시글에 댓글이 존재하지 않습니다.
</c:when>	
<c:otherwise><c:forEach var = "rvo" items = "${MY_KEY_BVO_RLIST.rlist}">
<c:if test = "${rvo.regid == 'guest'}">
<form method="post" action="/Myreply">
  <table class="datatable-table">
  <tbody>
  <tr>
  <th>글쓴이</th>
  <td>${rvo.regid}</td>
  </tr>
  <tr>
   <th>내용</th>
   <td><input type = "text" name = "contents" size = "60" rows = "5" value = "${rvo.reply}"></td> 
  </tr>
  <tr>
  <th>날짜</th>
  <td>${rvo.regdate}</td>
  </tr>
  </tbody>
</table>
</form>
</c:if>
</c:forEach>

</c:otherwise>
</c:choose>
<!-- --------------------------------------------------------- -->                                
<form name = "replyForm" method = "post" action = "/Myreply">
<table style = "{width:100%}">
<input type = "hidden" name = "gubun" value = "RI001">
<input type = "hidden" name = "bseq" value = "${MY_KEY_BVO.bseq}">
			<tr>
				<td><input type = "text" size = "60" name = "reply"><input type = 'submit' value = "댓글 저장"><td>
			</tr>
	</table>
</form>                             
  
<!-- --------------------------------------------------------- -->                             
                                
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/sb/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/sb/assets/demo/chart-area-demo.js"></script>
        <script src="${pageContext.request.contextPath}/sb/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/sb/js/datatables-simple-demo.js"></script>
    
    
  
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
	$( document ).ready(function() {
		$("#listBtn").click( function() {  
	    	$("#myForm").attr("method", "get");
	    	$("#myForm").attr("action", "/Myboard");
	    	$("#myForm").submit();
	    } );
	    
	});
	
	$( document ).ready(function() {
		$("#updateBtn").click( function() {  
	    	$("#myForm").attr("method", "post");
	    	$("#myForm").attr("action", "/Myboard?gubun=U001");
	    	$("#myForm").submit();
	    } );
	    
	});
	
	$( document ).ready(function() {
		$("#deleteBtn").click( function() {  
	    	$("#myForm").attr("method", "post");
	    	$("#myForm").attr("action", "/Myboard?gubun=D001");
	    	$("#myForm").submit();
	    } );
	    
	});
	
	
</script>
</body>
</html>
