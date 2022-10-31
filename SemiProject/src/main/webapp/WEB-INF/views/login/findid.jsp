<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {

	// 아이디 입력창에 포커스주기
	$("input").eq(0).focus()
	
	// 이메일 입력창에 엔터키 입력 시 submit
	$("input").eq(1).keydown(function(e) {
		if( e.keyCode == 13 ) { // 엔터키
			$("#btnFindId").click();
		}
	})

	// 취소 버튼
	$("#btnCancel").click(function() {
		$(location).attr('href', '/hos/list') // 로그인 화면으로 가기
	})
})

// 입력 안 한 경우
function loginCheck() {
	let loginForm = document.loginForm;
	let owner_name = document.getElementById('owner_name').value;
	let owner_nick = document.getElementById('owner_nick').value;
	
	if(owner_name == "" && owner_nick == "") {
		alert("모든 정보를 입력해주세요.");
	} loginForm.submit();
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

<header>header</header>
<hr>

<div id="container">
	<h1>아이디 찾기</h1>	
	<div id="content">
		<div class="login_wrap">
			<form action="/login/findid" method="post" name="loginForm"class="form-horizontal">
				<div class="login_inner">
					<div class="id_pw_wrap">
						<div class="login_row">
							<input type="text" id="owner_name" name="owner_name" class="form-control" placeholder="이름" title="이름">
						</div>
						<div class="login_row">
							<input type="text" id="owner_nick" name="owner_nick" class="form-control" placeholder="닉네임" title="닉네임">
						</div>
					</div>
					<div class="login_btn_wrap">
						<p><button type="button" class="btn btn-primary" id="btnFindId" onclick="loginCheck()">
							<span>아이디 찾기</span>
						</button></p>
						<p><button type="button" class="btn btn-primary" id="btnCancel" onclick="history.back()">
							<span>취소</span>
						</button><p>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<%@ include file="../layout/footer.jsp" %>