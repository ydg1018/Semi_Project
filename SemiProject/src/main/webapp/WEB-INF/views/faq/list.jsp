<%@page import="faq.dto.FAQ"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--모델값 전달받기 --%>    
<% List<FAQ> faqList = (List) request.getAttribute("faqList"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동물병원을 찾아조</title>

<!-- 부트스트랩 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<style type="text/css">
input[id="answer"]{
display: none;
}
input[id="answer"]+label{
	display: block;
	padding: 20px;
	border: 1px solid #232188;
	border-bottom: 0;
	color: #fff;
	font-weight: 900;
	background: #3634a5;
	cursor: pointer;
	position: relative;
}

input[id="answer"]+label em {
	position: absolute;
	top:50%;
	right: 10px;
	width: 30px;
	height: 30px;
	margin-top: -15px;
	display: inline-block;
}

input[id="answer"]+label+div{
	max-height: 0;
	transition: all, 3ss;
	overflow: hidden;
	background: #ebf8ff;
	font-size: 11px;
}

input[id="answer"]+label+div p{
	display: inline-block;
	padding: 20px;
}

input[id="answer"]:checked + label + div {
	max-height: 100px;
}
</style>

</head>
<body>

<h1>공지사항</h1>
<hr>
<h2>FAQ</h2>

<% for(int i=0; i<faqList.size(); i++) { %>
<div class="accordion">
	<input type="checkbox" id=answer>
	<label for="answer"><%=faqList.get(i).getFaqIdx() %> <%=faqList.get(i).getFaqQuestion() %><em></em></label>
	<div><p><%=faqList.get(i).getFaqAnswer() %></p></div>

</div>
<% } %>







</body>
</html>