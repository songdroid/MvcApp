<%@page import="exam2.BookDto"%>
<%@page import="java.util.Vector"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<b>���� �ֹ��� ����</b>
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
		<td>
			<form method="post" action="/MvcApp/shop.action">
				<input type="hidden" name="param" value="DEL" />
				<input type="hidden" name="idx" value="<%=i%>" />
				<input type="submit" value="����" />
			</form>
		</td>
	</tr>
<%
			}
		}
	}
	catch(Exception err){ }
%>
</table>
<br/><br/>
<form method="post" action="/MvcApp/shop.action">
	<input type="hidden" name="param" value="CHKOUT" />
	<input type="submit" value="üũ �ƿ�" />
</form>







