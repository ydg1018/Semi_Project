<%@page import="hosInfo.dto.HosInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	HosInfo hos = (HosInfo) request.getAttribute("hosInfo"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
function goBack() {
	console.log("#btnbtnBack click")
	
	window.history.back();
}

function btnPay() {
	console.log("#btnPay click")
	
	location.href="/WEB-INF/views/payment/INIstdpay_pc_req.jsp"
}

</script>

<style type="text/css">

#mainDiv {
	width: 1200px;
	margin: 0 auto;
}

div#hosLeft {
	float: left;
	width: 48%;
}

#ownerRight {
	float: right;
	width: 48%;
}

#reserDetail {
	vertical-align: middle;
}

fieldset {
	height: 600px;
}

tr {
	height: 65px;
}

th {
	width: 100px;
}

legend {
/* 	display: inline-block; */
	font-size: 30px;
	font-weight: bold;
}

label {
	display: inline-block;
	text-align: center;
 	width: 500px;
}

button {
    margin: 0px 60px 0px 60px;
    width: 110px;
    height: 40px;
    font-size: 20px;
}

</style>

</head>
<body>

<header>
<h1>헤더부분</h1>
</header>

<div id="mainDiv" style="position:relative;width:1130px;margin:0 auto;z-index:11">	<!-- body start -->

<h1 style="text-align: center;">예약하기</h1>

<div id="hosLeft">

<fieldset>
	
<legend><%=hos.getHosName() %>병원 정보</legend>

<table>
<tr>
	<th>병원명 : </th>
	<td><%=hos.getHosName() %></td>
</tr>
<tr>
	<th>주소 : </th>
	<td><%=hos.getHosAdd() %></td>
</tr>
<tr>
	<th>전화번호 : </th>
	<td><%=hos.getHosCall() %></td>
</tr>
<tr>
	<th>우편번호 : </th>
	<td><%=hos.getHosZip() %></td>
</tr>
<tr>
	<th>진료시간 : </th>
	<td><%=hos.getHosTime() %></td>
</tr>
<tr>
	<th>교통정보</th>
	<td><%=hos.getHosTrans() %></td>
</tr>
<tr>
	<th>주차 정보 : </th>
	<td><%=hos.getHosPark() %></td>
</tr>
<tr>
	<th>중성화 가격 : </th>
	<td><%=hos.getHosPrice() %></td>
</tr>


</table>

</fieldset>
<br>
 
</div><!-- hosLeft -->

<div id="ownerRight">

<form action="<%=request.getContextPath() %>/reservation" method="post">

<fieldset>
	
<legend>예약자 정보</legend>

<div>
	<label>보호자명 : <input type="text" name="ownerName"></label><br><br>
</div>

<div>
<label>전화번호 : <input type="text" name="ownerPhone"></label><br><br>
</div>

<div>
	<label>주소 : <input type="text" name="ownerAddress"></label><br><br>
</div>

<div>
	<label>펫이름 : <input type="text" name="petName"></label><br><br>
</div>

<div>
	<label>펫 나이 : <input type="text" name="petAge"></label><br><br>
</div>

<div>
	<label>펏성별 : <input type="radio" name="petSex" value="m" checked>남
	<input type="radio" name="petGender" value="f">여</label><br><br>
</div>

<div>
	<label>펫 종류 : <input type="text" name="petType"></label><br><br>
</div>

<div>
	<label>방문일자 : <input type="date" name="visitDate">
	<input type="time" name="visitTime"></label><br><br>
</div>

<div>
	<label>진료내용 : <textarea rows="8" cols="50" id="reserDetail" name="reserDetail"></textarea></label><br><br>
</div>

<div style="text-align: center;">
</div>

	<button type="button" id="btnBack" onclick="goBack();">뒤로가기</button>
	<button onclick="btnPay()">결제하기</button>
</fieldset>
</form>
<br>

</div><!-- ownerRight -->

<div style="clear:both;"></div>

</div>  <!-- body end -->

<footer>
<h1>풋터부분</h1>
</footer>

</body>
</html>