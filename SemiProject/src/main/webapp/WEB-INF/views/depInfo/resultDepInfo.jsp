<%@page import="java.util.List"%>
<%@page import="depInfo.dto.DepInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>

<% ArrayList<DepInfo> list = (ArrayList<DepInfo>) request.getAttribute("list"); %>    
<%List<DepInfo> depInfo = (List) request.getAttribute("depInfo");%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>::: 진료항목 검색 결과 :::</title>
    
 <!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
<br>

<h3>검색 결과
<button class="btn btn-info btn-sm" onclick="location.href='../dep/list'">진료과 전체 목록</button>
<hr>
</h3>

<%	for(int i=0; i<list.size(); i++) { %>
	<h3><strong><%=list.get(i).getDep_item() %>: <%=list.get(i).getDet_item() %></strong></h3>
	<hr>
	<h3><%=list.get(i).getDet_detail() %></h3>
	<hr>
	<h3><%=list.get(i).getTrt_item() %></h3>
	<hr>
	<br>
<%	} %>

<%@ include file="../layout/footer.jsp" %>

