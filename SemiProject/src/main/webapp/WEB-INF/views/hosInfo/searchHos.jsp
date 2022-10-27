<%@page import="hosInfo.dto.HosInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>

<% request.setCharacterEncoding("UTF-8"); %>
   
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

#input {
	width: 90%;
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
	$("#input").eq(0).focus()
	
	//검색어 입력창에 엔터키 입력 시 submit
	$("#input").eq(1).keydown(function(e) {
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
		<select name="option">
			<option value="hos_name">병원 이름</option>
			<option value="hos_add">병원 주소</option>
		</select>
		<input id="input" type="text" placeholder="병원 정보를 검색하세요" name="keyword">
		<input id="btnsearch" type="submit" value="">
	</form>	
</div>

<br><br>

<button onclick="add()" class="btn btn-info" style="float: left; margin-left: 100px;">주소 선택</button>


<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
 function add(){  
	 new daum.Postcode({
        oncomplete: function(data) {
        	var addr = data.roadAddress;
        	
	 		document.getElementById('input').value = addr;
        }
    }).open();
 }
</script>

<!--
<button class="btn btn-info" onclick="hide()" style="float: right; margin-right: 250px;">전체목록 숨기기</button>
<button class="btn btn-info" onclick="show()" style="float: right; margin-right: 10px">전체목록 보기</button>
-->
<br><br>

<div id="map" style="width:80%; height:350px; margin: 0 auto;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8dac43c5806fc51358462c78ce0d3a41"></script>

<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 10 // 지도의 확대 레벨 
    }; 

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
if (navigator.geolocation) {
    
    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
    navigator.geolocation.getCurrentPosition(function(position) {
        
        var lat = position.coords.latitude, // 위도
            lon = position.coords.longitude; // 경도
        
        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
            message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
        
        // 마커와 인포윈도우를 표시합니다
        displayMarker(locPosition, message);
            
      });
    
} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
    
    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
        message = 'geolocation을 사용할수 없어요..'
        
    displayMarker(locPosition, message);
}

// 지도에 마커와 인포윈도우를 표시하는 함수입니다
function displayMarker(locPosition, message) {

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({  
        map: map, 
        position: locPosition
    }); 
    
    var iwContent = message, // 인포윈도우에 표시할 내용
        iwRemoveable = true;

    // 인포윈도우를 생성합니다
    var infowindow = new kakao.maps.InfoWindow({
        content : iwContent,
        removable : iwRemoveable
    });
    
    // 인포윈도우를 마커위에 표시합니다 
    infowindow.open(map, marker);
    
    // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(locPosition);      
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

<%@ include file="../layout/footer.jsp" %>


