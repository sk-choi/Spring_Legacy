<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%=session.getAttribute("SESS_NAME") %> ��  ȯ���մϴ�.<br>

${sessionScope.SESS_NAME}�� ȯ���մϴ�.<br>

${KEY_VO.id} ${KEY_VO.pw} ${KEY_VO.name} <br>
<a href="/logout.do">[�α׾ƿ�]</a>
<hr>

���� ������

</body>
</html>