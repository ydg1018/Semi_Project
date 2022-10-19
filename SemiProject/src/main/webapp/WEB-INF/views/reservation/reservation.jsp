<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>
<body>

<header>
<h1>헤더부분</h1>
<hr>
</header>

<div id="mainDiv">	<!-- body start -->
<h1>병원 예약</h1>

<form action="<%=request.getContextPath() %>/reservation/list" method="post">

<label for="searchHos">병원검색</label>
<input type="text" id="searchHos" name="searchHos">
<button>검색</button>

</form>

<br>

<table>
<tr>
	<th>번호</th>
	<th>병원명</th>
	<th>주소</th>
	<th>전화번호</th>
	<th>이메일</th>
</tr>

<tr>
	<td>1</td>
	<td>1</td>
	<td>1</td>
	<td>1</td>
	<td>1</td>
</tr>
</table>


</div>  <!-- body end -->
<footer>
<hr>
<h1>풋터부분</h1>
</footer>

</body>
</html>