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

$(document).ready(function() {
	
	//검색어 입력창에 포커스주기
	$("input").eq(0).focus()
	
	//검색어 입력창에 엔터키 입력 시 submit
	$("input").eq(1).keydown(function(e) {
		if( e.keyCode == 13 ) { //엔터키
			$("#btnsearch").click();
		}
	})
})
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
		font-size: 14px;
		display: inline">
	  	<img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
		<input id="btnsearch" style="display: none;" type="submit" value="검색">
	</form>	
</div>

<br><br>

<button class="btn btn-info" style="float: left; margin-left: 250px;">현재 위치</button>

<button class="btn btn-info" onclick="hide()" style="float: right; margin-right: 250px;">전체목록 숨기기</button>
<button class="btn btn-info" onclick="show()" style="float: right; margin-right: 10px">전체목록 보기</button>

<br><br>

<p style="margin-top:-12px">
    <em class="link">
        <a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
            혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요.
        </a>
    </em>
</p>
<div id="map" style="width:100%;height:350px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8dac43c5806fc51358462c78ce0d3a41&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.65510639249903, 127.04253066354522), // 지도의 중심좌표
        level: 4 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new daum.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new daum.maps.services.Geocoder();

var listData = [
    {
        groupAddress: '서울특별시 도봉구 도당로 63 (방학동)', 
    },
];
    
for (var i=0; i < listData.length ; i++) {
// 주소로 좌표를 검색합니다
geocoder.addressSearch(listData[i].groupAddress, function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === daum.maps.services.Status.OK) {

        var coords = new daum.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new daum.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new daum.maps.InfoWindow({
            content: result[0].y + "," + result[0].x
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
})


};    
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

