<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>���� �ֹ� ������</h1>
<form method="post" action="/MvcApp/shop.action">
	<input type="hidden" name="param" value="CART" />
	<b>���� ���� :</b>
	<select name="book">
		<option>� ���� / �����㻾�� / 15000</option>
		<option>���ݼ��� / �Ŀ÷� �ڿ��� / 21000</option>
		<option>ȫ�浿�� / ��� / 25000</option>
		<option>50 Greates Short Stroies/ Crane, Milton / 9800</option>
	</select>
	<b>���� : </b>
	<input type="text" name="quantity" size="2" value="1"/>
	<input type="submit" value="��ٱ��Ͽ� ���" />
</form>
<hr/>
<jsp:include page="cart.jsp" />
</body>
</html>