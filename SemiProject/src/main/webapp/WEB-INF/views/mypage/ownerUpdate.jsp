<%@page import="login.dto.Owner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/default.css" media="screen"/>

<div id="mypage-container" class="outer-container">

<div class="inner-container">
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
				
				<h1>비밀번호</h1>
				<input type="text" name="ownerPw" value="<%=data.getOwnerPw() %>"/>
	
				<h1>이름</h1>
				<input type="text" name="ownerName" value="<%=data.getOwnerName() %>"/>
				
				<h1>이메일</h1>
				<input type="text" name="ownerEmail" value="<%=data.getOwnerEmail() %>"/>
	
				<h1>전화번호</h1>
				<input type="text" name="ownerCall" value="<%=data.getOwnerCall() %>"/>
		
				<h1>닉네임</h1>
				<input type="text" name="ownerNick" value="<%=data.getOwnerNick() %>"/>
				
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