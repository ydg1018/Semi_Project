<%@page import="hosInfo.dto.HosInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	HosInfo hos = (HosInfo) request.getAttribute("hosInfo"); %>
    
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js" ></script>
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
		console.log(rsp)
	    if ( rsp.success ) {
	    	$("#merchant_uid").val(rsp.merchant_uid);
	    	
	    	console.log(rsp.success);
	    	console.log(rsp.merchant_uid)
   			$('#reservationForm').submit();

	    } else {
	        var msg = '결제에 실패하였습니다.';
	        msg += '에러내용 : ' + rsp.error_msg;
	        
	        alert(msg);
	    }

	})
};

function goBack() {
	console.log("#btnbtnBack click")
	
	window.history.back();
};

</script>

<script type="text/javascript">
$(document).ready(function() {
	$('input[name=hosCode]').attr('value', <%=hos.getHos_code() %>);
	
	$('#btnPay').click(function() {
		if($('input[name="ownerName"]').val() == '') {
			alert('이름을 입력하세요.');
			$('input[name="ownerName"]').fous();
			return false;
			} else if (
				$('input[name="ownerPhone"]').val() == '') {
				alert('번호을 입력하세요.');
				$('input[name="ownerPhone"]').fous();
				return false;
			} else if (
				$('input[name="ownerAddress"]').val() == '') {
					alert('주소을 입력하세요.');
					$('input[name="ownerAddress"]').fous();
					return false;
			} else if (
				$('input[name="ownerEmail"]').val() == '') {
					alert('이메일을 입력하세요.');
					$('input[name="ownerEmail"]').fous();
					return false;
			} else if (
				$('input[name="petName"]').val() == '') {
					alert('펫명을 입력하세요.');
					$('input[name="petName"]').fous();
					return false;
			} else if (
				$('input[name="petType"]').val() == '') {
					alert('펫종을 입력하세요.');
					$('input[name="petType"]').fous();
					return false;
			} else if (
				$('input[name="visitDate"]').val() == '') {
					alert('방문날짜을 입력하세요.');
					$('input[name="visitDate"]').fous();
					return false;
			} else if (
				$('input[name="visitTime"]').val() == '') {
					alert('방문시간을 입력하세요.');
					$('input[name="visitTime"]').fous();
					return false;
			} else if (
				$('input[name="reserDetail"]').val() == '') {
					alert('진료상세을 입력하세요.');
					$('input[name="reserDetail"]').fous();
					return false;
			} else {
				requestPay();
			}
	});

	$('#visitDate').val(new Date().toISOString().substring(0, 10));
	$('#visitTime').val(new Date().toISOString().slice(11, 16));

	
})

</script>

<script>
</script>

<style type="text/css">

#mainDiv {
	width: 1200px;
	margin: 0 auto;
}

#ownerRight {

	border: 1px solid #58C9B9;
	text-align: center;

} 

#reserDetail {
	vertical-align: middle;
}

legend {
/* 	display: inline-block; */
	text-align: center;
	font-size: 30px;
	font-weight: bold;
}

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

<body>

<%@ include file="../layout/header.jsp" %>

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
	<label>보호자명 : <input type="text" name="ownerName"></label><br>
</div>

<div class="form-group form-group-lg">
<label>전화번호 : <input type="text" name="ownerPhone"></label><br>
</div>

<div class="form-group">
	<label>주소 : <input type="text"  name="ownerAddress"></label><br>
</div>

<div class="form-group">
	<label>이메일 : <input type="text"  name="ownerEmail"></label><br>
</div>

<div class="form-group">
	<label>펫이름 : <input type="text"  name="petName"></label><br>
</div>

<div class="form-group">
	<label>펫 나이 : <select name="petAge" >
			<option value="1" selected="selected">1</option>
		<% for(int i=2; i<101; i++) { %>
			<option value="<%=i %>" ><%=i %></option>
		<%	} %>
			
		</select></label><br>
		
	<label>펫성별 : <input type="radio" name="petSex" value="m" checked="checked">남
	<input type="radio" name="petSex" value="f">여</label><br>
</div>

<div>
</div>

<div class="form-group">
	<label>펫 종류 : <input type="text"  name="petType"></label><br>
</div>

<div class="form-group">
	<label>방문일자 : <input type="date" name="visitDate" id="visitDate">
	<input type="time" name="visitTime" id="visitTime"></label><br>
</div>

<div class="form-group">
	<label>진료내용 : <textarea rows="5" cols="50" id="reserDetail" name="reserDetail"></textarea></label><br>
</div>

<div style="display: none;" class="form-group">
	<label>병원 번호 : <input type="text" name="hosCode"></label>
</div>

<div style="text-align: center;" class="form-group">
</div>

</fieldset>

<div style="display:none" id="hiddenDiv">
<input type="hidden" name="merchant_uid" id="merchant_uid">
</div>

</form>
<br>

	<button type="button" class="btn btn-primary" id="btnBack" onclick="goBack();">뒤로가기</button>
	<button type="button" class="btn btn-primary" id="btnPay">결제하기</button>

</div><!-- ownerRight -->

<div style="clear:both;"></div>

</div>  <!-- body end -->

<%@ include file="../layout/footer.jsp" %>
