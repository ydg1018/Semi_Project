<%@page import="review.dto.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%	Review viewBoard = (Review) request.getAttribute("viewBoard"); %>
    
<%@ include file="./bHeader.jsp" %>

<style type="text/css">

table {
	width: 100%;
	border-top: 2px solid #32a69f;
	border-bottom: 2px solid #ddd;
}

tr th {
	padding: 20px 10px;
}

tr td {
	padding: 15px 10px;
	color: #555;
}

th, td {
	text-align: center;
}

.board-wrap {
	margin-top: 60px;
}

.board-view_top {
	display: flex;
	flex-direction: column;
	justfiy-content: center;
	align-items: center;
}

#title {
	padding-top: 15px;
	padding-bottom: 0;
}

#nick {
	padding-top: 0;
	padding-bottom: 15px;
	color: #32a69f;
}

tr:nth-child(2) {
	border-bottom: 2px solid #ddd;
}

tr:nth-child(3) {
	float: right;
}
	
#btnList {
	float: left;
}

#btnUpdate, #btnDelete {
	float: right;
}
</style>

<script type="text/javascript">
// $(document).ready(function() {

// 	$("#btnList").click(function() {
// 		$(location).attr("href", "./list")
// 	})
// })

</script>

<body>

<div class="sub-contents wrap">
	<div class="top-container">
		<h1 class="title" style="color: #77767c; ">커뮤니티</h1>
	</div>
</div>	
	
<br><br>
<section class="section-content">
<div class="container">
	<div class="board-wrap board-view">
		<div class="board-table">
		<table>
			<div class="board-view-top">
			<tr>
				<td colspan="4" id="title"><h3><strong><%=viewBoard.getBoardTitle() %></strong></h3></td>
			</tr>
			<tr>
				<td colspan="4" id="nick"><h4><Strong><%=viewBoard.getOwnerNick() %></Strong></h4></td>
			</tr>
			</div><!-- board-view-top end -->
		
			<div class="board-view-body">
			<tr>
				<td><%=viewBoard.getBoardHit() %></td>
				<td><%=viewBoard.getInsertDat() %></td>
			</tr>
			<tr>
				<td colspan="4"><%=viewBoard.getBoardContent() %></td>
			</tr>
			</div><!-- board-view-body end -->
		</table>
		</div><!-- board-table end -->

		<br>
		<div class="board-bottom_button">
			<a class="btn btn-default" href="./list" role="button" id="btnList">목록</a>
			<input class="btn btn-default" type="submit" value="삭제" id="btnDelete">
			<input class="btn btn-default" type="submit" value="수정" id="btnUpdate">
		</div><!-- button end -->
	</div><!-- board-wrap board-view end -->
</div><!-- container end -->

</section>
</body>
</html>