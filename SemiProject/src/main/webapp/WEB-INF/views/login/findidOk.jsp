<%@ page import="login.dto.Owner" %>
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
}

.btn-primary {
	border-radius: 0.8em;
	border-color: #D7FFF1;
    color: #fff;
    background-color: #4F86C6;
    margin-bottom: 30px;
}

</style>

</head>
<body>

<div id="wrap">
	
	<h3>아이디 찾기 결과</h3>
	
	<div id="name">[<%= session.getAttribute("owner_name") %>] 님의 아이디는</div>
	<div id="id" style="margin-bottom: 100px;">[<%= ((Owner)request.getAttribute("owner_id")) %>] 입니다</div>
	
	<a href="/find/findpw"><button id="pwbutton" class="btn btn-primary">비밀번호 찾기</button></a>
	<a href="/find/findid"><button id="rebutton" class="btn btn-primary">다시 찾기</button></a>
	<a href="/login/login"><button id="lgbutton" class="btn btn-primary">로그인하러가기</button></a>
	
</div>

</body>
</html>