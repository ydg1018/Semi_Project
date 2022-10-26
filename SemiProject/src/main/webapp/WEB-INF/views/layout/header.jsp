<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> : : : 동물병원을 찾아줘 : : :</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
#header {
	text-align: center;
	background: #32a69f;
}

#footer {
	background: #b4e8e3;
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
	height: 50px;
	margin: auto;
}

.right > ul > li {
	margin-right: 20px; 
}

span {
	font-size: 15px;
	color: white;
}
</style>

</head>
<body>

<header id="header">
	<div class="right">
		<ul style="display: flex;">
			<li>
				<a>로그인</a>
			</li>
			<li>
				<a>회원가입</a>
			</li>
			<li>
				<a>마이페이지</a>
			</li>
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
					<a href="">
						<span>진료과 정보</span>
					</a>
				</li>
				<li>
					<h5><a href="/">
						<span>동물병원을 찾아줘</span>
					</a></h5>
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
