<%@page import="exam2.BookDto"%>
<%@page import="java.util.Vector"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>���� ���� �ֹ� ������</h1>
<b>�ֹ��� ����</b>
<table border="1">
	<tr>
		<td>���� ����</td><td>�۰�</td><td>����</td><td>����</td>
	</tr>
	<!-- �ֹ��� ���� ����� ��� -->
<%
	try{
		Vector bookList = (Vector)session.getAttribute("bookList");
		if(bookList != null || bookList.size() > 0){
			for(int i=0; i<bookList.size(); i++){
				BookDto dto = (BookDto)bookList.get(i);
%>
	<tr>
		<td><%=dto.getTitle()%></td>
		<td><%=dto.getAuthor()%></td>
		<td><%=dto.getPrice()%></td>
		<td><%=dto.getQuantity()%></td>
	</tr>
<%
			}
		}
	}
	catch(Exception err){ }
%>
</table>
<br/><br/>
<b>��ü ���� �׼� : <%=session.getAttribute("sum")%></b><br/><br/>
<form>
	<input type="submit" value="����" />
</form>
</body>
</html>