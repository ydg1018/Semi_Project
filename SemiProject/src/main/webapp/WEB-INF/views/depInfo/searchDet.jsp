<%@page import="depInfo.dto.DetInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% List<DetInfo> detInfo = (List) request.getAttribute("detInfo"); %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>::: 세부과 정보 :::</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>

<h1>세부과 정보</h1>
<hr>

<table class="table table-striped table-hover table-condensed">

<tr>
	<th style="width: 10%;">세부과</th>
	<th style="width: 90%;">세부과 설명</th>
</tr>

<%	for(int i=0; i<detInfo.size(); i++) { %>
<tr>
	<td><button class="btn btn-secondary" onclick="location.href='../trt/list'"><%=detInfo.get(i).getDet_item() %></td>
	<td><%=detInfo.get(i).getDet_detail() %></td>
</tr>
<%	} %>

</table>