<%@page import="login.dto.Hos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/default.css" media="screen"/>

<div id="mypage-container" class="outer-container">

<div class="inner-container">

	<div class="path">
		<a href="/mypage/hos">마이페이지</a> &#8250; <a href="/mypage/hos">회원정보 조회</a>
	</div>

	<div class="mypage-main">
		<div class="mypage-content">
			<%-- 모델값 전달받기 --%>
			<%	Hos data = (Hos) request.getAttribute("data"); %>
			
			<h1>아이디</h1>
			<p><%=data.getHosId() %></p>

			<h1>패스워드</h1>
			<p><%=data.getHosPw() %></p>

			<h1>사업자번호</h1>
			<p><%=data.getHosLic() %></p>

			<h1>병원이름</h1>
			<p><%=data.getHosName() %></p>
			
			<h1>병원등록번호</h1>
			<p><%=data.getHosCode() %></p>
		</div>

		<!-- 공통 메뉴 -->
		<jsp:include page="./mypageMenu.jsp" flush="true"/>

		<div class="clearer">&nbsp;</div>

	</div>
	
</div>

</div>
<%@ include file="../layout/footer.jsp" %>