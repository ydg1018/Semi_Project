<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>


<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {
	
	// 아이디 입력창에 포커스주기
	$("input").eq(0).focus()
	
	// 패스워드 입력창에 엔터키 입력 시 submit
	$("input").eq(1).keydown(function(e) {
		if( e.keyCode == 13 ) { // 엔터키
			$("#btnLogin").click();
		}
	})
	
	/* $("btnLogin").click(function() {
		console.log("#btnLogin 클릭")
		
		$.ajax({
			type: "post"
			, url: "./loginsuccess.jsp"
			, data {
				id: $("#owner_id").val()
				, pw: $("#owner_pw").val()
			}
			, dateType: "script"
			, success: function(res) {
				console.log("AJAX 성공")
				
				$("result").html(res)
			}
			, error: function() {
				console.log("AJAX 실패")
			}
		})
	}) */
/* 	// 로그인 버튼
	$("#btnLogin").click(function() {
		$(this).parents("form").submit();
	}) */
	
	// 회원가입 버튼
	$("#btnSignup").click(function() {
		console.log("#btnSignup 클릭")
		// history.go(-1) // 뒤로가기
		$(location).attr('href', '/login/signup') // 회원가입으로 가기
	})
	
	// 아이디·비밀번호 찾기 버튼
	$("#btnFind").click(function() {
		console.log("#btnFind 클릭")
		// history.go(-1) // 뒤로가기
		$(location).attr('href', '/login/find') // 아이디·비밀번호찾기로 가기
	})
})

// 아이디 비밀번호 입력 안 한 경우
function loginCheck(){
	let loginForm = document.loginForm;
	let hos_id = document.getElementById('hos_id').value;
	let hos_pw = document.getElementById('hos_pw').value;
	
	if(hos_id == ""){
		alert("아이디를 입력해주세요.");
	} else if (hos_pw == ""){
		alert("비밀번호를 입력해주세요.");
	} else {
		loginForm.submit();
	}
}	
/* 	$("#btnLogin").click(function() {
		var id = $('#owner_id').val();
		var pw = $("#owner_pw").val();
		
		$.ajax({
			type: "post"
			, url: "./loginsuccess.jsp"
			, data: {
				id: $("#owner_id").val()
				, pw: $("#owner_pw").val()
			}
			, dataType: "html"
			, success: function(res){
				if(res == "false"){
					alert('아이디와 비밀번호를 확인해주세요.');
				} else {
					location.href= "$/main";
				}	
			}
		})
	}) */
</script>

<style type="text/css">

h3 {
	font-size: 13px;
	font-weight: 600;
	margin: 20px 0 5px;
}

h1 {
	text-align: center;
	margin-top: 30px;
}

button {
	cursor: pointer;
}

#container {
	width: 800px;
	heigth: auto;
	margin: 0 auto;
	margin-top: 80px;
	margin-bottom: 80px;
	text-align: center;
	border: 1px solid #5edfdf;
	border-radius: 1.1em;
}

#content {
	width: 500px;
	margin: 0 auto;
	margin-bottom: 50px;
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
    width: 50%;
}

.form-control {
	width: 50%;
	margin: 0 auto;
}

.login_btn_wrap {
	text-alian: center;
}

.btn_check {
	border-radius: 0.8em;
	border-color: #D7FFF1;
    color: #fff;
    background-color: #4F86C6;
}

.login_wrap {
	text-align: center;
}

.login_row {
	margin-top: 20px;
}

.login_btn_wrap {
	margin-top: 20px;
}

</style>

</head>
<body>

<div id="container">
	<h1>펫병원 로그인</h1>	
	<div id="content">
		<div class="login_wrap">
			<form action="/login/loginhos" method="post" name="loginForm"class="form-horizontal">
				<div class="login_inner">
					<div class="id_pw_wrap">
						<div class="login_row">
							<input type="text" id="hos_id" name="hos_id" class="form-control" placeholder="아이디" title="아이디">
						</div>
						<div class="login_row">
							<input type="password" id="hos_pw" name="hos_pw" class="form-control" placeholder="비밀번호" title="비밀번호">
						</div>
					</div>
					<div class="login_btn_wrap">
						<p><button type="button" class="btn btn-primary" id="btnLogin" onclick="loginCheck()">
							<span>로그인</span>
						</button></p>
						<p><button type="button" class="btn btn-primary" id="btnSignup">
							<span>회원가입</span>
						</button></p>
						<p><button type="button" class="btn btn-primary" id="btnFind">
							<span>아이디·비밀번호 찾기</span>
						</button><p>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<%@ include file="../layout/footer.jsp" %>