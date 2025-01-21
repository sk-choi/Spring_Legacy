<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 	uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" 	uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="sql" 	uri="http://java.sun.com/jsp/jstl/sql" %>
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
게시시판 검색 REST<hr>

<form id="searchForm">
검색구분 : <select   name="searchGubun" id="searchGubun">
			<option value="title">제목</option>
			<option value="regid">글쓴이</option>
		</select> 
검색어 : <input type="text"  name="searchStr" id="searchStr">
</form>
<div id="resultDiv"></div>



<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
$( document ).ready(function() {
	//jQuery 동적이벤트 바인딩
	$(document).on('keyup',"#searchStr",function(){
			var str   = $("#searchStr").val();
			
			if(str !="") {
			
						//var gubun = $("#searchGubun").val();
						//console.log( gubun + "," + str  );
						var formData = $("#searchForm").serialize();  //k=v&k=v
						console.log( formData );
						
						$.ajax({
					    	url  		: "/search" ,
					    	method 		: 'POST' , 
					    	data 		: formData , 			
					    	//contentType : "application/x-www-form-urlencoded; charset=UTF-8", 
					    	//dataType 	: "json", 	
					    	success 	: function(obj) { 
								    		
					    						$("#resultDiv").empty();
					    						htmlStr = "<table border=1 width=200>";
						    					
					    						$(obj).map(function(i, vo) {
						    						//console.log(vo.bseq + "," + vo.title + "," + vo.regid);
						    						htmlStr += "<tr>";
						    						htmlStr += "<td>"+vo.bseq+"</td>";
						    						htmlStr += "<td>"+vo.title+"</td>";
						    						htmlStr += "<td>"+vo.regid+"</td>";
						    						htmlStr += "</tr>";
						    					});
					    						htmlStr += "</table>";
						    					$("#resultDiv").html(htmlStr);
								    		
								    	  } ,
					    	error 		: function(err) { console.log("에러:" + err) }  
					    });
			}
	});
	
	
	//$("#btn").click( function() {  
	//    	$("#input").val();
	//});
});
</script>
</body>
</html>