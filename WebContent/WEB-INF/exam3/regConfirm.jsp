<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>ȸ�� ���� Ȯ��</h1>
<form method="post" action="/MvcApp/member.action">
	<input type="hidden" name="command" value="REGCOMPLETE" />
	����� �Է��� ������ ������ �����ϴ�.
	<ul>
		<li>���̵� : </li>
		<li>�н����� : </li>
		<li>�ּ� : </li>
	</ul>
	<input type="submit" value="���� �Ϸ�" />
</form>
</body>
</html>