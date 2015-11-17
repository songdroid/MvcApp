<%@page import="exam2.BookDto"%>
<%@page import="java.util.Vector"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>도서 구매 주문 페이지</h1>
<b>주문한 도서</b>
<table border="1">
	<tr>
		<td>도서 제목</td><td>작가</td><td>가격</td><td>수량</td>
	</tr>
	<!-- 주문한 도서 목록이 출력 -->
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
<b>전체 구입 액수 : <%=session.getAttribute("sum")%></b><br/><br/>
<form>
	<input type="submit" value="결제" />
</form>
</body>
</html>