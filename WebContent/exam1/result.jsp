<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>당신이 선택한 학과에 대한 도움말입니다.</h1>
<%
	ArrayList list = (ArrayList)request.getAttribute("result");
	for(int i=0; i<list.size(); i++){
%>
		<%=list.get(i) %><br/>
<%
	}
%>

</body>
</html>