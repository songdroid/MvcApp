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
		1. ��� ���ؾ� �Ѵ�<br/>
		2. ��� ����ؾ� �Ѵ�.<br/>
<%
	}
	else if(choice.equals("eng")){
%>
		1. ��� ���ؾ� �Ѵ�<br/>
		2. ��� ����ؾ� �Ѵ�.<br/>
<%
	}
	else if(choice.equals("com")){
%>
		1. ��ǻ�͸� ���ؾ� �Ѵ�<br/>
		2. ��ǻ�͸� ����ؾ� �Ѵ�.<br/>
<%
	}
%>

</body>
</html>