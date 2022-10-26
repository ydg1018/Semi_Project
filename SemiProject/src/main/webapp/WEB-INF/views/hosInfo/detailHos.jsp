<%@page import="java.util.List"%>
<%@page import="hosInfo.dto.HosInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% HosInfo detailHosInfo = (HosInfo) request.getAttribute("detailHosInfo"); %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>::: <%=detailHosInfo.getHos_name() %> 정보 :::</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
<h1 style="text-align: center;">
<%=detailHosInfo.getHos_name() %>
<button class="btn btn-info" onclick="location.href='../reservation?hosCode=<%=detailHosInfo.getHos_code() %>'">예약하러가기</button>

<button class="btn btn-info" onclick="location.href='../hos/list'">병원 전체 목록</button>
</h1>

<hr>
<br>
지도
<br><br>

<table class="table table-bordered">

<tr>
	<td class="info">주소</td>
	<td><%=detailHosInfo.getHos_add() %></td>
</tr>
<tr>
	<td class="info">우편번호</td>
	<td><%=detailHosInfo.getHos_zip() %></td>
</tr>
<tr>	
	<td class="info">전화번호</td>
	<td><%=detailHosInfo.getHos_call() %></td>
</tr>
<tr>
	<td class="info">진료시간</td>
	<td><%=detailHosInfo.getHos_time() %></td>
</tr>
<tr>
	<td class="info">오시는 길</td>
	<td><%=detailHosInfo.getHos_trans() %></td>
</tr>
<tr>
	<td class="info">주차 정보</td>
	<td><%=detailHosInfo.getHos_park() %></td>
</tr>

</table>

</body>