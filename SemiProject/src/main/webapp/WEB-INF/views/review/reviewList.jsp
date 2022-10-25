<%@page import="review.dto.Review"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./bHeader.jsp" %>

<style type="text/css">

/* 커뮤니티 하단 메뉴 */
ul.tab-list {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	position: relative;
	list-style-type: none;
	padding: 0;
	margin: 0;
}

/* 커뮤니티 하단 메뉴 항목 */
ul.tab-list > li {
	float: left;
	border-bottom: 2px solid #32a69f; 
	width: 300px;
	text-align: center;
	line-height: 80px;
	margin: 0;
}

/* 커뮤니티 하단 메뉴의 항목 텍스트 */
ul.tab-list > li > a {	
	display: block;
	text-decoration: none;
	font-size: 20px; 
	font-weight: 900; 
}

a.center {
	background-color: #32a69f;
	color: white;
}

a.side {
	color: #32a69f;
} 

table {
	width: 100%;
	border-top: 2px solid #32a69f;
	border-bottom: 2px solid #ddd;
}

tr th {
	padding: 20px 10px;
	background-color: #fbfbfb;
}

tr td {
	padding: 15px 10px;
	color: #555;
}

tr td:hover {
	color: black;
}

th, td {
	text-align: center;
}

.btn {
	float: right;
	margin-top: 10px;
}

/* 검색버튼 */

.search {
	position: relative;
	width: 400px;
	margin: 0 auto;
	display: flex;
}

select {
	border: 1px solid #bbb;
	border-radius: 8px;
}
	
#query {
	width: 100%;
	border: 1px solid #bbb;
	border-radius: 8px;
	padding: 10px 12px;
	font-size: 14px;
}

#searchBtnImg {
	position: absolute;
	width: 17px;
	top: 11px;
	right: 12px;
	
	background-image: url(https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png);
    background-size: contain;
    background-repeat: no-repeat;
    background-color: white;
    border: none;
} 
</style> 
</head>
<body>

<script type="text/javascript">

//activate Enterkey for Search
    var query = document.getElementById('query');
    var searchBtnImg = document.getElementsById('searchBtnImg');
    query.addEventListener('keyup', function(event) {
        
//         if (event.keyCode === null) {
//             event.preventDefault();
//         }
        
        if (event.keyCode === 13) {
            window.location.href = searchBtnImg.href;
        }
    });

</script>

<!-- 서블릿이 전달한 데이터 꺼내기 (모델값 전달받기)  -->
<% List<Review> reviewList = (List) request.getAttribute("reviewList"); %>

<div class="sub-contents wrap">
	<div class="top-container">
		<h1 class="title" style="color: #77767c; ">커뮤니티</h1>
	</div>
	<div class="section-tab-container">
		<ul class="tab-list">
			<li><a href="./adopt" class="side">유기동물 공고</a></li>
			<li><a href="./review" class="center">병원 후기</a></li>
			<li><a href="./fes" class="side">반려동물 축제</a></li>			
		</ul>
	</div><!-- section-tab-container end -->	
</div><!-- top-container end -->

<br><br>
<section class="section-bbs">
	<div class="container">
		<table id="bbs">
			<tr>
				<th style="width: 10%;">번호</th>
				<th style="width: 50%;">제목</th>
				<th style="width: 15%;">작성자</th>
				<th style="width: 15%;">작성일</th>
				<th style="width: 10%;">조회</th>
			</tr>
			
  			<%	for(int i=0; i<reviewList.size(); i++) { %>
			<tr>
				<td><%=reviewList.get(i).getBoardNo() %></td>
				
				<td>
					<a href="/review/view?boardno=<%=reviewList.get(i).getBoardNo() %>">
					<%=reviewList.get(i).getBoardTitle() %></a>
				</td>
				<td><%=reviewList.get(i).getOwnerNick() %></td>
				<td><%=reviewList.get(i).getInsertDat() %></td>
				<td><%=reviewList.get(i).getBoardHit() %></td>
			</tr>
			<%	} %>	 
		
		</table>
		
		<div class="btn">
		<a class="btn btn-default" href="./insert" role="button">글쓰기</a>
		</div>

	<br><br>
	<%@ include file="./paging.jsp" %> 

<!-- 검색기능 -->
	<form action="/review/list" method="GET">
	<div class="search">
		<select name="f">
		<!-- 검색 상태 유지 -->
			<option ${(param.f == "board_title")?"selected":"" } value="board_title">제목</option>
			<option ${(param.f == "board_content")?"selected":"" } value="board_content">내용</option>
			<option ${(param.f == "owner_nick")?"selected":"" } value="owner_nick">글쓴이</option>
		</select>
		<input type="text" name="q" id="query" value="${param.q}" >
<!-- 		<input type="image" id="searchBtnImg" src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png"> -->
		<input type="submit" id="searchBtnImg" value="">
<!-- 	<input class="btn btn-default" type="submit" style="width: 60px;" value="검색"> -->
	</div>
	</form>
		
	</div><!-- container end -->
</section>
</body>
</html>