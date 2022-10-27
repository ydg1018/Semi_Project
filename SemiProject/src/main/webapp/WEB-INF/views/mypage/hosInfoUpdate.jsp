<%@page import="hosInfo.dto.HosInfo"%>
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
	
	<title>마이페이지 병원회원정보</title>
	
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
		<a href="/mypage/hosInfo">마이페이지</a> &#8250; <a href="/mypage/hosInfoUpdate">회원정보 수정</a>
	</div>

	<div class="mypage-main">
		<div class="mypage-content">
			<form name="mypageForm" action="/mypage/hospitalUpdate" method="post">
				<%-- 모델값 전달받기 --%>
				<%	HosInfo data = (HosInfo) request.getAttribute("data"); %>
	
				<h1>병원명</h1>
				<p><%=data.getHos_name() %></p>
	
				<h1>병원주소</h1>
				<input type="text" name="hosAdd" value="<%=data.getHos_add() %>"/>
	
				<h1>우편번호</h1>
				<input type="number" name="hosZip" value="<%=data.getHos_zip() %>"/>
		
				<h1>전화번호</h1>
				<input type="number" name="hosCall" value="<%=data.getHos_call() %>"/>
				
				<h1>진료시간</h1>
				<input type="number" name="hosTime" value="<%=data.getHos_time() %>"/>
				
				<h1>대중교통정보</h1>
				<input type="number" name="hosTrans" value="<%=data.getHos_trans() %>"/>
				
				<h1>주차정보</h1>
				<input type="number" name="hosPark" value="<%=data.getHos_park() %>"/>
				
				<h1>진료가격</h1>
				<input type="number" name="hosPrice" value="<%=data.getHos_price() %>"/>
				
				
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