<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% 	boolean owner_login = session.getAttribute("owner_no") != null && (int)session.getAttribute("owner_no") != 0;
	boolean hos_login = session.getAttribute("hos_no") != null && (int)session.getAttribute("hos_no") != 0; %>
<div class="navigation">
	<h1>회원정보 관리</h1>
	<ul> 
		<% if(owner_login) { %>
		<li class='<%=request.getAttribute("path").equals("/mypage/owner")? "active" : "" %>'>
			<a href="/mypage/owner">회원정보 조회</a>
		</li>
		<li class='<%=request.getAttribute("path").equals("/mypage/ownerUpdate")? "active" : "" %>'>
			<a href="/mypage/ownerUpdate">회원정보 수정</a>
		</li>
		<% } %>
		
		<% if(hos_login) { %>
		<li class='<%=request.getAttribute("path").equals("/mypage/hos")? "active" : "" %>'>
			<a href="/mypage/hos">회원정보 조회</a>
		</li>
		<li class='<%=request.getAttribute("path").equals("/mypage/hosUpdate")? "active" : "" %>'>
			<a href="/mypage/hosUpdate">회원정보 수정</a>
		</li>
		<% } %>		
	</ul>
	
	<% if(hos_login) { %>
	<h1>병원정보 관리</h1>
	<ul> 
		<li class='<%=request.getAttribute("path").equals("/mypage/hosInfo")? "active" : "" %>'>
			<a href="/mypage/hosInfo">병원정보 조회</a>
		</li>
		<li class='<%=request.getAttribute("path").equals("/mypage/hosInfoUpdate")? "active" : "" %>'>
			<a href="/mypage/hosInfoUpdate">병원정보 수정</a>
		</li>
	</ul>
	<% } %>
	
	<h1>예약 관리</h1>
	<ul>
		<% if(owner_login) { %>
		<li class='<%=request.getAttribute("path").equals("/mypage/ownerReservation")? "active" : "" %>'>
			<a href="/mypage/ownerReservation">예약 조회</a>
		</li>
		<% } %>
		<% if(hos_login) { %>
		<li class='<%=request.getAttribute("path").equals("/mypage/hosReservation")? "active" : "" %>'>
			<a href="/mypage/hosReservation">예약 조회</a>
		</li>
		<% } %>
	</ul>

<!-- 	<h2>작성글 관리</h2> -->
<!-- 	<ul> -->
<!-- 		<li> -->
<!-- 			<a href="index.html">작성글 조회</a> -->
<!-- 		</li> -->
<!-- 		<li> -->
<!-- 			<a href="index.html">작성글 수정</a> -->
<!-- 		</li> -->
<!-- 	</ul> -->
</div>