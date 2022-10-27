<%@page import="login.dto.Hospital"%>
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

	<div class="path">
		<a href="/mypage/hospital">마이페이지</a> &#8250; <a href="/mypage/hospital">병원회원정보 조회</a>
	</div>

	<div class="mypage-main">
		<div class="mypage-content">
			<%-- 모델값 전달받기 --%>
			<%	Hospital data = (Hospital) request.getAttribute("data"); %>
			
<!--  			<h1>병원회원번호</h1> 
			<p><%=data.getHosNo() %></p> -->

			<h1>아이디</h1>
			<p><%=data.getHosId() %></p>

			<h1>패스워드</h1>
			<p><%=data.getHosPw() %></p>

			<h1>사업자번호</h1>
			<p><%=data.getHosLic() %></p>

			<h1>병원등록번호</h1>
			<p><%=data.getHosCode() %></p>
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