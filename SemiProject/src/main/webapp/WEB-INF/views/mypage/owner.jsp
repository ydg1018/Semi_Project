<%@page import="login.dto.Owner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/default.css" media="screen"/>

<div id="mypage-container" class="outer-container">

<div class="inner-container">
	<div class="path">
		<a href="/mypage/owner">마이페이지</a> &#8250; <a href="/mypage/owner">회원정보 조회</a>
	</div>

	<div class="mypage-main">
		<div class="mypage-content">
			<%-- 모델값 전달받기 --%>
			<%	Owner data = (Owner) request.getAttribute("data"); %>
			
			<h1>아이디</h1>
			<p><%=data.getOwnerId() %></p>

			<h1>이름</h1>
			<p><%=data.getOwnerName() %></p>

			<h1>이메일</h1>
			<p><%=data.getOwnerEmail() %></p>

			<h1>전화번호</h1>
			<p><%=data.getOwnerCall() %></p>

			<h1>닉네임</h1>
			<p><%=data.getOwnerNick() %></p>
		</div>

		<!-- 공통 메뉴 -->
		<jsp:include page="./mypageMenu.jsp" flush="true"/>

		<div class="clearer">&nbsp;</div>
	</div>
	
</div>

</div>
<%@ include file="../layout/footer.jsp" %>