<%@page import="hosInfo.dto.HosInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<HosInfo> hosInfo = (List) request.getAttribute("hosInfo"); %>    

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>::: 병원 정보 :::</title>

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

th, td {
	text-align: center;
}

td:nth-child(2) {
	text-align: justify;
}
</style>

<script type="text/javascript">

function hide() {
	const row = document.getElementById('contents');
	row.style.display = 'none';
}

function show() {
	const row = document.getElementById('contents');
	row.style.display = '';
}

</script>
    
</head>
<body>

<h1 style="text-align: center;">병원 검색</h1>
<hr><br>

<div class="search">
	<form method="get" action="./result">
		<input type="text" placeholder="검색어를 입력하세요" name="hos_name"
		style="width: 100%;
		border: 1px solid #bbb;
		border-radius: 8px;
		padding: 10px 12px;
		font-size: 14px;">
	  	<img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
		<input type="submit" value="검색">
	</form>	
</div>

<br><br>

<button class="btn btn-info" onclick="show()">전체목록 보기</button>
<button class="btn btn-info" onclick="hide()">전체목록 숨기기</button>

<button class="btn btn-info">현재 위치</button>

<br><br>

<p style="margin-top:-12px"></p>
<div id="map" style="width:70%; height:200px; margin: 0 auto;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8dac43c5806fc51358462c78ce0d3a41"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(37.413294, 127.269311), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
 
// 마커를 표시할 위치와 title 객체 배열입니다 
var positions = [
];

// 마커 이미지의 이미지 주소입니다
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
    
for (var i = 0; i < positions.length; i ++) {
    
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35); 
    
    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
    });
}
</script>

<br><br>
<div id="contents">
<table id="hos" class="table table-striped table-hover table-condensed">
<tr>
	<th style="width: 30%;">병원명</th>
	<th style="width: 30%;">주소</th>
	<th style="width: 30%;">전화번호</th>
	
</tr>


<%	for(int i=0; i<hosInfo.size(); i++) { %>
<tr >
	<td><a href="./detail?hos_name=<%=hosInfo.get(i).getHos_name() %>">
		<%=hosInfo.get(i).getHos_name() %></a></td>
		
	<td><%=hosInfo.get(i).getHos_add() %></td>
	<td><%=hosInfo.get(i).getHos_call() %></td>
</tr>
<%	} %>

</table>

<%@ include file="../layout/paging.jsp" %>

</div>
