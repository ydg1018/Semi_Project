<%@page import="util.BoardFile"%>
<%@page import="review.dto.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="../layout/header.jsp" %>

<%	Review updateBoard = (Review) request.getAttribute("updateBoard"); %>
<%	BoardFile boardFile = (BoardFile) request.getAttribute("boardFile"); %>

<!-- summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	$('#content').summernote({
		width: 800,
		height: 400,
		placeholder: '내용을 입력하세요',
		focus: true,
		toolbar: [
		    ['style', ['bold', 'italic', 'underline', 'clear']],
		    ['font', ['strikethrough', 'superscript', 'subscript']],
		    ['fontname', ['fontname']],
		    ['fontsize', ['fontsize']],
		    ['color', ['color']],
		    ['para', ['ul', 'ol', 'paragraph']],
			['insert', ['link', 'picture', 'video']],
			['view', ['codeview']],
		  ]
	});

	// textarea #content 에 웹 에디터 적용
	$("#content").summernote()
		

	//파일이 있을 경우
	if(<%=boardFile != null %>) {
		$("#beforeFile").show();
		$("#afterFile").hide();
	}
	
	//파일이 없을 경우
	if(<%=boardFile == null %>) {
		$("#beforeFile").hide();
		$("#afterFile").show();
	}
	
	//파일 삭제 버튼(X) 처리
	$("#delFile").click(function() {
		$("#beforeFile").toggle();
		$("#afterFile").toggle();
	})

})
</script>


<style type="text/css">

.top-container {
	display: flex;
	align-items: center;
	justify-content: center;
	height: 215px;
	background-color: #e1f4f3;
} 

.board-container {
	max-width: 1200px;
	margin: auto;
	padding: 0;
}

input {
	border: 2px solid #ddd;
}

.note-editor {
	display: inline-block;
/* 	margin: 0 auto; */
}

table {
	margin: 0 auto; }
	
.board-top {
	text-align: center;
	padding-bottom: 15px;
	}

</style>
</head>
<body>

<div class="sub-contents wrap">
	<div class="top-container">
		<h1 class="title" style="color: #77767c; ">커뮤니티</h1>
	</div>
</div>	

<br><br><br>

<div class="content-box">
<form action="./update" method="post" enctype="multipart/form-data">
<input type="hidden" name="boardno" value='<%=request.getParameter("boardno") %>'>
<table>
	<tr><td class="board-top"><%=session.getAttribute("owner_nick") %></td></tr>
	<tr></tr>
	<tr><td class="board-top"><input type="text" name="title" value="<%=updateBoard.getBoardTitle() %>" style="width: 700px;"></td></tr>
	<tr><td><textarea id="content" name="content"><%=updateBoard.getBoardContent() %></textarea></td></tr>

	<tr><td id="beforeFile">
		<%	if( boardFile != null ) { %>
		<a href="<%=request.getContextPath() %>/upload/<%=boardFile.getStoredname() %>"
		 download="<%=boardFile.getOriginname() %>">
			<%=boardFile.getOriginname() %>
		</a>
		<span id="delFile" style="color: red; font-weight: bold; cursor: pointer;">X</span>
		<%	} %>
	</td></tr>
	
	<tr><td id="afterFile">
		새 첨부파일 <input type="file" name="file">
	</td></tr>
</table>	
	
	<div class="text-center">
	<button class="btn btn-default" type="submit" id="btnUpdate">수정</button>
	<a class="btn btn-default" href="./list" role="button">취소</a>
	</div>
</form>
</div>
</body>

<br><br><br>
<%@ include file="../layout/footer.jsp" %>

</html>


