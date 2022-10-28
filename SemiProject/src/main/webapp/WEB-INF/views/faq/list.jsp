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

</script>


<div>
	<h1>고객센터</h1>
</div>
<hr>
<h2><button id="btnNotice">공지사항</button> <button id="btnFaQ">FaQ</button></h2>

<% for(int i=0; i<faqList.size(); i++) { %>
<div class="accordion">
	<input type="checkbox" id="answer01">
	<label for="answer01"><%=faqList.get(i).getFaqIdx() %> <%=faqList.get(i).getFaqQuestion() %></label>
	<div><p><%=faqList.get(i).getFaqAnswer() %></p></div>

</div>
<% } %>

<%@ include file="../layout/footer.jsp" %>





