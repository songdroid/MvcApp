<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>회원 가입 확인</h1>
<form method="post" action="/MvcApp/member.action">
	<input type="hidden" name="command" value="REGCOMPLETE" />
	당신이 입력한 내용은 다음과 같습니다.
	<ul>
		<li>아이디 : </li>
		<li>패스워드 : </li>
		<li>주소 : </li>
	</ul>
	<input type="submit" value="가입 완료" />
</form>
</body>
</html>