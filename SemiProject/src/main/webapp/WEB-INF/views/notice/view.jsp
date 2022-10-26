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

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#btnList").click(function() {
		$(location).attr("href", "./list")
	})
	
})

$(document).ready(function () {
	$("#btnNotice").click(function () {
		$(location).attr("href","./list")
	})
})

</script>

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



<h1>고객센터</h1>
<hr>

<h2><button id="btnNotice">공지사항</button> <button>FaQ</button></h2>

<table class="table table-bordered">
<tr>
	<td class="success">제목</td>
	<td colspan="5"><%=viewNotice.getNoticeTitle() %></td>
</tr>

<tr>
	<td class="success">글번호</td>
	<td><%=viewNotice.getNoticeIdx() %></td>
	
	<td class="success">작성일</td>
	<td><%=viewNotice.getNoticeDate() %></td>
	
	<td class="success">조회수</td>
	<td><%=viewNotice.getNoticeHit() %></td>
</tr>

<tr>
	<td colspan="6"><%=viewNotice.getNoticeContent() %></td>
</tr>
</table>

<div class="text-right">
	<button id="btnList" class="btn">목록</button>
</div>



</div>

<footer id="footer" class="text-center">사이트정보</footer>

</head>
<body>
</body>
</html>
