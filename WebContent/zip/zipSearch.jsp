<%@page import="dbcp.ZipDto"%>
<%@page import="java.util.Vector"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
	function fnSendAddr(zipcode, sido, gugun, dong, bunji){
		var addr = sido + "  " + gugun + "  " + dong + "  " + bunji;
		
		opener.document.f1.zip1.value = zipcode.substring(0, 3);
		opener.document.f1.zip2.value = zipcode.substring(4);
		opener.document.f1.addr.value = addr;
		
		self.close();
	}
</script>
</head>
<body>
<h2>우편번호 찾기</h2>
<form method="post" action="/MvcApp/member.action">
	<input type="hidden" name="command" value="ZIPSEARCH" />
	<table>
		<tr>
			<td>동 이름 입력 : <input type="text" name="dong"/>
				&nbsp;&nbsp;<input type="submit" value="검색" />
			</td>
		</tr>
		<!-- 검색된 결과 리스트 출력 -->
<%
try{
	Vector vlist = (Vector)request.getAttribute("addr");
	if(vlist.size() == 0 || vlist == null){
%>
		<tr>
			<td>검색 결과가 없습니다.</td>
		</tr>
<%
	}
	else{
		String bunji="";
		for(int i=0; i<vlist.size(); i++){
			ZipDto dto = (ZipDto)vlist.get(i);
			bunji = (dto.getBunji() == null) ? " " : dto.getBunji();
%>
		<tr>
			<td><a href="javascript:fnSendAddr('<%=dto.getZipcode()%>','<%=dto.getSido()%>','<%=dto.getGugun()%>','<%=dto.getDong()%>','<%=bunji%>')">
				<%=dto.getZipcode()%>&nbsp;&nbsp;&nbsp;
				<%=dto.getSido()%>&nbsp;&nbsp;&nbsp;
				<%=dto.getGugun()%>&nbsp;&nbsp;&nbsp;
				<%=dto.getDong()%>&nbsp;&nbsp;&nbsp;
				<%=bunji%></a>
			</td>
		</tr>
<%
		}
	}
}
catch(Exception err){}
%>
	</table>
	<br/><br/>
	<input type="button" value="닫기" onclick="self.close();" />
</form>
</body>
</html>