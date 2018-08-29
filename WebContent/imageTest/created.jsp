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
<title>Insert title here</title>
<link rel = "stylesheet" href ="<%=cp %>/imageTest/css/style.css" type ="text/css"/>
 
<script type="text/javascript">
	function sendIt(){
		var f= document.myForm;
		
		if(!f.subject.value){
			alert("제목을 입력해주세요");
			f.subject.focus();
			return;
		}
		if(!f.upload.value){
			alert("이미지 파일을 선택해주세요");
			return;
		}
		
		f.action = "<%=cp %>/imageTest/created.action";
		f.submit();
		
	}
</script>


</head>
<body>
<center>	
	<div id="bbsList_title">
	<a href ="javascript:location.href='<%=cp%>/image/list.do';" style="font-size: 18pt">
	이미지게시판 (Struts2)
	</a>
	</div>
	
	<form  method="post" enctype="multipart/form-data" name ="myForm" >
	<table class ="line" border="0" height="100px;" cellpadding="0" cellspacing="0">
		<tr >
	
			<td  style="width: 100px; text-align: center;" bgcolor="#EAEAEA">제&nbsp;&nbsp;&nbsp;목</td>
			<td>
				<input type="text" name = "subject" style ="width: 300px;"/> 
			</td>
		</tr>
		<tr >
			<td class ="end" style="width: 100px; text-align: center;" bgcolor="#EAEAEA">파&nbsp;&nbsp;&nbsp;일</td>
			<td class= "end">
				<input type="file" name = "upload" /> 
			</td>
		</tr>	
		
		<tr align="center" >
			<td colspan="2">
				
				<input type="hidden" name ="mode" value="save" />
				<input class = "btn2" type="button" value="등록하기" onclick="sendIt()"/>
				<input class = "btn2" type="reset" value="다시입력" onclick ="document.myForm.subject.focus();" />
				<input class = "btn2" type ="button" value ="작성취소" 
				onclick ="javascript:location.href='<%=cp %>/imageTest/list.action?pageNum=${pageNum }'"/>
				
			</td>
		</tr>
	</table>
	</form>
</center>

</body>
</html>


