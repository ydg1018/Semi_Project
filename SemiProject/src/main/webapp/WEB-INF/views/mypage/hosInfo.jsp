<%@page import="hosInfo.dto.HosInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/default.css" media="screen"/>

<div id="mypage-container" class="outer-container">

<div class="inner-container">
	<div class="path">
		<a href="/mypage/hos">마이페이지</a> &#8250; <a href="/mypage/hosInfo">병원회원정보 조회</a>
	</div>

	<div class="mypage-main">
		<div class="mypage-content">
			<%-- 모델값 전달받기 --%>
			<%	HosInfo data = (HosInfo) request.getAttribute("infoData"); %>

			<h1>병원명</h1>
			<p><%=data.getHos_name() %></p>

			<h1>병원주소</h1>
			<p><%=data.getHos_add() %></p>

			<h1>우편번호</h1>
			<p><%=data.getHos_zip() %></p>

			<h1>전화번호</h1>
			<p><%=data.getHos_call() %></p>
			
			<h1>진료시간</h1>
			<p><%=data.getHos_time() != null ? data.getHos_time() : "-"%></p>
			
			<h1>대중교통정보</h1>
			<p><%=data.getHos_trans() != null ? data.getHos_trans() : "-" %></p>
			
			<h1>주차정보</h1>
			<p><%=data.getHos_park() != null ? data.getHos_park() : "-" %></p>
			
			<h1>진료가격</h1>
			<p><%=data.getHos_price() != 0 ? data.getHos_price() : "-" %></p>
			
		</div>

		<!-- 공통 메뉴 -->
		<jsp:include page="./mypageMenu.jsp" flush="true"/>

		<div class="clearer">&nbsp;</div>

	</div>
	
</div>

</div>
<%@ include file="../layout/footer.jsp" %>