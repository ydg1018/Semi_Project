<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



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
	height: 550px;
}

tr {
	height: 70px;
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

input, textarea {
/* 	width: 300px; */
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
	
<legend>병원 정보</legend>

<table>
<tr>
	<th>병원명 : </th>
	<td>00병원</td>
</tr>
<tr>
	<th>주소 : </th>
	<td>서울 00시 00동 000-000</td>
</tr>
<tr>
	<th>전화번호 : </th>
	<td>000-0000-0000</td>
</tr>
<tr>
	<th>담당의 : </th>
	<td> 000</td>
</tr>
<tr>
	<th>진료시간 : </th>
	<td>00:00~00:00</td>
</tr>
<tr>
	<th>진료항목 : </th>
	<td>00과, 00과</td>
</tr>

</table>

</fieldset>
 
</div><!-- hosLeft -->

<div id="ownerRight">

<form action="<%=request.getContextPath() %>/reservation/input" method="post">

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
	<label>반려동물명 : <input type="text" name="petName"></label><br><br>
</div>

<div>
	<label>성별 : <input type="radio" name="petGender" value="m" checked>남
	<input type="radio" name="petGender" value="f">여</label><br><br>
</div>

<div>
	<label>방문일자 : <input type="date" name="visitDate">
	<input type="time" name="visitTime"></label><br><br>
</div>

<div>
	<label>진료내용 : <textarea rows="10" cols="50" id="reserDetail" name="reserDetail"></textarea></label><br><br>
</div>

<div style="text-align: center;">
	<button id="btnBack">뒤로가기</button>
	<button id="btnPay" onclick="requestPay()">결제하기</button>
</div>

</fieldset>

</form>

</div><!-- ownerRight -->

<div style="clear:both;"></div>

</div>  <!-- body end -->
<footer>
<h1>풋터부분</h1>
</footer>

</body>
</html>