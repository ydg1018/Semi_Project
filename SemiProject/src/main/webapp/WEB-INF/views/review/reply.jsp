<%@page import="review.dto.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {
	
setInterval(selectReplyList(), 1000);

function insertReply() {
		
	$.ajax({
		type: "post"		//요청메소드
		, url: "/reply/insert"		//요청 URL
		, data: {		//요청 파라미터
			replyContent: $('#reply-content').val()
			, boardno: <%=request.getParameter("boardno") %>
			, ownerNick: <%=request.getSession().getAttribute("ownerNick")%>
		}
	
		, success: function( res ) {
			if(res > 0) {
				//전체 댓글 리스트 갱신
				selectReplyList();
				$("#reply-content").val("");
			}
		}
	})
}


	
function selectReplyList(){
	
	$.ajax({
		url: "/reply/list"
		, data: { boardno: <%=request.getParameter("boardno") %> }
		, success: function(list){
			var res = "";
				
			for(var i in list) {
				res +=
					"<br>" +
					"<td>" + "<b>" + list[i].ownerNick + "</b>" +"</td>" +
					"<td colspan='3'>" + list[i].replyContent + "</td>" +
					"<br>" +
					"<td>" + list[i].insertDat +"</td>" +
				}
					$("#reply-content-area tbody").html(res);
			}
		})
}

})
</script>
</head>
<body>

<div class="reply-insert" align="center">
작성자: <%=request.getSession().getAttribute("ownerNick") %>
<textarea name="reply-content" id="reply-content" style="width: 300px; height: 50px;"></textarea>
<button onclick="insertReply();">등록</button>
</div>

<div id="reply-list-area">
	<div class="reply-list" align="center" id="reply-content-area">
		<table style="width: 500px;">
			<tbody>
			
			</tbody>
		</table>
	</div>
</div>
</body>
</html>