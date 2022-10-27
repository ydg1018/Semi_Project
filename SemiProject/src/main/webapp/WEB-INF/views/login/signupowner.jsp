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
	
	/* $("#btnJoin").click(function() {
		alert("회원가입 하시겠습니까?");
	}) */
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
	$('#ownerid').focus(function() {
		$('#ownerid_msg').html("")
	})
	
	// 패스워드 입력 시도할 때 패스워드 메시지 삭제
	$("#ownerpw").focus(function() {
		$("#ownerpw_msg").html("")
	})
	// 패스워드 확인 입력 시도할 때 패스워드 체크 메시지 삭제
	$("#ownerpw_check").focus(function() {
		$("#ownerpw_check_msg").html("")
	})
	
	// 이름 입력 시도할 때 이름 메시지 삭제
	$("#ownername").focus(function() {
		$("#ownername_msg").html("")
	})

	// 이메일 입력 시도할 때 이름 메시지 삭제
	$("#owneremail").focus(function() {
		$("#owneremail_msg").html("")
	})

	// 전화번호 입력 시도할 때 이름 메시지 삭제
	$("#ownercall").focus(function() {
		$("#ownercall_msg").html("")
	})

	// 닉네임 입력 시도할 때 이름 메시지 삭제
	$("#ownernick").focus(function() {
		$("#ownernick_msg").html("")
	})
})

// input 데이터의 유효성 검증
function validate() {
	//----- ID 유효성 검증 -----
	
	// 아이디를 입력했는지 검증
	if( $("#ownerid").val() == '' ) {
		$('#ownerid_msg').html("아이디를 입력해주세요.");
		return false;
	}
	
	 if(form.idDuplication.value != "idCheck"){
		alert("아이디 중복체크를 해주세요.");
		return false;
		}
	
	// 아이디 입력값 검증
	if( !/^[a-z0-9]{6,12}$/.test( $("#ownerid").val() ) ) {
		$('#ownerid_msg').html("아이디는 영어 소문자, 숫자 포함 6~12 글자만 가능합니다.")
		return false;
	}
	
	//--------------------
	
	//----- PASSWORD 유효성 검증 -----
	
	// 패스워드를 입력하지 않았을 때
	if( $("#ownerpw").val() == '' ) {
		$("#ownerpw_msg").html("패스워드를 입력해주세요.")
		return false;
	}
	
	// 패스워드 입력값 검증
	if( !/^[a-zA-z0-9]{8,16}$/.test( $("#ownerpw").val() ) ) {
		$("#ownerpw_msg").html("패스워드는 영어 대소문자, 숫자 포함 8~16 글자만 가능합니다.")
		return false;
	}
	
	// 패스워드와 확인 입력값이 같은지 검증
	if( $("#ownerpw").val() != $("#ownerpw_check").val() ) {
		$("#ownerpw_check_msg").html("비밀번호 확인 입력이 동일하지 않습니다.")
		return false;
	}
	
	//--------------------
	
	// 이름 입력하지 않았을 때
	if( $("#ownername").val() == '' ) {
		$("#ownername_msg").html("이름을 입력해주세요.")
		return false;
	}
	
	// 이름 입력값 검증
	if( !/^[가-힣]{2,10}$/.test( $("#ownername").val() ) ) {
		$("#ownername_msg").html("이름은 한글만 가능합니다.")
		return false;
	}
	
	//--------------------
	
	// 이메일 입력하지 않았을 때
	if( $("#owneremail").val() == '' ) {
		$("#owneremail_msg").html("이메일을 입력해주세요.")
		return false;
	}
	
	/* // 이메일 입력값 검증
	if( !/^[0-9]$/.test( $("#owneremail").val() ) ) {
		$("#owneremail_msg").html("이메일 형식이 맞지 않습니다.")
		return false;
	} */
	
	//--------------------
	
	// 전화번호 입력하지 않았을 때
	if( $("#ownercall").val() == '' ) {
		$("#ownercall_msg").html("전화번호를 입력해주세요.")
		return false;
	}
	
	// 전화번호 입력값 검증
	if( !/^01[0-9]{1}-[0-9]{4}-[0-9]{4}$/.test( $("#ownercall").val() ) ) {
		$("#ownercall_msg").html("전화번호 형식이 맞지 않습니다.")
		return false;
	}

	//--------------------
	
	// 닉네임 입력하지 않았을 때
	if( $("#ownernick").val() == '' ) {
		$("#ownernick_msg").html("닉네임을 입력해주세요.")
		return false;
	}
	
	// 전화번호 입력값 검증
	if( !/^[a-zA-z가-힣]$/.test( $("#ownernick").val() ) ) {
		$("#ownernick_msg").html("닉네임은 한글과 영어만 가능합니다.")
		return false;
	}
	return true;
}
/* 
function onpenIdChk() {
	var owner_id = $("#owner_id").val();
	$.ajax({
		type: 'post'
		, url: 
		, data: { owner_id: owner_id}
		, success: function(result) {
			if(result == 1){
				$("#checkMessage").html("사용할 수 있는 아이디입니다.");
				$("#checkType").attr("class", "modal-content panel-success")
			} else {
				$("#checkMessage").html("사용할 수 있는 아이디입니다.");
				$("#checkType").attr("class", "modal-content panel-warning")
			} $("#checkModal").html("show");
		}
	
	})
} */

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

#owner_id {
	width: 300px;
	float: left;
}

#owner_nick {
	width: 300px;
	float: left;
}

</style>

</head>
<body>

<form action="/login/signupowner" method="post" class="form-horizontal" name="ownerInfo">
	<div id="container">
		<h1>펫오너 회원가입</h1>
		<div id="content">
			<div class="join_content">
				<div class="join_row" style="border-top: 1px solid #f4e4e5; margin-bottom: 30px;">
					<h3 class="join_title">
						<label for="owner_id" class="col-xs-2 control-label">아이디</label>
					</h3>
					<span>
						<input type="text" id="owner_id" name="owner_id" class="form-control">
						<input type="button" value="중복확인" onclick="onpenIdChk()" class="btn_check" id="checkMessage">
					</span>
					<span id="ownerid_msg" class=msg></span>
				</div>

				<div class="join_row">
					<h3 class="join_title">
						<label for="owner_pw" class="col-xs-2 control-label">패스워드</label>
					</h3>
					<span>
						<input type="password" id="owner_pw" name="owner_pw" class="form-control">
					</span>
					<span id="ownerpw_msg" class=msg></span>

					<h3 class="join_title">
						<label for="ownerpw_check" class="col-xs-2 control-label">패스워드 확인</label>
					</h3>
					<span>
						<input type="password" id="ownerpw_check" name="ownerpw_check" class="form-control">
					</span>
					<span id="ownerpw_check_msg" class=msg></span>
				</div>

				<div class="join_row">
					<h3 class="join_title">
						<label for="owner_name" class="col-xs-2 control-label">이름</label>
					</h3>
					<span>
						<input type="text" id="owner_name" name="owner_name" class="form-control">
					</span>
					<span id="ownername_msg" class=msg></span>
				</div>

				<div class="join_row">
					<h3 class="join_title">
						<label for="owner_email" class="col-xs-2 control-label">이메일</label>
					</h3>
					<span>
						<input type="text" id="owner_email" name="owner_email" class="form-control">
					</span>
					<span id="owneremail_msg" class=msg></span>
				</div>

				<div class="join_row">
					<h3 class="join_title">
						<label for="owner_call" class="col-xs-2 control-label">전화번호</label>
					</h3>
					<span>
						<input type="tel" id="owner_call" name="owner_call" class="form-control">
					</span>
					<span id="ownercall_msg" class=msg></span>
				</div>

				<div class="join_row">
					<h3 class="join_title">
						<label for="owner_nick" class="col-xs-2 control-label">닉네임</label>
					</h3>
					<span>
						<input type="text" id="owner_nick" name="owner_nick" class="form-control">
						<input type="button" value="중복확인" onclick="onpenIdChk()" class="btn_check">
					</span>
					<span id="owner_msg" class=msg></span>
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