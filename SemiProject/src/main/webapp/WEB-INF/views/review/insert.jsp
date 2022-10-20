<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="./bHeader.jsp" %>

<!-- summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	$('#content').summernote({
		width: 1000,
		height: 500,
		placeholder: '내용을 입력하세요',
		focus: true,
		toolbar: [
		    ['style', ['bold', 'italic', 'underline', 'clear']],
		    ['font', ['strikethrough', 'superscript', 'subscript']],
		    ['fontname', ['fontname']],
		    ['fontsize', ['fontsize']],
		    ['color', ['color']],
		    ['para', ['ul', 'ol', 'paragraph']],
		    ['table', ['table']],
			['insert', ['link', 'picture', 'video']],
			['view', ['fullscreen', 'codeview', 'help']],
		    ['height', ['height']]
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

.content-box {
	text-align: center;
}

input {
	width: 800px; 
	border: 2px solid #ddd;
}

.note-editor {
	margin: 0 auto;
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
<form action="./insert" method="post">

	<input type="text" name="title" placeholder="제목을 입력하세요"><br><br>
	<textarea id="content" name="content"></textarea><br>
	
	<div class="button">
	<button class="btn btn-default" type="submit" id="send">등록</button>
	<a class="btn btn-default" href="./list" role="button">취소</a>
	</div>
</form>
</div>
</body>
</html>