<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="../layout/header.jsp" %>

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
		
})


	$("#send").click(function() {
		$(location).attr("href", "./list")
	
})

</script>


<style type="text/css">

* {
	font-family: 나눔고딕코딩;
}

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
<form action="./insert" method="post" enctype="multipart/form-data">

<table>
	<tr><td class="board-top"><%=session.getAttribute("owner_nick") %></td></tr>
	<tr></tr>
	<tr><td class="board-top"><input type="text" name="title" placeholder="제목을 입력하세요" style="width: 700px;"></td></tr>
	<tr><td><textarea id="content" name="content"></textarea></td></tr>
	<tr><td style="padding-bottom: 15px">첨부파일<input type="file" name="file"></td></tr>
</table>	
	
	<div class="text-center">
	<button class="btn btn-default" type="submit" id="send">등록</button>
	<a class="btn btn-default" href="./list" role="button">취소</a>
	</div>
</form>
</div>
</body>

<br><br><br>
<%@ include file="../layout/footer.jsp" %>

</html>








