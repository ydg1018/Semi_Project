<%@page import="util.Paging"%>
<%@page import="notice.dto.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<%--모델값 전달받기 --%>
<% List<Notice> noticeList = (List) request.getAttribute("noticeList"); %>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function () {
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


th, td{
	text-align: center;
}
</style>

<h1>고객센터</h1>
<hr>

<div class="">
<div><button id="btnNotice">공지사항</button> <button id="btnFaQ">FaQ</button></div>

<table class="table .table-condensed table-hover">
	<tr>
		<th style="width: 15%;">번호</th>
		<th style="width: 50%">제목</th>
		<th style="width: 25%">작성일자</th>
		<th style="widows: 15%">조회수</th>
	<% for(int i=0; i<noticeList.size(); i++) { %>
	</tr>
		<td><%=noticeList.get(i).getNoticeIdx() %></td>
		<td>
			<a href="./view?noticeIdx=<%=noticeList.get(i).getNoticeIdx() %>">
				<%=noticeList.get(i).getNoticeTitle() %>
			</a>
		</td>
		<td><%=noticeList.get(i).getNoticeDate() %></td>
		<td><%=noticeList.get(i).getNoticeHit() %></td>
	<tr>
	<% } %>
	</tr>
</table>

</div>

<%@ include file="./paging.jsp" %>

<%@ include file="../layout/footer.jsp" %>










