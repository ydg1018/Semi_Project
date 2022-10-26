<%@page import="hosInfo.dto.HosInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	HosInfo hos = (HosInfo) request.getAttribute("hosInfo"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 부트스트랩 Bootstrap3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>

<script type="text/javascript">
var IMP = window.IMP; // 생략 가능
IMP.init("imp50844488"); // 예: imp00000000

function requestPay() {
	IMP.request_pay({
	    pg : 'html5_inicis',
	    pay_method : 'card',
	    merchant_uid: "merchant_" + new Date().getTime(), // 상점에서 관리하는 주문 번호
	    name : "예약금",
	    amount : 100,
	    buyer_email : $('input[name=ownerEmail]').val(),
	    buyer_name : $('input[name=ownerName]').val(),
	    buyer_tel : $('input[name=ownerPhone]').val(),
	    buyer_addr : $('input[name=ownerAddress]').val(),
	}, function(rsp) {
	    if ( rsp.success ) {
	    	console.log(rsp.success);
	    	console.log(rsp.merchant_uid)
	    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
	    	jQuery.ajax({
	    		url: "http://localhost:8888/reservation", /* //cross-domain error가 발생하지 않도록 주의해주세요 */
	    		type: 'POST',
	    		dataType: 'json',
	    		data: {
		    		imp_uid : rsp.imp_uid,
		    		merchant_uid : rsp.merchant_uid,
		    		name: rsp.buyer_name,
		    		email: rsp.buyer_email,
		    		tel: rsp.buyer_tel,
		    		addr: rsp.buyer_addr,
		    		paid_time: rsp.paid_at
		    		
		    		//기타 필요한 데이터가 있으면 추가 전달
	    		}
	    	}).done(function(data) {
	    		//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
	    		if ( everythings_fine ) {
	    			
	    			var msg = '결제가 완료되었습니다.';
	    			msg += '\n고유ID : ' + rsp.imp_uid;
	    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
	    			msg += '\결제 금액 : ' + rsp.paid_amount;
	    			msg += '카드 승인번호 : ' + rsp.apply_num;
	    			
	    			
	    		} else {
	    			//[3] 아직 제대로 결제가 되지 않았습니다.
	    			//[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
	    		}
	    	});
	    } else {
	        var msg = '결제에 실패하였습니다.';
	        msg += '에러내용 : ' + rsp.error_msg;
	        
	        alert(msg);
	    }
	    
	    
   			$('#reservationForm').submit();

	})
};

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

/* div#hosLeft {
	float: left;
	width: 48%;
} */

#ownerRight {

	border: 1px solid #58C9B9;
	text-align: center;

} 

#reserDetail {
	vertical-align: middle;
}

/* fieldset { */
/* 	height: 640px; */
/* } */

/* tr { */
/* 	height: 65px; */
/* } */

/* th { */
/* 	width: 100px; */
/* } */

legend {
/* 	display: inline-block; */
	text-align: center;
	font-size: 30px;
	font-weight: bold;
}

/* label {
	display: inline-block;
	text-align: center;
 	width: 500px;
} */

button {
    margin: 0px 60px 0px 60px;
    width: 110px;
    height: 40px;
    font-size: 20px;
}

.form-group {
	margin: 0 auto;
}

</style>

<script type="text/javascript">
$(document).ready(function() {
	$('input[name=hosCode]').attr('value', <%=hos.getHos_code() %>);
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

<legend><%=hos.getHos_name() %> 정보</legend>

<table class="table">

<tr>
	<th>병원명 : </th>
	<td id="hosName"><%=hos.getHos_name() %></td>
</tr>

<tr>
	<th>주소 : </th>
	<td><%=hos.getHos_add() %></td>
</tr>

<tr>
	<th>전화번호 : </th>
	<td><%=hos.getHos_call() %></td>
</tr>

<tr>
	<th>우편번호 : </th>
	<td><%=hos.getHos_zip() %></td>
</tr>

<tr>
	<th>진료시간 : </th>
	<td><%=hos.getHos_time() %></td>
</tr>

<tr>
	<th>교통정보</th>
	<td><%=hos.getHos_trans() %></td>
</tr>

<tr>
	<th>주차 정보 : </th>
	<td><%=hos.getHos_park() %></td>
</tr>

<tr>
	<th>중성화 가격 : </th>
	<td><%=hos.getHos_price() %></td>
</tr>


</table>

</fieldset>
<br>

 
</div><!-- hosLeft -->

<div id="ownerRight">

<form action="<%=request.getContextPath() %>/reservation" method="post" id="reservationForm" >

<fieldset>
	
<legend>예약자 정보</legend>

<div class="form-group form-group-lg">
	<label>보호자명 : <input type="text" name="ownerName" placeholder="윤대건"></label><br><br>
</div>

<div class="form-group form-group-lg">
<label>전화번호 : <input type="text" name="ownerPhone"></label><br><br>
</div>

<div class="form-group">
	<label>주소 : <input type="text"  name="ownerAddress"></label><br><br>
</div>

<div class="form-group">
	<label>이메일 : <input type="text"  name="ownerEmail"></label><br><br>
</div>

<div class="form-group">
	<label>펫이름 : <input type="text"  name="petName"></label><br><br>
</div>

<div class="form-group">
	<label>펫 나이 : <select name="petAge" >
			<option value="1" selected="selected">1</option>
		<% for(int i=2; i<101; i++) { %>
			<option value="<%=i %>" ><%=i %></option>
		<%	} %>
			
		</select></label><br><br>
	<label>펫성별 : <input type="radio" name="petSex" value="m">남
	<input type="radio" name="petSex" value="f">여</label><br><br>
</div>

<div>
</div>

<div class="form-group">
	<label>펫 종류 : <input type="text"  name="petType"></label><br><br>
</div>

<div class="form-group">
	<label>방문일자 : <input type="date" name="visitDate">
	<input type="time" name="visitTime"></label><br><br>
</div>

<div class="form-group">
	<label>진료내용 : <textarea rows="5" cols="50" id="reserDetail" name="reserDetail"></textarea></label><br><br>
</div>

<div style="display: none;" class="form-group">
	<label>병원 번호 : <input type="text" name="hosCode"></label>
</div>

<div style="text-align: center;" class="form-group">
</div>

</fieldset>

</form>
<br>

	<button type="button" class="btn btn-primary" id="btnBack" onclick="goBack();">뒤로가기</button>
	<button type="button" class="btn btn-primary" id="btnPay" onclick="requestPay()">결제하기</button>


</div><!-- ownerRight -->

<div style="clear:both;"></div>

</div>  <!-- body end -->

<footer>
<h1>풋터부분</h1>
</footer>

</body>
</html>