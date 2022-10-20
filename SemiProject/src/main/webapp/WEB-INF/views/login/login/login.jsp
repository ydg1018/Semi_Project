<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">

</script>

</head>
<body>

<header>
<h1>header</h1>
</header>
<hr>

<form action="/login/login" method="post">

		<label for="userid">아이디</label>
		<input type="text" id="userid" name="userid">

		<label for="userpw">패스워드</label>
		<input type="password" id="userpw" name="userpw">

		<button type="submit">로그인</button>
		<button type="button">취소</button>
		
</form>

<hr>
<footer>
<h1>footer</h1>
</footer>

</body>
</html>