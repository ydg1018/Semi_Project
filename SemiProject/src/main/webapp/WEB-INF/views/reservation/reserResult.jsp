<%@page import="reservation.dto.Reservation"%>
<%@page import="login.dto.Owner"%>
<%@page import="hosInfo.dto.HosInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	HosInfo hos = (HosInfo) request.getAttribute("hosInfo"); %>
<%	Owner owner = (Owner) request.getAttribute("owner"); %>
<%  Reservation reser = (Reservation) request.getAttribute("reserResult"); %>

<style type="text/css">

th, td {
	height: 50px;
}

button {
    width: 200px;
    height: 100px;
    margin: 10px 140px 10px 140px;
    font-size: 20px;
}

#resultDiv table{
	text-align: center;
	margin: 0 auto;
}

</style>

<body>

<%@ include file="../layout/header.jsp" %>

<div id="mainDiv" style="position:relative;width:1130px;margin:0 auto;z-index:11">	<!-- body start -->

<h1 style="text-align: center;">예약해주셔서 감사합니다.</h1>
<h3 style="text-align: center;">예약 완료</h3>

<div id="resultDiv">
<fieldset>
<legend style="font-size: 30px; font-weight: bold; text-align: center;">예약 상세</legend>

<table>
<tr>
	<th>병원명 : </th>
	<td><%=hos.getHos_name() %></td>
</tr>
<tr>
	<th>병원주소 : </th>
	<td><%=hos.getHos_add() %></td>
</tr>
<tr>
	<th>병원 전화번호 : </th>
	<td><%=hos.getHos_call() %></td>
</tr>
<tr>
	<th>예약번호 : </th>
	<td><%=reser.getResNo() %></td>
</tr>
<tr>
	<th>보호자명 : </th>
	<td><%=owner.getOwnerName() %></td>
</tr>
<tr>
	<th>예약 시간 : </th>
	<td><%=reser.getResDate() %></td>
</tr>
<tr>
	<th>진료 내용 : </th>
	<td><%=reser.getResDetail() %></td>
</tr>

</table>

</fieldset>

</div>

<br><br>

<div style="text-align: center;">
	<button type="button" class="btn btn-primary">홈으로</button>
	<button type="button" class="btn btn-primary">마이페이지로 이동</button>
</div>

</div>  <!-- body end -->

<br>

<%@ include file="../layout/footer.jsp" %>
