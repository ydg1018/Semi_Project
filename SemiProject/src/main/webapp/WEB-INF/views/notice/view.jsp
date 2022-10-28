<%@page import="notice.dto.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<% Notice viewNotice = (Notice) request.getAttribute("viewNotice"); %>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() { //공지사항으로 이동
	
	$("#btnList").click(function() {
		$(location).attr("href", "./list")
	})
	
	$("#btnNotice").click(function () {
		$(location).attr("href","./list")
	})
})

$(document).ready(function () {	//FAQ로 이동
	$("#btnFaQ").click(function () {
		$(location).attr("href","../faq/list")
	})
})

</script>

<style type="text/css">


.thead{background-color: #46B4B4}

th, td{
	text-align: center;
}



</style>

<h1>고객센터</h1>
<hr>

<h2><button id="btnNotice">공지사항</button> <button id="btnFaQ">FaQ</button></h2>

<table class="table table-bordered  table-hover">
<tr>
	<td class="thead">제목</td>
	<td colspan="5"><%=viewNotice.getNoticeTitle() %></td>
</tr>

<tr>
	<td class="thead">글번호</td>
	<td><%=viewNotice.getNoticeIdx() %></td>
	
	<td class="thead">작성일</td>
	<td><%=viewNotice.getNoticeDate() %></td>
	
	<td class="thead">조회수</td>
	<td><%=viewNotice.getNoticeHit() %></td>
</tr>

	<tr>
		<td colspan="6"><%=viewNotice.getNoticeContent() %></td>
	</tr>
</table>

<div class="text-right">
	<button id="btnList" class="btn">목록</button>
</div>




<%@ include file="../layout/footer.jsp" %>
