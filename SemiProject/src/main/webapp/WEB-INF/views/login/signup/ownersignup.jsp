<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫오너 회원가입</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">

</script>

</head>
<body>

<header>
<h1>header</h1>
</header>
<hr>

<form action="/signup/ownersignup" method="post">

<fieldset>
	<h3>
		<label>아이디</label>
	</h3>
	<span>
		<input type="text" name="id" id="id" placeholder="6~12자리 영문 소문자, 숫자 조합">
	</span>	
	<button type="button">중복확인</button><br>
	<span id="id_msg" class="msg"></span><br>

	<h3>
		<label>비밀번호</label>
	</h3>
	<span>
		<input type="password" name="pw" id="pw" placeholder="8~16자리 영어 대소문자, 숫자, 특수문자 조합"><br>
	</span>
	<span id="pw_msg" class="msg"></span><br>
	
	<h3>
		<label>비밀번호확인</label>
	</h3>
	<span>
		<input type="password" name="pw_check" id="pw_check" placeholder="비밀번호 확인을 위해 재입력 해주세요."><br>
	</span>
	<span id="pw_check_msg" class="msg"></span><br>
	
	<h3>
		<label>이름</label>
	</h3>
	<span>
		<input type="text" name="name" id="name"><br>
	</span>
	<span id="name_msg" class="msg"></span><br>
	
	<h3>
		<label>이메일</label>
	</h3>
	<span>
		<input type="email" name="email" id="email"><br>
	</span>
	<span id="email_msg" class="msg"></span><br>

	<h3>
		<label>전화번호</label>
	</h3>
	<span>
		<input type="tel" name="call" id="call"><br>
	</span>
	<span id="call_msg" class="msg"></span><br>
	
	<h3>
		<label>닉네임</label>
	</h3>
	<span>
		<input type="text" name="nick" id="nick">
	</span>
	<button type="button">중복확인</button><br>
	<span id="nick_msg" class="msg"></span><br>

	<button type="submit">회원가입</button>
	<button type="button">취소</button>

</fieldset>
</form>

<hr>
<footer>
<h1>footer</h1>
</footer>

</body>
</html>