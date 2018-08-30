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
<title>이미지 게시판(Struts2)</title>
<link rel="stylesheet" href="<%=cp%>/imageTest/css/style.css"
	type="text/css" />

</head>
<body>
<c:choose>
	<c:when test="${empty sessionScope.customInfo.userId }">
		<div align="center">
		<br/><br/><br/>
		로그인하시면 이미지 게시판이 보입니다.<br/><br/>
		<a href="<%=cp%>/imageTest/signup.action">회원가입</a>
		<br /><br />
		<a href="<%=cp%>/imageTest/login.action">로그인</a>
		<br /><br />
		</div>
	</c:when>
	<c:otherwise>
	<div align="center">
		${sessionScope.customInfo.userName } 안녕하세요 ! <br/><br/>
	</div>
	<div style="padding-top: 30px;" align="center">
		<div id="bbsList_title" align="center">
			<a href="javascript:location.href='<%=cp%>/imageTest/list.action';"
				style="font-size: 18pt"> 이미지 게시판 (Struts2) </a>
		</div>
	

		<table border="0" width="550" align="center">
			<tr>
				<td>Total ${totalDataCount } articles , ${totalPage } pages / Now page is ${pageNum }</td>
				<td align="right">	
				<input type="button" value="게시물 등록"
				onclick="javascript:location.href='<%=cp%>/imageTest/created.action';" />
				<input type="button" value ="로그아웃"
				onclick="javascript:location.href='<%=cp%>/imageTest/logout.action';"/>  
				</td>
				
				
				
			</tr>
		
		</table>

			<c:set var = "i" value ="1"></c:set>
			<table >
				<c:forEach var="dto" items="${lists }"> 
					<c:if test="${i % 3 == 1}">
						<tr>
					</c:if>
						<td align="center">
							<img alt="${savePath }/${dto.saveFileName}" src= "${savePath }/${dto.saveFileName }" width="180" height="180" /><br/> 
							${dto.subject } 
							<a href="${deletePath }?num=${dto.num }&pageNum=${pageNum}" >삭제</a>
						</td> 	
						<c:if test="${i%3 != 0 }">
							<c:forEach var = "j" begin ="${i%3+1 }" end ="3" step = "1">
								<td></td>
							</c:forEach>
						</c:if>	
					<c:if test="${i% 3 == 0}">
						</tr>
					</c:if>				
					<c:set var = "i" value ="${i+1 }"></c:set>
				</c:forEach>
			</table>
	
	
		<div id="footer">
			<p>
				<c:if test="${totalDataCount != 0 }">
					${pageIndexList }
				</c:if>
				<c:if test="${totalDataCount == 0 }">
					등록된 게시물이 없습니다.
				</c:if>
			</p>
		</div>


	</div>

	</c:otherwise>
	
</c:choose>
</body>
</html>