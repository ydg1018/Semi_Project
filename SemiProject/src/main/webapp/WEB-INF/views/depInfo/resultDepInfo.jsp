<%@page import="depInfo.dto.DepInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<DepInfo> list = (ArrayList<DepInfo>) request.getAttribute("list"); %>    
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>::: 검색 :::</title>
    
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

img {
  position : absolute;
  width: 17px;
  top: 10px;
  right: 12px;
  margin: 0;
}
</style>

</head>
<body>

<div class="search">
	<form method="get" action="./result" >
		<input type="text" placeholder="검색어를 입력하세요" name="det_detail"
		style="width: 100%;
		border: 1px solid #bbb;
		border-radius: 8px;
		padding: 10px 12px;
		font-size: 14px;">
		<img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
		<input type="submit" value="검색">
	</form>
</div>

<table class="table table-striped table-hover table-condensed">
<tr>
	<th style="width: 30%;">세부과</th>
	<th style="width: 30%;">설명</th>
</tr>

<%	for(int i=0; i<list.size(); i++) { %>
<tr>
	<td><%=list.get(i).getDet_item() %></td>
	<td><%=list.get(i).getDet_detail() %></td>
</tr>
<%	} %>

</table>

</body>
</html>