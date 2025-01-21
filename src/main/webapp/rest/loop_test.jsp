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

<ul>
  <li>foo</li>
  <li>bar</li>
</ul>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
$( document ).ready(function() {
	$("li").each(function(i){ 
		console.log(i + "," + $(this).text());
	}); 
	
	var obj = ["aa", "bb", "cc"];
	$(obj).each(function(i){ 
		console.log(i + "," + obj[i]);
	});
	$(obj).each(function(i, v){ 
		console.log(i + "," + v);
	});
	
	console.log("-------");
	
	var obj2 = [ {"uid":"kim" ,   "upw":"111" }, 
				 {"uid":"hong",   "upw":"222" }, 
				 {"uid":"park",   "upw":"333" }    
			  ];
	$(obj2).each(function(i){ 
		console.log(i + "," + obj2[i]["uid"] + "," + obj2[i]["upw"]);
	});
	$(obj2).each(function(i, v){ 
		console.log(i + "," + v["uid"] + "," + v["upw"]);
	});
	$.each(obj2, function(i, v){ 
		console.log(i + "," + v["uid"] + "," + v["upw"]);
	});
	console.log("---------dddd ------");
	
	
	$(obj2).map(function(i, v){
		console.log(i + "," + v["uid"] + "," + v["upw"]);
	});
	$.map(obj2,  function(v, i){   //******************************************
		console.log(v["uid"] + "," + i);
	});
	
	
	
	
	
	
	//$("#btn").click( function() {  
	//    	$("#input").val();
	//});
});
</script>
</body>
</html>