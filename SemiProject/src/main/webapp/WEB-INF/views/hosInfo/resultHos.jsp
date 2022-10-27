<%@page import="util.Paging"%>
<%@page import="java.util.List"%>
<%@page import="hosInfo.dto.HosInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>
    
<% ArrayList<HosInfo> list = (ArrayList<HosInfo>) request.getAttribute("list"); %>
<% List<HosInfo> hosInfo = (List) request.getAttribute("hosInfo"); %>    

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

</head>
<body>

<table class="table table-striped table-hover table-condensed">
<tr>
	<th style="width: 30%;">병원명</th>
	<th style="width: 30%;">주소</th>
	<th style="width: 30%;">전화번호</th>
</tr>

<%	for(int i=0; i<list.size(); i++) { %>
	<%	for(int j=0; j<1; j++) { %>
<tr>
	<td><a href="./detail?hos_name=<%=hosInfo.get(j).getHos_name() %>">
	<%=list.get(i).getHos_name() %></a></td>
	<td><%=list.get(i).getHos_add() %></td>
	<td><%=list.get(i).getHos_call() %></td>
</tr>
	<%	} %>
<%	} %>

</table>

<%@ include file="../layout/footer.jsp" %>



