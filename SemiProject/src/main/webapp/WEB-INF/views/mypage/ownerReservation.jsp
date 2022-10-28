<%@page import="reservation.dto.Reservation"%>
<%@page import="hosInfo.dto.HosInfo"%>
<%@page import="login.dto.Owner"%>
<%@page import="reservation.dto.Pet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/default.css" media="screen"/>

<div id="mypage-container" class="outer-container">

<div class="inner-container">
	<div class="path">
		<a href="/mypage/owner">마이페이지</a> &#8250; <a href="/mypage/ownerReservation">예약 조회</a>
	</div>

	<div class="mypage-main">
		<div class="mypage-content">
			<%-- 모델값 전달받기 --%>
			<%	Reservation resData = (Reservation) request.getAttribute("resData"); %>
			<%	HosInfo infoData = (HosInfo) request.getAttribute("infoData"); %>
			<%	Owner ownerData = (Owner) request.getAttribute("ownerData"); %>
			<%	Pet petData = (Pet) request.getAttribute("petData"); %>
			
			<h1>예약번호</h1> 
			<p><%=resData.getResNo() %></p>

			<h1>예약날짜</h1>
			<p><%=resData.getResDate() %></p>

			<h1>예약상세</h1>
			<p><%=resData.getResDetail() %></p>

			<h1>예약자</h1>		
			<p><%=ownerData.getOwnerName() %></p>

			<h1>펫번호</h1>
			<p><%=petData.getPetName() %></p>

			<h1>병원이름</h1>
			<p><%=infoData.getHos_name() %></p>
		</div>

		<!-- 공통 메뉴 -->
		<jsp:include page="./mypageMenu.jsp" flush="true"/>

		<div class="clearer">&nbsp;</div>
	</div>
	
</div>

</div>
<%@ include file="../layout/footer.jsp" %>