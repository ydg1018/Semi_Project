<%@page import="depInfo.dto.TrtInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% List<TrtInfo> trtInfo = (List) request.getAttribute("trtInfo"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::: 진료항목 정보 :::</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>

<h1 style="text-align: center;">진료항목 정보</h1>
<hr>

<table class="table table-striped table-hover table-condensed">

<tr>
	<th style="width: 10%;">진료항목</th>
</tr>

<%	for(int i=0; i<trtInfo.size(); i++) { %>
<tr>
	<td><strong><%=trtInfo.get(i).getTrt_item() %></strong></td>
</tr>
<%	} %>

</table>

</body>
</html>