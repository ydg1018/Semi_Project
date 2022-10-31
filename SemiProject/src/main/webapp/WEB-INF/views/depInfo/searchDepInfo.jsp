<%@page import="depInfo.dto.DepInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<% request.setCharacterEncoding("utf-8"); %>

<%List<DepInfo> depInfo = (List) request.getAttribute("depInfo");%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>::: 진료과 정보 :::</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
.search {
  position: relative;
  width: 700px;
  margin: 0 auto;
}

img {
  position : absolute;
  width: 17px;
  top: 10px;
  right: 12px;
  margin: 0;
}

.dep_item {
	position: static;
	top: 20%;
	width: 15%;
	float: left;
	text-align: center;
}

#dep_detail {
	margin-left: 10px;
	margin-right: 10px;
	border: 3px solid #bbb;
	border-radius: 30px;
}

button {
	display: inline;
}

#input {
	width: 100%;
	border: 1px solid #bbb;
	border-radius: 8px;
	padding: 10px 12px;
	font-size: 14px;
	color: #0dbcaf
}

#btnsearch {
	width: 25px;
	height: 25px;
	background-image: url(https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png);
	background-size: 100% 100%;
	display: none;
}

</style>

<script type="text/javascript">

$(document).ready(function() {
	
	//아이디 입력창에 포커스주기
	$("#input").eq(0).focus()
	
	//검색어 입력창에 엔터키 입력 시 submit
	$("#input").eq(1).keydown(function(e) {
		if( e.keyCode == 13 ) { //엔터키
			$("#btnsearch").click();
		}
	})
})

//

$(function() {
	$('#menu').click(function() {
		if($('#det').is(':hidden')) {
			$('#det').show();
		} else {
			$('#det').hide();
		}
	})
});

$(function() {
	$('#menu2').click(function() {
		if($('#det2').is(':hidden')) {
			$('#det2').show();
		} else {
			$('#det2').hide();
		}
	})
});

$(function() {
	$('#menu5').click(function() {
		if($('#det5').is(':hidden')) {
			$('#det5').show();
		} else {
			$('#det5').hide();
		}
	})
});

$(function() {
	$('#menu6').click(function() {
		if($('#det6').is(':hidden')) {
			$('#det6').show();
		} else {
			$('#det6').hide();
		}
	})
});
</script>

</head>

<body>

<h1 style="text-align: center;">진료과 정보</h1>
<hr>
<br>

<div class="search">
	<form method="get" action="./result">
		<input id="input" type="text" placeholder="진료 항목을 검색하세요" name="det_detail">
	  	<img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
		<input id="btnsearch" type="submit" value="">
	</form>	
</div>

<br><br>

<table class="table table-hover table-condensed">

<tr>
	<th style="width: 10%;">진료과</th>
	<th style="width: 90%;">설명</th>
</tr>

</table>

<table id="menu" class="table table-hover table-condensed">

<tr>
	<td  style="width: 10%">
		<button class="btn btn-info"><%=depInfo.get(0).getDep_item() %></button>
	</td>
	<td style="width: 90%"><%=depInfo.get(0).getDep_detail() %></td>
</tr>

</table>

<table id="det" style="display: none;" class="table table-striped table-hover table-condensed">

<%	for(int i=0; i<9; i++) { %>
<tr>	
	<td>
    <a href="./detail?det_item=<%=depInfo.get(i).getDet_item() %>">
	<%=depInfo.get(i).getDet_item() %></a>
	</td>
	<td>
	<%=depInfo.get(i).getDet_detail() %>
	</td>
</tr>
<%	} %>

</table>

<table id="menu2" class="table table-hover table-condensed">

<tr>
	<td style="width: 10%">
		<button class="btn btn-info"><%=depInfo.get(9).getDep_item() %></button>
	</td>
	<td style="width: 90%"><%=depInfo.get(9).getDep_detail() %></td>
</tr>

</table>

<table id="det2" style="display: none;" class="table table-striped table-hover table-condensed">

<%	for(int i=9; i<13; i++) { %>
<tr>
	<td>
		<a href="./detail?det_item=<%=depInfo.get(i).getDet_item() %>">
		<%=depInfo.get(i).getDet_item() %></a>
	</td>
	<td><%=depInfo.get(i).getDet_detail() %></td>
</tr>
<%	} %>
</table>

<table id="menu3" class="table table-hover table-condensed">

<tr>
	<td style="width: 10%">
		<button class="btn btn-info"><%=depInfo.get(13).getDep_item() %></button>
	</td>
	<td style="width: 90%"><%=depInfo.get(13).getDep_detail() %></td>
</tr>

</table>

<table id="menu4" class="table table-hover table-condensed">

<tr>
	<td style="width: 10%">
		<button class="btn btn-info"><%=depInfo.get(14).getDep_item() %></button>
	</td>
	<td style="width: 90%"><%=depInfo.get(14).getDep_detail() %></td>
</tr>

</table>

<table id="menu5" class="table table-hover table-condensed">

<tr>
	<td style="width: 10%">
		<button class="btn btn-info"><%=depInfo.get(15).getDep_item() %></button>
	</td>
	<td style="width: 90%"><%=depInfo.get(15).getDep_detail() %></td>
</tr>

</table>

<table id="det5" style="display: none;" class="table table-striped table-hover table-condensed">

<%	for(int i=15; i<20; i++) { %>
<tr>
	<td>
		<a href="./detail?det_item=<%=depInfo.get(i).getDet_item() %>">
		<%=depInfo.get(i).getDet_item() %></a>
	</td>
	<td><%=depInfo.get(i).getDet_detail() %></td>
</tr>
<%	} %>
</table>

<table id="menu6" class="table table-hover table-condensed">

<tr>
	<td style="width: 10%">
		<button class="btn btn-info"><%=depInfo.get(20).getDep_item() %></button>
	</td>
	<td style="width: 90%"><%=depInfo.get(20).getDep_detail() %></td>
</tr>

</table>

<table id="det6" style="display: none;" class="table table-striped table-hover table-condensed">

<%	for(int i=20; i<26; i++) { %>
<tr>
	<td>
		<a href="./detail?det_item=<%=depInfo.get(i).getDet_item() %>">
		<%=depInfo.get(i).getDet_item() %></a>
	</td>
	<td><%=depInfo.get(i).getDet_detail() %></td>
</tr>
<%	} %>

</table>
<br>
<%@ include file="../layout/footer.jsp" %>
