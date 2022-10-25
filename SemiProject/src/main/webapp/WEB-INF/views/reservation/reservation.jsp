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
	IMP.request_pay({
	    pg : 'html5_inicis',
	    pay_method : 'card',
	    merchant_uid: "order_no_0001", // 상점에서 관리하는 주문 번호
	    name : '주문명:결제테스트',
	    amount : 14000,
	    buyer_email : 'iamport@siot.do',
	    buyer_name : '구매자이름',
	    buyer_tel : '010-1234-5678',
	    buyer_addr : '서울특별시 강남구 삼성동',
	    buyer_postcode : '123-456'
	}, function(rsp) {
	    if ( rsp.success ) {
	    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
	    	jQuery.ajax({
	    		url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
	    		type: 'POST',
	    		dataType: 'json',
	    		data: {
		    		imp_uid : rsp.imp_uid
		    		merchant_uid : rsp.merchant_uid
		    		paid_amount : rsp.paid_amount
		    		
		    		
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
	    			
	    			alert(msg);
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