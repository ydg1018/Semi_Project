<%@page import="login.dto.Hos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/default.css" media="screen"/>

<div id="mypage-container" class="outer-container">

<div class="inner-container">
	<div class="path">
		<a href="/mypage/hos">마이페이지</a> &#8250; <a href="/mypage/hosUpdate">회원정보 수정</a>
	</div>

	<div class="mypage-main">
		<div class="mypage-content">
			<form name="mypageForm" action="/mypage/hosUpdate" method="post">
				<%-- 모델값 전달받기 --%>
				<%	Hos data = (Hos) request.getAttribute("data"); %>
				
				<h1>아이디</h1>
				<p><%=data.getHosId() %></p>
	
				<h1>패스워드</h1>
				<input type="text" name="hosPw" value="<%=data.getHosPw() %>"/>
	
				<h1>사업자번호</h1>
				<input type="number" name="hosLic" value="<%=data.getHosLic() %>"/>
		
				<h1>병원이름</h1>
				<input type="text" name="hosName" value="<%=data.getHosName() %>"/>
	
				<h1>병원등록번호</h1>
				<input type="number" name="hosCode" value="<%=data.getHosCode() %>"/>
				
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