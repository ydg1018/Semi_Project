<%@page import="depInfo.dto.DepInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<%
DepInfo detail = (DepInfo) request.getAttribute("detail");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> <%=detail.getDet_item() %> 정보</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
<h1 style="text-align: center;">
<button class="btn btn-info" onclick="location.href='../dep/list'">진료과 전체 목록</button>
</h1>

<hr>

<table class="table table-bordered">

<tr>
	<td class="info">세부과</td>
	<td class="info">설명</td>
	<td class="info">진료항목</td>
</tr>
<tr>
	<td><%=detail.getDet_item() %></td>
	<td><%=detail.getDet_detail() %></td>
	<td><%=detail.getTrt_item() %></td>
</tr>
</table>

<%@ include file="../layout/footer.jsp" %>
