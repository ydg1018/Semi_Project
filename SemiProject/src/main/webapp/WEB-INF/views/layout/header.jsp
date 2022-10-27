<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> : : : 동물병원을 찾아줘 : : :</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"><style>
*{
font-family: 'Nanum Gothic', sans-serif;
}
</style>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
#header {
	text-align: center;
	background: #46B4B4;
}

#footer {
	background: #46B4B4;
}

#header h1 a {
	text-decoration: none;
	color: white;
}

.right {
	background: #e1f3f3;
}

ul {
	list-style: none;
}

.menu li {
	width: 150px;
	height: 80px;
}

.menu1 {
	width: 50%;
	height: 55px;
	margin: auto;
}

.right > ul > li {
	margin-right: 20px; 
}

span {
	font-size: 12px;
	color: white;
}
</style>

</head>
<body>

<header id="header">
	<div class="right">
		<ul style="display: flex;">
		<%	if( session.getAttribute("login") == null ) { %>
			<li>
				<a href="/login/login">로그인</a>
			</li>
			<li>
				<a href="/login/signup">회원가입</a>
			</li>
		<%	} %>
		
		<%	if( session.getAttribute("login") != null && (boolean) session.getAttribute("login") ) { %>
			<li>
				<a href="/login/logout">로그아웃</a>
			</li>
			<li>
				<a>마이페이지</a>
			</li>
		<% } %>
		</ul>
	</div>

	<div class="menu">
		<div class="menu1">
			<ul class="menu2" style="display: flex;">
				<li>
					<a href="">
						<span>병원 예약</span>
					</a>
				</li>
				<li>
					<a href="">
						<span>병원 후기</span>
					</a>
				</li>
				<li>
					<a href="../dep/list">
						<span>진료과 정보</span>
					</a>
				</li>
				<li>
					<h5><strong><a href="../hos/list" style="color: white;">
						동물병원을<br>찾아줘
					</a></strong></h5>
				</li>
				<li>
					<a href="">
						<span>반려동물 행사</span>
					</a> 
				</li>
				<li>
					<a href="">
						<span>유기동물 공고</span>
					</a>
				</li>
				<li>
					<a href="">
						<span>고객센터</span>
					</a>
				</li>
			</ul>
		</div>
	</div>
	
	
	
</header>

<div class="container">
