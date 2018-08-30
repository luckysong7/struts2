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
<title>로그인</title>

<link rel = "stylesheet" href ="<%=cp%>/imageTest/css/style.css" type ="text/css"/>
<link rel = "stylesheet" href ="<%=cp%>/imageTest/css/created.css" type ="text/css"/>

<script type="text/javascript">
	
	function login(){
		var f = document.myForm;
		
		if(!f.userId.value){
			alert("아이디를 입력하세요 !");
			f.userId.focus();
			return;
		}
		if(!f.userPwd.value){
			alert("비밀번호를 입력하세요 !");
			f.userPwd.focus();
			return;
		}
		
		f.action = "<%=cp%>/imageTest/login.action";
		f.submit();
		
	}

</script>
</head>

<body>

<br/><br/>
<center>
<form action="" method = "post" name ="myForm">
	
	<table align ="center" cellpadding="0" cellspacing="0"> 			
		<tr height="2">
			<td colspan="2" bgcolor="#cccccc"></td>
		</tr>
		
		<tr height ="30">
			<td colspan="2" align="center">
				<b>로그인</b>
			</td>
		</tr>
		
		<tr height="2">
			<td colspan="2" bgcolor="#cccccc"></td>
		</tr>
		
		<tr height = "25">
			<td width = "80" bgcolor="#e6e4e6" align="center">아이디</td>
			<td width = "120" style ="padding-left: 5px;">
				<input type ="text" name ="userId" maxlength="10" size ="15" style ="width:200px; height:20px;"/>
			</td>
			
		</tr>
		
		<tr height="2">
			<td colspan="2" bgcolor="#cccccc"></td>
		</tr>
		
		<tr height = "25">
			<td width = "80" bgcolor="#e6e4e6" align="center">패스워드</td>
			<td width = "120" style ="padding-left: 5px;">
				<input type ="password" name ="userPwd" maxlength="10" size ="15" style ="width:200px; height:20px;"/>
			</td>
			
		</tr>
		
		<tr height="2">
			<td colspan="2" bgcolor="#cccccc"></td>
		</tr>
	
		<tr>
			<td colspan="2" align="center">
				<input type ="hidden" name ="mode" value="input">
				<input type= "button" value ="로그인" class="btn2" onclick="login();"/>
				
				<input type= "button" value ="취소" class="btn2" onclick="javascript:location.href='<%=cp%>/imageTest/list.action';"/>
				
				<input type= "button" value ="회원가입" class="btn2" onclick="javascript:location.href='<%=cp %>/imageTest/signup.action';"/>
			</td>
		</tr>
	
		<tr height = "30">
			<td colspan = "2" align = "center">
			<br/>
				<font color ="red"><b> ${message } </b></font>
				<br/>
				<c:if test="${!empty message}">
					<input type ="button" value ="비밀번호 찾기" onclick ="javascript:location.href='<%=cp %>/imageTest/searchPwd.action';" />
				</c:if>
			</td>
		</tr>
	
	</table>


</form>

</center>

</body>
</html>