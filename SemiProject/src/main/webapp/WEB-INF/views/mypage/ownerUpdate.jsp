<%@page import="login.dto.Owner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>	
	<meta charset="UTF-8">
	<meta http-equiv="mypage-content-type" content="text/html; charset=UTF-8"/>
	<meta name="description" content="description"/>
	<meta name="keywords" content="keywords"/>
	<meta name="author" content="author"/>
	<link rel="stylesheet" type="text/css" href="/resources/css/mypage/default.css" media="screen"/>
	
	<title>마이페이지 회원정보</title>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	<script type="text/javascript">
		$(document).on("ready", function(){

		});
	</script>
</head>
<body>

<div id="mypage-container" class="outer-container">

<div class="inner-container">
<!-- 헤더영역 임시 주석처리 (추후 필요할수도 잇으니)
	<div class="header">

		<div class="title">

			<span class="sitename"><a href="index.html">Dirtylicious</a></span>
			<div class="slogan">Free website template</div>

		</div>

	</div> 
	-->
<%-- <%=request.getAttribute("path") %> --%>
	<div class="path">
		<a href="/mypage/owner">마이페이지</a> &#8250; <a href="/mypage/ownerUpdate">회원정보 수정</a>
	</div>

	<div class="mypage-main">
		<div class="mypage-content">
			<form name="mypageForm" action="/mypage/ownerUpdate" method="post">
				<%-- 모델값 전달받기 --%>
				<%	Owner data = (Owner) request.getAttribute("data"); %>
				
				<h1>아이디</h1>
				<p><%=data.getOwnerId() %></p>
	
				<h2>이름</h2>
				<input type="text" name="ownerName" value="<%=data.getOwnerName() %>"/>
	
				<h1>이메일</h1>
				<input type="text" name="ownerEmail" value="<%=data.getOwnerEmail() %>"/>
	
				<h1>전화번호</h1>
				<input type="text" name="ownerCall" value="<%=data.getOwnerCall() %>"/>
		
				<h1>닉네임</h1>
				<input type="text" name="ownerNick" value="<%=data.getOwnerNick() %>"/>
				
				<br>
				<input type="submit" value="저장"/>
			</form>
		</div>

		<!-- 공통 메뉴 -->
		<jsp:include page="./mypageMenu.jsp" flush="true"/>

		<div class="clearer">&nbsp;</div>

	</div>
	
<!-- 푸터영역 임시 주석처리 (추후 필요할수도 잇으니)
	<div class="footer">

		<span class="left">
			&copy; 2017 <a href="index.html">Website.com</a>. Valid <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> &amp; <a href="http://validator.w3.org/check?uri=referer">XHTML</a>
		</span>

		

		<div class="clearer"></div>

	</div> -->

</div>

</div>

</body>
</html>