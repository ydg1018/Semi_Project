<%@page import="hosInfo.dto.HosInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/default.css" media="screen"/>

<div id="mypage-container" class="outer-container">

<div class="inner-container">
	<div class="path">
		<a href="/mypage/hos">마이페이지</a> &#8250; <a href="/mypage/hosInfoUpdate">회원정보 수정</a>
	</div>

	<div class="mypage-main">
		<div class="mypage-content">
			<form name="mypageForm" action="/mypage/hosInfoUpdate" method="post">
				<%-- 모델값 전달받기 --%>
				<%	HosInfo data = (HosInfo) request.getAttribute("infoData"); %>
	
				<h1>병원명</h1>
				<input type="text" name="hosName" value="<%=data.getHos_name() %>"/>
	
				<h1>병원주소</h1>
				<input type="text" name="hosAdd" value="<%=data.getHos_add() %>"/>
	
				<h1>우편번호</h1>
				<input type="number" name="hosZip" value="<%=data.getHos_zip() %>"/>
		
				<h1>전화번호</h1>
				<input type="text" name="hosCall" value="<%=data.getHos_call() %>"/>
				
				<h1>진료시간</h1>
				<input type="text" name="hosTime" value="<%=data.getHos_time() != null ? data.getHos_time() : "" %>"/>
				
				<h1>대중교통정보</h1>
				<input type="text" name="hosTrans" value="<%=data.getHos_trans() != null ? data.getHos_trans() : ""  %>"/>
				
				<h1>주차정보</h1>
				<input type="text" name="hosPark" value="<%=data.getHos_park() != null ? data.getHos_park() : ""  %>"/>
				
				<h1>진료가격</h1>
				<input type="number" name="hosPrice" value="<%=data.getHos_price() != 0 ? data.getHos_price() : ""  %>"/>
				
				
				<br><br>
				<input type="submit" value="저장"/>
			</form>
		</div>

		<!-- 공통 메뉴 -->
		<jsp:include page="./mypageMenu.jsp" flush="true"/>

		<div class="clearer">&nbsp;</div>

	</div>
	
</div>

</div>
<%@ include file="../layout/footer.jsp" %>