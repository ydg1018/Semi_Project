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
	
	// 회원가입 버튼
	$("#btnJoin").click(function() {
		$(this).parents("form").submit();
	})
	
	// 취소 버튼
	$("#btnCancel").click(function() {
		// history.go(-1) // 뒤로가기
		$(location).attr('href', '/hos/list') // 메인으로 가기
	})
/* 
	$("form").submit(function() { 
		console.log("submit event")
		
		// 유효성 검증 후 submit
		if( validate() ) {
			$(this).submit();
		}
		
		// submit 중단시키기
		return false;
	}) */

	//----- 유효성 검증 에러 메시지 초기화 ------
	
	// 아이디 입력 시도할 때 아이디 메시지 삭제
	$('#hosid').focus(function() {
		$('#hosid_msg').html("")
	})
	
	// 패스워드 입력 시도할 때 패스워드 메시지 삭제
	$("#hospw").focus(function() {
		$("#hospw_msg").html("")
	})
	// 패스워드 확인 입력 시도할 때 패스워드 체크 메시지 삭제
	$("#hospw_check").focus(function() {
		$("#hospw_check_msg").html("")
	})
	
	// 이름 입력 시도할 때 이름 메시지 삭제
	$("#hosname").focus(function() {
		$("#hosname_msg").html("")
	})

	// 이메일 입력 시도할 때 이름 메시지 삭제
	$("#hosemail").focus(function() {
		$("#hosemail_msg").html("")
	})

	// 전화번호 입력 시도할 때 이름 메시지 삭제
	$("#hoscall").focus(function() {
		$("#hoscall_msg").html("")
	})

	// 닉네임 입력 시도할 때 이름 메시지 삭제
	$("#hosnick").focus(function() {
		$("#hosnick_msg").html("")
	})
})

// input 데이터의 유효성 검증
function validate() {
	//----- ID 유효성 검증 -----
	
	// 아이디를 입력했는지 검증
	if( $("#hosid").val() == '' ) {
		$('#hosid_msg').html("아이디를 입력해주세요.");
		return false;
	}
	
	// 아이디 입력값 검증
	if( !/^[a-z0-9]{6,12}$/.test( $("#hosid").val() ) ) {
		$('#hosid_msg').html("아이디는 영어 소문자, 숫자 포함 6~12 글자만 가능합니다.")
		return false;
	}
	
	//--------------------
	
	//----- PASSWORD 유효성 검증 -----
	
	// 패스워드를 입력하지 않았을 때
	if( $("#hospw").val() == '' ) {
		$("#hospw_msg").html("패스워드를 입력해주세요.")
		return false;
	}
	
	// 패스워드 입력값 검증
	if( !/^[a-zA-z0-9]{8,16}$/.test( $("#hospw").val() ) ) {
		$("#hospw_msg").html("패스워드는 영어 대소문자, 숫자 포함 8~16 글자만 가능합니다.")
		return false;
	}
	
	// 패스워드와 확인 입력값이 같은지 검증
	if( $("#hospw").val() != $("#hospw_check").val() ) {
		$("#hospw_check_msg").html("비밀번호 확인 입력이 동일하지 않습니다.")
		return false;
	}
	
	//--------------------
	
	// 이름 입력하지 않았을 때
	if( $("#hosname").val() == '' ) {
		$("#hosname_msg").html("이름을 입력해주세요.")
		return false;
	}
	
	// 이름 입력값 검증
	if( !/^[가-힣]{2,10}$/.test( $("#hosname").val() ) ) {
		$("#hosname_msg").html("이름은 한글만 가능합니다.")
		return false;
	}
	
	//--------------------
	
	// 이메일 입력하지 않았을 때
	if( $("#hosemail").val() == '' ) {
		$("#hosemail_msg").html("이메일을 입력해주세요.")
		return false;
	}
	
	// 이메일 입력값 검증
	if( !/^[a-z0-9]@[a-z0-9]$/.test( $("#hosemail").val() ) ) {
		$("#hosemail_msg").html("이메일 형식이 맞지 않습니다.")
		return false;
	}
	
	//--------------------
	
	// 전화번호 입력하지 않았을 때
	if( $("#hoscall").val() == '' ) {
		$("#hoscall_msg").html("전화번호를 입력해주세요.")
		return false;
	}
	
	// 전화번호 입력값 검증
	if( !/^01[0-9]{1}-[0-9]{4}-[0-9]{4}$/.test( $("#hoscall").val() ) ) {
		$("#hoscall_msg").html("전화번호 형식이 맞지 않습니다.")
		return false;
	}

	//--------------------
	
	// 닉네임 입력하지 않았을 때
	if( $("#hosnick").val() == '' ) {
		$("#hosnick_msg").html("닉네임을 입력해주세요.")
		return false;
	}
	
	// 전화번호 입력값 검증
	if( !/^[a-zA-z가-힣]$/.test( $("#hosnick").val() ) ) {
		$("#hosnick_msg").html("닉네임은 한글과 영어만 가능합니다.")
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

#hos_name {
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
				<div class="join_row" style="border-top: 1px solid #f4e4e5; margin-bottom: 30px;">
					<h3 class="join_title">
						<label for="hos_id" class="col-xs-2 control-label">아이디</label>
					</h3>
					<span>
						<input type="text" id="hos_id" name="hos_id" class="form-control">
						<input type="button" value="중복확인" onclick="onpenIdChk()" class="btn_check">
					</span>
					<span id="hos_id_msg" class=msg></span>
				</div>

				<div class="join_row">
					<h3 class="join_title">
						<label for="hos_pw" class="col-xs-2 control-label">패스워드</label>
					</h3>
					<span>
						<input type="password" id="hos_pw" name="hos_pw" class="form-control">
					</span>
					<span id="hos_pw_msg" class=msg></span>

					<h3 class="join_title">
						<label for="hos_pw_check" class="col-xs-2 control-label">패스워드 확인</label>
					</h3>
					<span>
						<input type="password" id="hos_pw_check" name="hos_pw_check" class="form-control">
					</span>
					<span id="hos_pw_check_msg" class=msg></span>
				</div>


				<div class="join_row">
					<h3 class="join_title">
						<label for="hos_add" class="col-xs-2 control-label">병원주소</label>
					</h3>
					<span>
						<input type="text" id="hos_add" name="hos_add" class="form-control">
					</span>
					<span id="hos_email_msg" class=msg></span>
				</div>

				<div class="join_row">
					<h3 class="join_title">
						<label for="hos_call" class="col-xs-2 control-label">전화번호</label>
					</h3>
					<span>
						<input type="number" id="hos_call" name="hos_call" class="form-control">
					</span>
					<span id="hos_call_msg" class=msg></span>
				</div>

				<div class="join_row">
					<h3 class="join_title">
						<label for="hos_lic" class="col-xs-2 control-label">사업자 번호</label>
					</h3>
					<span>
						<input type="text" id="hos_lic" name="hos_lic" class="form-control">
					</span>
					<span id="hos_msg" class=msg></span>
				</div>

				<div class="join_row">
					<h3 class="join_title">
						<label for="hos_name" class="col-xs-2 control-label" style="margin-bottom: 30px;">병원명</label>
					</h3>
					<span>
						<input type="text" id="hos_name" name="hos_name" class="form-control">
						<input type="button" value="중복확인" onclick="onpenIdChk()" class="btn_check">
					</span>
					<span id="hos_name_msg" class=msg></span>
				</div>
				
				<div class="join_row" style="margin-top: 30px;">
					<h3 class="join_title">
						<label for="hos_code" class="col-xs-2 control-label">등록번호</label>
					</h3>
					<span>
						<input type="text" id="hos_code" name="hos_code" class="form-control">
					</span>
					<span id="hos_msg" class=msg></span>
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