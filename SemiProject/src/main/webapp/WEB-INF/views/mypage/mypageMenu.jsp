<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="navigation">
	<h2>회원정보 관리</h2>
	<ul> 
		<li class='<%=request.getAttribute("path").equals("/mypage/owner")? "active" : "" %>'>
			<a href="/mypage/owner">회원정보 조회</a>
		</li>
		<li class='<%=request.getAttribute("path").equals("/mypage/ownerUpdate")? "active" : "" %>'>
			<a href="/mypage/ownerUpdate">회원정보 수정</a>
		</li>
		<li class='<%=request.getAttribute("path").equals("/mypage/hospital")? "active" : "" %>'>
			<a href="/mypage/hospital">병원회원정보 조회</a>
		</li>
		<li class='<%=request.getAttribute("path").equals("/mypage/hospitalUpdate")? "active" : "" %>'>
			<a href="/mypage/hospitalUpdate">병원회원정보 수정</a>
	</ul>
	
	

	<h2>작성글 관리</h2>
	<ul>
		<li>
			<a href="index.html">작성글 조회</a>
		</li>
		<li>
			<a href="index.html">작성글 수정</a>
		</li>
	</ul>
</div>