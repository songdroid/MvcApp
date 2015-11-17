<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
	String choice = request.getParameter("depart");
	if(choice.equals("kor")){
%>
		1. 국어를 잘해야 한다<br/>
		2. 국어를 사랑해야 한다.<br/>
<%
	}
	else if(choice.equals("eng")){
%>
		1. 영어를 잘해야 한다<br/>
		2. 영어를 사랑해야 한다.<br/>
<%
	}
	else if(choice.equals("com")){
%>
		1. 컴퓨터를 잘해야 한다<br/>
		2. 컴퓨터를 사랑해야 한다.<br/>
<%
	}
%>

</body>
</html>