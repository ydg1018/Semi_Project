<%@page import="hosInfo.dto.HosInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	HosInfo hos = (HosInfo) request.getAttribute("hosInfo"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>

<script type="text/javascript">
var IMP = window.IMP; // 생략 가능
IMP.init("imp50844488"); // 예: imp00000000

function requestPay() {
    // IMP.request_pay(param, callback) 결제창 호출
    IMP.request_pay({ // param
        pg: "html5_inicis",
        pay_method: "card",
        merchant_uid: "ORD20180131-0000011",
        name: <%=hos.getHosName() %> 예약금,
        amount: 100,
        buyer_email: "romasity@naver.com",
        buyer_name: "윤대건",
        buyer_tel: "010-4242-4242",
        buyer_addr: "서울특별시 강남구 신사동",
        buyer_postcode: "01181"
    }, function (rsp) { // callback
        if (rsp.success) { // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
            // jQuery로 HTTP 요청
            jQuery.ajax({
                url: "http://localhost:8888/reservation", // 예: https://www.myservice.com/payments/complete
                method: "post",
                headers: { "Content-Type": "application/json" },
                data: {
                    imp_uid: rsp.imp_uid,
                    merchant_uid: rsp.merchant_uid
                }
            }).done(function (data) {
              // 가맹점 서버 결제 API 성공시 로직
              alert("결제 성공")
            })
          } else {
            alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
          }
        });
  }

</script>



<script type="text/javascript">
function goBack() {
	console.log("#btnbtnBack click")
	
	window.history.back();
}

/* function btnPay() {
	console.log("#btnPay click")
	
	location.href="/resources/payment/INIstdpay_pc_req.jsp"
} */

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

<script type="text/javascript">
$(document).ready(function() {
	$('input[name=hosCode]').attr('value', <%=hos.getHosCode() %>);
})

</script> 

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
	<label>보호자명 : <input type="text" name="ownerName" placeholder="윤대건"></label><br><br>
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
	<label>펫 나이 : <select name="petAge" >
			<option value="1" selected="selected">1</option>
		<% for(int i=2; i<101; i++) { %>
			<option value="<%=i %>" ><%=i %></option>
		<%	} %>
			
		</select></label><br><br>
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

<div style="display: none;">
	<label>병원 번호 : <input type="text" name="hosCode"></label>
</div>

<div style="text-align: center;">
</div>

</fieldset>

</form>
<br>

	<button type="button" id="btnBack" onclick="goBack();">뒤로가기</button>
	<button onclick="requestPay()">결제하기</button>
</div><!-- ownerRight -->

<div style="clear:both;"></div>

</div>  <!-- body end -->

<footer>
<h1>풋터부분</h1>
</footer>

</body>
</html>