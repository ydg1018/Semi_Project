<%@page import="depInfo.dto.DepInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% List<DepInfo> depInfo = (List) request.getAttribute("depInfo"); %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>::: 진료과 정보 :::</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
.search {
  position: relative;
  width: 700px;
  margin: 0 auto;
}

input {
  width: 100%;
  border: 1px solid #bbb;
  border-radius: 8px;
  padding: 10px 12px;
  font-size: 14px;
}

img {
  position : absolute;
  width: 17px;
  top: 10px;
  right: 12px;
  margin: 0;
}

.dep_item {
	position: static;
	top: 20%;
	width: 15%;
	float: left;
	text-align: center;
}

#dep_detail {
	margin-left: 10px;
	margin-right: 10px;
	border: 3px solid #bbb;
	border-radius: 30px;
}

</style>
    
</head>

<body>

<h1 style="text-align: center;">진료과 정보</h1>
<hr>
<br>

<div class="search">
  <input type="text" placeholder="검색어 입력">
  <img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
</div>

<br><br>

<%	for(int i=0; i<depInfo.size(); i++) { %>

<div class="dep_item">
	<div id="dep_detail">
	<br>
	   	<strong>
		<%=depInfo.get(i).getDep_item() %>
		</strong>
	<br><br>
		<%=depInfo.get(i).getDep_detail() %>
	</div>
	<br>
		<button class="btn btn-secondary" onclick="location.href='../det/list'">바로 가기</button>
</div>

<%	} %>

<hr>
<br><br>

<table class="table table-striped table-hover table-condensed">

<tr>
	<th style="width: 10%;">진료과</th>
	<th style="width: 80%;">설명</th>
	<th style="width: 10%;">세부과 보기</th>
</tr>

<%	for(int i=0; i<depInfo.size(); i++) { %>
<tr>
	<td><strong><%=depInfo.get(i).getDep_item() %></strong></td>
	<td><%=depInfo.get(i).getDep_detail() %></td>
	<td><button class="btn btn-secondary" onclick="location.href='../det/list'">클릭!</button></td>
</tr>
<%	} %>

</table>
</body>



