<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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

</head>
<body>

<header>
<h1>헤더부분</h1>
</header>

<div id="mainDiv" style="position:relative;width:1130px;margin:0 auto;z-index:11">	<!-- body start -->

<h1 style="text-align: center;">예약해주셔서 감사합니다.</h1>
<h3 style="text-align: center;">예약 완료</h3>

<div id="resultDiv">
<fieldset>
<legend style="font-size: 30px; font-weight: bold; text-align: center;">예약 상세</legend>

<table>
<tr>
	<th>병원명 : </th>
	<td>00병원</td>
</tr>
<tr>
	<th>병원주소 : </th>
	<td>서울 00시 00동 000-000</td>
</tr>
<tr>
	<th>병원 전화번호 : </th>
	<td>000-0000-0000</td>
</tr>
<tr>
	<th>예약번호 : </th>
	<td> 0000</td>
</tr>
<tr>
	<th>보호자명 : </th>
	<td> 000</td>
</tr>
<tr>
	<th>예약 시간 : </th>
	<td>00:00~00:00</td>
</tr>
<tr>
	<th>진료 내용 : </th>
	<td>00000000000</td>
</tr>

</table>

</fieldset>

</div>

<br><br>

<div style="text-align: center;">
	<button>홈으로</button>
	<button>마이페이지로 이동</button>
</div>

</div>  <!-- body end -->
<footer>
<h1>풋터부분</h1>
</footer>

</body>
</html>