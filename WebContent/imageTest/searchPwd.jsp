<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	request.setCharacterEncoding("UTF-8");
	
	String cp = request.getContextPath();
	
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 찾기</title>


<link rel="stylesheet" href="<%=cp%>/imageTest/css/style.css"
	type="text/css" />
<link rel="stylesheet" href="<%=cp%>/imageTest/css/created.css"
	type="text/css" />
	
<script type="text/javascript">
	function sendIt(){
		var f = document.myForm;
		
		f.action = "<%=cp%>/imageTest/searchPwd.action";
		f.submit();
	}
</script>
</head>
<body>
	<div id="bbs">
		<div id="bbs_title">비밀번호 찾기</div>

		<form action="" method="post" name="myForm">
			<div id="bbsCreated">
				<div class="bbsCreated_bottomLine">
					<dl>
						<dt>아&nbsp;이&nbsp;디</dt>
						<dd>
							<input type="text" name="userId" size="35" maxlength="20"
								class="boxTF" />
						</dd>
					</dl>
				</div>

				<div class="bbsCreated_bottomLine">
					<dl>
						<dt>전 화 번 호</dt>
						<dd>
							<input type="text" name="userTel" size="35" maxlength="20"
								class="boxTF" />
						</dd>
					</dl>
				</div>
				
				<div id="bbsCreated_footer">
					<input type="hidden" name= "mode" value="search">
					<input type="button" value="확인" class="btn2" onclick="sendIt();" />
					<input type="button" value="취소" class="btn2"
						onclick="javascript:location.href='<%=cp%>/imageTest/list.action';" />

				</div>
				
			</div>
			
			<table align ="center" cellpadding="0" cellspacing="0"> 
				<tr height = "15">
			<td colspan = "2" align = "center">
			<br/>
				<font color ="red"><b> ${message2 } </b></font>
				<br/>
				
			</td>
		</tr>
			
			</table>
			
		</form>	
	</div>

</body>
</html>