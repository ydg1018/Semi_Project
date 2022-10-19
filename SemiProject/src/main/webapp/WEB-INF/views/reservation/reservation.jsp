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
	border: 1px solid #ccc;
	width: 48%;
}

#ownerRight {
	float: right;
	border: 1px solid #ccc;
	width: 48%;
	
}

#reserDetail {
	vertical-align: middle;
}

label {
	width: 100px;
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


<h3>병원 정보</h3>

<span>병원명 : ㅇㅇ병원</span><br><br>
<span>주소 : 서울 00시 00동 000-000</span><br><br>
<span>전화번호 : 000-0000-0000</span><br><br>
<span>담당의 : 000</span><br><br>
<span>진료시간 : 00:00~00:00</span><br><br>
<span>진료항목 : 00과, 00과</span><br><br>

 
</div><!-- hosLeft -->

<div id="ownerRight">

<form action="<%=request.getContextPath() %>/reservation/input" method="post">

<label>보호자명 : <input type="text" name="ownerName"></label><br><br>

<label>전화번호 : <input type="text" name="ownerPhone"></label><br><br>

<label>주소 : <input type="text" name="ownerAddress"></label><br><br>

<label>반려동물명 : <input type="text" name="petName"></label><br><br>

<label>성별 : <input type="radio" name="petGender" value="m" checked>남
<input type="radio" name="petGender" value="f">여</label><br><br>

<label>방문일자 : <input type="date" name="visitDate"></label>
<input type="time" name="visitTime"><br><br>

<label>진료내용 : <textarea rows="10" cols="50" id="reserDetail" name="reserDetail"></textarea></label><br><br>

<button id="btnBack">뒤로가기</button><button id="btnPay">결제하기</button>

</form>

</div><!-- ownerRight -->

<div style="clear:both;"></div>

</div>  <!-- body end -->
<footer>
<h1>풋터부분</h1>
</footer>

</body>
</html>