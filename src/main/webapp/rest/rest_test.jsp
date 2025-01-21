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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my.css">
</head>
<body>
<h1><font color="red">제발 F12누르고 테스트</font></h1>
<!-- 

REST (Representational State Transfer)
	: 웹서비스를 위한 분산시스템 아키텍쳐
	: 특징(방법)
		: http 프로토콜 사용 (method : get post put delete) 
		: 주 데이터 포맷 (xml, json)
		: 서버(프로파이더)가 정한 규칙에 맞게 요청을 해야 응답을 받을 수 있음
		: ★★★★★ 일반적인 웹 서비스와의 가장~~~~큰 차이점 (인증방식 ::::: 세센&쿠키  --  토큰)
		: 일반적으로 비동기통신을 사용 (웹에서 AJAX 스크립트 사용해 비동기통신 지원)
 -->

<form id="1_string-string-form">
<input type="text" name="searchStr" id="searchStr1"> 
<input type="button" id="1_string-string-btn" value="1_string-string전송">
</form>

<hr>
<form id="2_jsonstring-string-form">
<input type="text" name="searchStr" id="searchStr2"> 
<input type="button" id="2_jsonstring-string-btn" value="2_jsonstring-string전송">
</form>

<hr>
<form id="3_json-string-form">
<input type="text" name="searchStr" id="searchStr3"> 
<input type="button" id="3_json-string-btn" value="3_json-string전송">
</form>


<hr>
<form id="4_string-jsonstring-form">
<!-- <input type="hidden" name="pageGubun" value="4test"> -->
<input type="text" name="searchStr" id="searchStr4">
<input type="text" name="userid" id="userid"> 
<input type="text" name="userpw" id="userpw">  
<input type="button" id="4_string-jsonstring-btn" value="4_string-jsonstring전송">
</form>

 
 
<hr>
<form id="5_jsonstring-json-form">
<input type="text" name="searchStr" id="searchStr5"> 
<input type="button" id="5_jsonstring-json-btn" value="5_jsonstring-json-btn전송">
</form>


<hr>
<form id="6_json-json-form">
<input type="text" name="searchStr" id="searchStr6"> 
<input type="button" id="6_json-json-btn" value="6_json-json-btn전송">
</form>


<hr>
<form id="emp_form"> 
<input type="button" id="emp-btn" value="emp-btn전송">
</form>
<div id="empDiv"></div>



<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
$( document ).ready(function() {
	
	//$("#emp-btn").click( function() {  
	    $.ajax({
	    	url  		: "/rest?pageGubun=emp_rest" ,
	    	method 		: 'POST' , 
	    	//data 		: , 			
	    	//dataType 	: "json", 	
	    	success 	: function(obj) { 
	    					console.log("응답:" + obj);
	    					console.log("------------- $().map(function(i,v){})----------------");
	    					
	    					$("#empDiv").empty();
	    					var htmlStr = "<table class=blueTable>";
	    					htmlStr += "<tr><th>번호</th><th>제목</th><th>글쓴이</th></tr>";
	    					$(obj).map(function(i,v){ 
	    						//console.log(i + "," + v["bseq"] + "," + v.title + "," + v.regid);
	    						htmlStr += "<tr>";
	    						htmlStr += "<td>"+v.bseq+"</td>";
	    						htmlStr += "<td><a href='/myboard'>"+v.title+"</a></td>";
	    						htmlStr += "<td>"+v.regid+"</td>";
	    						htmlStr += "</tr>";
	    					});
	    					htmlStr += "</table>";
	    					$("#empDiv").html(htmlStr);
	    					
	    				  }   ,
	    	error 		: function(err) { console.log("에러:" + err) }  
	    });
	//});
	
	
	
	
	
	//var valueById = $('input[name=searchStr]').val();
	
	// -------------------------------------- 서버응답이 String 인 경우 ---------------------------------
	//     #1_string-string-btn
	// #2_jsonstring-string-btn
	//       #3_json-string-btn
	//------------------------------------------------
	$("#1_string-string-btn").click( function() {  
	    str = $("#searchStr1").val();
	    $.ajax({
	    	url  		: "/rest" ,
	    	method 		: 'GET' , 
	    	data 		: "mykey="+str+"&pageGubun=1test" , 			
	    	//contentType : "application/x-www-form-urlencoded; charset=UTF-8", 
	    	//dataType 	: "String", 	
	    	success 	: function(res) { console.log("응답:" + res) }   ,
	    	error 		: function(err) { console.log("에러:" + err) }  
	    });
	});
	//------------------------------------------------ 
	$("#2_jsonstring-string-btn").click( function() {  
	    str     = $("#searchStr2").val();
	    jsonObj = {"uid" : str, "upw" : "1111"} 
	    console.log(jsonObj);
	    jsonStr = JSON.stringify(jsonObj);
	    console.log(jsonStr);
	    
	    $.ajax({
	    	url  		: "/rest" ,
	    	method 		: 'POST' , 
	    	data 		:  "mykey="+jsonStr+"&pageGubun=2test", 	//?mykey:[]&pageGubun=2test(자동변환해서전송)
	    	//contentType : "application/x-www-form-urlencoded; charset=UTF-8", 
	    	//dataType 	: "String", 	
	    	success 	: function(res) { console.log("응답:" + res) }   ,
	    	error 		: function(err) { console.log("에러:" + err) }  
	    });
	});
	
	
	//------------------------------------------------ 
	$("#3_json-string-btn").click( function() {  
	    str     = $("#searchStr3").val();
	    jsonObj = {"uid" : str, "upw" : "1111"} 
	    console.log(jsonObj);
	    jsonStr = JSON.stringify(jsonObj);
	    console.log(jsonStr);
	    $.ajax({
	    	url  		: "/rest?pageGubun=3test" ,
	    	method 		: 'POST' , 
	    	data 		: jsonStr , 	//?mykey:aa&pageGubun=2test(자동변환해서전송) 
	    	contentType : "application/json; charset=UTF-8", 
	    	//dataType 	: "String", 	
	    	success 	: function(res) { console.log("응답:" + res) }   ,
	    	error 		: function(err) { console.log("에러:" + err) }  
	    });
	    
	});
	
	// -------------------------------------- 서버응답이 JSONStr 인 경우 ---------------------------------
	
	$("#4_string-jsonstring-btn").click( function() {  
	    //str    = $("#searchStr4").val();
	    //userid = $("#userid").val();
	    //userpw = $("#userpw").val();
	    //alert("searchStr="+str+"&userid="+userid+"&userpw="+userpw);
	    var sendFormData = $("#4_string-jsonstring-form").serialize();
	    alert(sendFormData);
	    
		  $.ajax({
		    	url  		: "/rest?pageGubun=4test" ,
		    	method 		: 'POST' , 
		    	data 		: sendFormData ,
		    	//data 		: "searchStr="+str+"&userid="+userid+"&userpw="+userpw , 			
		    	//contentType : "application/x-www-form-urlencoded; charset=UTF-8", 
		    	//dataType 	: "String", 	
		    	success 	: function(jsonStr) {
		    					//jsonStr = JSON.stringify(jsonObj)의 반대
		    					obj = JSON.parse(jsonStr);
		    					console.log("응답:" + obj) 
		    					console.log(obj['message']);
				    			console.log(obj['status']);
		    				  }   ,
		    	error 		: function(err) { console.log("에러:" + err) }  
		    });
	});
	
	
	
	// -------------------------------------- 서버응답이 JSON 인 경우 ---------------------------------
	$("#5_jsonstring-json-btn").click( function() {  
	    str     = $("#searchStr5").val();
	    jsonObj = {"uid" : str, "upw" : "1111"} 
	    console.log(jsonObj);
	    jsonStr = JSON.stringify(jsonObj);
	    console.log(jsonStr);
	    
	    $.ajax({
	    	url  		: "/rest" ,
	    	method 		: 'POST' , 
	    	data 		:  "mykey="+jsonStr+"&pageGubun=5test", 	//?mykey:[]&pageGubun=2test(자동변환해서전송)
	    	//contentType : "application/x-www-form-urlencoded; charset=UTF-8", 
	    	dataType 	: "json", 				//json이라고 해서 json이 들어오는게 아니다. 서버에서 정한다.
	    	success 	: function(obj) { 		//{"message":"okmap","status":"200"}
				    			console.log("응답:" + obj);
				    			console.log(obj['message']);
				    			console.log(obj['status']);
				    			
				    	  }   ,
	    	error 		: function(err) { console.log("에러:" + err) }  
	    });
	});
	
	
	$("#6_json-json-btn").click( function() {  
	    str     = $("#searchStr6").val();
	    jsonObj = {"uid" : str, "upw" : "1111"} 
	    console.log(jsonObj);
	    jsonStr = JSON.stringify(jsonObj);
	    console.log(jsonStr);
	    
	    $.ajax({
	    	url  		: "/rest?pageGubun=6test" ,
	    	method 		: 'POST' , 
	    	data 		:  jsonStr ,
	    	contentType : "application/json; charset=UTF-8", 
	    	dataType 	: "json", 				//json이라고 해서 json이 들어오는게 아니다. 서버에서 정한다.
	    	success 	: function(obj) { 		//{"message":"okmap","status":"200"}
				    			console.log("응답:" + obj);
				    			console.log(obj['message']);
				    			console.log(obj['status']);
				    	  }   ,
	    	error 		: function(err) { console.log("에러:" + err) }  
	    });
	});
	
	
	
});



/*
// ------------------------------------------------------------------------------------------------
$.ajax(
 	{
		url  : ___________ ,
		설정키 : __________ ,
		설정키 : __________ ,
		설정키 : __________ ,
		설정키 : __________ ,
		설정키 : function(응답변수) {  응답변수이용한로직.. }  //콜백함수 
	}
);
// ------------------------------------------------------------------------------------------------
$.ajax({
	url  		: "/rest" ,
	method 		: 'GET' , 
	data 		: __________ ,     //request  서버로 전송할 데이터  sent to the server.
							//{ a: "bc", d: "e,f" } is converted to the string "a=bc&d=e%2Cf"			
	contentType : "application/x-www-form-urlencoded; charset=UTF-8",  //request  서버로 전송할 데이터 타입
	dataType 	: "json", 		//response : 서버의 응답 타입  you're expecting back from the server.
							//String, xml, json, script, or html	
	success 	: function(res)    { res    } ,
	error 		: function(AAAerr) { AAAerr }
	//headers : { "Authorized" , "Useinfo 23242342343244" } ,																	
	//async : true   , 
	//crossDomain : true ,	//API허용, 서버내허용설정
	//beforeSend : function(res) { res } ,
	//complete : function(res) { res }  
});
// ------------------------------------------------------------------------------------------------
*/	



</script>
</body>
</html>