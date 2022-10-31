<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {
	
	// 아이디 입력창에 포커스주기
	$("input").eq(0).focus()
	
	// 닉네임 입력창에 엔터키 입력 시 submit
	$("input").eq(2).keydown(function(e) {
		if( e.keyCode == 13 ) { // 엔터키
			$("#btnJoin").click();
		}
	})
	// 취소 버튼
	$("#btnCancel").click(function() {
		// history.go(-1) // 뒤로가기
		$(location).attr('href', '/hos/list') // 메인으로 가기
	})

	$("#btnJoin").click(function() { 
		console.log("submit event")
		
		// 유효성 검증 후 submit
		if( validate() ) {
			$("form").submit();
		}
		
		// submit 중단시키기
		return false;
	})

	//----- 유효성 검증 에러 메시지 초기화 ------
	
	// 아이디 입력 시도할 때 아이디 메시지 삭제
	$('#hos_id').focus(function() {
		$('#hos_id_msg').html("")
	})
	
	// 패스워드 입력 시도할 때 패스워드 메시지 삭제
	$("#hos_pw").focus(function() {
		$("#hos_pw_msg").html("")
	})
	
	// 패스워드 확인 입력 시도할 때 패스워드 체크 메시지 삭제
	$("#hos_pw_check").focus(function() {
		$("#hos_pw_check_msg").html("")
	})

	// 사업자번호 입력 시도할 때 이름 메시지 삭제
	$("#hos_lic").focus(function() {
		$("#hos_lic_msg").html("")
	})

	// 병원명 입력 시도할 때 이름 메시지 삭제
	$("#hos_name").focus(function() {
		$("#hos_name_msg").html("")
	})

	// 병원등록번호 입력 시도할 때 이름 메시지 삭제
	$("#hos_code").focus(function() {
		$("#hos_code_msg").html("")
	})
})

// input 데이터의 유효성 검증
function validate() {
	
	// 아이디를 입력했는지 검증
	if( $("#hos_id").val() == '' ) {
		$('#hos_id_msg').html("아이디를 입력해주세요.");
		return false;
	}
	
	// 아이디 입력값 검증
	if( !/^[a-z0-9]{6,12}$/.test( $("#hos_id").val() ) ) {
		$('#hos_id_msg').html("아이디는 영어 소문자, 숫자 포함 6~12 글자만 가능합니다.")
		return false;
	}
	
	//--------------------
	
	// 패스워드를 입력하지 않았을 때
	if( $("#hos_pw").val() == '' ) {
		$("#hos_pw_msg").html("패스워드를 입력해주세요.")
		return false;
	}
	
	// 패스워드 입력값 검증
	if( !/^[a-zA-z0-9]{8,16}$/.test( $("#hos_pw").val() ) ) {
		$("#hos_pw_msg").html("패스워드는 영어 대소문자, 숫자 포함 8~16 글자만 가능합니다.")
		return false;
	}
	
	// 패스워드와 확인 입력값이 같은지 검증
	if( $("#hos_pw").val() != $("#hos_pw_check").val() ) {
		$("#hos_pw_check_msg").html("비밀번호 확인 입력이 동일하지 않습니다.")
		return false;
	}
	
	//--------------------
	
	// 사업자번호 입력하지 않았을 때
	if( $("#hos_lic").val() == '' ) {
		$("#hos_lic_msg").html("사업자 번호를 입력해주세요.")
		return false;
	}
	
	// 사업자번호 입력값 검증
	if( !/^[0-9]$/.test( $("#hos_lic").val() ) ) {
		$("#hos_lic_msg").html("사업자 번호는 숫자만 가능합니다.")
		return false;
	}
	
	//--------------------
	
	// 병원명 입력하지 않았을 때
	if( $("#hos_name").val() == '' ) {
		$("#hos_name_msg").html("병원이름을 입력해주세요.")
		return false;
	}
	
	// 병원명 입력값 검증
	if( !/^[a-zA-z0-9가-힣]$/.test( $("#hos_name").val() ) ) {
		$("#hos_name_msg").html("병원명 형식이 맞지 않습니다.")
		return false;
	}
	
	//--------------------
	
	// 병원등록번호 입력하지 않았을 때
	if( $("#hos_code").val() == '' ) {
		$("#hos_code_msg").html("병원등록번호를 입력해주세요.")
		return false;
	}
	
	// 병원등록번호 입력값 검증
	if( !/^[0-9]$/.test( $("#hos_code").val() ) ) {
		$("#hos_code_msg").html("병원등록번호 형식이 맞지 않습니다.")
		return false;
	}
	return true;
}

</script>

<style type="text/css">

h3 {
	font-size: 13px;
	font-weight: 600;
	margin: 20px 0 5px;
}

h1 {
	text-align: center;
}

button {
	cursor: pointer;
}

#container {
	width: 800px;
	margin: 0 auto;
	margin-top: 80px;
	margin-bottom: 50px;
	text-align: center;
	border: 1px solid #5edfdf;
	border-radius: 1.1em;
}

#content {
	width: 500px;
	margin: 0 auto;
}

.msg {
	display: block;
	font-size: 11px;
	color: red;
}

.btn-primary {
	border-radius: 0.8em;
	border-color: #D7FFF1;
    color: #fff;
    background-color: #4F86C6;
    margin-bottom: 30px;
}

.btn-danger {
	border-radius: 0.8em;
	border-color: #D7FFF1;
    color: #fff;
    background-color: #4F86C6;
    margin-bottom: 30px;
}

.btn_type {
	margin: 30px 0 9px;
	text-align: center;
}

.form-control {
	width: 390px;
}

.btn_check {
	border-radius: 0.8em;
	border-color: #D7FFF1;
    color: #fff;
    background-color: #4F86C6;
    cursor: pointer;
    width: 70px;
}

#hos_id {
	width: 300px;
	float: left;
}

</style>

</head>
<body>

<form action="/login/signuphos" method="post" class="form-horizontal" name="hosInfo">
	<div id="container">
	<h1>펫병원 회원가입</h1>
		<div id="content">
			<div class="join_content">
				<div class="join_row" style="border-top: 1px solid #f4e4e5">
					<h3 class="join_title">
						<label for="hos_id" class="col-xs-2 control-label">아이디</label>
					</h3>
					<span>
						<input type="text" id="hos_id" name="hos_id" class="form-control" placeholder="아이디">
						<input type="button" value="중복확인" class="btn_check" onclick="winopen()">
					</span>
					<span id="hos_id_msg" class=msg></span>
				</div>

				<div class="join_row">
					<h3 class="join_title">
						<label for="hos_pw" class="col-xs-2 control-label">비밀번호</label>
					</h3>
					<span>
						<input type="password" id="hos_pw" name="hos_pw" class="form-control" placeholder="비밀번호">
					</span>
					<span id="hos_pw_msg" class=msg></span>

					<h3 class="join_title">
						<label for="hos_pw_check" class="col-xs-2 control-label">비밀번호 확인</label>
					</h3>
					<span>
						<input type="password" id="hos_pw_check" name="hos_pw_check" class="form-control" placeholder="비밀번호 확인">
					</span>
					<span id="hos_pw_check_msg" class=msg></span>
				</div>

				<div class="join_row">
					<h3 class="join_title">
						<label for="hos_lic" class="col-xs-2 control-label">사업자번호</label>
					</h3>
					<span>
						<input type="text" id="hos_lic" name="hos_lic" class="form-control" placeholder="사업자번호">
					</span>
					<span id="hos_lic_msg" class=msg></span>
				</div>

				<div class="join_row">
					<h3 class="join_title">
						<label for="hos_name" class="col-xs-2 control-label">병원명</label>
					</h3>
					<span>
						<input type="text" id="hos_name" name="hos_name" class="form-control" placeholder="병원명">
					</span>
					<span id="hos_name_msg" class=msg></span>
				</div>
				
				<div class="join_row">
					<h3 class="join_title">
						<label for="hos_code" class="col-xs-2 control-label">병원등록번호</label>
					</h3>
					<span>
						<input type="text" id="hos_code" name="hos_code" class="form-control" placeholder="병원등록번호">
					</span>
					<span id="hos_code_msg" class=msg></span>
				</div>

				<div class="btn_type">
					<button type="button" class="btn btn-primary" id="btnJoin" style="width: 40%">회원가입</button>
					<button type="button" class="btn btn-danger" id="btnCancel" style="width: 40%">취소</button>
				</div>

			</div>
		</div>
	</div>
</form>

<%@ include file="../layout/footer.jsp" %>