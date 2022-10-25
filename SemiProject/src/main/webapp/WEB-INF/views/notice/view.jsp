<%@page import="notice.dto.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% Notice viewNotice = (Notice) request.getAttribute("viewNotice"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동물병원을 찾아조</title>

<!-- 부트스트랩 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
#header, #footer {
	background-color: mediumaquamarine;
	height: 70px;
	display: flex;
	justify-content: center;
	align-items: center;
}

th, td{
	text-align: center;
}
</style>

</head>
<body>

<header id="header" class="text-center">
	<h1>동물병원 찾아조</h1>
</header>

<div class="container">

<h1><buttontype="button" class="btn">고객센터</button></h1>
<hr>


</div>

<footer id="footer" class="text-center">사이트정보</footer>

</head>
<body>
</body>
</html>
