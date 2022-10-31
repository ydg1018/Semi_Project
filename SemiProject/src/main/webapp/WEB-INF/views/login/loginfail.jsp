<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<style type="text/css">

#wrap {
	border: 1px solid #5edfdf;
	border-radius: 1.1em;
	width: 300px;
	height: 300px;
	margin: 0 auto;
	margin-top: 100px;
	text-align: center;
}

.btn {
	cursor: pointer;
}

.btn-primary {
	border-radius: 0.8em;
	border-color: #D7FFF1;
    color: #fff;
    background-color: #4F86C6;
    margin-bottom: 30px;
    width: 100px;
    margin-top: 25px;
}

</style>

</head>
<body>

<div id="wrap">
	
	<p style="margin-top: 100px;">로그인에 실패하셨습니다</p>
	<p>다시 시도해주시기 바랍니다</p>
	
	<a href="/login/loginowner"><button id="lgbutton" class="btn btn-primary">다시 시도</button></a>
	<a href="/hos/list"><button id="hmbutton" class="btn btn-primary">홈으로 가기</button></a>
	
</div>

<%@ include file="../layout/footer.jsp" %>