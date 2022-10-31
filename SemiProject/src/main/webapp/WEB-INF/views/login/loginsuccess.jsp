<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

#wrap {
	border: 1px solid #5edfdf;
	border-radius: 1.1em;
	width: 300px;
	height: 300px;
	margin: 0 auto;
	margin-top: 100px;
	text-align: center;
}

.btn {
	cursor: pointer;
	width: 50%;
}

.btn-primary {
	border-radius: 0.8em;
	border-color: #D7FFF1;
    color: #fff;
    background-color: #4F86C6;
    margin-bottom: 30px;
}

p {
	margin: 50px 0;
}

</style>

</head>
<body>

<div id="wrap">
	
	<p><%= session.getAttribute("owner_id") %>님, 환영합니다.</p>
	
	<a href="/login/logout"><button id="pwbutton" class="btn btn-primary">로그아웃</button></a>
	<a href="/"><button id="lgbutton" class="btn btn-primary">마이페이지</button></a>
	<a href="/hos/list"><button id="lgbutton" class="btn btn-primary">홈으로 가기</button></a>
</div>
</body>
</html>