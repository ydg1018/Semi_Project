<%@page import="faq.dto.FAQ"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<%--모델값 전달받기 --%>    
<% List<FAQ> faqList = (List) request.getAttribute("faqList"); %>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() { //공지사항으로 이동
	
	$("#btnList").click(function() {
		$(location).attr("href", "../notice/list")
	})
	
	$("#btnNotice").click(function () {
		$(location).attr("href","../notice/list")
	})
})

$(document).ready(function () {	//FAQ로 이동
	$("#btnFaQ").click(function () {
		$(location).attr("href","./list")
	})
})

//메뉴 리스트 함수
$()

</script>

<style type="text/css">
.wrapper{
	padding: 100px;
}
.fmenu{
	background-color: #e1f3f3
}
h1, h2{text-align: center;
 }
.content{
	left: 50%;
	top: 50%;
	
}
button {
	font-size:30px; padding:20px 100px;
	background-color: #339999;
	border-radius: 10px;
	color: #fff;

}


</style>

<div class="wrapper">
<div class="fmenu">
<h1>고객센터</h1>

<hr>

<div>
	<h2><button id="btnNotice">공지사항</button>  <button id="btnFaQ">FaQ</button></h2>
</div>
</div>
<div class = "content">
<div class="accordion">

<% for(int i=0; i<faqList.size(); i++) { %>

<style type="text/css">
input[id="answer<%=i%>"]{
display: none;
}

input[id="answer<%=i%>"]+label{
	display: block;
	padding: 20px;
	border: 1px solid #009999;
	border-bottom: 0;
	font-weight: 900;
	color: #009999;
	background: #fff;
	cursor: pointer;
	position: relative;
}

input[id="answer<%=i%>"]+label+div{
	max-height: 0;
	transition: all, 3ss;
	overflow: hidden;
	background: #ebf8ff;
	font-size: 11px;
}

input[id="answer<%=i%>"]+label+div p{
	display: inline-block;
	padding: 20px;
}

input[id="answer<%=i%>"]:checked + label + div {
	max-height: 100px;
}

</style>
	<input type="checkbox" id="answer<%=i%>">
	<label for="answer<%=i%>"><%=faqList.get(i).getFaqIdx() %> <%=faqList.get(i).getFaqQuestion() %></label>
	<div><p><%=faqList.get(i).getFaqAnswer() %></p></div>

<% } %>
</div>
</div>
</div>

<%@ include file="../layout/footer.jsp" %>





