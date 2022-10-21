<%@page import="util.Paging"%>
<%@page import="notice.dto.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--모델값 전달받기 --%>
<% List<Notice> noticeList = (List) request.getAttribute("noticeList"); %>


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

<table class="table .table-condensed">
	<tr>
		<th style="width: 15%;">번호</th>
		<th style="width: 50%">제목</th>
		<th style="width: 25%">작성일자</th>
		<th style="widows: 15%">조회수</th>
	<% for(int i=0; i<noticeList.size(); i++) { %>
	</tr>
		<td><%=noticeList.get(i).getNoticeIdx() %></td>
		<td>
			<a href="./view?noticeidx=<%=noticeList.get(i).getNoticeIdx() %>">
				<%=noticeList.get(i).getNoticeTitle() %>
			</a>
		</td>
		<td><%=noticeList.get(i).getNoticeDate() %></td>
		<td><%=noticeList.get(i).getNoticeHit() %></td>
	<tr>
	<% } %>
	</tr>
</table>

</div>

<%@ include file="./paging.jsp" %>

<footer id="footer" class="text-center">사이트정보</footer>

</body>
</html>











