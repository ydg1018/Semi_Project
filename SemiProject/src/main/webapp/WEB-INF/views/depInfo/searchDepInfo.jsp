<%@page import="depInfo.dto.DepInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%List<DepInfo> list = (List) request.getAttribute("list");%>

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

<table class="table table-striped table-hover table-condensed">

<tr>
	<th style="width: 15%;">진료과</th>
	<th style="width: 85%;">설명</th>
</tr>

<tr>
	<td><%=list.get(0).getDep_item() %></td>
	<td><%=list.get(0).getDep_detail() %></td>
</tr>

<tr>
	<td><%=list.get(9).getDep_item() %></td>
	<td><%=list.get(9).getDep_detail() %></td>
</tr>

<tr>
	<td><%=list.get(13).getDep_item() %></td>
	<td><%=list.get(13).getDep_detail() %></td>
</tr>

<tr>
	<td><%=list.get(14).getDep_item() %></td>
	<td><%=list.get(14).getDep_detail() %></td>
</tr>

<tr>
	<td><%=list.get(15).getDep_item() %></td>
	<td><%=list.get(15).getDep_detail() %></td>
</tr>

<tr>
	<td><%=list.get(20).getDep_item() %></td>
	<td><%=list.get(20).getDep_detail() %></td>
</tr>

</table>

<hr>

<table class="table table-striped table-hover table-condensed">

<tr>
	<th style="width: 15%;">세부과</th>
	<th style="width: 85%;">설명</th>
</tr>

<%	for(int i=0; i<9; i++) { %>

<tr>
	<td>
		<a href="./detail?det_item=<%=list.get(i).getDet_item() %>">
		<%=list.get(i).getDet_item() %></a>
	</td>
	<td><%=list.get(i).getDet_detail() %></td>
</tr>
<%	} %>
</table>

<table class="table table-striped table-hover table-condensed">

<tr>
	<th style="width: 15%;">세부과</th>
	<th style="width: 85%;">설명</th>
</tr>

<%	for(int i=9; i<13; i++) { %>

<tr>
	<td>
		<a href="./detail?det_item=<%=list.get(i).getDet_item() %>">
		<%=list.get(i).getDet_item() %></a>
	</td>
	<td><%=list.get(i).getDet_detail() %></td>
</tr>
<%	} %>
</table>

<table class="table table-striped table-hover table-condensed">

<tr>
	<th style="width: 15%;">세부과</th>
	<th style="width: 85%;">설명</th>
</tr>

<%	for(int i=13; i<14; i++) { %>

<tr>
	<td>
		<a href="./detail?det_item=<%=list.get(i).getDet_item() %>">
		<%=list.get(i).getDet_item() %></a>
	</td>
	<td><%=list.get(i).getDet_detail() %></td>
</tr>
<%	} %>
</table>

<table class="table table-striped table-hover table-condensed">

<tr>
	<th style="width: 15%;">세부과</th>
	<th style="width: 85%;">설명</th>
</tr>

<%	for(int i=14; i<15; i++) { %>

<tr>
	<td>
		<a href="./detail?det_item=<%=list.get(i).getDet_item() %>">
		<%=list.get(i).getDet_item() %></a>
	</td>
	<td><%=list.get(i).getDet_detail() %></td>
</tr>
<%	} %>
</table>

<table class="table table-striped table-hover table-condensed">

<tr>
	<th style="width: 15%;">세부과</th>
	<th style="width: 85%;">설명</th>
</tr>

<%	for(int i=15; i<20; i++) { %>

<tr>
	<td>
		<a href="./detail?det_item=<%=list.get(i).getDet_item() %>">
		<%=list.get(i).getDet_item() %></a>
	</td>
	<td><%=list.get(i).getDet_detail() %></td>
</tr>
<%	} %>
</table>

<table class="table table-striped table-hover table-condensed">

<tr>
	<th style="width: 15%;">세부과</th>
	<th style="width: 85%;">설명</th>
</tr>

<%	for(int i=20; i<26; i++) { %>

<tr>
	<td>
		<a href="./detail?det_item=<%=list.get(i).getDet_item() %>">
		<%=list.get(i).getDet_item() %></a>
	</td>
	<td><%=list.get(i).getDet_detail() %></td>
</tr>
<%	} %>
</table>




</body>



