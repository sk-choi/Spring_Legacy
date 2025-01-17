<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

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
        
<jsp:include page="${pageContext.request.contextPath}/sb/common_top.jsp"/>
        
        <div id="layoutSidenav">
            
<jsp:include page="${pageContext.request.contextPath}/sb/common_side.jsp"/>

            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Dashboard</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Dashboard</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                DataTable Example
                            </div>
                            <div class="card-body">
                            
<!-- ------------------------------------------------------------- -->        
								<!-- <table class ="datatable-table"> -->                    
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>글번호</th>
                                            <th>제목</th>
                                            <th>글쓴이</th>
                                            <th>날짜</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>글번호</th>
                                            <th>제목</th>
                                            <th>글쓴이</th>
                                            <th>날짜</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                   <c:forEach var="bvo" items="${MY_KEY_BLIST}">
									    <tr>
									        <td>${bvo.bseq}</td>
									        <td><a href="/Myboard?bseq=${bvo.bseq}&gubun=T001">${bvo.title}</a></td>
									        <td>${bvo.regid}</td>
									        <td>${bvo.regdate}</td>
									    </tr>
									</c:forEach>
                                    </tbody>
                                </table>
                                <br>

								<c:out value="${MY_KEY_PAGING_HTML}" />
                                <input type="button" value = "글쓰기" id = "insertFormBtn">
                                
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
    		$("#insertFormBtn").click( function() {  
    			//console.log("123");
    	    	location.href = "/sb/board_input.jsp";
    	    } );
    	});
    	</script>
    </body>
</html>


