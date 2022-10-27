<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>

<style type="text/css">

body {
	margin: 0 auto;
}

button {
	cursor: pointer;
}

.choice-btns {
	width: 100%;
	heigth: auto;
	margin: 0 auto;
	margin-top: 80px;
	margin-bottom: 50px;
	text-align: center;
	border: 1px solid #5edfdf;
	border-radius: 1.1em;
}

.choice-btns hr {
	margin: 0 auto;
	text-align: center;
	margin-top: 50px;
	margin-bottom: 50px;
}

.title-box1 {
	width: 100%;
	margin: 0 auto;
	margin-bottom: 40px;
}

.title-box2 {
	width: 100%;
	margin: 0 auto;
	margin-bottom: 20px;
}

.title1 {
	text-align: center;
	font-size: 50px;
	position: relative;
	margin-bottom: 20px;
}

.title3 {
	text-align: center;
	font-size: 16px;
	position: relative;
}

.memberJoin {
	margin-left: 10px;
	margin-right: 10px;
	width: 450px;
	height: 60px;
	border-radius: 10px;
	font-size: 25px;
	font-weight: 500;
	background-color: #555;
	color: #fff;
}

.brandJoin {
	margin-left: 10px;
	margin-right: 10px;
	width: 450px;
	height: 60px;
	border-radius: 10px;
	font-size: 25px;
	font-weight: 500;
	background-color: #555;
	color: #fff;
}

.move-btns {
	heigth: auto;
	margin: 0 auto;
	text-align: center;
	margin-bottom: 80px;
	margin-top: 30px;
}

.goback-btn {
	margin-left: 10px;
	margin-right: 10px;
	width: 100px;
	height: 30px;
	font-size: 15px;
	font-weight: 500;
	background-color: #4F86C6;
	color: #fff;
	border-radius: 0.8em;
	border-color: #D7FFF1;
}

.gohome-btn {
	margin-left: 10px;
	margin-right: 10px;
	width: 100px;
	height: 30px;
	font-size: 15px;
	font-weight: 500;
	background-color: #4F86C6;
	color: #fff;
	border-radius: 0.8em;
	border-color: #D7FFF1;
}

.ownerJoin {
	border-radius: 0.8em;
	border-color: #D7FFF1;
    color: #fff;
    background-color: #4F86C6;
    margin-bottom: 30px;
}

.hosJoin {
	border-radius: 0.8em;
	border-color: #D7FFF1;
    color: #fff;
    background-color: #4F86C6;
    margin-bottom: 30px;
}

</style>

</head>
<body>

<div class="choice-btns">
	<div class="title-box1">
		<p class="title1">회원가입</p>
	</div>
	<div class="title-box2">
		<p class="title3">펫오너/펫병원 유형을 선택해주세요.</p>
	</div>
	<div class="signupJoin">
		<a href="/login/signupowner"><button class="ownerJoin">펫오너 회원가입</button></a>
	</div>
	<div class="signupJoin">
		<a href="/login/signuphos"><button class="hosJoin">펫병원 회원가입</button></a>
	</div>
	<div class="move-btns">
		<a href="/hos/list"><button class="gohome-btn">홈으로 가기</button></a>
	</div>
</div>
			
<%@ include file="../layout/footer.jsp" %>