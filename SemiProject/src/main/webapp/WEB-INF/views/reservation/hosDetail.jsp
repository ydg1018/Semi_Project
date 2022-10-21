<%@page import="java.util.List"%>
<%@page import="hosInfo.dto.HosInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	List<HosInfo> detail = (List) request.getAttribute("detailHos"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<!-- 부트스트랩 Bootstrap3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
th, td {
	text-align: center;
}
td:nth-child(2) {
	text-align: justify;
}

#mainDiv {
	width: 1200px;
	margin: 0 auto;
}

form {
	text-align: center;
}


</style>

</head>
<body>

<header>
<h1>헤더부분</h1>
</header>


<h1 style="text-align: center;">병원 목록</h1>
<hr>

<div id="mainDiv">

<form action="<%=request.getContextPath() %>/search/reser" method="post" >

<label >검색하기 <input type="text" name="hosname"></label>

<button>검색</button>

</form>

<br>

<table class="table table-striped table-hover ">
<tr>
	<th>병원 번호</th>
	<th>병원 이름</th>
	<th>병원 주소</th>
	<th>우편 번호</th>
	<th>예약 하기</th>
</tr>

<%	for(int i=0; i<detail.size(); i++) { %>
<tr>
	<td><%=detail.get(i).getHosCode() %></td>
	
	<td><%=detail.get(i).getHosName() %></td>
	
	<td><%=detail.get(i).getHosAdd() %></td>
	<td><%=detail.get(i).getHosZip() %></td>
	<td><button>예약하기</button></td>
</tr>
<%	} %>

</table>

</div>

<%@ include file="../layout/paging.jsp" %>

<footer>
<h1>풋터부분</h1>
</footer>


</body>
</html>